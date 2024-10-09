package pl.kwojcik.project_lab.products.cmd;

public interface Command {
    void undo();
    boolean execute();
}
