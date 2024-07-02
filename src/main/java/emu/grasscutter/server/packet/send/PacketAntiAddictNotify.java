package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AntiAddictNotifyOuterClass.AntiAddictNotify;

public class PacketAntiAddictNotify extends BasePacket {
    public PacketAntiAddictNotify(int MsgType, String Msg) {
        super(PacketOpcodes.AntiAddictNotify);

        AntiAddictNotify proto = AntiAddictNotify.newBuilder()
            .setMsgType(MsgType)
            .setMsg(Msg)
            .build();

        this.setData(proto);
    }
}
