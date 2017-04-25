

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author amilcar
 */

    //****************************************
    // Fui buscar a http://stackoverflow.com/questions/6118737/how-to-draw-in-jpanel-swing-graphics-java
     //****************************************


public class ImageDisplayer5 extends JPanel{
    
        private final static int WIDTH = 1158;
        private final static int HEIGHT = 570;
        private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
    
        ImageDisplayer5() {
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
        
        public void saveImage(String filename){
            try {
                // Grava imagem
                ImageIO.write(image, "jpg", new File(filename));
            }
            
            catch (IOException e) {
                System.out.println( e.getMessage());
            }
        }
        
        public void createEmptyImage() {
            image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D)image.getGraphics();
            g2.setColor(Color.white);
            Rectangle2D r = new Rectangle2D.Double(0,0,WIDTH,HEIGHT);
            g2.fill(r);
            repaint();
        }
        
        public void drawImage() {
            try {
                
                ArrayList<String> imagens = new ArrayList<String>();
                
                int numImgs = 0;
        
                switch (Interface.numAlbumShow) {
                    case 1:
                        numImgs = Interface.imagensAlbum1.size();
                        for(int i=0; i<numImgs; i++){
                            imagens.add(Interface.imagensAlbum1.get(i));
                        }
                        break;
                    case 2:
                        numImgs = Interface.imagensAlbum2.size();
                        for(int i=0; i<numImgs; i++){
                            imagens.add(Interface.imagensAlbum2.get(i));
                        }
                        break;
                    case 3:
                        numImgs = Interface.imagensAlbum3.size();
                        for(int i=0; i<numImgs; i++){
                            imagens.add(Interface.imagensAlbum3.get(i));
                        }
                        break;
                    default:
                        break;
                }
                
                String num = String.valueOf(Interface.numAlbumShow);
                String fileLocation = "./Album" + num + "/";
                
                System.out.println("Nome do Album a Apresentar em ImageDisplayer5: " + Interface.numAlbumShow);
                
                Image thumbnail = null;
                
                image = ImageIO.read(new File(fileLocation + imagens.get(Interface.numFotoShowReel)));
                BufferedImage imgInput = ImageIO.read(new File(fileLocation + imagens.get(Interface.numFotoShowReel)));
                if(imgInput.getWidth() > imgInput.getHeight()){
                    int scaledWidth = 880/imgInput.getWidth();
                    if(scaledWidth * imgInput.getHeight() > 750){
                        thumbnail = imgInput.getScaledInstance(-1, 750, Image.SCALE_SMOOTH);
                    }else{
                        thumbnail = imgInput.getScaledInstance(880, -1, Image.SCALE_SMOOTH);
                    }
                }else{
                    thumbnail = imgInput.getScaledInstance(-1, 750, Image.SCALE_SMOOTH);
                }
                
                // Criação de um fundo branco por detrás das imagens
//                BufferedImage fundo = ImageIO.read(new File("blank.png"));
//                Image thumbnailFundo = fundo.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//                image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
//                image.getGraphics().drawImage(thumbnailFundo, WIDTH/2 - thumbnail.getWidth(this)/2, HEIGHT/2 - thumbnail.getHeight(this)/2, null);
                
                // Apresenta a foto que dita o numFotoShowReel no painel de edit
                image = new BufferedImage(thumbnail.getWidth(this), thumbnail.getHeight(this), BufferedImage.TYPE_INT_RGB);
                //image.getGraphics().translate(this.getWidth()/2 - image.getWidth(null)/2, this.getHeight()/2 - image.getHeight(null)/2);
                image.getGraphics().translate(1000, 1000);
                image.getGraphics().drawImage(thumbnail, 0, 0, null);
            
                // Measures to save Java allocated memory
                imagens.clear();
            }
            catch (IOException e) {
                System.out.println( e.getMessage());
            }
            this.repaint();
        }
        
        public void drawInBuffer() {
     
            // Prepara-se para desenhar no Buffer
            Graphics2D g2 = (Graphics2D)image.getGraphics();
            
            this.repaint();
        }
}
