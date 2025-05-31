package net.yirmiri.urban_decor.common.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ToolboxBlockItem extends BlockItem {
    public ToolboxBlockItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer().isShiftKeyDown()) {
            InteractionResult actionResult = place(new BlockPlaceContext(context));
            if (!actionResult.consumesAction()) {
                InteractionResult actionResult2 = use(context.getLevel(), context.getPlayer(), context.getHand()).getResult();
                return actionResult2 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : actionResult2;
            } else {
                return actionResult;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<net.minecraft.network.chat.Component> tooltip, TooltipFlag ctx) {
        super.appendHoverText(stack, world, tooltip, ctx);
        tooltip.add(CommonComponents.EMPTY);
        tooltip.add(Component.translatable("item.urban_decor.toolbox.use").withStyle(ChatFormatting.GRAY));
        tooltip.add(CommonComponents.space().append(Component.translatable("item.urban_decor.toolbox.desc").withStyle(ChatFormatting.BLUE)));
    }
}
