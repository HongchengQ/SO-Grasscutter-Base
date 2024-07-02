package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu. grasscutter.config.ConfigContainer.JoinOptions;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAntiAddictNotify;
import emu.grasscutter.server.packet.send.PacketTowerAllDataRsp;

@Opcodes(PacketOpcodes.TowerAllDataReq)
public class HandlerTowerAllDataReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketAntiAddictNotify(1, JoinOptions.noticeMessage));
        session.send(
                new PacketTowerAllDataRsp(
                        session.getServer().getTowerSystem(), session.getPlayer().getTowerManager()));
    }
}
