package es.ulpgc.dis.view;

import es.ulpgc.dis.model.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageDisplayPanel extends JPanel implements ImageDisplay {
    private Image image;

    public ImageDisplayPanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            BufferedImage bufferedImage = (BufferedImage) image.bitMap();
            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();
            int imageWidth = bufferedImage.getWidth();
            int imageHeight = bufferedImage.getHeight();

            double widthRatio = (double) panelWidth / imageWidth;
            double heightRatio = (double) panelHeight / imageHeight;
            double scale = Math.min(widthRatio, heightRatio);

            int scaledWidth = (int) (imageWidth * scale);
            int scaledHeight = (int) (imageHeight * scale);

            int x = (panelWidth - scaledWidth) / 2;
            int y = (panelHeight - scaledHeight) / 2;

            g.drawImage(bufferedImage, x, y, scaledWidth, scaledHeight, this);
        }
    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void show(Image image) {
        new SwingWorker<BufferedImage, Void>() {
            @Override
            protected BufferedImage doInBackground() throws Exception {
                return (BufferedImage) image.bitMap();
            }

            @Override
            protected void done() {
                try {
                    BufferedImage newImage = get();
                    if (ImageDisplayPanel.this.image != null) {
                        ((BufferedImage) ImageDisplayPanel.this.image.bitMap()).flush();
                    }
                    ImageDisplayPanel.this.image = image;
                    ImageDisplayPanel.this.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.execute();
    }

}
