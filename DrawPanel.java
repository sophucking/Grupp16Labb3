
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private ArrayList<PositionImage> images;

    // Initializes the panel
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        images = new ArrayList<>();
    }

    public DrawPanel() {
        super();
        images = new ArrayList<>();
    }

    
    private class PositionImage {
        private int x;
        private int y;
        private BufferedImage image;

        private PositionImage(int x, int y, BufferedImage image) {
            set(x, y);
            this.image = image;
        }

        private void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public BufferedImage getImage() {
            return image;
        }
    }

    public void addImage(int x, int y, String imagePath) {
        images.add(createNewVisualItem(x, y, imagePath));
    }

    private PositionImage createNewVisualItem(int x, int y, String imagePath) {
        // Print an error message in case file is not found with a try/catch block
        // ImagePointPair newItem;
        try {
            return new PositionImage(x, y, ImageIO.read(
                    DrawPanel.class.getResourceAsStream(imagePath)));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImages(g);
        images.clear();
    }

    private void drawImages(Graphics g) {
        for (PositionImage image : images) {
            drawImage(g, image);
        }
    }

    private void drawImage(Graphics g, PositionImage image) {
        //                                                         vv this could be implemented if drawPanel is an observer
        g.drawImage(image.getImage(), image.getX(), image.getY(), null); // see javadoc for more info on the parameters
    }
}
