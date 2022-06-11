package me.ultraqc4.qc4plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class AddLife implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player playerSender = (Player) sender;
            Team teamT = playerSender.getScoreboard().getEntryTeam(playerSender.getName());
            String team = teamT.getName();

            if (team.equals("ADMIN")) {

                if (args.length > 0) {
                    String playerTargetName = args[0];
                    Player playerTarget = Bukkit.getPlayer(playerTargetName);

                    if (playerTarget == null) return false;

                    LifesPlayers lifesPlayers = new LifesPlayers();
                    lifesPlayers.AddLife(1, playerTarget);

                }
            }
        }
        return true;
    }
}
