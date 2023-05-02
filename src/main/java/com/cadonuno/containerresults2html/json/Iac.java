package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Iac {
    @JsonProperty("SchemaVersion")
    public int schemaVersion;

    @JsonProperty("ArtifactType")
    public String artifactType;

    @JsonProperty("ArtifactName")
    public String artifactName;

    @JsonProperty("Metadata")
    public Metadata2 metadata;

    @JsonProperty("Results")
    public ArrayList<Result> results;

}
