package net.yirmiri.urban_decor.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ToolboxBlockItem extends BlockItem {
    public ToolboxBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer().isSneaking()) {
            ActionResult actionResult = place(new ItemPlacementContext(context));
            if (!actionResult.isAccepted() && isFood()) {
                ActionResult actionResult2 = use(context.getWorld(), context.getPlayer(), context.getHand()).getResult();
                return actionResult2 == ActionResult.CONSUME ? ActionResult.CONSUME_PARTIAL : actionResult2;
            } else {
                return actionResult;
            }
        }
        return ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<net.minecraft.text.Text> tooltip, TooltipContext ctx) {
        super.appendTooltip(stack, world, tooltip, ctx);
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Text.translatable("item.urban_decor.toolbox.use").formatted(Formatting.GRAY));
        tooltip.add(ScreenTexts.space().append(Text.translatable("item.urban_decor.toolbox.desc").formatted(Formatting.BLUE)));
    }
}
