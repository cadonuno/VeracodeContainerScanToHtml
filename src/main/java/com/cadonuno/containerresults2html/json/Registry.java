package com.cadonuno.containerresults2html.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Registry {
    @JsonProperty("insecure-skip-tls-verify")
    public boolean insecureSkipTlsVerify;

    @JsonProperty("insecure-use-http")
    public boolean insecureUseHttp;

    public ArrayList<Object> auth;
}
