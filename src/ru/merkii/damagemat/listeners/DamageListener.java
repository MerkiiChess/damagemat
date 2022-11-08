package ru.merkii.damagemat.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.merkii.damagemat.DamageMain;

public class DamageListener implements Listener {
	private DamageMain plugin;
	public DamageListener(final DamageMain plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onChat(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if(this.plugin.getConfig().getStringList("Words").contains(e.getMessage())) {
			p.damage(this.plugin.getConfig().getInt("Damage"));
			if(this.plugin.getConfig().getBoolean("DelMessage")) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
			if(p.getHealthScale() <= 0) {
				e.setMessage(this.plugin.getConfig().getString("DeathMessage").replaceAll("%player%", p.getName()).replaceAll("&", "§"));
			}
		}
	}
}
