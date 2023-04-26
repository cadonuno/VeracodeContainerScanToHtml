package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Secret{
    @JsonProperty("Category")
    public String category;
    @JsonProperty("Code")
    public Code code;
    @JsonProperty("EndLine")
    public int endLine;
    @JsonProperty("Layer")
    public Layer layer;
    @JsonProperty("Match")
    public String match;
    @JsonProperty("RuleID")
    public String ruleID;
    @JsonProperty("Severity")
    public String severity;
    @JsonProperty("StartLine")
    public int startLine;
    @JsonProperty("Title")
    public String title;
}