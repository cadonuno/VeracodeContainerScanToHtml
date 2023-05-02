package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Result{
    @JsonProperty("Class")
    public String clazz;
    @JsonProperty("Secrets")
    public ArrayList<Secret> secrets;
    @JsonProperty("Target")
    public String target;
    @JsonProperty("Misconfigurations")
    public ArrayList<Misconfiguration> misconfigurations;
    @JsonProperty("Type")
    public String type;

    @JsonProperty("MisconfSummary")
    public MisconfSummary misconfSummary;
}