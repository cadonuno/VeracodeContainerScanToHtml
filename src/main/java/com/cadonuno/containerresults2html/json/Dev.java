package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dev {
    @JsonProperty("profile-cpu")
    public boolean profileCpu;

    @JsonProperty("profile-mem")
    public boolean profileMem;
}
