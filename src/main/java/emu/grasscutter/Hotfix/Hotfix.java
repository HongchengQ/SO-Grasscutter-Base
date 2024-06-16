package emu.grasscutter.Hotfix;

import lombok.Getter;
import lombok.Setter;

public interface Hotfix {
    String getResourceUrl();
    String getDataUrl();
    String getResourceUrlBak();
    String getDataUrlBak();
    int getClientDataVersion();
    int getClientSilenceDataVersion();
    String getClientDataMd5();
    String getClientSilenceDataMd5();
    String getClientVersionSuffix();
    String getClientSilenceVersionSuffix();
    ResVersionConfig getResVersionConfig();

    @Setter
    @Getter
    class ResVersionConfig {
        // Getters and setters
        public int version;
        public String md5;
        public String releaseTotalSize;
        public String versionSuffix;
        public String branch;
        public boolean relogin;

        public ResVersionConfig() {}

        public ResVersionConfig(int version, String md5, String releaseTotalSize, String versionSuffix, String branch, boolean relogin) {
            this.version = version;
            this.md5 = md5;
            this.releaseTotalSize = releaseTotalSize;
            this.versionSuffix = versionSuffix;
            this.branch = branch;
            this.relogin = relogin;
        }

    }
}
