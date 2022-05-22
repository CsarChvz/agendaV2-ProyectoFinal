/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package cesar.chavez.agenda2;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author César Chávez Rodríguez 6A TPIN
 */
public final class Captura extends AuxiliarInternalFrameImagen {
    
    // # Atributos globales de nuestra clase
    
    // -- fis: Nos sirve para guarda la cadena del archivo de entrada
    FileInputStream fis;
    // -- longitud: Como es de tipo entero, nos ayuda para guardar el largo del archivo
    int longitud;
    // imgFoto: Este es un objeto para la foto en el cuadro de "jfoto"
    Image imgFoto;
    // nomabus: Cadena la cual se usa para guardar normalmente el nombre a buscar
    String nomabus;
    
    // # Constructor de la clase -- Tira una expeción de SQL por si da un error
    public Captura() throws SQLException {
        
        // Iniciamos los compoenentes
        initComponents();
        // --Mandamos a llamar el metodo setImage el cual toma como parametro la ruta del archivo o el nombre del archivp
        //      __ En este caso escribimos la ruta del archivo/imagen que queremos mostrar o
        
        //      ## Este metodo se sobrescribio de la clase JInternalFrame y se esta usando la clase AuxiliarInternalFrame
        setImage("/fondo/fondo7.png");
        
        // # Sobreescribimiento del campo edad según la fecha del JdateChooser
        
        //  -- Se obtiene la fecha de editor y agregamos la propiedad de "escuchar los cambios" 
        jDateChooser.getDateEditor().addPropertyChangeListener(
        // Se pasa como parametro un nuevo objeto de tipo "PropertyChangeListener"
        new PropertyChangeListener() {
            // __ Sobreescribimos los un metodo el cual es propertyChange, esto se pone porque es una clase absctracta (talvez)
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // -- Condicion para sobreescribir el campo edad
                //  __ Si detecta que el JDatechose nos da algo diferente a null, va a hacer lo siguiente:
                if(jDateChooser.getDate() != null){
                    
                    // Va a obtener la fecha del dateChoose
                    Date fecha = jDateChooser.getDate();
                    // Va crear una nueva instancia de la clase Date para comparar con la fecha obtenida y convertir
                    Date fechaCompu = new Date();
                    // Se convierte con los datos anteriores para obtener los años desde el momento en que se creo la instancia
                    // y comparando con la fecha que se obtuvo del jDateChooser.
                    int agno = (int) (((fechaCompu.getTime()-fecha.getTime())
                            /86400000)/365);
                    
                    // Con el valor que se guarda en la comparación/calculo, se va a poner los datos en el campo de edad
                    JT_Edad.setText(String.valueOf(agno));
                }
            }
        });
        
