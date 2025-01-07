package es.ulpgc.dis.model;

public interface Image {
    Image next();
    Image prev();
    Object bitMap();
}