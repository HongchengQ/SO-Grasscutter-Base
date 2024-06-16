package emu.grasscutter.Hotfix;

public class HotfixNocode implements Hotfix {
    public static String resourceUrl = "";
    public static String dataUrl = "";
    public static String resourceUrlBak = "";
    public static String dataUrlBak = "";
    public static int clientDataVersion = 0;
    public static int clientSilenceDataVersion = 0;
    public static String clientDataMd5 = "";
    public static String clientSilenceDataMd5 = "";
    public static ResVersionConfig resVersionConfig = new ResVersionConfig();
    public static String clientVersionSuffix = "";
    public static String clientSilenceVersionSuffix = "";
    public static String nextResourceUrl = "";

    static {
        resVersionConfig.setVersion(0);
        resVersionConfig.setMd5("");
        resVersionConfig.setReleaseTotalSize("");
        resVersionConfig.setVersionSuffix("");
        resVersionConfig.setBranch("");
        resVersionConfig.setRelogin(false);
    }

    @Override
    public String getResourceUrl() { return resourceUrl; }
    @Override
    public String getDataUrl() { return dataUrl; }
    @Override
    public String getResourceUrlBak() { return resourceUrlBak; }
    @Override
    public String getDataUrlBak() { return dataUrlBak; }
    @Override
    public int getClientDataVersion() { return clientDataVersion; }
    @Override
    public int getClientSilenceDataVersion() { return clientSilenceDataVersion; }
    @Override
    public String getClientDataMd5() { return clientDataMd5; }
    @Override
    public String getClientSilenceDataMd5() { return clientSilenceDataMd5; }
    @Override
    public String getClientVersionSuffix() { return clientVersionSuffix; }
    @Override
    public String getClientSilenceVersionSuffix() { return clientSilenceVersionSuffix; }
    @Override
    public ResVersionConfig getResVersionConfig() { return resVersionConfig; }

    public static class ResVersionConfig extends Hotfix.ResVersionConfig {}
}
