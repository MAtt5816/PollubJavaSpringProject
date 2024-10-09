package pl.kwojcik.project_lab.utils;

public interface Cacheable {
    Memento cache();
    void restore(Memento memento);
}
