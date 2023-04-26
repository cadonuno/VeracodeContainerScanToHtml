package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Secrets{
    @JsonProperty("ArtifactName")
    public String artifactName;
    @JsonProperty("ArtifactType")
    public String artifactType;
    @JsonProperty("Metadata")
    public Metadata2 metadata;
    @JsonProperty("Results")
    public ArrayList<Result> results;
    @JsonProperty("SchemaVersion")
    public int schemaVersion;
}