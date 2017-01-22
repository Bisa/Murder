package io.github.bisa.murder;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public final class Murder extends JavaPlugin {

    private static Random rand;

    @Override
    public void onEnable() {
        rand = new Random();
        getLogger().fine("Let there be Murder!");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().fine("No more Murder...");
        super.onDisable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("murder")){

            Player[] players;
            players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[Bukkit.getServer().getOnlinePlayers().size()]);

            if (players.length > 0) {
                sender.sendMessage("Commencing murder!");
                Player player = players[rand.nextInt(players.length)];
                player.setHealth(0);

                return true;
            } else {
                sender.sendMessage("There's no players for us to murder... sad panda.");
                return true;
            }

        } else {
            getLogger().finest("The command was not murder");
            return false;
        }
    }
}