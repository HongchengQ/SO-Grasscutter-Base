package emu.grasscutter.scripts.data.controller;

import emu.grasscutter.*;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.scripts.*;
import org.terasology.jnlua.LuaState;
import org.terasology.jnlua.LuaType;
import org.terasology.jnlua.LuaValueProxy;

import java.util.Set;
import javax.script.*;



public class EntityController {
    private static final Set<String> SERVER_CALLED = Set.of("OnBeHurt", "OnDie", "OnTimer");

    private transient CompiledScript entityController;
    private transient Bindings entityControllerBindings;

    public EntityController(CompiledScript entityController, Bindings entityControllerBindings) {
        this.entityController = entityController;
        this.entityControllerBindings = entityControllerBindings;
    }

    public void onBeHurt(GameEntity entity, ElementType elementType, boolean isHost) {
        callControllerScriptFunc(
                entity,
                "OnBeHurt",
            LuaType.valueOf(String.valueOf(elementType.getValue())),
            LuaType.valueOf(String.valueOf(0)),
            LuaType.valueOf(String.valueOf(isHost)));
    }

    public void onDie(GameEntity entity, ElementType elementType) {
        callControllerScriptFunc(
                entity, "OnDie", LuaType.valueOf(String.valueOf(elementType.getValue())), LuaType.valueOf(String.valueOf(0)));
    }

    public void onTimer(GameEntity entity, int now) {
        callControllerScriptFunc(entity, "OnTimer", LuaType.valueOf(String.valueOf(now)));
    }

    public int onClientExecuteRequest(GameEntity entity, int param1, int param2, int param3) {
        if (DebugConstants.LOG_LUA_SCRIPTS) {
            Grasscutter.getLogger()
                    .debug(
                            "Request on {}, {}: {}",
                            entity.getGroupId(),
                            param1,
                            entity.getPosition().toString());
        }
        LuaType value =
                callControllerScriptFunc(
                        entity,
                        "OnClientExecuteReq",
                    LuaType.valueOf(String.valueOf(param1)),
                    LuaType.valueOf(String.valueOf(param2)),
                    LuaType.valueOf(String.valueOf(param3)));
        if (value != null) return 1;

        return 0;
    }

    // TODO actual execution should probably be handle by EntityControllerScriptManager
    private LuaType callControllerScriptFunc(GameEntity entity, String funcName, LuaType arg1) {
        return callControllerScriptFunc(entity, funcName, arg1, LuaType.NIL, LuaType.NIL);
    }

    private LuaType callControllerScriptFunc(
            GameEntity entity, String funcName, LuaType arg1, LuaType arg2) {
        return callControllerScriptFunc(entity, funcName, arg1, arg2, LuaType.NIL);
    }

    private LuaType callControllerScriptFunc(
            GameEntity entity, String funcName, LuaType arg1, LuaType arg2, LuaType arg3) {
        LuaType funcLua = null;
        if (funcName != null && !funcName.isEmpty()) {
            funcLua = (LuaType) entityControllerBindings.get(funcName);
        }

        LuaType ret = LuaType.valueOf(String.valueOf(1));

        if (funcLua != null) {
            try {
                ScriptLoader.getScriptLib().setCurrentEntity(entity);
                ret = null;
            } catch (Exception e) {
                ScriptLib.logger.error(
                        "[LUA] call function failed in gadget {} with {} {} {},{}",
                        entity.getEntityTypeId(),
                        funcName,
                        arg1,
                        arg2,
                        arg3);
                ret = LuaType.valueOf(String.valueOf(-1));
            }
        } else if (funcName != null && !SERVER_CALLED.contains(funcName)) {
            ScriptLib.logger.error(
                    "[LUA] unknown func in gadget {} with {} {} {} {}",
                    entity.getEntityTypeId(),
                    funcName,
                    arg1,
                    arg2,
                    arg3);
        }
        return ret;
    }
}
