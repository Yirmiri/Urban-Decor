package net.yirmiri.urban_decor.common.block.appliances;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.common.block.enums.WrapType;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.stream.Stream;

public class PorcelainTableBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_0 = Stream.of(Block.box(3, 0, 3, 13, 1, 13), Block.box(7, 1, 7, 9, 14, 9), Block.box(0, 14, 0, 16, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_1 = Stream.of(Block.box(0, 0, 0, 2, 14, 2), Block.box(0, 0, 14, 2, 14, 16), Block.box(14, 0, 14, 16, 14, 16), Block.box(14, 0, 0, 16, 14, 2), Block.box(0, 14, 0, 16, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 1);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    public static final EnumProperty<WrapType> WRAP_TYPE = EnumProperty.create("wrap_type", WrapType.class);

    public PorcelainTableBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WRAP_TYPE, WrapType.NONE)
                .setValue(VARIANT, 0)
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH)
                .setValue(OCCUPIED, false)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx) {
        if (state.getValue(VARIANT) == 1) {
            return SHAPE_1;
        }
        else return SHAPE_0;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.plastic_table.variant_" + state.getValue(VARIANT)), true);
            return ItemInteractionResult.SUCCESS;
        }
        if (state.getValue(WRAP_TYPE) == WrapType.NONE && stackHand.is(UDTags.ItemT.WRAPS)) {
            for (WrapColor color : WrapColor.values()) {
                if (stackHand.is(UDItems.getWrappedWraps(color.getId()).get())) {
                    level.setBlockAndUpdate(pos, state.setValue(WRAP_TYPE, WrapType.valueOf(color.name())));
                    UDUtils.wrapUsed(level, pos);
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (UDUtils.canSitOn(state, pos, level, player)) {
            UDUtils.createPlayerOnlySeat(0.9D, state, level, pos, player, hitResult);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT, OCCUPIED, WRAP_TYPE);
    }
}
