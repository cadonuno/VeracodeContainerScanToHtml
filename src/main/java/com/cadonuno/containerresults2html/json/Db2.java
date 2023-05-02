package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Db2 {
    @JsonProperty("cache-dir")
    public String cacheDir;

    @JsonProperty("update-url")
    public String updateUrl;

    @JsonProperty("ca-cert")
    public String caCert;

    @JsonProperty("auto-update")
    public boolean autoUpdate;

    @JsonProperty("validate-by-hash-on-start")
    public boolean validateByHashOnStart;

    @JsonProperty("validate-age")
    public boolean validateAge;

    @JsonProperty("max-allowed-built-age")
    public long maxAllowedBuiltAge;
}
