package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ContainerScanResults {

    @JsonProperty("target_id")
    public String targetId;

    public Findings findings;

    public Vulnerabilities vulnerabilities;
    public Secrets secrets;
    public Configs configs;

    @JsonProperty("policy-results")
    public ArrayList<PolicyResult> policyResults;

    @JsonProperty("policy-passed")
    public boolean policyPassed;
}
















