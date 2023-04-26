# VeracodeContainerScanToHtml
This plugin converts the JSON output of a Veracode container scan into HTML.

It contains 2 mandatory parameters:
- From file* - JSON file to read:
    - --from or -f
- To file* - where to save the HTML output:
    - --to or -t

**Installation and usage**
- Run mvn package
- Run a veracode container scan
- Run the plugin:
  - java -jar <jar-name>.jar -f <container-scan-report>.json -t <output-file>.html