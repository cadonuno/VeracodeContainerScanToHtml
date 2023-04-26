package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Line{
    @JsonProperty("Annotation")
    public String annotation;
    @JsonProperty("Content")
    public String content;
    @JsonProperty("FirstCause")
    public boolean firstCause;
    @JsonProperty("Highlighted")
    public String highlighted;
    @JsonProperty("IsCause")
    public boolean isCause;
    @JsonProperty("LastCause")
    public boolean lastCause;
    @JsonProperty("Number")
    public int number;
    @JsonProperty("Truncated")
    public boolean truncated;
}
