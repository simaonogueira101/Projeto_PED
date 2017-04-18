

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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


public class ImageDisplayer3 extends JPanel{
    
        private final static int WIDTH = 4000;
        private final static int HEIGHT = 201;
        private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
    
        ImageDisplayer3() {
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
        
        public void drawImage() {
            try {
                
                String num = String.valueOf(Interface.numAlbumShow);
                String fileLocation = "/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album" + num + "/";
                
                // Faz a leitura dos vários ficheiros dentro da pasta pretendida
                File imgs = new File(fileLocation);
                ArrayList<String> imagens = new ArrayList<String>(Arrays.asList(imgs.list()));
                for(int i=0; i<imagens.size(); i++){
                    String temp = imagens.get(i);
                    // Remove o ficheiro que não nos interessa
                    if(temp.equals(".DS_Store")){
                        imagens.remove(i);
                    }
                }
                
                // Número de Imagens a ler e display
                int numImgs = imagens.size();
                
                // Verificação dos ficheiros lidos e dos nomes guardados
                System.out.println("Nome das Imagens: " + imagens);
                
                // Criação de um ArrayList onde serão colocadas imagens
                ArrayList<Image> albumIcons = new ArrayList<Image>();
                
                // Leitura das várias imagens para adicionar ao ArrayList
                for(int i=0; i<numImgs; i++){
                    image = ImageIO.read(new File(fileLocation + imagens.get(i)));
                    BufferedImage imgInput = ImageIO.read(new File(fileLocation + imagens.get(i)));
                    if(imgInput.getWidth() > imgInput.getHeight()){
                        Image thumbnail = imgInput.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
                        albumIcons.add(thumbnail);
                    }else{
                        Image thumbnail = imgInput.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
                        albumIcons.add(thumbnail);
                    }
                }
                
                // Criação de um fundo branco por detrás das imagens
                BufferedImage fundo = ImageIO.read(new File("blank.png"));
                Image thumbnailFundo = fundo.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
                image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
                image.getGraphics().drawImage(thumbnailFundo, 0, 0, null);
                
                for(int i=0; i<numImgs; i++){
                    image.getGraphics().drawImage(albumIcons.get(i), 20+20*i+150*i+((150-albumIcons.get(i).getWidth(this)))/2, 20+((150-albumIcons.get(i).getHeight(this))/2), null);
                }
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
