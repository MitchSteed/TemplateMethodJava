package composition;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringMatchesCounter implements FileProcessorDependency {

    private Pattern pattern;
    private String filename;
    private int numberOfMatches;
    private List<String> matchingLines;
    private String output;

    public StringMatchesCounter(String patternToMatch) {
        this.pattern = Pattern.compile(patternToMatch);
    }

    @Override
    public void beginFile(String filename) {
        this.filename = filename;
        this.numberOfMatches = 0;
        this.matchingLines = new ArrayList<String>();
    }

    @Override
    public void beginLine(String line) {
        if (pattern.matcher(line).find()) {
            this.numberOfMatches++;
            this.matchingLines.add(line);
        }
    }

    @Override
    public void endFile() {
        StringBuilder builder = new StringBuilder();
        builder.append("Found " + this.numberOfMatches  + " matches in file: " + filename);
        for (String matchingLine : this.matchingLines) {
            builder.append("\n");
            builder.append(matchingLine);
        }
        this.output = builder.toString();
    }

    @Override
    public String printInfo() {
        return this.output;
    }
}
