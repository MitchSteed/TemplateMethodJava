package composition;

public class LineCounter implements FileProcessorDependency {

    private String filename;
    private int numberOfLines;

    @Override
    public void beginFile(String filename) {
        this.filename = filename;
        this.numberOfLines = 0;
    }

    @Override
    public void beginLine(String line) {
        this.numberOfLines++;
    }

    @Override
    public void endFile() {

    }

    @Override
    public String printInfo() {
        return "Found " + this.numberOfLines + " lines in " + filename + ".";
    }
}
