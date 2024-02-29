package mnt.damgel.hackerchecker.events;

import mnt.damgel.hackerchecker.commands.CheckCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class BanChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {


        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if (CheckCommand.playerOnCheck.containsKey(playerUUID)) {
            if (CheckCommand.isPlayerOnCheck(playerUUID)) {
                if (!event.getMessage().startsWith("/contact")) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(ChatColor.RED + "You are allowed to use just /contact");
                }
            }
        }

    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if (CheckCommand.playerOnCheck.containsKey(playerUUID)) {
            if (CheckCommand.isPlayerOnCheck(playerUUID)) {
                String message = event.getMessage();
                if (!message.startsWith("/contact")) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(ChatColor.RED + "You are allowed to use just /contact");
                }
            }
        }
    }
}
