package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {
    public String scope;
    @JsonProperty("unindexed-archives")
    public boolean unindexedArchives;

    @JsonProperty("indexed-archives")
    public boolean indexedArchives;
}
