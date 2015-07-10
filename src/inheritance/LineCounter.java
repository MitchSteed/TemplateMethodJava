package inheritance;

public class LineCounter extends FileSkeleton {

    private String filename;
    private int numberOfLines;

    @Override
    protected void beginFile(String filename) {
        this.filename = filename;
        this.numberOfLines = 0;
    }

    @Override
    protected void beginLine(String line) {
        this.numberOfLines++;
    }

    @Override
    protected void endFile() {

    }

    @Override
    public String printInfo() {
        return "Found " + this.numberOfLines + " lines in " + filename + ".";
    }
}
