package net.whcuk.whitehorsecraft.whitehorsecore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

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
	
	@EventHandler
	public void onFlightAttempt(PlayerToggleFlightEvent event) {
	 
	    if(!event.isFlying() && event.getPlayer().getGameMode() != GameMode.CREATIVE) {
	 
	        event.getPlayer().setVelocity(event.getPlayer().getVelocity().add(new Vector(0,0.25,0)));
	        event.getPlayer().setFlying(false);
	        event.setCancelled(true);
	 
	    }
	 
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
			sender.getServer().broadcastMessage("Server Rebooting in 60 seconds!");
			time = 0;
			timer.setInitialDelay(30000);
			timer.start();
			return true;
		}
		return false;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (time == 0)
		{
			getServer().broadcastMessage("Server Rebooting in 30 Seconds!");
			timer.setDelay(20000);
			time = 30;
		}
		else if (time == 30)
		{
			getServer().broadcastMessage("Server Rebooting in 10 Seconds");
			timer.setDelay(10000);
			time = 50;
		}
		else if (time == 50)
		{
			getServer().shutdown();
		}
	}
}
