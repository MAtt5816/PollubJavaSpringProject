package pl.kwojcik.project_lab.utils;

// #Zadanie_3__2
//start L3 Odwracania zależności
public interface Cacheable {
    Memento cache();
    void restore(Memento memento);
}
