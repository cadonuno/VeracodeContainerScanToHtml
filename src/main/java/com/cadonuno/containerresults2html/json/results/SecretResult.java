package com.cadonuno.containerresults2html.json.results;

import com.cadonuno.containerresults2html.json.Result;

import java.util.List;
import java.util.stream.Collectors;

public class SecretResult {
   /*
            (secretResult) -> secretResult.target,
            (secretResult) -> secretResult.category,
            (secretResult) -> secretResult.startLine,
            (secretResult) -> secretResult.endLine,
            (secretResult) -> secretResult.match,
            (secretResult) -> secretResult.severity,
            (secretResult) -> secretResult.title
    */
    private String target;
    private String category;
    private String startLine;
    private String endLine;
    private String match;
    private String severity;
    private String title;

    public SecretResult(String target, String category, String startLine,
                        String endLine, String match, String severity, String title) {
        this.target = target;
        this.category = category;
        this.startLine = startLine;
        this.endLine = endLine;
        this.match = match;
        this.severity = severity;
        this.title = title;
    }


    public static List<SecretResult> GetListFromResult(Result result) {
        return result.secrets.stream()
                .map(secret -> new SecretResult(
                        result.target,
                        secret.category,
                        Integer.toString(secret.startLine),
                        Integer.toString(secret.endLine),
                        secret.match,
                        secret.severity,
                        secret.title
                )).collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMatch() {
        return match;
    }

    public String getEndLine() {
        return endLine;
    }

    public String getStartLine() {
        return startLine;
    }

    public String getCategory() {
        return category;
    }

    public String getTarget() {
        return target;
    }
}
