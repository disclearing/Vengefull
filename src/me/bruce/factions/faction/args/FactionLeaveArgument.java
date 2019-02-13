package me.bruce.factions.faction.args;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import LorexMC.us.utils.other.command.CommandArgument;
import me.bruce.factions.LorexHCF;
import me.bruce.factions.faction.struct.Relation;
import me.bruce.factions.faction.struct.Role;
import me.bruce.factions.faction.type.PlayerFaction;

import java.util.UUID;

public class FactionLeaveArgument extends CommandArgument {

	private final LorexHCF plugin;

	public FactionLeaveArgument(LorexHCF plugin) {
		super("leave", "Leave your current faction.");
		this.plugin = plugin;
	}

	@Override
	public String getUsage(String label) {
		return '/' + label + ' ' + getName();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can leave faction.");
			return true;
		}

		Player player = (Player) sender;
		PlayerFaction playerFaction = plugin.getFactionManager().getPlayerFaction(player);

		if (playerFaction == null) {
			sender.sendMessage(ChatColor.RED + "You are not in a faction.");
			return true;
		}

		UUID uuid = player.getUniqueId();
		if (playerFaction.getMember(uuid).getRole() == Role.LEADER) {
			sender.sendMessage(ChatColor.RED + "You cannot leave factions as a leader. Either use " + ChatColor.GOLD
					+ '/' + label + " disband" + ChatColor.RED + " or " + ChatColor.GOLD + '/' + label + " leader"
					+ ChatColor.RED + '.');

			return true;
		}

		if (playerFaction.removeMember(player, player, player.getUniqueId(), false, false)) {
			sender.sendMessage(ChatColor.YELLOW + "Successfully left the faction.");
			playerFaction.broadcast(
					Relation.ENEMY.toChatColour() + sender.getName() + ChatColor.YELLOW + " has left the faction.");
		}

		return true;
	}
}
