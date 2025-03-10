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
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.block.entity.StorageApplianceBlockEntity;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.init.UDStats;
import net.yirmiri.urban_decor.util.UDUtils;
import org.jetbrains.annotations.Nullable;

public class WashingMachineBlock extends AbstractStorageDecorBlock {
    public static final BooleanProperty OPEN = BooleanProperty.of("open");
    public static final BooleanProperty OPAQUE = BooleanProperty.of("opaque");

    private static final VoxelShape SHAPE_NORTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 1, 15, 12, 15),
            Block.createCuboidShape(1, 12, 13, 15, 16, 15), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 1, 15, 12, 15),
            Block.createCuboidShape(1, 12, 1, 3, 16, 15), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 1, 15, 12, 15),
            Block.createCuboidShape(13, 12, 1, 15, 16, 15), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 1, 15, 12, 15),
            Block.createCuboidShape(1, 12, 1, 15, 16, 3), BooleanBiFunction.OR);

    public WashingMachineBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(TRUE_OPEN, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(OPEN, false).with(OPAQUE, false));
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
        if (!world.isClient && blockEntity instanceof StorageApplianceBlockEntity && !stackHand.isIn(UDItemTagProvider.TOOLBOXES) && !player.isSneaking()) {
            player.openHandledScreen((StorageApplianceBlockEntity) blockEntity);
            player.incrementStat(UDStats.OPEN_APPLIANCES);
            PiglinBrain.onGuardedBlockInteracted(player, true);
        }

        if (!stackHand.isIn(UDItemTagProvider.TOOLBOXES) && player.isSneaking()) {
            world.setBlockState(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
            if (state.get(OPEN)) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            } else if (!state.get(OPEN)) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_DOOR_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
            return ActionResult.SUCCESS;

        } else if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(OPAQUE));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.washing_machine.variant_" + state.get(OPAQUE)), true);
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, OPAQUE, TRUE_OPEN);
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
