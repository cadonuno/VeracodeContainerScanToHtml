package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attestation {
    @JsonProperty("public-key")
    public String publicKey;

    @JsonProperty("skip-verification")
    public boolean skipVerification;
}
