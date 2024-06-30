package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketCodexDataUpdateNotify;

import java.util.List;

@Command(
    label = "QuestAddAll",
    usage = {"QuestAddAll"},
    permission = "server.QuestAddAll",
    targetRequirement = Command.TargetRequirement.PLAYER)
public final class QuestAddAllCommand implements CommandHandler {

    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {

        int typeValue = Integer.parseInt(args.get(0)); //10010007
        int codexId = Integer.parseInt(args.get(1));


        targetPlayer.sendPacket(new PacketCodexDataUpdateNotify(typeValue, codexId));
    }

}
