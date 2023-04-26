package com.cadonuno.containerresults2html;

import com.cadonuno.containerresults2html.parameters.ExecutionParameters;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Executor.run(ExecutionParameters.of(args));
    }
}
