package composition;

public interface FileProcessorDependency {

    public void beginFile(String filename);

    public void beginLine(String line);

    public void endFile();

    public String printInfo();
}
