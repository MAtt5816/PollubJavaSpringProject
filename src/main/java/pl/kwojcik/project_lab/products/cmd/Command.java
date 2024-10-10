package pl.kwojcik.project_lab.products.cmd;

// #Zadanie_3__2
//start L3 Odwracania zależności
public interface Command {
    void undo();
    boolean execute();
}
