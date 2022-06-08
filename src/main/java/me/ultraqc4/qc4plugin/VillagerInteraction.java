package me.ultraqc4.qc4plugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class VillagerInteraction implements Listener {

    @EventHandler
    public void VillagerInteractionV(PlayerInteractEntityEvent event)
    {
        Entity entity = event.getRightClicked();
        System.out.println("VILLAGER INTERACT");
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null)
        {
            if (entity instanceof Villager && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Admin Rod")) {
                System.out.println("VILLAGER INTERACT WITH ROD");
                Villager villager = (Villager) entity;
                villager.setRecipes(new ArrayList<>());
                VillagerTradeChanger vtc = new VillagerTradeChanger();
                vtc.ReadBook(event.getPlayer(), event.getRightClicked());
            }

        }
    }
}
