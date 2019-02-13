package me.bruce.factions.faction.args;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import LorexMC.us.utils.other.command.CommandArgument;
import me.bruce.factions.LorexHCF;
import me.bruce.factions.faction.claim.Claim;
import me.bruce.factions.faction.type.ClaimableFaction;
import me.bruce.factions.faction.type.Faction;
import me.bruce.factions.faction.type.PlayerFaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * FactionListener argument used to check {@link Claim}s made by {@link FactionListener}s.
 */
public class FactionClaimsArgument extends CommandArgument {

	private final LorexHCF plugin;

	public FactionClaimsArgument(LorexHCF plugin) {
		super("claims", "View all claims for a faction.");
		this.plugin = plugin;
	}

	@Override
	public String getUsage(String label) {
		return '/' + label + ' ' + getName() + " [factionName]";
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		PlayerFaction selfFaction = sender instanceof Player
				? plugin.getFactionManager().getPlayerFaction((Player) sender)
				: null;
		ClaimableFaction targetFaction;
		if (args.length < 2) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Usage: " + getUsage(label));
				return true;
			}

			if (selfFaction == null) {
				sender.sendMessage(ChatColor.RED + "You are not in a faction.");
				return true;
			}

			targetFaction = selfFaction;
		} else {
			Faction faction = plugin.getFactionManager().getContainingFaction(args[1]);

			if (faction == null) {
				sender.sendMessage(ChatColor.RED + "FactionListener named or containing member with IGN or UUID " + args[1]
						+ " not found.");
				return true;
			}

			if (!(faction instanceof ClaimableFaction)) {
				sender.sendMessage(ChatColor.RED + "You can only check the claims of factions that can have claims.");
				return true;
			}

			targetFaction = (ClaimableFaction) faction;
		}

		Collection<Claim> claims = targetFaction.getClaims();

		if (claims.isEmpty()) {
			sender.sendMessage(ChatColor.RED + "FactionListener " + targetFaction.getDisplayName(sender) + ChatColor.RED
					+ " has no claimed land.");
			return true;
		}

		if (sender instanceof Player && !sender.isOp()
				&& (targetFaction instanceof PlayerFaction && ((PlayerFaction) targetFaction).getHome() == null)) {
			if (selfFaction != targetFaction) {
				sender.sendMessage(ChatColor.RED + "You cannot view the claims of "
						+ targetFaction.getDisplayName(sender) + ChatColor.RED + " because their home is unset.");
				return true;
			}
		}

		sender.sendMessage(ChatColor.GOLD + "Claims of " + targetFaction.getDisplayName(sender) + ChatColor.GOLD + " ("
				+ claims.size() + "):");

		for (Claim claim : claims) {
			sender.sendMessage(ChatColor.GRAY + " " + claim.getFormattedName());
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
			Player player = ((Player) sender);
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