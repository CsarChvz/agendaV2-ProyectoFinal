/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesar.chavez.agenda2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 *
 * @author depresion
 */
public class FondoJDPane extends JDesktopPane{
    private BufferedImage imagen;

    public FondoJDPane() {
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/fondo/fondo-5.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
    }
    
    
}
