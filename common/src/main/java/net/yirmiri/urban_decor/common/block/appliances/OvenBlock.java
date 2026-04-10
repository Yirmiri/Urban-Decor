package net.yirmiri.urban_decor.common.block.appliances;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractSmokerDecorBlock;
import net.yirmiri.urban_decor.common.block.enums.WrapType;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDItems;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class OvenBlock extends AbstractSmokerDecorBlock {
    public static final EnumProperty<WrapType> WRAP_TYPE = EnumProperty.create("wrap_type", WrapType.class);
    public static final BooleanProperty OPAQUE = BooleanProperty.create("opaque");

    private static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 2, 16, 16, 16);
    private static final VoxelShape SHAPE_WEST = Block.box(2, 0, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 14, 16, 16);
    private static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 14);

    public OvenBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState()
                .setValue(OPAQUE, false)
                .setValue(WRAP_TYPE, WrapType.NONE)
        );
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
        if (state.getValue(WRAP_TYPE) == WrapType.NONE && stackHand.is(UDTags.ItemT.WRAPS)) {
            for (WrapColor color : WrapColor.values()) {
                if (stackHand.is(UDItems.getWrappedWraps(color.getId()).get())) {
                    level.setBlockAndUpdate(pos, state.setValue(WRAP_TYPE, WrapType.valueOf(color.name())));
                    UDUtils.wrapUsed(level, pos);
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(OPAQUE));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.oven.variant_" + state.getValue(OPAQUE)), true);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!player.getMainHandItem().getItem().getDefaultInstance().is(UDTags.ItemT.TOOLBOXES)) {
            if (!level.isClientSide && !player.isShiftKeyDown()) {
                this.openContainer(level, pos, player);
                return InteractionResult.SUCCESS;
            }

            if (player.isShiftKeyDown()) {
                level.setBlockAndUpdate(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
                if (state.getValue(OPEN)) {
                    UDUtils.playSound(level, pos, state, UDSounds.METALLIC_CLOSE.get());
                } else if (!state.getValue(OPEN)) {
                    UDUtils.playSound(level, pos, state, UDSounds.METALLIC_OPEN.get());
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, OPAQUE, TRUE_OPEN, LIT, WRAP_TYPE);
    }
}
