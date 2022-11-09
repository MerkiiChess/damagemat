package ru.merkii.damagemat.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.merkii.damagemat.DamageMain;

public class DamageListener implements Listener {
	@EventHandler
	public void onChat(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if(DamageMain.getInstance().getConfig().getStringList("Words").contains(e.getMessage())) {
			p.damage(DamageMain.getInstance().getConfig().getInt("Damage"));
			e.setCancelled(DamageMain.getInstance().getConfig().getBoolean("DelMessage"));
			if(p.getHealthScale() <= 0) {
				e.setMessage(DamageMain.getInstance().getConfig().getString("DeathMessage"));
			}
		}
	}
}
