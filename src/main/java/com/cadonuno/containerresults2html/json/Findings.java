package com.cadonuno.containerresults2html.json;

import java.util.ArrayList;

public class Findings {
    public Vulnerabilities vulnerabilities;
    public Secrets secrets;
    public Configs configs;
    public Iac iac;
    public ArrayList<Permission> permissions;
}
