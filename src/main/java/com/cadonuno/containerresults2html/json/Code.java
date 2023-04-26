package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Code{
    @JsonProperty("Lines")
    public ArrayList<Line> lines;
}
