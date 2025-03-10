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
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractMiniStorageDecorBlock;
import net.yirmiri.urban_decor.block.entity.MiniStorageApplianceBlockEntity;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.init.UDStats;
import net.yirmiri.urban_decor.util.UDUtils;
import org.jetbrains.annotations.Nullable;

public class TrashCanBlock extends AbstractMiniStorageDecorBlock {
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 2);

    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 12, 12);

    private static final VoxelShape SHAPE_THIN_SN = Block.createCuboidShape(3, 0, 5, 13, 12, 11);
    private static final VoxelShape SHAPE_THIN_EW = Block.createCuboidShape(5, 0, 3, 11, 12, 13);

    public TrashCanBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(VARIANT, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        int variant = state.get(VARIANT);
        return switch (state.get(FACING)) {
            case WEST, EAST -> variant == 2 ? SHAPE_THIN_EW : SHAPE;
            default -> variant == 2 ? SHAPE_THIN_SN : SHAPE;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            if (blockEntity instanceof MiniStorageApplianceBlockEntity && !stackHand.isIn(UDItemTagProvider.TOOLBOXES) && !player.isSneaking()) {
                player.openHandledScreen((MiniStorageApplianceBlockEntity) blockEntity);
                player.incrementStat(UDStats.OPEN_APPLIANCES);
                PiglinBrain.onGuardedBlockInteracted(player, true);
            }
        }
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.trash_can.variant_" + state.get(VARIANT)), true);
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT, OPEN, TRUE_OPEN);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MiniStorageApplianceBlockEntity(pos, state);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MiniStorageApplianceBlockEntity) {
                ((MiniStorageApplianceBlockEntity)blockEntity).setCustomName(itemStack.getName());
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
        if (blockEntity instanceof MiniStorageApplianceBlockEntity) {
            ((MiniStorageApplianceBlockEntity)blockEntity).tick();
        }
    }
}
