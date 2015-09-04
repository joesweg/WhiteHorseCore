package net.whcuk.whitehorsecraft.whitehorsecore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WhiteHorseCore extends JavaPlugin 
{
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
		return false;
	}
}
