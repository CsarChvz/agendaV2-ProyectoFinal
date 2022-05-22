/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesar.chavez.agenda2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author depresion
 */
public class PanelImagen extends JPanel{
    private Image imagen;
    
    public PanelImagen(){
        imagen = null;
    }
    
    public PanelImagen(String nombreImagen){
        if(nombreImagen != null){
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        }
    }
    
    public void setImage(String nombreImagen){
        if(nombreImagen != null){
            imagen =  new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        } else {
            imagen = null;
        }
        repaint();
    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g){
        if(imagen != null){
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            this.setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paint(g);
    }
}
