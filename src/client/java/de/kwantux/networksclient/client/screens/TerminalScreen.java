package de.kwantux.networksclient.client.screens;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class TerminalScreen extends CottonInventoryScreen<TerminalScreenDescription> {
    public TerminalScreen(TerminalScreenDescription gui, Player player) {
        super(gui, player, Component.translatable("gui.networksclient.terminal"));
    }
}
