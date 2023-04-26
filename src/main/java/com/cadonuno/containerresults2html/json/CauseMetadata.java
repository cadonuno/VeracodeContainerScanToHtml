package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CauseMetadata {
    @JsonProperty("Code")
    public Code code;
    @JsonProperty("Provider")
    public String provider;
    @JsonProperty("Service")
    public String service;
    @JsonProperty("EndLine")
    public int endLine;
    @JsonProperty("Resource")
    public String resource;
    @JsonProperty("StartLine")
    public int startLine;
}
