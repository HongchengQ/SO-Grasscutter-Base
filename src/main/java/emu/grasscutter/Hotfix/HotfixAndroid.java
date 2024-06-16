package emu.grasscutter.Hotfix;

import static emu.grasscutter.config.Configuration.DISPATCH_INFO;

public class HotfixAndroid implements Hotfix {
    public static String ResourceUrl = DISPATCH_INFO.HotfixData.ResourceUrl;
    public static String DataUrl = DISPATCH_INFO.HotfixData.DataUrl;
    public static String ResourceUrlBak = DISPATCH_INFO.HotfixData.Branch;
    public static String DataUrlBak = DISPATCH_INFO.HotfixData.Branch;
    public static int ClientDataVersion = DISPATCH_INFO.HotfixData.Android.ClientDataVersion;
    public static int ClientSilenceDataVersion = DISPATCH_INFO.HotfixData.Android.ClientSilenceDataVersion;
    public static String ClientDataMd5 = DISPATCH_INFO.HotfixData.Android.ClientDataMd5;
    public static String ClientSilenceDataMd5 = DISPATCH_INFO.HotfixData.Android.ClientSilenceDataMd5;
    public static ResVersionConfig ResVersionConfig = new ResVersionConfig();
    public static String ClientVersionSuffix = DISPATCH_INFO.HotfixData.Android.ClientVersionSuffix;
    public static String ClientSilenceVersionSuffix = DISPATCH_INFO.HotfixData.Android.ClientSilenceVersionSuffix;
    static {
        ResVersionConfig.setVersion(DISPATCH_INFO.HotfixData.Android.ResVersionConfig.Version);
        ResVersionConfig.setMd5(DISPATCH_INFO.HotfixData.Android.ResVersionConfig.Md5);
        ResVersionConfig.setReleaseTotalSize("0");
        ResVersionConfig.setVersionSuffix(DISPATCH_INFO.HotfixData.Android.ResVersionConfig.VersionSuffix);
        ResVersionConfig.setBranch(DISPATCH_INFO.HotfixData.Branch);
        ResVersionConfig.setRelogin(false);
    }

    @Override
    public String getResourceUrl() { return ResourceUrl; }
    @Override
    public String getDataUrl() { return DataUrl; }
    @Override
    public String getResourceUrlBak() { return ResourceUrlBak; }
    @Override
    public String getDataUrlBak() { return DataUrlBak; }
    @Override
    public int getClientDataVersion() { return ClientDataVersion; }
    @Override
    public int getClientSilenceDataVersion() { return ClientSilenceDataVersion; }
    @Override
    public String getClientDataMd5() { return ClientDataMd5; }
    @Override
    public String getClientSilenceDataMd5() { return ClientSilenceDataMd5; }
    @Override
    public String getClientVersionSuffix() { return ClientVersionSuffix; }
    @Override
    public String getClientSilenceVersionSuffix() { return ClientSilenceVersionSuffix; }
    @Override
    public HotfixAndroid.ResVersionConfig getResVersionConfig() { return ResVersionConfig; }

    public static class ResVersionConfig extends Hotfix.ResVersionConfig {}
}
