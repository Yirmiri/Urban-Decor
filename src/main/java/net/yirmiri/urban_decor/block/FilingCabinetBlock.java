package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.block.entity.StorageApplianceBlockEntity;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.init.UDStats;
import net.yirmiri.urban_decor.util.UDUtils;
import org.jetbrains.annotations.Nullable;

public class FilingCabinetBlock extends AbstractStorageDecorBlock {
    public static final BooleanProperty COMPACT = BooleanProperty.of("compact");
    public static final BooleanProperty TRUE_OPEN = BooleanProperty.of("true_open");

    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0, 0, 1, 16, 16, 16);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0, 0, 0, 16, 16, 15);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0, 0, 0, 15, 16, 16);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(1, 0, 0, 16, 16, 16);

    public FilingCabinetBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(TRUE_OPEN, false).with(OPEN, false).with(COMPACT, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            if (blockEntity instanceof StorageApplianceBlockEntity && !stackHand.isIn(UDItemTagProvider.TOOLBOXES) && !player.isSneaking()) {
                player.openHandledScreen((StorageApplianceBlockEntity) blockEntity);
                player.incrementStat(UDStats.OPEN_APPLIANCES);
                PiglinBrain.onGuardedBlockInteracted(player, true);
            }

            if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
                world.setBlockState(pos, state.cycle(COMPACT));
                UDUtils.toolboxUsed(world, pos);
                player.sendMessage(Text.translatable("toolbox.filing_cabinet.variant_" + state.get(COMPACT)), true);
                return ActionResult.SUCCESS;
            }

            if (player.getMainHandStack().isEmpty() && player.isSneaking()) {
                world.setBlockState(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
                if (state.get(OPEN)) {
                    playSound(world, pos, state, SoundEvents.BLOCK_IRON_DOOR_CLOSE);
                } else if (!state.get(OPEN)) {
                    playSound(world, pos, state, SoundEvents.BLOCK_IRON_DOOR_OPEN);
                }
                return ActionResult.SUCCESS;
            }
            return ActionResult.CONSUME;
        }
    }

    void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = (state.get(AbstractStorageDecorBlock.FACING)).getVector();
        double d = (double)pos.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)pos.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)pos.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, COMPACT, TRUE_OPEN);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StorageApplianceBlockEntity(pos, state);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StorageApplianceBlockEntity) {
                ((StorageApplianceBlockEntity)blockEntity).setCustomName(itemStack.getName());
            }
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Inventory) {
                ItemScatterer.spawn(world, pos, (Inventory)blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof StorageApplianceBlockEntity) {
            ((StorageApplianceBlockEntity)blockEntity).tick();
        }
    }
}
