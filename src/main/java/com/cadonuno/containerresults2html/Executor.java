package com.cadonuno.containerresults2html;


import com.cadonuno.containerresults2html.json.*;
import com.cadonuno.containerresults2html.json.results.ConfigsResult;
import com.cadonuno.containerresults2html.json.results.SecretResult;
import com.cadonuno.containerresults2html.parameters.ExecutionParameters;
import com.cadonuno.containerresults2html.util.NullHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Executor {
    public static void run(ExecutionParameters executionParameters) throws FileNotFoundException {
        File fileToRead = new File(executionParameters.getFileToRead());
        if (!fileToRead.exists()) {
            throw new FileNotFoundException("Couldn't find file named " + fileToRead.getAbsolutePath());
        }
        try (InputStream inputStream = new FileInputStream(fileToRead)) {
            saveResultsAs(
                    new ObjectMapper().readValue(inputStream, ContainerScanResults.class),
                    executionParameters.getFileToSave());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveResultsAs(ContainerScanResults containerScanResults, String fileToSave) {
        String reportHtml = getReportXml(containerScanResults);
        try (PrintWriter printWriter = new PrintWriter(fileToSave)) {
            printWriter.println(reportHtml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getReportXml(ContainerScanResults containerScanResults) {
        return "<html>\n" +
                "<head>\n" +
                "<script src=\"https://unpkg.com/gridjs/dist/gridjs.production.min.js\"></script>\n" +
                "<link href=\"https://unpkg.com/gridjs/dist/theme/mermaid.min.css\" rel=\"stylesheet\" />\n" +
                "<script type=\"module\">import{Grid,html}from\"https://unpkg.com/gridjs/dist/gridjs.production.es.min.js\";</script>\n" +
                "    <style type=\"text/css\">\n" +
                "      html, body{font-family: Arial, Helvetica, sans-serif;}\n" +
                "      h3{color: #fff;}" +
                "      h2{font-size: 1.5em; text-align: center;}\n" +
                "      .header{height: 100px;}\n" +
                "      button{border:none;}\n" +
                "      .logo{width:300px; float: left;}\n" +
                "      .report{max-width:800px; float: right;}\n" +
                "      .report button{width:100px; padding:14px; border:none; border-radius: 25px;}\n" +
                "      .report button a{color:#fff; text-decoration: none; font-weight: bold;}\n" +
                "      .pink{background-color: #d73185;}\n" +
                "      .column {float: left;}\n" +
                "      .column a{color:#000;}\n" +
                "      .column h5{margin: 0 auto; text-align: center; font-weight: bold; font-size:7.5em;}\n" +
                "      .column h6{margin: 0 auto; text-align: center; font-variant: small-caps;}\n" +
                "      .middle.column h6 {margin: 0 auto; text-align: center; font-variant: small-caps; line-height: 1.2; font-family: monospace; font-size: 1.25em; text-align: center; margin-left: 5px;}\n" +
                "  .column p {margin-block-start: .1em;font-size: .75em;text-align: center;font-family: monospace;}\n" +
                "      .row:after {content: \"\"; display: table; clear: both;}\n" +
                "      .left{max-width:500px; width:50%;}\n" +
                "      .left h2{color: #fff;}\n" +
                "      .middle{max-width: 300px; height: 300px; width:25%; background-color:#e2e369;}\n" +
                "      .right{max-width: 300px; height: 300px; width:25%; background-color: #37a2e4;}\n" +
                "      #wrapper{width:100%; position: absolute; margin: 50 0 0 0; }\n" +
                "      #container{max-width:1200px; min-height:1100px; margin: 0 auto;}\n" +
                "      .row{width:100%; display: block; min-width:1100px;}\n" +
                "      .chartruce{background-color: #e2e369;}\n" +
                "      html,body{background-color:#000;}\n" +
                "  .panel { " +
                "       overflow: hidden; " +
                "       transition: max-height 0.2s ease-out;" +
                "       max-height: 0;" +
                "  }" +
                "  .active, .accordion:hover {\n" +
                "       background-color: #ccc;\n" +
                "  }" +
                "   .accordion {\n" +
                "       background-color: #eee;\n" +
                "       color: #444;\n" +
                "       cursor: pointer;\n" +
                "       padding: 18px;\n" +
                "       width: 100%;\n" +
                "       text-align: left;\n" +
                "       border: none;\n" +
                "       outline: none;\n" +
                "       transition: 0.4s;\n" +
                "   }" +
                "  .policyDidNotPass { background: url(https://analysiscenter.veracode.com/images/policy/policyIcon_sprite_new.png) -83px -148px no-repeat; }" +
                "  .policyPass { background: url(https://analysiscenter.veracode.com/images/policy/policyIcon_sprite_new.png) -83px -454px no-repeat; }" +
                "  .policyPassIcon { height: 70px; width: 100%; float: left; }" +
                "    </style>    \n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div class=\"row header\">\n" +
                "          <div class=\"logo\">\n" +
                "            <img src=\"https://community.veracode.com/resource/1544728435000/VeracodeCommunityLogo\" alt=\"Home\" width=\"250\">\n" +
                "          </div>\n" +
                "          <div class=\"report\"><button class=\"pink\"><a href=\"https://docs.veracode.com/\" target=\"_blank\">Need help?</a></button></div>\n" +
                "        </div>\n" +
                "     <div>\n" +
                "     " + getPolicyResultInfo(containerScanResults.policyPassed) +
                "     </div>\n" +
                "     <div id=\"wrapper\">\n" +
                "        <div class=\"row\">\n" +
                "           <button class=\"accordion\">Policy Results</button>\n" +
                "           <div class=\"panel\" id=\"gridPolicyResults\"></div>\n" +
                "        </div>\n" +
                "        <div class=\"row\">\n" +
                "           <button class=\"accordion\">Vulnerabilities</button>\n" +
                "           <div class=\"panel\" id=\"gridVulnerabilities\"></div>\n" +
                "        </div>\n" +
                "        <div class=\"row\">\n" +
                "           <button class=\"accordion\">Secrets</button>\n" +
                "           <div class=\"panel\" id=\"gridSecrets\"></div>\n" +
                "        </div>\n" +
                "        <div class=\"row\">\n" +
                "           <button class=\"accordion\">IaC Configuration</button>\n" +
                "           <div class=\"panel\" id=\"gridConfigs\"></div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <script src=\"https://unpkg.com/gridjs@6.0.6/dist/gridjs.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "      new gridjs.Grid({\n" +
                "        columns: [\"Policy Failure\"],\n" +
                "        search: true,\n" +
                "        sort: true,\n" +
                "        pagination: true,\n" +
                "        data: [" + getPolicyResultsTable(containerScanResults.policyResults) + "]\n" +
                "      }).render(document.getElementById(\"gridPolicyResults\"));\n" +

                "      new gridjs.Grid({\n" +
                "        columns: [\"Component Name\", \"Version\", \"Severity\", \"CVSS\"],\n" +
                "        search: true,\n" +
                "        sort: true,\n" +
                "        pagination: true,\n" +
                "        data: [" + getVulnerabilitiesTable(NullHandler.ifNull(containerScanResults.vulnerabilities, () -> containerScanResults.findings.vulnerabilities)) + "]\n" +
                "      }).render(document.getElementById(\"gridVulnerabilities\"));\n" +

                "      new gridjs.Grid({\n" +
                "        columns: [\"Target\", \"Category\", \"Start Line\", \"End Line\", \"Match\", \"Severity\", \"Title\"],\n" +
                "        search: true,\n" +
                "        sort: true,\n" +
                "        pagination: true,\n" +
                "        data: [" + getSecretsTable(NullHandler.ifNull(containerScanResults.secrets, () -> containerScanResults.findings.secrets)) + "]\n" +
                "      }).render(document.getElementById(\"gridSecrets\"));\n" +

                "      new gridjs.Grid({\n" +
                "        columns: [\"Target\", \"Type\", \"VDID\", \"Title\", \"Severity\", \"Message\", \"Description\", \"Resolution\"],\n" +
                "        search: true,\n" +
                "        sort: true,\n" +
                "        pagination: true,\n" +
                "        data: [" + getConfigsTable(containerScanResults) + "]\n" +
                "      }).render(document.getElementById(\"gridConfigs\"));\n" +

                "       var acc = document.getElementsByClassName(\"accordion\");\n" +
                "       var i;\n" +

                "       for (i = 0; i < acc.length; i++) {\n" +
                "         acc[i].addEventListener(\"click\", function() {\n" +
                "           this.classList.toggle(\"active\");\n" +
                "           var panel = this.nextElementSibling;\n" +
                "           if (panel.style.maxHeight) {\n" +
                "             panel.style.maxHeight = null;\n" +
                "           } else {\n" +
                "             panel.style.maxHeight = panel.scrollHeight + \"px\";\n" +
                "           }\n" +
                "         });\n" +
                "       }" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>";
    }

    private static String getPolicyResultInfo(boolean policyPassed) {
        return "<div class=\"" + (policyPassed ? "policyPass" : "policyDidNotPass") + " policyPassIcon\" " +
                "data-toggle=\"tooltip\" " +
                "data-placement=\"bottom\" " +
                "alt=\"" + (policyPassed ? "Pass" : "Did Not Pass") + "\" " +
                "data-original-title=\"" + (policyPassed ? "Pass" : "Did Not Pass") + "\">" +
                "<h3 style='margin-left: 25px; margin-top: 0px;'>" + " Policy Evaluation " + (policyPassed ? "Passed" : "Failed!") + "</h3>" +
                "</div>";
    }

    private static String getPolicyResultsTable(ArrayList<PolicyResult> policyResults) {
        return getListAsGridElements(policyResults.get(0).failures, Collections.singletonList(
                (policyFailure) -> policyFailure.msg));
    }

    private static String getVulnerabilitiesTable(Vulnerabilities vulnerabilities) {
        return getListAsGridElements(vulnerabilities.matches, Arrays.asList(
                (match) -> match.artifact.name,
                (match) -> match.artifact.version,
                (match) -> match.vulnerability.severity,
                (match) -> match.vulnerability.cvss.stream()
                        .filter(element -> element instanceof Cvss)
                        .map(element -> (Cvss) element)
                        .map(cvss -> ("Cvss v" + cvss.version + " " + cvss.metrics.baseScore))
                        .collect(Collectors.joining(", "))));
    }

    private static String getSecretsTable(Secrets secrets) {
        return getListAsGridElements(secrets.results.stream()
                        .map(SecretResult::GetListFromResult)
                        .flatMap(List::stream)
                        .collect(Collectors.toList()),
                Arrays.asList(
                        SecretResult::getTarget,
                        SecretResult::getCategory,
                        SecretResult::getStartLine,
                        SecretResult::getEndLine,
                        SecretResult::getMatch,
                        SecretResult::getSeverity,
                        SecretResult::getTitle));
    }

    private static String getConfigsTable(ContainerScanResults containerScanResults) {
        ArrayList<Result> results =
                containerScanResults.configs != null
                        ? containerScanResults.configs.results
                        : containerScanResults.findings.iac.results;
        return getListAsGridElements(results.stream()
                        .map(ConfigsResult::GetListFromResult)
                        .flatMap(List::stream)
                        .collect(Collectors.toList()),
                Arrays.asList(
                        ConfigsResult::getTarget,
                        ConfigsResult::getType,
                        ConfigsResult::getaVDID,
                        ConfigsResult::getTitle,
                        ConfigsResult::getSeverity,
                        ConfigsResult::getMessage,
                        ConfigsResult::getDescription,
                        ConfigsResult::getResolution));
    }

    private static <T> String getListAsGridElements(List<T> elementList, List<Function<T, String>> elementExtractors) {
        int lastElementIndex = elementList.size() - 1;
        StringBuilder elementsAsStringBuilder = new StringBuilder();
        for (int currentElement = 0; currentElement <= lastElementIndex; currentElement++) {
            buildElement(elementList.get(currentElement), elementExtractors, elementsAsStringBuilder);
            if (currentElement < lastElementIndex) {
                elementsAsStringBuilder.append(",");
            }
        }
        return elementsAsStringBuilder.toString();
    }

    private static <T> void buildElement(T element, List<Function<T, String>> elementExtractors,
                                         StringBuilder elementsAsStringBuilder) {
        if (element == null) {
            return;
        }
        elementsAsStringBuilder.append("[");
        int lastExtractorIndex = elementExtractors.size() - 1;
        for (int currentExtractor = 0; currentExtractor <= lastExtractorIndex; currentExtractor++) {
            elementsAsStringBuilder
                    .append("'")
                    .append(elementExtractors.get(currentExtractor).apply(element)
                            .replace("'", "\\'")
                            .replace('\n', ' '))
                    .append("'");
            if (currentExtractor < lastExtractorIndex) {
                elementsAsStringBuilder.append(",");
            }
        }
        elementsAsStringBuilder.append("]");
    }
}
