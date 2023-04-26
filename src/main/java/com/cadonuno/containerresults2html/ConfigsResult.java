package com.cadonuno.containerresults2html;

import com.cadonuno.containerresults2html.json.Result;

import java.util.List;
import java.util.stream.Collectors;

public class ConfigsResult {

    private final String target;
    private final String type;
    private final String aVDID;
    private final String title;
    private final String severity;
    private final String message;
    private final String description;
    private final String resolution;

    public ConfigsResult(String target, String type, String aVDID, String title,
                         String severity, String message, String description, String resolution) {
        this.target = target;
        this.type = type;
        this.aVDID = aVDID;
        this.title = title;
        this.severity = severity;
        this.message = message;
        this.description = description;
        this.resolution = resolution;
    }

    public static List<ConfigsResult> GetListFromResult(Result result) {
        return result.misconfigurations.stream()
                .map(misconfiguration -> new ConfigsResult(
                        result.target,
                        result.type,
                        misconfiguration.aVDID,
                        misconfiguration.title,
                        misconfiguration.severity,
                        misconfiguration.message,
                        misconfiguration.description,
                        misconfiguration.resolution
                )).collect(Collectors.toList());
    }

    public String getResolution() {
        return resolution;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public String getSeverity() {
        return severity;
    }

    public String getTitle() {
        return title;
    }

    public String getaVDID() {
        return aVDID;
    }

    public String getType() {
        return type;
    }

    public String getTarget() {
        return target;
    }
}
