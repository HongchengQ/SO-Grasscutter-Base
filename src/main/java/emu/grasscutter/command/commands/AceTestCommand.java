package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketReportFightAntiCheatNotify;

import java.util.List;

@Command(
        label = "AceTest",
        usage = {"ace <msg>"},
        permission = "server.AceTest",
        targetRequirement = Command.TargetRequirement.PLAYER)
public final class AceTestCommand implements CommandHandler {

    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.isEmpty()) {
            sendUsageMessage(sender);
            return;
        }

        int CheatType = Integer.parseInt(args.get(0));
        var CheatCount = 1;
        if (args.size() == 2) {
            CheatCount = Integer.parseInt(args.get(1));
        }

        targetPlayer.sendPacket(new PacketReportFightAntiCheatNotify(CheatType, CheatCount));
    }

}