        // Función para mandar a llamar los datos y que se ingresen en la tabla - jTable1
        datosTabla();
        // Funcioon para esconder los labels que sirven para mostrar que un jTextField esta incorrecto según la condicioon
        esconderStatesLabels();
        // Deshabilitamos la tabla para que no se puedan seleccionar las filas
        jTable1.setEnabled(false);
        // Deshabilitamos los campos ID y edad para que no se modifiquen, estos estan de adornos
        //      __ Se pueden usar labels, pero creo que se pueden apreciar mejor con jTextField
        JT_ID.setEnabled(false);
        JT_Edad.setEnabled(false);
    }
       /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // # Componentes de nuestra clase -- Estos fueron inicializados en nuestro constructoe
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JCFFoto = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jInputs = new javax.swing.JPanel();
        JLID = new javax.swing.JLabel();
        JL_Nombre = new javax.swing.JLabel();
        JL_Apellido = new javax.swing.JLabel();
        JL_Domicilio = new javax.swing.JLabel();
        JL_Telefono = new javax.swing.JLabel();
        JL_Email = new javax.swing.JLabel();
        JL_FechaDeNacimiento = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JL_Edad = new javax.swing.JLabel();
        JT_ID = new javax.swing.JTextField();
        JT_Nombre = new javax.swing.JTextField();
        JT_Apellido = new javax.swing.JTextField();
        JT_Domicilio = new javax.swing.JTextField();
        JT_Telefono = new javax.swing.JTextField();
        JL_Sexo = new javax.swing.JLabel();
        JR_Masculino = new javax.swing.JRadioButton();
        JR_Femenino = new javax.swing.JRadioButton();
        JT_Edad = new javax.swing.JTextField();
        JT_Email = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPFoto = new javax.swing.JPanel();
        JL_Foto = new javax.swing.JLabel();
        JB_Foto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPBotones = new javax.swing.JPanel();
        JB_Buscar = new javax.swing.JButton();
        JB_Agregar = new javax.swing.JButton();
        JB_Modificar = new javax.swing.JButton();
        JB_Eliminar = new javax.swing.JButton();
        JB_Limpiar = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName(""); // NOI18N

        jInputs.setOpaque(false);

        JLID.setText("ID");
        JLID.setMaximumSize(new java.awt.Dimension(28, 30));

        JL_Nombre.setText("Nombre");

        JL_Apellido.setText("Apellido");

        JL_Domicilio.setText("Domicilio");

        JL_Telefono.setText("Telefono");

        JL_Email.setText("Email");

        JL_FechaDeNacimiento.setText("Fecha de nacimiento");

        JL_Edad.setText("Edad");

        JT_ID.setMaximumSize(new java.awt.Dimension(150, 50));
        JT_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_IDActionPerformed(evt);
            }
        });

        JT_Nombre.setMaximumSize(new java.awt.Dimension(150, 50));
        JT_Nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_NombreFocusLost(evt);
            }
        });
        JT_Nombre.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JT_NombreInputMethodTextChanged(evt);
            }
        });

        JT_Apellido.setMaximumSize(new java.awt.Dimension(150, 50));
        JT_Apellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_ApellidoFocusLost(evt);
            }
        });
        JT_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_ApellidoActionPerformed(evt);
            }
        });

        JT_Domicilio.setMaximumSize(new java.awt.Dimension(150, 50));

        JT_Telefono.setMaximumSize(new java.awt.Dimension(150, 50));
        JT_Telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_TelefonoFocusLost(evt);
            }
        });

        JL_Sexo.setText("Sexo");

        buttonGroup1.add(JR_Masculino);
        JR_Masculino.setText("Masculino");
        JR_Masculino.setMaximumSize(new java.awt.Dimension(200, 35));

        buttonGroup1.add(JR_Femenino);
        JR_Femenino.setText("Femenino");
        JR_Femenino.setMaximumSize(new java.awt.Dimension(200, 35));

        JT_Edad.setMaximumSize(new java.awt.Dimension(150, 50));

        JT_Email.setMaximumSize(new java.awt.Dimension(150, 50));
        JT_Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_EmailFocusLost(evt);
            }
        });

        jDateChooser.setMaximumSize(new java.awt.Dimension(150, 50));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jInputsLayout = new javax.swing.GroupLayout(jInputs);
        jInputs.setLayout(jInputsLayout);
        jInputsLayout.setHorizontalGroup(
            jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputsLayout.createSequentialGroup()
                                .addComponent(JL_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputsLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(104, 104, 104))
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JL_Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(98, 98, 98))
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JLID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(135, 135, 135))
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JL_Domicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(92, 92, 92))
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JL_Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(93, 93, 93))
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JL_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(114, 114, 114))
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JL_Edad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(115, 115, 115)))
                        .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JT_Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JT_Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JT_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputsLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputsLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(JT_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputsLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(JT_Edad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(JT_Domicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JT_Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JL_Sexo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addGap(107, 107, 107))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputsLayout.createSequentialGroup()
                                .addComponent(JL_FechaDeNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addComponent(JR_Masculino, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JR_Femenino, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                            .addGroup(jInputsLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        jInputsLayout.setVerticalGroup(
            jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInputsLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JLID, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                    .addComponent(JT_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JL_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                    .addComponent(JT_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JL_Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JT_Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Domicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JT_Domicilio, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JL_Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JT_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(JT_Email, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JL_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addComponent(JL_FechaDeNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addGap(21, 21, 21)))
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JL_Edad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInputsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(JT_Edad, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addComponent(jLabel9)
                .addGap(22, 22, 22)
                .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JR_Masculino, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(JR_Femenino, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        jPFoto.setOpaque(false);

        JL_Foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        JL_Foto.setMaximumSize(new java.awt.Dimension(5, 5));

        JB_Foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/camera-gang.png"))); // NOI18N
        JB_Foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_FotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPFotoLayout = new javax.swing.GroupLayout(jPFoto);
        jPFoto.setLayout(jPFotoLayout);
        jPFotoLayout.setHorizontalGroup(
            jPFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPFotoLayout.setVerticalGroup(
            jPFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(JB_Foto)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Domiclio", "Telefono", "E-mail", "Nacimiento", "Edad", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jPBotones.setOpaque(false);

        JB_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        JB_Buscar.setText("Buscar");
        JB_Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JB_Buscar.setMaximumSize(new java.awt.Dimension(200, 50));
        JB_Buscar.setName(""); // NOI18N
        JB_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_BuscarActionPerformed(evt);
            }
        });

        JB_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        JB_Agregar.setText("Agregar");
        JB_Agregar.setMaximumSize(new java.awt.Dimension(200, 50));
        JB_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AgregarActionPerformed(evt);
            }
        });

        JB_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-save.png"))); // NOI18N
        JB_Modificar.setText("Modificar");
        JB_Modificar.setMaximumSize(new java.awt.Dimension(200, 50));
        JB_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ModificarActionPerformed(evt);
            }
        });

        JB_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        JB_Eliminar.setText("Eliminar");
        JB_Eliminar.setMaximumSize(new java.awt.Dimension(200, 50));
        JB_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EliminarActionPerformed(evt);
            }
        });

        JB_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sweep.png"))); // NOI18N
        JB_Limpiar.setText("Limpiar");
        JB_Limpiar.setMaximumSize(new java.awt.Dimension(200, 50));
        JB_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotonesLayout = new javax.swing.GroupLayout(jPBotones);
        jPBotones.setLayout(jPBotonesLayout);
        jPBotonesLayout.setHorizontalGroup(
            jPBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotonesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(JB_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(JB_Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(JB_Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(JB_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(JB_Limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPBotonesLayout.setVerticalGroup(
            jPBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBotonesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane1)
                            .addComponent(jPBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 778, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(jPFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




 
    private void JTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNombreActionPerformed
    
    // # Funcion para mostrar fotografía
    //      -- Esta funcion muestra la foto y la coloca en el JL_Foto
    private void mostrarFoto(int ID) {
        
        // Se instancia un objeto de la clase Metodos
        Metodos enlace = new Metodos();
        
        // -- Creamos y guardamos una variable tipo byte para los datos que se nos devuelven del metood obtenerFoto
        //      __ Se obtiene mediante el ID y se guarda
        byte[] resultado = enlace.obtenerFoto(ID);
        
        // Checamos si el resultado que nos devuelve es igual a null
        //      __  Esto representa que no se devolvio ninguna foto
        if (resultado == null) {
            JOptionPane.showMessageDialog(rootPane, "la persona no tiene foto.");
        } else {
            // -- So la condicion anterior no se cumplio, se pasa a esta la cual va a convertir la imagen y mostrarla
            try {
                
                // Guardamos en el objeto el resultado que nos devuelve convertir la foto 
                imgFoto = convertirImagen(resultado);
                // Creamos un icono pero tipo imageIcon con los valores del label de Jl_Fot
                Icon foto = new ImageIcon(imgFoto.getScaledInstance(JL_Foto.getWidth(), JL_Foto.getHeight(), Image.SCALE_DEFAULT));
                // Colocamos la foto instanciada en el JL_Foto
                JL_Foto.setIcon(foto);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }
        
    // # Funcion para convertir imagen apartir de bytes
    private Image convertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator lector = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader ir = (ImageReader) lector.next();
        Object objeto = bais;
        ImageInputStream iis = ImageIO.createImageInputStream(objeto);
        ir.setInput(iis, true);
        ImageReadParam irp = ir.getDefaultReadParam();
        return ir.read(0, irp);
    }
        
    private void JLHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLHombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JLHombreActionPerformed

    private void JLMUJERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLMUJERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JLMUJERActionPerformed

    private void JT_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_ApellidoActionPerformed

    private void JT_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_IDActionPerformed

    private void JB_FotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_FotoActionPerformed
        // # Evento de mostrar la foto cuando se presiona el boton de foto
        
        // -- Se instancia un objeto de la clase FileChooser
        JCFFoto = new JFileChooser();
        //      - Se coloca el objeto en modo FILES_ONLY
        JCFFoto.setFileSelectionMode
        (JCFFoto.FILES_ONLY);
        //      __ Se coloca un filtro para solo aceptar cierto tipo de archivos y extensiones
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "jpg");
        //      - Colocamos el filtro a nuestro objeto fileChooser
        JCFFoto.setFileFilter(filtro);
        
        //      __ Guardamos la lo que nos devuelve de Dialog
        int estado = JCFFoto.showOpenDialog(null);
        
        // Si este fue aprovado, entonces vamos a hacer lo siguiente
        if(estado == JFileChooser.APPROVE_OPTION){
            
            // __ Vamos a intentar lo siguiente
            try {
                
                // -- Guaradamos en la variable fis, el archivo que se selecciono
                fis = new FileInputStream(JCFFoto.getSelectedFile());
                //      - Con el archivo que se selecciono, tambien se guarda la longitud del archivo
                longitud = (int) JCFFoto.getSelectedFile().length();
                // __ Con los datos anteriores, intentamos lo siguiente
                try {
                    
                    // Creamos un objeto Imagen llamado icon y guardamos lo que nos devuelve dle metodo read de la clase ImageIO
                    //      - Lo que hace este metodo es con el archivo obtenido, se obtiene la escala y sy se obtiene lo de JL_FOTO
                    Image icon = ImageIO.read
                                            (JCFFoto.getSelectedFile()).getScaledInstance (JL_Foto.getWidth(), JL_Foto.getHeight(), Image.SCALE_DEFAULT);
                    // -- Se coloca el icon con el metodo setIcon
                    //      __ Se tiene que hacer un objeto tipo ImageIcon con la imagen que se hizo anteriormente
                    JL_Foto.setIcon(new ImageIcon(icon));
                    // Se actualiza el UI
                    JL_Foto.updateUI();
                    
                    // ## Errores
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(rootPane, "Imagen:" +ioe);
                }
            } catch (FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(rootPane, "Imagen:" +fnfe);

            }
        }
    }//GEN-LAST:event_JB_FotoActionPerformed

    private void JB_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_BuscarActionPerformed
        
        Metodos enlace = new Metodos();
        nomabus = JOptionPane.showInputDialog(rootPane, "¿A que persona quieres buscar?", "Buscando...", JOptionPane.QUESTION_MESSAGE);
        if(nomabus != null){
            String[] resultados = null;
            int nVeces = enlace.vecesRepetidas(nomabus);
            // Hacer un metodo para checar si existe el usuario y si no mostrar wea
            String[] nombreExistencia = enlace.existenciaUsuario(nomabus);
            resultados = enlace.Buscar(nomabus);
            
            if(nVeces>1){
                try {
                    jTable1.setEnabled(true);
                    JOptionPane.showMessageDialog(rootPane, "Existen " + nVeces + " usuarios con el nombre igual \n Seleccione el que quiera en la tabla");
                    busquedaConsultar(nomabus);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if(nombreExistencia[0] == null){
                    JOptionPane.showMessageDialog(rootPane, "No se encontro a " + nomabus);
                } else {
                    JT_ID.setText(resultados[0]);
                    JT_Nombre.setText(resultados[1]);
                    JT_Apellido.setText(resultados[2]);
                    JT_Domicilio.setText(resultados[3]);
                    JT_Telefono.setText(resultados[4]);
                    JT_Email.setText(resultados[5]);
                    try {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MMM/yyyy");
                        Date fechanac = formato.parse(resultados[6]);
                        jDateChooser.setDate(fechanac);
                    } catch (ParseException pex) {
                        Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, pex);
                    } finally {
                        // Si se encuentra podremos mostrar
                    }
                    

                    if (resultados[7].equals("Masculino")) {
                        buttonGroup1.setSelected(JR_Masculino.getModel(), true);
                    } else {
                        buttonGroup1.setSelected(JR_Femenino.getModel(), true);

                    }
                    mostrarFoto(Integer.parseInt(resultados[0]));
                    
                    if(!JT_ID.getText().isEmpty()){
                        JB_Agregar.setEnabled(false);
                    }
                    try {
                        datosTabla();
                    } catch (SQLException ex) {
                        Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_JB_BuscarActionPerformed

    private void JB_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AgregarActionPerformed

        String campo = "Campos:";
        String nombre =JT_Nombre.getText();
        String apellido =JT_Apellido.getText();
        String domicilio =JT_Domicilio.getText();
        String telefono =JT_Telefono.getText();
        String email =JT_Email.getText();
        Date fecha= jDateChooser.getDate();
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MMM/yyyy");
        String  nacimiento = sdf.format(fecha);
        int edad =Integer.parseInt(JT_Edad.getText());
        String edadCampo = JT_Edad.getText();
        String sexo;
        
        if(JR_Masculino.isSelected()){
            sexo = "Masculino";
        } else {
            sexo = "Femenino";
        }
        
                // Todos estos ifs se pueden solucionar si se crea un objeto algo asi
        // {nombre: valorNombre,
        //  apellido: apellido,
        //  etc,
        //          }
        // Y con este hubieramos podido iterar, y si alguno de estos no estaba vacio
        // Entonces pudieramos agregar o concatenar el campo que esta vacio para que se muestre una alerta
        // Nombre
        if (nombre.isEmpty()) {
            System.out.println("Nombre vacio");
            campo = campo.concat("+Nombre");
        }
        // Apellido
        if (apellido.isEmpty()) {
            System.out.println("Apellido vacio");
            campo = campo.concat("+Apellido");
        }
        // Domicilio
        if (domicilio.isEmpty()) {
            System.out.println("Domicilio vacio");
            campo = campo.concat("+Domicilio");
        }
        // Telefono
        if (telefono.isEmpty()) {
            System.out.println("Telefono vacio");
            campo = campo.concat("+Telefono");
        }
        // Email
        if (email.isEmpty()) {
            System.out.println("Email vacio");
            campo = campo.concat("+Email");
        }
        // Faltaria la fecha la cual se puede sacar con la edad
        // Edad
        if (edadCampo.isEmpty()) {
            System.out.println("Edad vacio");
            campo = campo.concat("+Edad");
        }
        
        // Nuevas incorporaciones para foto y edad
        if(longitud == 0){
            System.out.println("Foto vacia");
            campo = campo.concat("+Foto");
        } 
        if(jDateChooser.getDate()  == null){
            System.out.println("Fecha vacia");
            campo = campo.concat("+FechaNacimiento");

        }
        if ("Campos:".equals(campo)) {
            System.out.println(campo);
            // Si no hay ningun campo vacio
            // -- Entonces vamos a mandar una alerta la cual pregunte si realmente quiere agregar los datos.
            //       -- Si es asi entonces vamos a mandar a llamar al metood agregar, si no podemos hacer otra cosa
            // nomabus = JOptionPane.showInternalInputDialog(rootPane, "¿Seguro que quiere agregar?", "Buscando...", JOptionPane.QUESTION_MESSAGE);

            // Luego podemos mandar a llamar las validaciones, si este estan bien, entonces podemos ya psaar al pregunta
            // de que si queremos agregar
            // Por el momento asi esta bien, luego hacemos una funcion para checar si las validaciones de los campos estan bien
            //@todo
            int nomabusPa = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres agregar al nuevo usuario?");
            // Saber que retorna si presiona
            // Si se presiona si, entonces retona un cero, si este no, devuelve un 1 o 2 de los botones
            System.out.println(nomabusPa);
            if (0 == nomabusPa) {
                // Metodos error
                try {
                    if(JT_ID.getText().isEmpty()){
                        Metodos enlace = new Metodos();
                        enlace.Agregar(nombre, apellido, domicilio, telefono, email, nacimiento, sexo, edad, fis, longitud);
                        Limpiar();
                        datosTabla();
                        jTable1.setEnabled(false);
                        jTable1.addNotify();

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Debes de limpiar los campos");
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con error: " + e);
                } finally {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con exito");
                }

            } else {
                System.out.println("Nos cancela");
                System.exit(0);
                System.out.println("ADIÓS");
            }
        } else {
            // Split y luego pop
            JOptionPane.showMessageDialog(rootPane, "Faltan los siguientes campos a completar" + campo);
        }

    }//GEN-LAST:event_JB_AgregarActionPerformed

    private void JB_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ModificarActionPerformed

        String campo = "Campos:";
        int ID = Integer.parseInt(JT_ID.getText());
        String nombre = JT_Nombre.getText();
        String apellido = JT_Apellido.getText();
        String domicilio = JT_Domicilio.getText();
        String telefono = JT_Telefono.getText();
        String email = JT_Email.getText();
        Date fecha = jDateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        String nacimiento = sdf.format(fecha);
        int edad = Integer.parseInt(JT_Edad.getText());
        String edadCampo = JT_Edad.getText();
        String sexo;

        if (JR_Masculino.isSelected()) {
            sexo = "Masculino";
        } else {
            sexo = "Femenino";
        }

        // Todos estos ifs se pueden solucionar si se crea un objeto algo asi
        // {nombre: valorNombre,
        //  apellido: apellido,
        //  etc,
        //          }
        // Y con este hubieramos podido iterar, y si alguno de estos no estaba vacio
        // Entonces pudieramos agregar o concatenar el campo que esta vacio para que se muestre una alerta
        // Nombre
        if (nombre.isEmpty()) {
            System.out.println("Nombre vacio");
            campo = campo.concat("+Nombre");
        }
        // Apellido
        if (apellido.isEmpty()) {
            System.out.println("Apellido vacio");
            campo = campo.concat("+Apellido");
        }
        // Domicilio
        if (domicilio.isEmpty()) {
            System.out.println("Domicilio vacio");
            campo = campo.concat("+Domicilio");
        }
        // Telefono
        if (telefono.isEmpty()) {
            System.out.println("Telefono vacio");
            campo = campo.concat("+Telefono");
        }
        // Email
        if (email.isEmpty()) {
            System.out.println("Email vacio");
            campo = campo.concat("+Email");
        }
        // Faltaria la fecha la cual se puede sacar con la edad
        // Edad
        if (edadCampo.isEmpty()) {
            System.out.println("Edad vacio");
            campo = campo.concat("+Edad");
        }

        if ("Campos:".equals(campo)) {
            System.out.println(campo);
            // Si no hay ningun campo vacio
            // -- Entonces vamos a mandar una alerta la cual pregunte si realmente quiere agregar los datos.
            //       -- Si es asi entonces vamos a mandar a llamar al metood agregar, si no podemos hacer otra cosa
            // nomabus = JOptionPane.showInternalInputDialog(rootPane, "¿Seguro que quiere agregar?", "Buscando...", JOptionPane.QUESTION_MESSAGE);

            // Luego podemos mandar a llamar las validaciones, si este estan bien, entonces podemos ya psaar al pregunta
            // de que si queremos agregar
            // Por el momento asi esta bien, luego hacemos una funcion para checar si las validaciones de los campos estan bien
            //@todo
            int nomabusPa = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres modificar al usuario?");
            // Saber que retorna si presiona
            // Si se presiona si, entonces retona un cero, si este no, devuelve un 1 o 2 de los botones
            System.out.println(nomabusPa);
            if (0 == nomabusPa) {
                // Metodos error
                try {
                    Metodos enlace = new Metodos();
                    enlace.Modificar(nombre, apellido, domicilio, telefono, email, nacimiento, sexo, edad, fis, longitud, ID);
                    Limpiar();
                    datosTabla();
                    jTable1.clearSelection();
                    jTable1.setEnabled(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con error: " + e);
                } finally {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con exito");
                }

            } else {
                System.out.println("Nos cancela");
                System.exit(0);
                System.out.println("ADIÓS");
            }
        } else {
            // Split y luego pop
            JOptionPane.showMessageDialog(rootPane, "Faltan los siguientes campos a completar" + campo);
        }

    }//GEN-LAST:event_JB_ModificarActionPerformed

    private void JB_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EliminarActionPerformed
        // TODO add your handling code here:
        Metodos enlace = new Metodos();
        int ID = Integer.parseInt(JT_ID.getText());
        int nomabusPa = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quiere eliminar?");
        if (nomabusPa == 0) {
            try {
                enlace.Eliminar(ID);
                Limpiar();
                jTable1.clearSelection();
                datosTabla();
                jTable1.setEnabled(false);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "NO SE ENCONTRÓ A: " + ID);

            }
        }
    }//GEN-LAST:event_JB_EliminarActionPerformed

    private void JB_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_LimpiarActionPerformed
        try {
            // TODO add your handling code her
            Limpiar();
            datosTabla();
            JB_Agregar.setEnabled(true);
            jTable1.setEnabled(false);
            jTable1.clearSelection();
            JOptionPane.showMessageDialog(rootPane, "Limpiados los campos del formulario");
        } catch (SQLException ex) {
            Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_LimpiarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        int fila = jTable1.getSelectedRow();
//        if (fila == -1) {
//
//        } else {
//
//            // Obtenemos los valores de la fila
//            int idc = Integer.parseInt((String) jTable1.getValueAt(fila, 0).toString());
//            String id = (String) jTable1.getValueAt(fila, 0).toString();
//            String Nombre = (String) jTable1.getValueAt(fila, 1);
//            String apellido = (String) jTable1.getValueAt(fila, 2);
//            String domicilio = (String) jTable1.getValueAt(fila, 3);
//            String telefono = (String) jTable1.getValueAt(fila, 4);
//            String email = (String) jTable1.getValueAt(fila, 5);
//            //Fecha
//            String fechaNacimiento = (String) jTable1.getValueAt(fila, 6);
//            String date = fechaNacimiento;
//            try {
//                
//                SimpleDateFormat formato = new SimpleDateFormat("dd/MMM/yyyy");
//                Date fechanac = formato.parse(date);
//                jDateChooser.setDate(fechanac);
//            } catch (ParseException ex) {
//                Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            // -- Fin de fecha
//            String sexo = (String) jTable1.getValueAt(fila, 7);
//            String edad = (String) jTable1.getValueAt(fila, 8).toString();
//            //Blob foto = (Blob) jTable1.getValueAt(fila, 9);
//            JTFID2.setText(id);
//            JTFNombre.setText(Nombre);
//            JTFApellido.setText(apellido);
//            JTFDomicilio.setText(domicilio);
//            JTFTelefono.setText(telefono);
//            JTFEmail.setText(email);
//            JTFEdad.setText(edad);
//            //JD_DateChooser.setDate(d1);
//            if ("Masculino".equals(sexo)) {
//                buttonGroup1.setSelected(JLHombre.getModel(), true);
//            } else {
//                buttonGroup1.setSelected(JLMUJER.getModel(), true);
//
//            }
//            // Fotografia
//            mostrarFoto(idc);
//            JBAgregar.setEnabled(false);
//            mostrarBotones();
//            //System.out.println(foto);
//        }


    // Se encontro solucion para poder clickear dos veces 
    
    // https://stackoverflow.com/questions/14852719/double-click-listener-on-jtable-in-java
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        //JTable jTable1 = (JTable) evt.getSource();
        jTable1 = (JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = jTable1.rowAtPoint(point);
        if (evt.getClickCount() == 2 && jTable1.getSelectedRow() != -1) {
            // your valueChanged overridden method 
            System.out.println("Pressed twiche");
            
            int fila = jTable1.getSelectedRow();
            if (fila == -1) {
                System.out.println("PENDEJADA");
            } else {

                // Obtenemos los valores de la fila
                int idc = Integer.parseInt((String) jTable1.getValueAt(fila, 0).toString());
                String id = (String) jTable1.getValueAt(fila, 0).toString();
                String Nombre = (String) jTable1.getValueAt(fila, 1);
                String apellido = (String) jTable1.getValueAt(fila, 2);
                String domicilio = (String) jTable1.getValueAt(fila, 3);
                String telefono = (String) jTable1.getValueAt(fila, 4);
                String email = (String) jTable1.getValueAt(fila, 5);
                //Fecha
                String fechaNacimiento = (String) jTable1.getValueAt(fila, 6);
                String date = fechaNacimiento;
                try {
                    java.util.Date date2 = new SimpleDateFormat("dd/MMM/yyyy").parse(date);
                    jDateChooser.setDate(date2);
                } catch (ParseException ex) {
                    Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
                }

                // -- Fin de fecha
                String sexo = (String) jTable1.getValueAt(fila, 7);
                String edad = (String) jTable1.getValueAt(fila, 8).toString();
                //Blob foto = (Blob) jTable1.getValueAt(fila, 9);
                JT_ID.setText(id);
                JT_Nombre.setText(Nombre);
                JT_Apellido.setText(apellido);
                JT_Domicilio.setText(domicilio);
                JT_Telefono.setText(telefono);
                JT_Email.setText(email);
                JT_Edad.setText(edad);
                //JD_DateChooser.setDate(d1);
                
                // CORREGIR LO DEl dia
                
                if ("Masculino".equals(sexo)) {
                    buttonGroup1.setSelected(JR_Masculino.getModel(), true);
                } else {
                    buttonGroup1.setSelected(JR_Femenino.getModel(), true);

                }
                // Fotografia
                mostrarFoto(idc);
                JB_Agregar.setEnabled(false);
                mostrarBotones();
                //System.out.println(foto);
            }
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void JT_NombreInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JT_NombreInputMethodTextChanged
        System.out.println("");
    }//GEN-LAST:event_JT_NombreInputMethodTextChanged

    private void JT_NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_NombreFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("[0-9]");
        if (!JT_Nombre.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Nombre.getText());
            boolean matchFound = matcher.find();
            System.out.println(matchFound);
            if (matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel1.setVisible(true);
                jLabel1.setText("No es un nombre");
                jLabel1.updateUI();
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel1.setVisible(true);
                jLabel1.setText("Correcto");
                jLabel1.updateUI();
            }
        }
    }//GEN-LAST:event_JT_NombreFocusLost

    private void JT_ApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_ApellidoFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("[0-9]");
        // Podemos ver si se tiene numeros, si este es asi entonces mostrar
        if (!JT_Apellido.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Apellido.getText());
            boolean matchFound = matcher.find();
            if (!matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel2.setVisible(true);
                jLabel2.setText("Correcto");
                jLabel2.updateUI();
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel2.setVisible(true);
                jLabel2.setText("No es un apellido");
                jLabel2.updateUI();
            }
        }
    }//GEN-LAST:event_JT_ApellidoFocusLost

    private void JT_TelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_TelefonoFocusLost
        Pattern pattern = Pattern.compile("[A-Za-z]");
        if (!JT_Telefono.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Telefono.getText());
            boolean matchFound = matcher.find();
            System.out.println(matchFound);
            if (matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel3.setVisible(true);
                jLabel3.setText("No es un telefono");
                jLabel3.updateUI();
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel3.setVisible(true);
                jLabel3.setText("Correcto");
                jLabel3.updateUI();
            }
        }
    }//GEN-LAST:event_JT_TelefonoFocusLost

    private void JT_EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_EmailFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        if (!JT_Email.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Email.getText());
            boolean matchFound = matcher.find();
            if (matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel4.setVisible(true);
                jLabel4.setText("Correcto");
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel4.setVisible(true);
                jLabel4.setText("No es correcto");
                jLabel4.updateUI();
            }
        }
    }//GEN-LAST:event_JT_EmailFocusLost
    public void Limpiar(){
           JT_ID.setText(null);
           JT_Nombre.setText(null);
           JT_Apellido.setText(null);
           JT_Domicilio.setText(null);
           JT_Telefono.setText(null);
           JT_Email.setText(null);
           
           jDateChooser.setDate(null);
           JT_Edad.setText(null); 
           buttonGroup1.clearSelection();
           JL_Foto.setIcon(null);
           JR_Masculino.setSelected(false);
           JR_Femenino.setSelected(false);
           
           // Los statesLabel -- Resetearlos
           jLabel1.setText("");
           jLabel2.setText("");
           jLabel3.setText("");
           jLabel4.setText("");
          }

    void datosTabla() throws SQLException {
        Metodos m = new Metodos();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Connection conexion = m.obtenerConexion();
        String query = "select * from personas";
        PreparedStatement instruccion = conexion.prepareStatement(query);
        ResultSet rs = instruccion.executeQuery();
        Object[] persona = new Object[9];
        model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();
        while (rs.next()) {
            persona[0] = rs.getInt("Id");
            persona[1] = rs.getString("nombre");
            persona[2] = rs.getString("apellido");
            persona[3] = rs.getString("domicilio");
            persona[4] = rs.getString("telefono");
            persona[5] = rs.getString("email");
            persona[6] = rs.getString("fechanacimiento");
            persona[8] = rs.getString("sexo");
            persona[7] = rs.getInt("edad");
            model.addRow(persona);
        }
    }
    
    public void busquedaConsultar(String nombre) throws SQLException {
        String query = "select * from Personas where Nombre=?";
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Metodos m = new Metodos();
        Connection conexion = m.obtenerConexion();

        PreparedStatement instruccion = conexion.prepareStatement(query);
        instruccion.setString(1, nombre);
        ResultSet rs = instruccion.executeQuery();
        Object[] persona = new Object[9];
        model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();
        while (rs.next()) {
            persona[0] = rs.getInt("Id");
            persona[1] = rs.getString("nombre");
            persona[2] = rs.getString("apellido");
            persona[3] = rs.getString("domicilio");
            persona[4] = rs.getString("telefono");
            persona[5] = rs.getString("email");
            persona[6] = rs.getString("fechanacimiento");
            persona[7] = rs.getString("sexo");
            persona[8] = rs.getInt("edad");
            model.addRow(persona);
        }

    }
    
    void mostrarBotones() {
        JB_Modificar.setVisible(true);
        JB_Eliminar.setVisible(true);
    }
    
    void esconderStatesLabels(){
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
    }
    
    // Funcion para checar que los regex esten correctos
    void checarRegexBoton(){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Agregar;
    private javax.swing.JButton JB_Buscar;
    private javax.swing.JButton JB_Eliminar;
    private javax.swing.JButton JB_Foto;
    private javax.swing.JButton JB_Limpiar;
    private javax.swing.JButton JB_Modificar;
    private javax.swing.JFileChooser JCFFoto;
    private javax.swing.JLabel JLID;
    private javax.swing.JLabel JL_Apellido;
    private javax.swing.JLabel JL_Domicilio;
    private javax.swing.JLabel JL_Edad;
    private javax.swing.JLabel JL_Email;
    private javax.swing.JLabel JL_FechaDeNacimiento;
    private javax.swing.JLabel JL_Foto;
    private javax.swing.JLabel JL_Nombre;
    private javax.swing.JLabel JL_Sexo;
    private javax.swing.JLabel JL_Telefono;
    private javax.swing.JRadioButton JR_Femenino;
    private javax.swing.JRadioButton JR_Masculino;
    private javax.swing.JTextField JT_Apellido;
    private javax.swing.JTextField JT_Domicilio;
    private javax.swing.JTextField JT_Edad;
    private javax.swing.JTextField JT_Email;
    private javax.swing.JTextField JT_ID;
    private javax.swing.JTextField JT_Nombre;
    private javax.swing.JTextField JT_Telefono;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jInputs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPBotones;
    private javax.swing.JPanel jPFoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
