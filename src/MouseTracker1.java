
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simaonogueira
 */

// Implementado a partir de http://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseListener.html
// e de http://stackoverflow.com/questions/18324853/checking-if-the-mouse-is-clicked-in-java

public class MouseTracker1 implements MouseListener{
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int X = e.getX();
        int Y = e.getY();
        Interface.relMouseXFoto = X;
        Interface.relMouseYFoto = Y;
        System.out.println("Clicou numa Imagem");
        System.out.println(Interface.relMouseXFoto + "," + Interface.relMouseYFoto);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
