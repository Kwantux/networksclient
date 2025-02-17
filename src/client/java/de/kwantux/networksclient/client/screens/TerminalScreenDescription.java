package de.kwantux.networksclient.client.screens;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;

import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public class TerminalScreenDescription extends SyncedGuiDescription {

    public TerminalScreenDescription(int syncId, Inventory playerInventory, Inventory terminalInventory) {
        super(MenuType.GENERIC_9x6 , syncId, playerInventory);

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(185, 240);

        WWidget searchField = new WTextField(Component.translatable("gui.networksclient.search"));
        root.add(searchField, 8, 20, 165, 20);

        WGridPanel containerPanel = new WGridPanel();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 50; j++) {
                WItemSlot itemSlot = WItemSlot.of(terminalInventory, 0);
                containerPanel.add(itemSlot, i, j);
            }
        }

        WScrollPanel scrollPanel = new WScrollPanel(containerPanel);
        scrollPanel.setScrollingHorizontally(TriState.FALSE);
        scrollPanel.setScrollingVertically(TriState.TRUE);

        root.add(scrollPanel, 8, 50, 170, 90);

        root.add(this.createPlayerInventoryPanel(), 8, 145);

        root.validate(this);
        searchField.requestFocus();
    }
}