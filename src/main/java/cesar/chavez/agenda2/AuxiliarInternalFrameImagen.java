/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesar.chavez.agenda2;

import javax.swing.JInternalFrame;


/**
 *
 * @author depresion
 */
public class AuxiliarInternalFrameImagen extends JInternalFrame{
    private PanelImagen pi = new PanelImagen();
    
    public AuxiliarInternalFrameImagen(){
        setContentPane(pi);
    }
    
    public void setImage(String nombreImagen){
        pi.setImage(nombreImagen);
    }
}
