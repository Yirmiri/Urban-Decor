package net.yirmiri.urban_decor.common.block.sewing_machine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;

import java.util.stream.Stream;

public class SewingMachineBlock extends AbstractDecorBlock {
    public static final MapCodec<SewingMachineBlock> CODEC = simpleCodec(SewingMachineBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container.urban_decor.sewing_machine");

    private static final VoxelShape SHAPE_NORTH = Stream.of(Block.box(1, 0, 4, 15, 2, 12), Block.box(2, 2, 5, 8, 10, 11), Block.box(8, 6, 5, 14, 10, 11), Block.box(1, 6, 6, 2, 9, 9)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(Block.box(4, 0, 1, 12, 2, 15), Block.box(5, 2, 2, 11, 10, 8), Block.box(5, 6, 8, 11, 10, 14), Block.box(6, 6, 1, 9, 9, 2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(Block.box(4, 0, 1, 12, 2, 15), Block.box(5, 2, 8, 11, 10, 14), Block.box(5, 6, 2, 11, 10, 8), Block.box(7, 6, 14, 10, 9, 15)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(Block.box(1, 0, 4, 15, 2, 12), Block.box(8, 2, 5, 14, 10, 11), Block.box(2, 6, 5, 8, 10, 11), Block.box(14, 6, 7, 15, 9, 10)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public SewingMachineBlock(Properties settings) {
        super(settings);
    }

    @Override
    public MapCodec<SewingMachineBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inventory, player) ->
                new SewingMachineMenu(i, inventory, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));
            return InteractionResult.CONSUME;
        }
    }
}
