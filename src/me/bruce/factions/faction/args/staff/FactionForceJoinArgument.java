package me.bruce.factions.faction.args.staff;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import LorexMC.us.utils.other.command.CommandArgument;
import me.bruce.factions.LorexHCF;
import me.bruce.factions.faction.FactionMember;
import me.bruce.factions.faction.struct.ChatChannel;
import me.bruce.factions.faction.struct.Role;
import me.bruce.factions.faction.type.Faction;
import me.bruce.factions.faction.type.PlayerFaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FactionListener argument used to forcefully join {@link FactionListener}s.
 */
public class FactionForceJoinArgument extends CommandArgument {

	private final LorexHCF plugin;

	public FactionForceJoinArgument(LorexHCF plugin) {
		super("forcejoin", "Forcefully join a faction.");
		this.plugin = plugin;
		this.permission = "hcf.command.faction.argument." + getName();
	}

	@Override
	public String getUsage(String label) {
		return '/' + label + ' ' + getName() + " <factionName>";
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can join factions.");
			return true;
		}

		if (args.length < 2) {
			sender.sendMessage(ChatColor.RED + "Usage: " + getUsage(label));
			return true;
		}

		Player player = (Player) sender;
		PlayerFaction playerFaction = plugin.getFactionManager().getPlayerFaction(player);

		if (playerFaction != null) {
			sender.sendMessage(ChatColor.RED + "You are already in a faction.");
			return true;
		}

		Faction faction = plugin.getFactionManager().getContainingFaction(args[1]);

		if (faction == null) {
			sender.sendMessage(
					ChatColor.RED + "FactionListener named or containing member with IGN or UUID " + args[1] + " not found.");
			return true;
		}

		if (!(faction instanceof PlayerFaction)) {
			sender.sendMessage(ChatColor.RED + "You can only join player factions.");
			return true;
		}

		playerFaction = (PlayerFaction) faction;
		if (playerFaction.addMember(player, player, player.getUniqueId(),
				new FactionMember(player, ChatChannel.PUBLIC, Role.MEMBER))) {
			playerFaction.broadcast(ChatColor.RED.toString() + ChatColor.BOLD + sender.getName()
					+ " has forcefully joined the faction.");
		}

		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if (args.length != 2 || !(sender instanceof Player)) {
			return Collections.emptyList();
		} else if (args[1].isEmpty()) {
			return null;
		} else {
			Player player = (Player) sender;
			List<String> results = new ArrayList<>(plugin.getFactionManager().getFactionNameMap().keySet());
			for (Player target : Bukkit.getOnlinePlayers()) {
				if (player.canSee(target) && !results.contains(target.getName())) {
					results.add(target.getName());
				}
			}

			return results;
		}
	}
}
