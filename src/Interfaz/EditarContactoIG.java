package Interfaz;

import agenda.Agenda;
import agenda.Contacto;
import agenda.Telefono;
import com.google.i18n.phonenumbers.NumberParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author almig
 */
public class EditarContactoIG extends javax.swing.JFrame {

    /**
     * Creates new form NuevoContactoIG
     */
    private InterfazGrafica ig;
    private String contacto;
    private Contacto contactoSelec, contactoMod;
    private DefaultListModel lm = new DefaultListModel();
    
    public EditarContactoIG(InterfazGrafica ig, String contacto) {
        initComponents();
        this.setTitle("Editar Contacto");
        this.setLocationRelativeTo(ig);
        this.ig = ig;
        this.contacto = contacto;
        contactoSelec = ig.getAgenda().Buscar(contacto);
        try {
            contactoMod = new Contacto(contactoSelec.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(EditarContactoIG.class.getName()).log(Level.SEVERE, null, ex);
        }
        campoNombre.setText(contacto);
        for(Telefono tel: this.contactoSelec.getTelefonos()){
            lm.addElement(tel.getNumero());
            contactoMod.anadeTelefono(tel);
        }
        this.listaTelefonos = new javax.swing.JList<>(lm);
        listaTelefonos.ensureIndexIsVisible(lm.getSize());
        jScrollPane1.setViewportView(listaTelefonos);
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGuardaCambiosEditar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonCancelarEditar = new javax.swing.JLabel();
        botonEliminarContacto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        botonAgregarTelefono = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTelefonos = new javax.swing.JList<>();
        botonEliminarTelefono = new javax.swing.JLabel();
        botonLlamada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(36, 115, 165));
        jPanel1.setForeground(new java.awt.Color(40, 129, 186));

        btnGuardaCambiosEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/done.png"))); // NOI18N
        btnGuardaCambiosEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardaCambiosEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardaCambiosEditarMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ver/Editar Contacto");

        botonCancelarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cancel.png"))); // NOI18N
        botonCancelarEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelarEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonCancelarEditarMouseReleased(evt);
            }
        });

        botonEliminarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bin.png"))); // NOI18N
        botonEliminarContacto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonEliminarContactoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonEliminarContacto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelarEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardaCambiosEditar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardaCambiosEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCancelarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminarContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user-large.png"))); // NOI18N

        jLabel4.setText("Nombre:");

        jLabel5.setText("Teléfono:");

        botonAgregarTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonAgregarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/add.png"))); // NOI18N
        botonAgregarTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAgregarTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonAgregarTelefonoMouseReleased(evt);
            }
        });

        jLabel7.setText("Telefonos:");

        listaTelefonos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaTelefonos);

        botonEliminarTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonEliminarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/trash.png"))); // NOI18N
        botonEliminarTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonEliminarTelefonoMouseReleased(evt);
            }
        });

        botonLlamada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonLlamada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/phone.png"))); // NOI18N
        botonLlamada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNombre)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTelefono)
                            .addComponent(jScrollPane1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonAgregarTelefono))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(botonEliminarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAgregarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardaCambiosEditarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardaCambiosEditarMouseReleased
        try {
            String nombre = this.campoNombre.getText();
            this.contactoMod.setNombre(nombre);
            JOptionPane.showMessageDialog(rootPane,"¡Contacto editado con éxito!");
            this.ig.getAgenda().Eliminar(contactoSelec.getNombre());
            this.ig.getAgenda().Anadir(contactoMod);
            this.ig.actualizarTabla("todo");
            this.dispose();
            ig.setViendoContactoFalse();
        } catch (Exception ex) {
            Logger.getLogger(EditarContactoIG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardaCambiosEditarMouseReleased

    private void botonCancelarEditarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarEditarMouseReleased
        this.dispose();
        ig.setViendoContactoFalse();
    }//GEN-LAST:event_botonCancelarEditarMouseReleased

    private void botonEliminarContactoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarContactoMouseReleased
        int opcion;
        opcion = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro que deseas borrar el contacto?", "Mensaje", YES_NO_OPTION);
        if(opcion == YES_OPTION){
            Agenda agd = this.ig.getAgenda();
            agd.Eliminar(this.contacto);
            JOptionPane.showMessageDialog(rootPane,"¡Contacto borrado con éxito!");
            this.ig.actualizarTabla("todo");
            this.dispose();
            ig.setViendoContactoFalse();
        }
    }//GEN-LAST:event_botonEliminarContactoMouseReleased

    private void botonAgregarTelefonoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarTelefonoMouseReleased
        try {
            Telefono tlf = new Telefono(this.campoTelefono.getText());
            this.contactoMod.anadeTelefono(tlf);
            lm.addElement(tlf.getNumero());
            listaTelefonos = new javax.swing.JList<>(lm);
            listaTelefonos.ensureIndexIsVisible(lm.getSize());
            jScrollPane1.setViewportView(listaTelefonos);
            this.campoTelefono.setText("");
        } catch (NumberParseException ex) {
            Logger.getLogger(NuevoContactoIG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAgregarTelefonoMouseReleased

    private void botonEliminarTelefonoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarTelefonoMouseReleased
        int opcion;
        Telefono telSelec = null;
        try {
            telSelec = new Telefono(this.listaTelefonos.getSelectedValue());
        } catch (NumberParseException ex) {
            Logger.getLogger(EditarContactoIG.class.getName()).log(Level.SEVERE, null, ex);
        }
        opcion = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro que deseas borrar el número "+telSelec.getNumero()+"?", "Mensaje", YES_NO_OPTION);
        if(opcion == YES_OPTION){
            this.contactoMod.borraTelefono(telSelec);
            lm.removeElement(telSelec.getNumero());
            listaTelefonos = new javax.swing.JList<>(lm);
            listaTelefonos.ensureIndexIsVisible(lm.getSize());
            jScrollPane1.setViewportView(listaTelefonos);
        }
    }//GEN-LAST:event_botonEliminarTelefonoMouseReleased

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
            java.util.logging.Logger.getLogger(EditarContactoIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarContactoIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarContactoIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarContactoIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonAgregarTelefono;
    private javax.swing.JLabel botonCancelarEditar;
    private javax.swing.JLabel botonEliminarContacto;
    private javax.swing.JLabel botonEliminarTelefono;
    private javax.swing.JLabel botonLlamada;
    private javax.swing.JLabel btnGuardaCambiosEditar;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaTelefonos;
    // End of variables declaration//GEN-END:variables
}
