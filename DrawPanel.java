import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private class ImagePointPair {
        private Point point;
        private BufferedImage image;

        private ImagePointPair(Point point, BufferedImage image) {
            this.point = point;
            this.image = image;
        }
        ImagePointPair(int x, int y, BufferedImage image) {
            this(new Point(x,y), image);
        }
        public int getX() {
            return point.x;
        }
        public int getY() {
            return point.y;
        }
        public Point getPoint() {
            return point;
        }
        public BufferedImage getImage() {
            return image;
        }
        
    }
    // Just a single image, TODO: Generalize
    // BufferedImage volvoImage;
    ArrayList<ImagePointPair> carList;

    ImagePointPair volvoWorkshop;
    // BufferedImage volvoWorkshopImage;
    // Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int ind, int x, int y){
        carList.get(ind).getPoint().move(x, y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.carList = new ArrayList<>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            // volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            carList.add(
                new ImagePointPair(0, 0, ImageIO.read(
                    DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))));
            carList.add(
                new ImagePointPair(0, 100, ImageIO.read(
                    DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))));
            carList.add(
                new ImagePointPair(0, 200, ImageIO.read(
                    DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))));
            volvoWorkshop = 
                new ImagePointPair(300, 300, ImageIO.read(
                    DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAllCars(g);
        drawImage(g, volvoWorkshop);
    }

    private void drawAllCars(Graphics g) {
        for (ImagePointPair car : carList) {
            drawImage(g, car);
        }
    }

    private void drawImage(Graphics g, ImagePointPair image) {
        g.drawImage(image.getImage(), image.getX(), image.getY(), null); // see javadoc for more info on the parameters
    }
}
