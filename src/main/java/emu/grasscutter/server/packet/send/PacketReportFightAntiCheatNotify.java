package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.ReportFightAntiCheatNotifyOuterClass.ReportFightAntiCheatNotify;

public class PacketReportFightAntiCheatNotify extends BasePacket {

    public PacketReportFightAntiCheatNotify(int CheatType, int CheatCount) {
        super(PacketOpcodes.ReportFightAntiCheatNotify, true);

        ReportFightAntiCheatNotify proto =
                ReportFightAntiCheatNotify.newBuilder()
                        .setCheatType(CheatType)
                        .setCheatCount(CheatCount)
                        .build();

        this.setData(proto);
    }
}
