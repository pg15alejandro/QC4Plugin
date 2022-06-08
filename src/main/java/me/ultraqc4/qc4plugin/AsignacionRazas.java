package me.ultraqc4.qc4plugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class AsignacionRazas implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        System.out.println(block.getType());

        if (block.getType() == Material.STONE) {
            Player player = event.getPlayer();

            System.out.println(player.getScoreboard().getEntryTeam(player.getName()));
            if (player.getScoreboard().getEntryTeam(player.getName()) == null) {
                event.setCancelled(true);
            }
        }
    }
}
