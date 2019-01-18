package net.novelmc.novelengine.command;

import net.novelmc.novelengine.command.util.CommandBase;
import net.novelmc.novelengine.command.util.CommandParameters;
import net.novelmc.novelengine.command.util.SourceType;
import net.novelmc.novelengine.rank.Rank;
import net.novelmc.novelengine.util.NPlayer;
import net.novelmc.novelengine.util.NUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Toggle CommandSpy", aliases = "cmdspy", source = SourceType.IN_GAME, rank = Rank.TRAINEE)
public class Command_commandspy extends CommandBase
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        Player player = (Player) sender;
        NPlayer.commandSpyPlayers.add(player);
        sender.sendMessage(NUtil.colorize("&8<-> &3&lINFO &7Your gamemode has been set to creative."));
        return true;
        // INCOMPLETE
    }
}
