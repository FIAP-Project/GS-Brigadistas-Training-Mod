package com.cerbon.brigadista_training.neoforge.key_mapping;

import com.cerbon.brigadista_training.client.screen.QuizScreen;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.jarjar.nio.util.Lazy;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class BDTKeyMappings {
    public static final Lazy<KeyMapping> OPEN_QUIZ_SCREEN_MAPPING = Lazy.of(
            new KeyMapping(
                    "Quiz Screen",
                    KeyConflictContext.IN_GAME,
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_G,
                    "Training"
            )
    );

    public static void handleKeyPressed() {
        if (OPEN_QUIZ_SCREEN_MAPPING.get().consumeClick())
            Minecraft.getInstance().setScreen(new QuizScreen());
    }
}
