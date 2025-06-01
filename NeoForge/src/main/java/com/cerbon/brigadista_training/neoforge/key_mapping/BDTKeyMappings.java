package com.cerbon.brigadista_training.neoforge.key_mapping;

import com.cerbon.brigadista_training.client.gui.InfoOverlay;
import com.cerbon.brigadista_training.client.screen.QuizScreen;
import com.cerbon.cerbons_api.api.static_utilities.MiscUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.jarjar.nio.util.Lazy;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class BDTKeyMappings {
    private static final String CATEGORY = "Debug Brigadista Training Mod";

    public static final Lazy<KeyMapping> OPEN_QUIZ_SCREEN_MAPPING = Lazy.of(
            new KeyMapping(
                    "Quiz Screen",
                    KeyConflictContext.IN_GAME,
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_G,
                    CATEGORY
            )
    );

    public static final Lazy<KeyMapping> INFO_OVERLAY_MAPPING = Lazy.of(
            new KeyMapping(
                    "Info Overlay",
                    KeyConflictContext.IN_GAME,
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_H,
                    CATEGORY
            )
    );

    public static void handleKeyPressed() {
        if (OPEN_QUIZ_SCREEN_MAPPING.get().consumeClick() && MiscUtils.isDevelopmentEnvironment())
            Minecraft.getInstance().setScreen(new QuizScreen());

        else if (INFO_OVERLAY_MAPPING.get().consumeClick() && MiscUtils.isDevelopmentEnvironment())
            InfoOverlay.shouldRender = !InfoOverlay.shouldRender;
    }
}
