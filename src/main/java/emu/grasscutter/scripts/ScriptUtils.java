package emu.grasscutter.scripts;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.world.Position;
import org.slf4j.Logger;
import org.terasology.jnlua.util.AbstractTableMap;

import java.util.HashMap;
import java.util.Map;


public interface ScriptUtils {
    public static final Logger logger = Grasscutter.getLogger();
    public static Integer getInt(Object value){
        if(value instanceof Integer l){
            return l.intValue();
        } else if(value instanceof Double d){
            return d.intValue();
        }
        return 0;
    }

    public static Float getFloat(Object value){
        if(value instanceof Double l){
            return l.floatValue();
        } else if(value instanceof Integer l) {
            return l.floatValue();
        }
        return 0f;
    }

    public static Map<Object, Object> toMap(Object table) {
        return (Map<Object, Object>)table;
    }

    static void print(Object table) {
        Grasscutter.getLogger().info(toMap(table).toString());
    }

    /**
     * Converts a position object into a Lua table.
     *
     * @param position The position object to convert.
     * @return The Lua table.
     */
    static Map<String, Object> posToLua(Position position) {
        Map<String, Object> result = new HashMap<>();
        if (position != null) {
            result.put("x", position.getX());
            result.put("y", position.getY());
            result.put("z", position.getZ());
        } else {
            result.put("x", 0);
            result.put("y", 0);
            result.put("z", 0);
        }

        return result;
    }

    /**
     * Converts a Lua table into a position object.
     *
     * @param position The Lua table to convert.
     * @return The position object.
     */
/*    static Position luaToPos(LuaValue position) {
        var result = new Position();
        if (position != null && !position.isnil()) {
            result.setX(position.get("x").optint(0));
            result.setY(position.get("y").optint(0));
            result.setZ(position.get("z").optint(0));
        }

        return result;
    }*/

    static int luaToPos(Object position) {
        logger.warn("luaToPos报错");
        return 0;
    }

    public static Integer[] toIntegerArray(Object luaTable) {
        var table = (AbstractTableMap)luaTable;
        return (Integer[]) table.values().stream()
            .map(i -> ((Integer)i).intValue())
            .toArray(Integer[]::new);
    }
    public static int[] toIntArray(Object luaTable) {
        var table = (AbstractTableMap)luaTable;
        return table.values().stream()
            .mapToInt(i -> ((Integer)i).intValue())
            .toArray();
    }
}
