package net.whcuk.whitehorsecraft.whitehorsecore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WhiteHorseCore extends JavaPlugin implements ActionListener 
{
	int time = 0;
	Timer timer = new Timer(100, this);
	@Override
	public void onEnable()
	{
		getLogger().info("WhiteHorseCraft Booting!");
		
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("WhiteHorseCraft Exited Sucessfully!");
	}

	 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("whc")) 
		{
			if (sender instanceof Player)
			{
				String playername = sender.getName();
				sender.sendMessage("Welcome to WhiteHorseCraft "+ playername + "!");
			}
			else
			{
				sender.sendMessage("Hello, Console/CommandBlock!");
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("reboot"))
		{
			sender.getServer().broadcastMessage(ChatColor.RED+"Server Rebooting in 60 seconds!");
			time = 0;
			timer.setInitialDelay(30000);
			timer.start();
			return true;
		}
		return false;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (time == 40)
		{
			getServer().shutdown();
		}
		else if (time == 30)
		{
			
		}
		else if (time == 0)
		{
			getServer().broadcastMessage(ChatColor.RED+"Server Rebooting in 30 Seconds!");
			timer.setDelay(20000);
			time = 30;
		}
	}
}
