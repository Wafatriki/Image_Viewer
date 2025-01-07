package es.ulpgc.dis.view;

import es.ulpgc.dis.model.Image;

public interface ImageDisplay {
    Image image();
    void show(Image image);
}