package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.OpenStateData;
import emu.grasscutter.game.player.*;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.OpenStateUpdateNotifyOuterClass.OpenStateUpdateNotify;

import static emu.grasscutter.config.Configuration.GAME_OPTIONS;

/*
    Must be sent on login for openStates to work
    Tells the client to update its openStateMap for the keys sent. value is irrelevant
 */
public class PacketOpenStateUpdateNotify extends BasePacket {

    public PacketOpenStateUpdateNotify(Player player) {
        super(PacketOpcodes.OpenStateUpdateNotify);

        OpenStateUpdateNotify.Builder proto = OpenStateUpdateNotify.newBuilder();

        GameData.getOpenStateList().stream().map(OpenStateData::getId).forEach(id -> {

            // 将所有OpenState的状态改为1 也就是全部打开 与/unlockall效果相同
            proto.putOpenStateMap(id, 1);
            proto.putOpenStateMap(48, 0);   // // 把地图大边界状态改为0

            if ((id == 45) && !GAME_OPTIONS.resinOptions.resinUsage) {
                proto.putOpenStateMap(45, 0);  // Remove resin from map
                return;
            }
            // If the player has an open state stored in their map, then it would always override any default value
            if (player.getOpenStates().containsKey(id)) {
                proto.putOpenStateMap(id, player.getProgressManager().getOpenState(id));
            }
            // Otherwise, add the state if it is contained in the set of default open states.
            else if (PlayerProgressManager.DEFAULT_OPEN_STATES.contains(id)) {
                proto.putOpenStateMap(id, 1);
            }
        });

        this.setData(proto);
    }
}
