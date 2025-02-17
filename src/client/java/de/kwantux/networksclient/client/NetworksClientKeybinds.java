package de.kwantux.networksclient.client;

import com.mojang.blaze3d.platform.InputConstants;
import de.kwantux.networksclient.client.screens.TerminalScreen;
import de.kwantux.networksclient.client.screens.TerminalScreenDescription;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Inventory;
import org.lwjgl.glfw.GLFW;

public class NetworksClientKeybinds {

    private static KeyMapping OPEN_TERMINAL;

    public static void init() {
        OPEN_TERMINAL = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.networksclient.terminal",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "key.categories.networksclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(NetworksClientKeybinds::tick);
    }

    private static void tick(Minecraft mc) {
        while (OPEN_TERMINAL.consumeClick()) {
            assert mc.player != null;
            mc.setScreen(new TerminalScreen(new TerminalScreenDescription(0, mc.player.getInventory(), new Inventory(mc.player)), mc.player));
        }
    }
}
