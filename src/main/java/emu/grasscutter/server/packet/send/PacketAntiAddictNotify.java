package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AntiAddictNotifyOuterClass.AntiAddictNotify;

public class PacketAntiAddictNotify extends BasePacket {
    public PacketAntiAddictNotify(int MsgType, String msg) {
        super(PacketOpcodes.AntiAddictNotify);

        AntiAddictNotify proto = AntiAddictNotify.newBuilder()
            .setMsgType(MsgType)
            .setMsg(msg)
            .build();

        this.setData(proto);
    }
}
