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
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

@Environment(EnvType.CLIENT)
public class InfoOverlay implements LayeredDraw.Layer {
    private final ResourceLocation INFO_OVERLAY_TEXTURE = ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "textures/gui/screen/info_overlay.png");

    private static float alpha = 0.0F;
    private static int fadeDir = 0;

    private static String text = "";
    private static boolean isRendering = false;

    public static final InfoOverlay INSTANCE = new InfoOverlay();

    public static void show(String msg) {
        text = msg;
        fadeDir = 1;
        isRendering = true;
    }

    public static void hide() {
        fadeDir = -1;
        isRendering = false;
    }

    public static boolean isRendering() {
        return isRendering;
    }

    @Override
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        if (fadeDir != 0) {
            int FADE_TICKS = 20;

            float step = 1.0F / FADE_TICKS;
            alpha += step * fadeDir;
            if (alpha >= 1.0F) { alpha = 1.0F; fadeDir = 0; }  // finished fade-in
            if (alpha <= 0.0F) { alpha = 0.0F; fadeDir = 0; }  // finished fade-out
        }

        if (alpha == 0.0F) return;

        Minecraft client = Minecraft.getInstance();
        client.getProfiler().push("infoOverlay");

        int imageWidth                = 159;
        int transparentBackgroundHeight = 80;
        int titleBarHeight            = 22;

        int x = guiGraphics.guiWidth() - imageWidth - 6;
        int y = 25;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        blit(guiGraphics, x, y, imageWidth, transparentBackgroundHeight, 0, titleBarHeight, true);
        blit(guiGraphics, x, y - 19, imageWidth, titleBarHeight);

        guiGraphics.drawCenteredString(
                client.font,
                "\uD83D\uDD25 Info",
                x + imageWidth / 2,
                y - 12,
                FastColor.ARGB32.colorFromFloat(alpha, 1.0F, 0.6666666667F, 0F)
        );

        List<FormattedCharSequence> lines = client.font.split(FormattedText.of(text), 154);

        int lineY = y + 6;
        for (FormattedCharSequence line : lines) {
            guiGraphics.drawString(
                    client.font,
                    line,
                    x + 5,
                    lineY,
                    0xFFFFFF | ((int) (alpha * 255) << 24),
                    false);
            lineY += 9;
        }

        RenderSystem.disableBlend();
        client.getProfiler().pop();
    }

    private void blit(GuiGraphics guiGraphics, int x, int y, int uWidth, int vHeight) {
        blit(guiGraphics, x, y, uWidth, vHeight, 0, 0, false);
    }

    private void blit(GuiGraphics guiGraphics, int x, int y, int uWidth, int vHeight, int uOffset, int vOffset, boolean background) {
        if (background)
            setTransparency(guiGraphics, 0.7F * alpha);
        else
            setTransparency(guiGraphics, alpha);

        guiGraphics.blit(INFO_OVERLAY_TEXTURE,x, y, uOffset, vOffset, uWidth, vHeight);

        setTransparency(guiGraphics, 1.0F); // reset for next draws
    }

    private void setTransparency(GuiGraphics guiGraphics, float a) {
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, a);
    }
}
