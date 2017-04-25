

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author amilcar
 */

    //****************************************
    // Fui buscar a http://stackoverflow.com/questions/6118737/how-to-draw-in-jpanel-swing-graphics-java
     //****************************************


public class CustomPanel extends JPanel{
    
        private final static int WIDTH = 1297;
        private final static int HEIGHT = 750;
        private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
    
        CustomPanel() {
            // set a preferred size for the custom panel.
            //setPreferredSize(new Dimension(100,100));
            setBackground(Color.lightGray);
            
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            if (image != null) {
                g.drawImage(image, 0, 0, null);
            }
        }
        
        public void drawImage(String file, int X, int Y) {
            try {
                // Leitura de ficheiro e desenho no painel
                image = ImageIO.read(new File(file));
                
                BufferedImage imgInput = ImageIO.read(new File(file));
                Image thumbnail = imgInput.getScaledInstance(WIDTH, -1, Image.SCALE_SMOOTH);
                image = new BufferedImage(thumbnail.getWidth(null),thumbnail.getHeight(null), BufferedImage.TYPE_INT_RGB);
                image.getGraphics().drawImage(thumbnail, X, Y, null);
            }
            catch (IOException e) {
                System.out.println( e.getMessage());
            }
            this.repaint();
        }
        
        public void saveImage(String filename){
            try {
                // Grava imagem
                ImageIO.write(image, "jpg", new File(filename + ".jpg"));
            }
            
            catch (IOException e) {
                System.out.println( e.getMessage());
            }
        }
        
        public void drawInBuffer() {
     
            // Prepara-se para desenhar no Buffer
            Graphics2D g2 = (Graphics2D)image.getGraphics();
            
            this.repaint();
        }
        
        public void addRectangle(Rectangle2D rectangle, Color color, boolean fill, Color color2) {
            //  Draw the Rectangle onto the BufferedImage
            Graphics2D g2 = (Graphics2D)image.getGraphics();
            g2.setColor( color );
            g2.draw( rectangle );
            
            if(fill == true){
                g2.fill( rectangle );
            }
            
            repaint();
        }
        
        public void addEllipse(Ellipse2D ellipse, Color color, boolean fill, Color color2) {
            //  Draw the Ellipse onto the BufferedImage
            Graphics2D g2 = (Graphics2D)image.getGraphics();
            g2.setColor( color );
            g2.draw( ellipse );
            
            if(fill == true){
                g2.fill( ellipse );
            }
            
            repaint();
        }
        
        public void createEmptyImage() {
            image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D)image.getGraphics();
            g2.setColor(Color.white);
            Rectangle2D r = new Rectangle2D.Double(0,0,WIDTH,HEIGHT);
            g2.fill(r);
            repaint();
        }
}
