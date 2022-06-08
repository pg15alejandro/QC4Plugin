package me.ultraqc4.qc4plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Team;

public class AdminRod implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        System.out.println("COMMAND CALLED");

        if (sender instanceof Player) {
            System.out.println("ROD FIRST IF");
            Player player = (Player) sender;
            Team teamT = player.getScoreboard().getEntryTeam(player.getName());
            String team = teamT.getName();
            System.out.println("TEAM OF COMMAND CALLER IS " + team);
            if (team.equals("ADMIN")) {
                System.out.println("ROD SECOND IF");
                ItemStack adminRod = new ItemStack(Material.STICK);
                ItemMeta itemMeta = adminRod.getItemMeta();
                itemMeta.setDisplayName("Admin Rod");
                itemMeta.addEnchant(Enchantment.DURABILITY, 4, true);
                adminRod.setItemMeta(itemMeta);
                adminRod.setAmount(1);
                player.getInventory().addItem(adminRod);
            }
        }
        return true;
    }
}
