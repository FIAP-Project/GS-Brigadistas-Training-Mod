package com.cerbon.brigadista_training.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class APIScreen extends Screen {

    private EditBox apiBox;

    private Button saveButton;

    private final Minecraft client = Minecraft.getInstance();

    public APIScreen() {
        super(Component.literal("API Screen"));
    }

    @Override
    protected void init() {
        this.apiBox = new EditBox(this.font, this.width / 2 - 150, this.height / 2 - 20, 300, 20, Component.literal("API Key"));

        this.saveButton = Button.builder(Component.literal("Save"), this::onSave).pos(this.width / 2 - 75, this.height / 2 + 5).width(150).build();

        this.addRenderableWidget(this.apiBox);
        this.addRenderableWidget(this.saveButton);

        this.setInitialFocus(this.apiBox);
    }

    @Override
    public void resize(Minecraft minecraft, int width, int height) {
        String s = this.apiBox.getValue();

        this.init(minecraft, width, height);

        this.apiBox.setValue(s);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        guiGraphics.drawString(this.font, Component.literal("API Key"), this.width / 2 - 150, this.height / 2 - 35, 10526880);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void onSave(Button button) {
        //TODO: Validate token?
        if (!apiBox.getValue().isEmpty() && client.screen == this)
            client.setScreen(null);
    }
}
