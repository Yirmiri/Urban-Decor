package net.yirmiri.urban_decor.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

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
}
