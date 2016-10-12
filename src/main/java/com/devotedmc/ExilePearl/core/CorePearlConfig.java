package com.devotedmc.ExilePearl.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.plugin.Plugin;

import com.devotedmc.ExilePearl.ExileRule;
import com.devotedmc.ExilePearl.RepairMaterial;
import com.devotedmc.ExilePearl.config.Document;
import com.devotedmc.ExilePearl.config.PearlConfig;

final class CorePearlConfig extends CoreConfiguration implements PearlConfig {
	
	public CorePearlConfig(final Plugin plugin) {
		super(plugin);
	}

	@Override
	public boolean getUseDevRamStorage() {
		return doc.getBoolean("storage.use_dev_ram_storage", false);
	}

	@Override
	public String getMySqlHost() {
		return doc.getString("storage.mysql.host", "localhost");
	}

	@Override
	public String getMySqlName() {
		return doc.getString("storage.mysql.dbname", "bukkit");
	}

	@Override
	public String getMySqlUsername() {
		return doc.getString("storage.mysql.username", "bukkit");
	}

	@Override
	public String getMySqlPassword() {
		return doc.getString("storage.mysql.password", "");
	}

	@Override
	public int getMySqlPort() {
		return doc.getInteger("storage.mysql.port", 3306);
	}

	@Override
	public int getMySqlPoolSize() {
		return doc.getInteger("storage.mysql.pool_size", 5);
	}

	@Override
	public int getMySqlConnectionTimeout() {
		return doc.getInteger("storage.mysql.connection_timeout", 5000);
	}

	@Override
	public int getMySqlIdleTimeout() {
		return doc.getInteger("storage.mysql.idle_timeout", 5000);
	}

	@Override
	public int getMySqlMaxLifetime() {
		return doc.getInteger("storage.mysql.max_lifetime", 5000);
	}

	@Override
	public int getPearlHealthDecayIntervalMin() {
		return doc.getInteger("pearls.decay_interval_min", 60);
	}

	@Override
	public int getPearlHealthDecayAmount() {
		return doc.getInteger("pearls.decay_amount", 1);
	}

	@Override
	public int getPearlHealthStartValue() {
		return doc.getInteger("pearls.start_value", 12);
	}

	@Override
	public int getPearlHealthMaxValue() {
		return doc.getInteger("pearls.max_value", 336);
	}

	@Override
	public boolean getShouldAutoFreeWorldBorder() {
		return doc.getBoolean("pearls.autofree_worldborder", true);
	}

	@Override
	public boolean getMustPrisonPearlHotBar() {
		return doc.getBoolean("pearls.hotbar_needed", true);
	}

	@Override
	public boolean getFreeByThrowing() {
		return doc.getBoolean("pearls.free_by_throwing", false);
	}

	@Override
	public Set<RepairMaterial> getRepairMaterials() {
		Set<RepairMaterial> repairs = new HashSet<RepairMaterial>();
		Document repairRecipes = doc.getDocument("pearls.repair_materials");
		
		for(String repairName : repairRecipes.keySet()) {
			repairs.add(RepairMaterial.fromDocument(repairName, repairRecipes.getDocument(repairName)));
		}
		
		return repairs;
	}

	@Override
	public List<String> getProtectedAnimals() {
		return doc.getStringList("rules.protected_mobs");
	}

	@Override
	public int getSuicideTimeoutSeconds() {
		return doc.getInteger("general.suicide_time_seconds", 180);
	}

	@Override
	public int getDamageLogMin() {
		return doc.getInteger("general.damage_log_min", 5);
	}

	@Override
	public int getDamagelogTicks() {
		return doc.getInteger("general.damage_log_min", 5);
	}

	@Override
	public int getRulePearlRadius() {
		return doc.getInteger("rules.pearl_radius", 1000);
	}

	@Override
	public void setRulePearlRadius(int value) {
		doc.append("rules.pearl_radius", value);
	}

	@Override
	public boolean canPerform(ExileRule rule) {
		switch(rule) {
		case PEARL_RADIUS:
			return getRulePearlRadius() > 0;

		case DAMAGE_REINFORCEMENT:
			return doc.getBoolean("rules.damage_reinforcement", false);
			
		case DAMAGE_BASTION:
			return doc.getBoolean("rules.damage_bastion", false);
			
		case CREATE_BASTION:
			return doc.getBoolean("rules.create_bastion", false);
			
		case ENTER_BASTION:
			return doc.getBoolean("rules.enter_bastion", false);
			
		case THROW_PEARL:
			return doc.getBoolean("rules.throw_pearl", false);
			
		case CHAT:
			return doc.getBoolean("rules.chat_local", false);
			
		case PVP:
			return doc.getBoolean("rules.pvp", false);
			
		case KILL_PETS:
			return doc.getBoolean("rules.kill_pets", false);
			
		case KILL_MOBS:
			return doc.getBoolean("rules.kill_mobs", false);
			
		case IGNITE:
			return doc.getBoolean("rules.ignite", false);
			
		case USE_BUCKET:
			return doc.getBoolean("rules.use_bucket", false);
			
		case USE_POTIONS:
			return doc.getBoolean("rules.use_potions", false);
			
		case USE_BED:
			return doc.getBoolean("rules.use_bed", false);
			
		case SUICIDE:
			return doc.getBoolean("rules.suicide", false);
			
		case SNITCH:
			return doc.getBoolean("rules.place_snitch", false);
			
		case MINE:
			return doc.getBoolean("rules.mine_blocks", true);
			
		case BREW:
			return doc.getBoolean("rules.brew", true);
			
		case ENCHANT:
			return doc.getBoolean("rules.enchant", true);
			
		default:
			return false;
		}
	}

	@Override
	public void setRule(ExileRule rule, boolean value) {
		switch(rule) {
		case DAMAGE_REINFORCEMENT:
			doc.append("rules.damage_reinforcement", value);
			break;
			
		case DAMAGE_BASTION:
			doc.append("rules.damage_bastion", value);
			break;
			
		case CREATE_BASTION:
			doc.append("rules.create_bastion", value);
			break;
			
		case ENTER_BASTION:
			doc.append("rules.enter_bastion", value);
			break;
			
		case THROW_PEARL:
			doc.append("rules.throw_pearl", value);
			break;
			
		case CHAT:
			doc.append("rules.chat_local", value);
			break;
			
		case PVP:
			doc.append("rules.pvp", value);
			break;
			
		case KILL_PETS:
			doc.append("rules.kill_pets", value);
			break;
			
		case KILL_MOBS:
			doc.append("rules.kill_mobs", value);
			break;
			
		case IGNITE:
			doc.append("rules.ignite", value);
			break;
			
		case USE_BUCKET:
			doc.append("rules.use_bucket", value);
			break;
			
		case USE_POTIONS:
			doc.append("rules.use_potions", value);
			break;
			
		case USE_BED:
			doc.append("rules.use_bed", value);
			break;
			
		case SUICIDE:
			doc.append("rules.suicide", value);
			break;
			
		case SNITCH:
			doc.append("rules.place_snitch", value);
			break;
			
		case MINE:
			doc.append("rules.mine_blocks", value);
			break;
			
		case BREW:
			doc.append("rules.brew", value);
			break;
			
		case ENCHANT:
			doc.append("rules.enchant", true);
			break;
			
		default:
			break;
		}
	}
	
}