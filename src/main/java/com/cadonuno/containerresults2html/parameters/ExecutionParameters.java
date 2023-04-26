package com.cadonuno.containerresults2html.parameters;

import com.cadonuno.containerresults2html.util.Logger;

import java.util.Optional;

public class ExecutionParameters {
    private final String fileToRead;
    private final String fileToSave;

    private ExecutionParameters(String fileToRead, String fileToSave) {
        if (fileToRead == null || fileToRead.isEmpty()) {
            throw new IllegalArgumentException("File to Read argument is mandatory (--from, -f)");
        }
        if (fileToSave == null || fileToSave.isEmpty()) {
            throw new IllegalArgumentException("File to Save argument is mandatory (--to, -t)");
        }
        this.fileToRead = fileToRead;
        this.fileToSave = fileToSave;
    }

    public static ExecutionParameters of(String[] commandLineArguments) {
        Logger.log("Parsing Execution Parameters");
        ParameterParser parameterParser = new ParameterParser(commandLineArguments);
        return new ExecutionParameters(
                parameterParser.getParameterAsString("--from", "-f"),
                parameterParser.getParameterAsString("--to", "-t"));
    }

    public String getFileToRead() {
        return fileToRead;
    }

    public String getFileToSave() {
        return fileToSave;
    }
}
