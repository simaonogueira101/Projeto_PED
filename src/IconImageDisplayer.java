
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simaonogueira
 */
public class IconImageDisplayer {
    
    public void getIconGeral(int maxSize){
        
            BufferedImage image = new BufferedImage(maxSize, maxSize, BufferedImage.TYPE_INT_ARGB);
            
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
                
                System.out.println("Nome do Album a Apresentar em IconDisplayer: " + Interface.numAlbumShow);
                
                // Criação de um ArrayList onde serão colocadas imagens
                ArrayList<Image> albumIcons = new ArrayList<Image>();
                
                // Leitura das várias imagens para adicionar ao ArrayList
                for(int i=0; i<numImgs; i++){
                    image = ImageIO.read(new File(fileLocation + imagens.get(i)));
                    BufferedImage imgInput = ImageIO.read(new File(fileLocation + imagens.get(i)));
                    if(imgInput.getWidth() > imgInput.getHeight()){
                        Image thumbnail = imgInput.getScaledInstance(maxSize, -1, Image.SCALE_SMOOTH);
                        albumIcons.add(thumbnail);
                    }else{
                        Image thumbnail = imgInput.getScaledInstance(-1, maxSize, Image.SCALE_SMOOTH);
                        albumIcons.add(thumbnail);
                    }
                }
                
                for(int i=0; i<albumIcons.size(); i++){
                    ImageIcon temp = new ImageIcon(albumIcons.get(i));
                    Interface.smalliconIcons.add(temp);
                }
                
                // Measures to save Java allocated memory
                albumIcons.clear();
                imagens.clear();
            }
            catch (IOException e) {
                System.out.println( e.getMessage());
            }
        }
}
