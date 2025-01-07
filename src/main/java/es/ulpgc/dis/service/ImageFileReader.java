package es.ulpgc.dis.service;

import es.ulpgc.dis.model.Image;
import es.ulpgc.dis.view.ImageReader;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageFileReader implements ImageReader {
    private final File[] files;
    private final Map<File, BufferedImage> imageCache = new HashMap<>();
    private static final String[] ImageExtensions = {".jpg", ".png", ".PNG", ".gif"};

    public ImageFileReader(String path) {
        this(new File(path));
    }

    public ImageFileReader(File folder) {
        this.files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String extension : ImageExtensions) {
                    if (name.endsWith(extension)) return true;
                }
                return false;
            }
        });
    }

    public Image read() {
        return imageAt(0);
    }

    private Image imageAt(int index) {
        return new Image() {
            @Override
            public Image next() {
                return imageAt(index < files.length - 1 ? index + 1 : 0);
            }

            @Override
            public Image prev() {
                return imageAt(index > 0 ? index - 1 : files.length - 1);
            }

            @Override
            public Object bitMap() {
                try {
                    if (!imageCache.containsKey(files[index])) {
                        BufferedImage bufferedImage = ImageIO.read(files[index]);
                        imageCache.put(files[index], bufferedImage);
                    }
                    return imageCache.get(files[index]);
                } catch (IOException e) {
                    return null;
                }
            }
        };
    }
}
