package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Configuration {
    public String configPath;
    public String output;
    public String file;
    public String distro;

    @JsonProperty("add-cpes-if-none")
    public boolean addCpesIfNone;

    @JsonProperty("output-template-file")
    public String outputTemplateFile;
    public boolean quiet;

    @JsonProperty("check-for-app-update")
    public boolean checkForAppUpdate;

    @JsonProperty("only-fixed")
    public boolean onlyFixed;

    @JsonProperty("only-notfixed")
    public boolean onlyNotFixed;

    public String platform;
    public Search search;

    //TODO: fill these 2?
    public Object ignore;
    public ArrayList<Object> exclude;


    public Db2 db;
    public ExternalSources externalSources;
    public Match2 match;
    public Dev dev;

    @JsonProperty("fail-on-severity")
    public String failOnSeverity;
    public Registry registry;
    public Log log;
    public Attestation attestation;
}
