package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ContainerScanResults {
    public Vulnerabilities vulnerabilities;
    public Secrets secrets;
    public Configs configs;

    @JsonProperty("policy-results")
    public ArrayList<PolicyResult> policyResults;

    @JsonProperty("policy-passed")
    public boolean policyPassed;
}
















