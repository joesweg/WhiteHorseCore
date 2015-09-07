package net.whcuk.whitehorsecraft.whitehorsecore;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Listen implements Listener {

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand().equals(Material.NETHER_STAR)) {
			e.getPlayer().openInventory(WhiteHorseCore.getInstance().getWHCMenu());
		}
	}
}
