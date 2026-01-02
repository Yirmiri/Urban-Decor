package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class ShowerBlock extends AbstractDecorBlock {
    public static final BooleanProperty ALT = BooleanProperty.create("alt");
    public static final BooleanProperty ON = BooleanProperty.create("on");

    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(7, 8, 8, 9, 10, 18),
            Block.box(5, 6, 6, 11, 8, 12), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(8, 8, 7, 18, 10, 9),
            Block.box(6, 6, 5, 12, 8, 11), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(-2, 8, 7, 8, 10, 9),
            Block.box(4, 6, 5, 10, 8, 11), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(7, 8, -2, 9, 10, 8),
            Block.box(5, 6, 4, 11, 8, 10), BooleanOp.OR);

    public ShowerBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(ALT, false).setValue(ON, false));
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
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(ALT));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.shower.variant_" + state.getValue(ALT)), true);
            return ItemInteractionResult.SUCCESS;
        }

        if (state.getValue(ON) && stackHand.is(Items.GLASS_BOTTLE)) {
            UDUtils.fillWaterBottle(level, pos, player, hand);
            UDUtils.turnBottleIntoItem(stackHand, player, PotionContents.createItemStack(Items.POTION, Potions.WATER), hand);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!player.isCrouching() && level.isClientSide && player.getMainHandItem().is(ItemStack.EMPTY.getItem())) {
            state.setValue(ON, !state.getValue(ON));
            level.playSound(player, pos, UDSounds.FAUCET_TURN.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(ON)) {
            double spread = 3.0 / 16.0;
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                double offsetX = dir.getStepX() * spread * random.nextDouble();
                double offsetZ = dir.getStepZ() * spread * random.nextDouble();
                double velocityX = dir.getStepX() * 0.0;
                double velocityY = -0.05;
                double velocityZ = dir.getStepZ() * 0.0;

                level.addParticle(ParticleTypes.FALLING_WATER, pos.getX() + 0.6 + offsetX, pos.getY() + 5.0 / 16.0, pos.getZ() + 0.5 + offsetZ,
                        velocityX, velocityY, velocityZ);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, ALT, ON);
    }
}
