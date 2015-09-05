package net.whcuk.whitehorsecraft.whitehorsecore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.ImmutableBiMap.Builder;

public class WhiteHorseCore extends JavaPlugin implements ActionListener {
	public final String VERSION = "1.5";
	int time = 0;
	Timer timer = new Timer(100, this);

	@Override
	public void onEnable() {
		getLogger().info("WhiteHorseCraft Booting!");

	}

	@Override
	public void onDisable() {
		getLogger().info("WhiteHorseCraft Exited Sucessfully!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("whc")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					String playername = sender.getName();
					sender.sendMessage("Welcome to WhiteHorseCraft " + playername + "!");
				} else {
					sender.sendMessage("Hello, Console/CommandBlock!");
				}
				return true;
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("version")) {
					sender.sendMessage("You are playing WhiteHorseCraft version " + VERSION);
					return true;
				}
			}
			} else if (cmd.getName().equalsIgnoreCase("reboot")) {
				sender.getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 60 seconds!");
				time = 0;
				timer.setInitialDelay(30000);
				timer.start();
				return true;
			}
		return false;
		}
		

	public void actionPerformed(ActionEvent e) {
		if (time == 60) {
			getServer().shutdown();
		} else if (time == 59) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting Now!");
			timer.setDelay(1000);
			time = 60;
		} else if (time == 58) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 1 Seconds!");
			timer.setDelay(1000);
			time = 59;
		} else if (time == 57) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 2 Seconds!");
			timer.setDelay(1000);
			time = 58;
		} else if (time == 56) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 3 Seconds!");
			timer.setDelay(1000);
			time = 57;
		} else if (time == 55) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 4 Seconds!");
			timer.setDelay(1000);
			time = 56;
		} else if (time == 54) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 5 Seconds!");
			timer.setDelay(1000);
			time = 55;
		} else if (time == 53) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 6 Seconds!");
			timer.setDelay(1000);
			time = 54;
		} else if (time == 52) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 7 Seconds!");
			timer.setDelay(1000);
			time = 53;
		} else if (time == 51) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 8 Seconds!");
			timer.setDelay(1000);
			time = 52;
		} else if (time == 50) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 9 Seconds!");
			timer.setDelay(1000);
			time = 51;
		} else if (time == 40) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 10 Seconds!");
			timer.setDelay(1000);
			time = 50;
		} else if (time == 30) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 20 Seconds!");
			timer.setDelay(10000);
			time = 40;
		} else if (time == 0) {
			getServer().broadcastMessage(ChatColor.RED + "Server Rebooting in 30 Seconds!");
			timer.setDelay(10000);
			time = 30;
		}
	}
}
