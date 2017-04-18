

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


public class ImageDisplayer extends JPanel{
        
        int numAlbum = 0;
        private final static int WIDTH = 201;
        private final static int HEIGHT = 1077;
        private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
    
        ImageDisplayer() {
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
                
                // Faz a contagem do número de albuns na pasta root do projeto
                File album = new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/");
                ArrayList<String> nomes = new ArrayList<String>(Arrays.asList(album.list()));

                for(int i=0; i<nomes.size(); i++){
                    String temp = nomes.get(i);
                    if(temp.contains("Album")){
                        numAlbum ++;
                    }
                }
                
                // Número de Imagens a ler e display
                int numImgs = numAlbum;
                
                // Faz a leitura dos vários ficheiros dentro da pasta pretendida
                File imgs = new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album1/");
                System.out.println(imgs);
                ArrayList<String> imagens = new ArrayList<String>(Arrays.asList(imgs.list()));
                for(int i=0; i<imagens.size(); i++){
                    String temp = imagens.get(i);
                    // Remove o ficheiro que não nos interessa
                    if(temp.equals(".DS_Store")){
                        imagens.remove(i);
                    }
                }
                
                File imgs2 = new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album2/");
                System.out.println(imgs2);
                ArrayList<String> imagens2 = new ArrayList<String>(Arrays.asList(imgs2.list()));
                for(int i=0; i<imagens2.size(); i++){
                    String temp = imagens2.get(i);
                    // Remove o ficheiro que não nos interessa
                    if(temp.equals(".DS_Store")){
                        imagens2.remove(i);
                    }
                }
                
                File imgs3 = new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album3/");
                System.out.println(imgs3);
                ArrayList<String> imagens3 = new ArrayList<String>(Arrays.asList(imgs3.list()));
                for(int i=0; i<imagens3.size(); i++){
                    String temp = imagens3.get(i);
                    // Remove o ficheiro que não nos interessa
                    if(temp.equals(".DS_Store")){
                        imagens3.remove(i);
                    }
                }
                
                // Verificação dos ficheiros lidos e dos nomes guardados
                System.out.println("Nome das Imagens da pasta Album1: " + imagens);
                System.out.println("Nome das Imagens da pasta Album2: " + imagens2);
                System.out.println("Nome das Imagens da pasta Album3: " + imagens3);
                
                // Criação de um ArrayList onde serão colocadas imagens
                ArrayList<Image> albumIcons = new ArrayList<Image>();
                
                // Leitura das várias imagens para adicionar ao ArrayList
                image = ImageIO.read(new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album1/" + imagens.get(0)));
                BufferedImage imgInput = ImageIO.read(new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album1/" + imagens.get(0)));
                if(imgInput.getWidth() > imgInput.getHeight()){
                    Image thumbnail = imgInput.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
                    albumIcons.add(thumbnail);
                }else{
                    Image thumbnail = imgInput.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
                    albumIcons.add(thumbnail);
                }
                
                image = ImageIO.read(new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album2/" + imagens2.get(0)));
                BufferedImage imgInput1 = ImageIO.read(new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album2/" + imagens2.get(0)));
                if(imgInput1.getWidth() > imgInput1.getHeight()){
                    Image thumbnail1 = imgInput1.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
                    albumIcons.add(thumbnail1);
                }else{
                    Image thumbnail1 = imgInput1.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
                    albumIcons.add(thumbnail1);
                }
                
                image = ImageIO.read(new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album3/" + imagens3.get(0)));
                BufferedImage imgInput2 = ImageIO.read(new File("/Users/simaonogueira/OneDrive - Universidade de Coimbra/FCTUC - LDM/PED/NetBeansProjects/MiniProjeto/Album3/" + imagens3.get(0)));
                if(imgInput2.getWidth() > imgInput2.getHeight()){
                    Image thumbnail2 = imgInput2.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
                    albumIcons.add(thumbnail2);
                }else{
                    Image thumbnail2 = imgInput2.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
                    albumIcons.add(thumbnail2);
                }
                
                
                // Criação de um fundo branco por detrás das imagens
                BufferedImage fundo = ImageIO.read(new File("blank.png"));
                Image thumbnailFundo = fundo.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
                image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
                image.getGraphics().drawImage(thumbnailFundo, 0, 0, null);
                
                // Final display das imagens pretendidas
                for(int i=0; i<numImgs; i++){
                    image.getGraphics().drawImage(albumIcons.get(i), 20+((150-albumIcons.get(i).getWidth(this))/2), 20+20*i+150*i+((150-albumIcons.get(i).getHeight(this))/2), null);
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
