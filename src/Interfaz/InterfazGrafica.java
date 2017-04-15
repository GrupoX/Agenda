package Interfaz;

import Interfaz.IconCellRenderer;
import agenda.Agenda;
import agenda.Contacto;
import agenda.Telefono;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.google.i18n.phonenumbers.NumberParseException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author almig
 */
public class InterfazGrafica extends javax.swing.JFrame {

    private boolean opcionesOpen = false;
    private boolean buscarOpen = false;
    private boolean nuevoContacto = false;
    private boolean viendoContacto = false;
    private Agenda agd;

    public InterfazGrafica(Agenda agenda) {
        initComponents();
        this.setTitle("Mi Agenda");
        this.agd=agenda;
        //Posicionar el Frame en la Pantalla
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) (screenSize.width * 0.5) - 150, (int) (screenSize.height * 0.5) - 252);
        this.setSize(300, 525);
        actualizarTabla("todo");
        //Mostrar solo panel Principal
        panelOpciones.setVisible(false);
        panelBuscar.setVisible(false);
    }
    
    public Agenda getAgenda(){
        return this.agd;
    }

    public void setNuevoContactoFalse() {
        nuevoContacto = false;
    }
    public void setViendoContactoFalse() {
        viendoContacto = false;
    }
    
    public JTable getTabla(){
        return this.tablaContactos;
    } 
    public void actualizarTabla(String busqueda) {
        if (busqueda.equals("todo")) {
            int num_contactos;
            if (this.agd.isEmpty()){
                num_contactos = 0;
            }else{
                num_contactos = agd.Mostrar().size(); //Cantidad de Resultados que tendra la Tabla
            }
            tablaContactos.setDefaultRenderer(Object.class, new IconCellRenderer());
            DefaultTableModel model = (DefaultTableModel) tablaContactos.getModel();
            model.setRowCount(num_contactos);
            tablaContactos.getTableHeader().setUI(null);
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/assets/default-user-image.png"));
            for (int i = 0; i < num_contactos; i++) { //Voy Rellenando la tabla
                tablaContactos.setValueAt(new JLabel(icon1), i, 0);
                tablaContactos.setValueAt(agd.Mostrar().get(i).getNombre(), i, 1);
            }
            
        }else{
            //Busqueda por Telefono o nombre
        }
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBuscar = new javax.swing.JPanel();
        campoBusqueda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        btnImportarCSV = new javax.swing.JLabel();
        btnExportarCSV = new javax.swing.JLabel();
        btnEliminarTodo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaContactos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        panelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        panelBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 129, 186)));

        campoBusqueda.setText("Nombre o Número");
        campoBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                campoBusquedaMouseReleased(evt);
            }
        });
        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/next.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel7MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(panelBuscar);
        panelBuscar.setBounds(10, 30, 210, 58);
        panelBuscar.getAccessibleContext().setAccessibleDescription("");

        panelOpciones.setBackground(new java.awt.Color(255, 255, 255));
        panelOpciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 129, 186)));

        btnImportarCSV.setText("Importar CSV");
        btnImportarCSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportarCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnImportarCSVMouseReleased(evt);
            }
        });

        btnExportarCSV.setText("Exportar CSV");
        btnExportarCSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportarCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExportarCSVMouseReleased(evt);
            }
        });

        btnEliminarTodo.setText("Eliminar Todo");
        btnEliminarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEliminarTodoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImportarCSV)
                    .addComponent(btnExportarCSV)
                    .addComponent(btnEliminarTodo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImportarCSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportarCSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarTodo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelOpciones);
        panelOpciones.setBounds(150, 30, 100, 90);

        jPanel1.setBackground(new java.awt.Color(40, 129, 186));
        jPanel1.setForeground(new java.awt.Color(40, 129, 186));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/menu.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setFocusCycleRoot(true);
        jLabel3.setFocusTraversalPolicyProvider(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel3MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mi Agenda");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/add-user.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel9MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setFocusable(false);
        jScrollPane2.setRequestFocusEnabled(false);

        tablaContactos.setBackground(new java.awt.Color(236, 240, 241));
        tablaContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Imagen", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaContactos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaContactos.setGridColor(new java.awt.Color(236, 240, 241));
        tablaContactos.setRowHeight(45);
        tablaContactos.setRowSelectionAllowed(false);
        tablaContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaContactosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaContactosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaContactos);
        if (tablaContactos.getColumnModel().getColumnCount() > 0) {
            tablaContactos.getColumnModel().getColumn(0).setMinWidth(50);
            tablaContactos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaContactos.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaContactos.getColumnModel().getColumn(1).setResizable(false);
            tablaContactos.getColumnModel().getColumn(1).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 20, 300, 510);

        jPanel3.setBackground(new java.awt.Color(40, 129, 186));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/close.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.setFocusable(false);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 300, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        if (!opcionesOpen) {
            tablaContactos.clearSelection();
            panelOpciones.setVisible(true);
            opcionesOpen = true;
            panelBuscar.setVisible(false);
            buscarOpen = false;
        } else {
            panelOpciones.setVisible(false);
            opcionesOpen = false;
            panelBuscar.setVisible(false);
            buscarOpen = false;
        }
    }//GEN-LAST:event_jLabel2MouseReleased

    private void btnImportarCSVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportarCSVMouseReleased
        System.out.println("Cargando copia en formato CSV...");
        String ruta = "";
        JFileChooser copiaDatos = new JFileChooser();
        LinkedList<Telefono> telefonos;
        if(copiaDatos.showOpenDialog(this)==copiaDatos.APPROVE_OPTION) {
            try {
                ruta = copiaDatos.getSelectedFile().getAbsolutePath();
                CsvReader contactos_import = new CsvReader(ruta);
                contactos_import.readHeaders();
                this.agd=new Agenda();
                while (contactos_import.readRecord()) {
                    String nombre = contactos_import.get("Nombre");
                    String telefono = contactos_import.get("Telefonos");
                    String arrayTelfs[] = telefono.split("-");
                    telefonos = new LinkedList<>();
                    for(String telf : arrayTelfs){
                        if (!(telf==null)&&!(telf.equals(""))){
                        Telefono t = new Telefono(telf);
                        telefonos.add(t);
                        }
                    }
                    Contacto c = new Contacto(nombre,telefonos);
                    this.agd.Anadir(c);
                }
             
                contactos_import.close();
            } catch (FileNotFoundException ex) {
                
            } catch (IOException ex) {

            } catch (NumberParseException ex) {

            } catch (Exception ex) {
                
            }
            this.actualizarTabla("todo");
        }
        panelOpciones.setVisible(false);
        opcionesOpen = false;
        panelBuscar.setVisible(false);
        buscarOpen = false;
    }//GEN-LAST:event_btnImportarCSVMouseReleased

    private void btnExportarCSVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarCSVMouseReleased
        System.out.println("Creando copia en formato CSV...");
        String ruta = "";
        String telfs = "";
        JFileChooser copiaDatos = new JFileChooser();
        if(copiaDatos.showSaveDialog(this)==copiaDatos.APPROVE_OPTION) {
            ruta = copiaDatos.getSelectedFile().getAbsolutePath();
            File arch = new File(ruta);
            arch.delete();
            try {
                arch.createNewFile();
                CsvWriter csvOutput = new CsvWriter(new FileWriter(ruta, true), ',');
                csvOutput.write("Nombre");
                csvOutput.write("Telefonos");
                csvOutput.endRecord();
                for(Contacto c : agd.Mostrar()){
                    csvOutput.write(c.getNombre());
                    for(Telefono t : c.getTelefonos()){
                        telfs = telfs+"-"+t.getNumero();
                    }
                    csvOutput.write(telfs);
                    telfs = "";
                    csvOutput.endRecord();                   
                }
                csvOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        panelOpciones.setVisible(false);
        opcionesOpen = false;
        panelBuscar.setVisible(false);
        buscarOpen = false;
    }//GEN-LAST:event_btnExportarCSVMouseReleased

    private void btnEliminarTodoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarTodoMouseReleased
        int respuesta = JOptionPane.showConfirmDialog(panelOpciones, "Se borrarán todos los contactos","Desea continuar...",YES_NO_OPTION);
        if (respuesta==JOptionPane.YES_OPTION) {
            this.agd.Vaciar();
            System.out.println(this.agd.isEmpty());
            JOptionPane.showMessageDialog(rootPane,"Contactos borrados satisfactoriamente");
            this.actualizarTabla("todo");
            panelOpciones.setVisible(false);
            opcionesOpen = false;
            panelBuscar.setVisible(false);
            buscarOpen = false;
        }
    }//GEN-LAST:event_btnEliminarTodoMouseReleased

    private void tablaContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaContactosMouseClicked
        panelOpciones.setVisible(false);
        opcionesOpen = false;
        panelBuscar.setVisible(false);
        buscarOpen = false;
    }//GEN-LAST:event_tablaContactosMouseClicked

    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased
        if (!buscarOpen) {
            panelBuscar.setVisible(true);
            campoBusqueda.setText("Nombre o Número");
            buscarOpen = true;
            opcionesOpen = false;
            panelOpciones.setVisible(false);
            tablaContactos.clearSelection();
        } else {
            panelBuscar.setVisible(false);
            buscarOpen = false;
            opcionesOpen = false;
            panelOpciones.setVisible(false);
        }
    }//GEN-LAST:event_jLabel3MouseReleased

    private void campoBusquedaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBusquedaMouseReleased
        campoBusqueda.setText("");
        tablaContactos.clearSelection();
        panelBuscar.setVisible(true);
    }//GEN-LAST:event_campoBusquedaMouseReleased

    private void jLabel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseReleased
        System.out.println("Has Buscado Algo");
        //actualizarTabla("Texto de Busqueda");
    }//GEN-LAST:event_jLabel7MouseReleased

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void jLabel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseReleased
        if (!nuevoContacto) {
            panelBuscar.setVisible(false);
            buscarOpen = false;
            opcionesOpen = false;
            panelOpciones.setVisible(false);
            NuevoContactoIG nc = new NuevoContactoIG(this);
            nc.setVisible(true);
            nuevoContacto = true;
        }
    }//GEN-LAST:event_jLabel9MouseReleased

    private void tablaContactosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaContactosMouseReleased
        if (!buscarOpen && !opcionesOpen && !viendoContacto) {
            System.out.println("HAS SELECCIONADO EL: " + tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1));
            //tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1) devuelve el nombre seleccionado
            //Sustituir el String por un Contacto y Modificar el Contructor 
            //de la Clase EditarContactoIG
            EditarContactoIG ec = new EditarContactoIG(this, (String) tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1));
            ec.setVisible(true);
            viendoContacto = true;
        }

    }//GEN-LAST:event_tablaContactosMouseReleased

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        agd.crearCopiaSeg();
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agenda agenda = new Agenda();
                agenda = agenda.restCopiaSeg();
                new InterfazGrafica(agenda).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEliminarTodo;
    private javax.swing.JLabel btnExportarCSV;
    private javax.swing.JLabel btnImportarCSV;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTable tablaContactos;
    // End of variables declaration//GEN-END:variables
}
