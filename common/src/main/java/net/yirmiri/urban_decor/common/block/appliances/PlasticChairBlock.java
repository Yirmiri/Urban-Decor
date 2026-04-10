package net.yirmiri.urban_decor.common.block.appliances;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.util.UDSeasonalEvents;
import net.yirmiri.urban_decor.common.util.UDUtils;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

public class PlasticChairBlock extends FaceAttachedHorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<PlasticChairBlock> CODEC = simpleCodec(PlasticChairBlock::new);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    public static final BooleanProperty BROKEN = BooleanProperty.create("broken");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    //BROKEN
    private static final VoxelShape SHAPE_BROKEN = Block.box(2, 0, 3, 14, 4, 13);

    //NORTH
    private static final VoxelShape SHAPE_NORTH_FLOOR = Stream.of(Block.box(2, 0, 3, 14, 8, 13), Block.box(2, 8, 11, 14, 16, 13)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_NORTH_UP = Stream.of(Block.box(2, 0, 8, 14, 10, 16), Block.box(2, 0, 0, 14, 2, 8)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_NORTH_DOWN = Stream.of(Block.box(2, 0, 8, 14, 10, 16), Block.box(2, 8, 0, 14, 10, 8)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //WEST
    private static final VoxelShape SHAPE_WEST_FLOOR = Stream.of(Block.box(3, 0, 2, 13, 8, 14), Block.box(11, 8, 2, 13, 16, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_UP = Stream.of(Block.box(8, 0, 2, 16, 10, 14), Block.box(0, 0, 2, 8, 2, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_DOWN = Stream.of(Block.box(8, 0, 2, 16, 10, 14), Block.box(0, 8, 2, 8, 10, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //SOUTH
    private static final VoxelShape SHAPE_SOUTH_FLOOR = Stream.of(Block.box(2, 0, 3, 14, 8, 13), Block.box(2, 8, 3, 14, 16, 5)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_UP = Stream.of(Block.box(2, 0, 0, 14, 10, 8), Block.box(2, 0, 8, 14, 2, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_DOWN = Stream.of(Block.box(2, 0, 0, 14, 10, 8), Block.box(2, 8, 8, 14, 10, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //EAST
    private static final VoxelShape SHAPE_EAST_FLOOR = Stream.of(Block.box(3, 0, 2, 13, 8, 14), Block.box(3, 8, 2, 5, 16, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_UP = Stream.of(Block.box(0, 0, 2, 8, 10, 14), Block.box(8, 0, 2, 16, 2, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_DOWN = Stream.of(Block.box(0, 0, 2, 8, 10, 14), Block.box(8, 8, 2, 16, 10, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public PlasticChairBlock(Properties properties) {
        super(properties.randomTicks());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BROKEN, false)
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH)
                .setValue(FACE, AttachFace.WALL)
                .setValue(OCCUPIED, false));
    }

    @Override
    protected MapCodec<PlasticChairBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx) {
        Direction dir = state.getValue(FACING);
        AttachFace face = state.getValue(FACE);

        if (!state.getValue(BROKEN)) {
            switch (face) {
                case FLOOR:
                    switch (dir) {
                        case NORTH:
                            return SHAPE_NORTH_FLOOR;
                        case SOUTH:
                            return SHAPE_SOUTH_FLOOR;
                        case WEST:
                            return SHAPE_WEST_FLOOR;
                        case EAST:
                            return SHAPE_EAST_FLOOR;
                    }
                case CEILING:
                    switch (dir) {
                        case NORTH:
                            return SHAPE_NORTH_UP;
                        case SOUTH:
                            return SHAPE_SOUTH_UP;
                        case WEST:
                            return SHAPE_WEST_UP;
                        case EAST:
                            return SHAPE_EAST_UP;
                    }
                case WALL:
                    switch (dir) {
                        case NORTH:
                            return SHAPE_NORTH_DOWN;
                        case SOUTH:
                            return SHAPE_SOUTH_DOWN;
                        case WEST:
                            return SHAPE_WEST_DOWN;
                        case EAST:
                            return SHAPE_EAST_DOWN;
                    }
            }
        }
        return SHAPE_BROKEN;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (UDUtils.canSitOn(state, pos, level, player) && state.getValue(FACE) == AttachFace.FLOOR) {
            UDSeasonalEvents event = new UDSeasonalEvents();
            boolean forceBreak = player.getUUID().equals(UUID.fromString("27a729ac-0a2a-42fc-8e65-a37fcba6a6c7")); //ZeusIGN
            int breakChance = event.isAprilFools() ? 100 : 7777;
            breakChance = forceBreak ? 1 : Math.max(100, breakChance + judgementList(player));
            boolean willBreak = !state.getValue(BROKEN) && (forceBreak || level.random.nextInt(breakChance) == 0);

            if (willBreak) {
                level.setBlockAndUpdate(pos, state.setValue(BROKEN, true));
                level.playSound(null, pos, SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.BLOCKS, 0.8F, 2.0F);
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, state), pos.getX() + 0.5D, pos.getY() + 0.3D, pos.getZ() + 0.5D, 20, 0.3D, 0.2D, 0.3D, 0.1D);
                }
                return InteractionResult.SUCCESS;
            }

            if (!state.getValue(BROKEN)) {
                UDUtils.createSeat(0.4D, state, level, pos, player, hitResult);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    //this only contains friend uuids, we are silly when we play minecraft, no one else outside of friends will be added here
    private static final Map<UUID, Integer> JUDGEMENT_MAP = Map.of(
            UUID.fromString("2913d971-a58d-4566-8706-b4fb5eacb954"), +514, //redeyevain
            UUID.fromString("c1e0e811-8b55-4ff2-be32-443596a12ade"), +150, //QueenSilverBlue
            UUID.fromString("2ab2e589-b328-441d-bebb-1f129e330ec2"), +150, //aCryingCloud

            UUID.fromString("774e37fc-1ca4-4156-827e-661afa24cb56"), -533, //_Artyrian
            UUID.fromString("bd35c402-fa9c-4d00-afe6-b4ed9ebe90c4"), Integer.MIN_VALUE, //amirasana
            UUID.fromString("3fd1d511-62d6-4e18-a28d-3e3d4fd93620"), -500, //KekeCreations
            UUID.fromString("eff789b6-ed9d-4787-8640-ab37e7daf81f"), -1000, //Slicraw
            UUID.fromString("f62a38cf-bae9-4a80-8743-6f985bec0ee6"), -5000, //StrickBrick
            UUID.fromString("a0437891-2b2a-4d0e-9792-463cad28dd38"), -2000 //Smillyblade
    );

    private int judgementList(Player player) {
        return JUDGEMENT_MAP.getOrDefault(player.getUUID(), 0);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(OCCUPIED) && state.getValue(FACE) == AttachFace.FLOOR && level.isRainingAt(pos.above())) {
            int fallChance = level.isThundering() ? 650 : 1300;
            if (random.nextInt(fallChance) == 0) {
                AttachFace windFace = (state.getValue(FACING) == Direction.NORTH || state.getValue(FACING) == Direction.EAST) ? AttachFace.CEILING : AttachFace.WALL;
                level.setBlockAndUpdate(pos, state.setValue(FACING, state.getValue(FACING).getOpposite()).setValue(FACE, windFace));
                level.playSound(null, pos, SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR, SoundSource.BLOCKS, 0.6F, 2.0F);
                level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, state), pos.getX() + 0.5D, pos.getY() + 0.3D, pos.getZ() + 0.5D, 20, 0.3D, 0.2D, 0.3D, 0.1D);
            }
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getNearestLookingDirections()[0];
        BlockState state;

        if (direction == Direction.UP) {
            state = this.defaultBlockState().setValue(FACE, AttachFace.CEILING).setValue(FACING, ctx.getHorizontalDirection());
        } else if (direction == Direction.DOWN) {
            state = this.defaultBlockState().setValue(FACE, AttachFace.FLOOR).setValue(FACING, ctx.getHorizontalDirection().getOpposite());
        } else {
            state = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite());
        }

        if (state.canSurvive(ctx.getLevel(), ctx.getClickedPos())) return state;

        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).is(Fluids.WATER));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE, OCCUPIED, WATERLOGGED, BROKEN);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }
}
