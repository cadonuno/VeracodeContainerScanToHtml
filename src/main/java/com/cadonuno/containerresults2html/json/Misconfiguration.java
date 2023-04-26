package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Misconfiguration{
    @JsonProperty("AVDID")
    public String aVDID;
    @JsonProperty("CauseMetadata")
    public CauseMetadata causeMetadata;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("Layer")
    public Layer layer;
    @JsonProperty("Message")
    public String message;
    @JsonProperty("Namespace")
    public String namespace;
    @JsonProperty("PrimaryURL")
    public String primaryURL;
    @JsonProperty("Query")
    public String query;
    @JsonProperty("References")
    public ArrayList<String> references;
    @JsonProperty("Resolution")
    public String resolution;
    @JsonProperty("Severity")
    public String severity;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Type")
    public String type;
}