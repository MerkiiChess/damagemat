package ru.merkii.damagemat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.merkii.damagemat.listeners.DamageListener;

public class DamageMain extends JavaPlugin {
	private static DamageMain instance;
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
		saveDefaultConfig();
		instance = this;
	}
	public static DamageMain getInstance() {
		return instance;
	}
}
