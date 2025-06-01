package com.cerbon.brigadista_training.client.gui;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

@Environment(EnvType.CLIENT)
public class InfoOverlay implements LayeredDraw.Layer {
    private final ResourceLocation INFO_OVERLAY_TEXTURE = ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "textures/gui/screen/info_overlay.png");

    public static boolean shouldRender = false;
    public static String text = "";

    @Override
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        if (!shouldRender) return;

        Minecraft client = Minecraft.getInstance();

        client.getProfiler().push("infoOverlay");

        int imageWidth = 159;
        int transparentBackgroundHeight = 80;
        int titleBarHeight = 22;

        int x = guiGraphics.guiWidth() - imageWidth - 6;
        int y = 25;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        blit(guiGraphics, x, y, imageWidth, transparentBackgroundHeight, 0, titleBarHeight, true);
        blit(guiGraphics, x, y - 19, imageWidth, titleBarHeight);

        guiGraphics.drawCenteredString(client.font, "\uD83D\uDD25 Info", x + 80, y - 12, 16755200);

        List<FormattedCharSequence> dividedMessage = client.font.split(FormattedText.of(text), 150);

        int lineDistance = 0;
        for (FormattedCharSequence line : dividedMessage) {
            guiGraphics.drawString(client.font, line, x + 5, y + 6 + lineDistance, 0xFFFFFF, false);
            lineDistance += 9;
        }

        RenderSystem.disableBlend();
        client.getProfiler().pop();
    }

    private void blit(GuiGraphics guiGraphics, int x, int y, int uWidth, int vHeight) {
        blit(guiGraphics, x, y, uWidth, vHeight, 0, 0, false);
    }

    private void blit(GuiGraphics guiGraphics, int x, int y, int uWidth, int vHeight, int uOffset, int vOffset, boolean transparency) {
        if (transparency)
            setTransparency(guiGraphics, 0.7F);

        guiGraphics.blit(INFO_OVERLAY_TEXTURE, x, y, uOffset, vOffset, uWidth, vHeight);

        if (transparency)
            setTransparency(guiGraphics, 1.0F);
    }

    private void setTransparency(GuiGraphics guiGraphics, float transparency) {
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, transparency);
    }
}
