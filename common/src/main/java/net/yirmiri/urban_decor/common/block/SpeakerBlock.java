package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.common.block_entity.entity.SpeakerBlockEntity;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;

public class SpeakerBlock extends AbstractDecorBlock implements EntityBlock {
    public static final IntegerProperty SOUND_TYPE = IntegerProperty.create("sound_type", 0, 1);

    public SpeakerBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(SOUND_TYPE, 0)
        );
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(SOUND_TYPE));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.speaker.variant_" + state.getValue(SOUND_TYPE)), true);

            if (level.getBlockEntity(pos) instanceof SpeakerBlockEntity speaker) {
                speaker.resetTimer();
            }

            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SOUND_TYPE);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SpeakerBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return (level1, pos, state1, blockEntity) ->
                SpeakerBlockEntity.tick(level1, pos, state1, (SpeakerBlockEntity) blockEntity);
    }
}
