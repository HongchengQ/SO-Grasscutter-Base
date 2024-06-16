package emu.grasscutter.Hotfix;


import emu.grasscutter.Grasscutter;

public class HotfixFactory {
    public static Hotfix getHotfix(String platformCodeName) {
        if ("OSRELWin".equals(platformCodeName) || "CNRELWin".equals(platformCodeName)) {
            return new HotfixWin();
        } else if ("OSRELAnd".equals(platformCodeName) || "CNRELAnd".equals(platformCodeName)) {
            return new HotfixAndroid();
        } else if ("OSRELios".equals(platformCodeName) || "CNRELios".equals(platformCodeName)) {
            return new Hotfixios();
        } else {
            Grasscutter.getLogger().warn("未知客户端{} 热更新信息不存在", platformCodeName);
            return new HotfixNocode();
        }
    }
}
