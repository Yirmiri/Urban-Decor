package net.yirmiri.urban_decor.common.block.sewing_machine;

import net.azurune.runiclib.RunicLib;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.yirmiri.urban_decor.UrbanDecor;

public class SewingMachineScreen extends AbstractContainerScreen<SewingMachineMenu> {
    private static final ResourceLocation BACKGROUND = RunicLib.customid(UrbanDecor.MOD_ID, "textures/gui/sewing_machine/sewing_machine.png");
    private static final ResourceLocation SCROLLER = RunicLib.customid(UrbanDecor.MOD_ID, "container/sewing_machine/scroller");
    private static final ResourceLocation SCROLLER_DISABLED = RunicLib.customid(UrbanDecor.MOD_ID, "container/sewing_machine/scroller_disabled");
    private static final ResourceLocation RECIPE_SELECTED = RunicLib.customid(UrbanDecor.MOD_ID, "container/sewing_machine/recipe_selected");
    private static final ResourceLocation RECIPE_HIGHLIGHTED = RunicLib.customid(UrbanDecor.MOD_ID, "container/sewing_machine/recipe_highlighted");
    private static final ResourceLocation RECIPE = RunicLib.customid(UrbanDecor.MOD_ID, "container/sewing_machine/recipe");

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public SewingMachineScreen(SewingMachineMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = leftPos;
        int y = topPos;

        guiGraphics.blit(BACKGROUND, x, y, 0, 0, imageWidth, imageHeight);
        guiGraphics.blitSprite(isScrollBarActive() ? SCROLLER : SCROLLER_DISABLED, x + 119, y + 15 + (int) (41.0F * scrollOffs), 12, 15);

        renderRecipeButtons(guiGraphics, mouseX, mouseY);
        renderRecipes(guiGraphics);
    }

//    @Override
//    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
//        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY - 1, 0xc1a0b8, false);
//    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private void renderRecipeButtons(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        int x = leftPos + 52;
        int y = topPos + 14;

        for (int i = startIndex; i < startIndex + 12 && i < menu.getRecipeCount(); i++) {
            int index = i - startIndex;
            int buttonX = x + (index % 4) * 16;
            int buttonY = y + (index / 4) * 18;

            ResourceLocation sprite;

            if (i == menu.getSelectedRecipeIndex()) {
                sprite = RECIPE_SELECTED;
            } else if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                sprite = RECIPE_HIGHLIGHTED;
            } else {
                sprite = RECIPE;
            }
            guiGraphics.blitSprite(sprite, buttonX, buttonY - 1, 16, 18);
        }
    }

    private void renderRecipes(GuiGraphics guiGraphics) {
        int x = leftPos + 52;
        int y = topPos + 14;

        for (int i = startIndex; i < startIndex + 12 && i < menu.getRecipeCount(); i++) {
            int index = i - startIndex;
            int itemX = x + (index % 4) * 16;
            int itemY = y + (index / 4) * 18;

            guiGraphics.renderItem(menu.getRecipeResult(i), itemX, itemY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;

        if (displayRecipes) {
            int x = leftPos + 52;
            int y = topPos + 14;

            for (int i = startIndex; i < startIndex + 12 && i < menu.getRecipeCount(); i++) {
                int index = i - startIndex;
                double dx = mouseX - (x + (index % 4) * 16);
                double dy = mouseY - (y + (index / 4) * 18);

                if (dx >= 0 && dy >= 0 && dx < 16 && dy < 18) {
                    menu.clickMenuButton(minecraft.player, i);
                    minecraft.gameMode.handleInventoryButtonClick(menu.containerId, i);
                    return true;
                }
            }

            int scrollX = leftPos + 119;
            int scrollY = topPos + 14;

            if (mouseX >= scrollX && mouseX < scrollX + 12 &&
                    mouseY >= scrollY && mouseY < scrollY + 54) {
                scrolling = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (scrolling && isScrollBarActive()) {
            int top = topPos + 14;
            int bottom = top + 54;

            scrollOffs = ((float) mouseY - top - 7.5F) / (bottom - top - 15F);
            scrollOffs = Mth.clamp(scrollOffs, 0F, 1F);

            startIndex = (int) ((scrollOffs * getOffscreenRows()) + 0.5D) * 4;

            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (isScrollBarActive()) {
            int rows = getOffscreenRows();
            scrollOffs = Mth.clamp(scrollOffs - (float)scrollY / rows, 0F, 1F);
            startIndex = (int) ((scrollOffs * rows) + 0.5D) * 4;
        }
        return true;
    }

    private boolean isScrollBarActive() {
        return displayRecipes && menu.getRecipeCount() > 12;
    }

    private int getOffscreenRows() {
        return (menu.getRecipeCount() + 4 - 1) / 4 - 3;
    }

    @Override
    protected void containerTick() {
        displayRecipes = menu.hasInputs();
        if (!displayRecipes) {
            scrollOffs = 0;
            startIndex = 0;
        }
    }
}