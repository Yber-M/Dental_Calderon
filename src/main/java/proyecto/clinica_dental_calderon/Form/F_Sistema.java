package proyecto.clinica_dental_calderon.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class F_Sistema extends javax.swing.JFrame implements ActionListener {

    public Connection connection;

    //ICONO DEL SISTEMA
    String logo = "/images/diente.png";
    String casa = "/images/menu-principal.png";

    //IMAGENES
    String logoimagencircle = "/images/LogoDentalCircle.png";
    String Pacientes = "/images/Pacientes.png";
    String Tratamientos = "/images/Tratamientos.png";
    String Citas = "/images/Citas.png";
    String Pagos = "/images/pagos.png";
    String Proforma = "/images/Proforma.png";
    String CerrarSesion = "/images/CerrarSesion.png";

    ImageIcon iconImagen = new ImageIcon(F_Sistema.class.getResource(logoimagencircle));
    ImageIcon pacientesImagen = new ImageIcon(F_Sistema.class.getResource(Pacientes));
    ImageIcon tratamientoImagen = new ImageIcon(F_Sistema.class.getResource(Tratamientos));
    ImageIcon citasImagen = new ImageIcon(F_Sistema.class.getResource(Citas));
    ImageIcon pagosImagen = new ImageIcon(F_Sistema.class.getResource(Pagos));
    ImageIcon proformasImagen = new ImageIcon(F_Sistema.class.getResource(Proforma));

    ImageIcon casaImagen = new ImageIcon(F_Sistema.class.getResource(casa));

    Panel_Pacientes pacientes = new Panel_Pacientes();
    Panel_Citas citas = new Panel_Citas();
    Panel_Tratamientos tratamientos = new Panel_Tratamientos();
    Panel_Pagos pagos = new Panel_Pagos();
    Panel_Proformas proformas = new Panel_Proformas();
    Panel_Inicio inicioMenu = new Panel_Inicio();
    F_Login login = new F_Login();

    public F_Sistema() throws SQLException {

        initComponents();

        PanelSistema.add(inicioMenu);

        this.setIconImage(new ImageIcon(F_Sistema.class.getResource(logo)).getImage());

        lblLogo.setIcon(iconImagen);
        lblPacientes.setIcon(pacientesImagen);
        lblTratamientos.setIcon(tratamientoImagen);
        lblCitas.setIcon(citasImagen);
        lblPagos.setIcon(pagosImagen);
        lblProforma.setIcon(proformasImagen);

        lblCasa.setIcon(casaImagen);

        btnMenuPrincipal.setEnabled(false);

        this.setResizable(false);
        this.setLocationRelativeTo(null);

        pacientes.abrirConexion();
        tratamientos.abrirConexion();
        citas.abrirConexion();
        pagos.abrirConexion();
        proformas.abrirConexion();
        login.cerrarRecursos();

        lblLogo.requestFocusInWindow();

        btnPacientes.addActionListener(this);
        btnTratamientos.addActionListener(this);
        btnCitas.addActionListener(this);
        btnPagos.addActionListener(this);
        btnReportes.addActionListener(this);
        btnMenuPrincipal.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if (evt.equals(btnPacientes)) {

            try {
                pacientes.actualizarDatos_Paciente();
                tratamientos.actualizarTablaTratamientos();
                citas.actualizarTablaCitas();
                pagos.actualizarTablaPagos();
                proformas.actualizarTablaProformas();
                inicioMenu.actualizarTabla();

                // Resto del código para mostrar el panel de pacientes
                inicioMenu.setVisible(false);

                citas.setVisible(false);
                tratamientos.setVisible(false);
                proformas.setVisible(false);
                pagos.setVisible(false);
                pacientes.setVisible(true);

                PanelSistema.add(pacientes);
                PanelSistema.validate();
                deshabilitar_Boton_Pacientes();
                // Resto de tu código para el botón Pacientes
            } catch (SQLException ex) {
                Logger.getLogger(F_Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.equals(btnTratamientos)) {

            try {
                pacientes.actualizarDatos_Paciente();
                tratamientos.actualizarTablaTratamientos();
                citas.actualizarTablaCitas();
                pagos.actualizarTablaPagos();
                proformas.actualizarTablaProformas();
                inicioMenu.actualizarTabla();

                inicioMenu.setVisible(false);

                citas.setVisible(false);
                pacientes.setVisible(false);
                proformas.setVisible(false);
                pagos.setVisible(false);
                tratamientos.setVisible(true);

                PanelSistema.add(tratamientos);
                PanelSistema.validate();
                deshabilitar_Boton_Tratamientos();
                // Resto de tu código para el botón Tratamientos
            } catch (SQLException ex) {
                Logger.getLogger(F_Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.equals(btnCitas)) {

            try {
                pacientes.actualizarDatos_Paciente();
                tratamientos.actualizarTablaTratamientos();
                citas.actualizarTablaCitas();
                pagos.actualizarTablaPagos();
                proformas.actualizarTablaProformas();
                inicioMenu.actualizarTabla();

                inicioMenu.setVisible(false);

                pacientes.setVisible(false);
                tratamientos.setVisible(false);
                proformas.setVisible(false);
                pagos.setVisible(false);
                citas.setVisible(true);

                PanelSistema.add(citas);
                PanelSistema.validate();
                deshabilitar_Boton_Citas();
                // Resto de tu código para el botón Citas
            } catch (SQLException ex) {
                Logger.getLogger(F_Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.equals(btnPagos)) {

            try {
                pacientes.actualizarDatos_Paciente();
                tratamientos.actualizarTablaTratamientos();
                citas.actualizarTablaCitas();
                pagos.actualizarTablaPagos();
                proformas.actualizarTablaProformas();
                inicioMenu.actualizarTabla();

                inicioMenu.setVisible(false);

                citas.setVisible(false);
                pacientes.setVisible(false);
                tratamientos.setVisible(false);
                proformas.setVisible(false);
                pagos.setVisible(true);

                PanelSistema.add(pagos);
                PanelSistema.validate();
                deshabilitar_Boton_Pagos();
                // Resto de tu código para el botón Pagos
            } catch (SQLException ex) {
                Logger.getLogger(F_Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.equals(btnReportes)) {

            try {
                pacientes.actualizarDatos_Paciente();
                tratamientos.actualizarTablaTratamientos();
                citas.actualizarTablaCitas();
                pagos.actualizarTablaPagos();
                proformas.actualizarTablaProformas();
                inicioMenu.actualizarTabla();

                inicioMenu.setVisible(false);

                pacientes.setVisible(false);
                citas.setVisible(false);
                tratamientos.setVisible(false);
                pagos.setVisible(false);
                proformas.setVisible(true);

                PanelSistema.add(proformas);
                PanelSistema.validate();
                deshabilitar_Boton_Reportes();
                // Resto de tu código para el botón Reportes
            } catch (SQLException ex) {
                Logger.getLogger(F_Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.equals(btnMenuPrincipal)) {

            try {
                pacientes.actualizarDatos_Paciente();
                tratamientos.actualizarTablaTratamientos();
                citas.actualizarTablaCitas();
                pagos.actualizarTablaPagos();
                proformas.actualizarTablaProformas();
                inicioMenu.actualizarTabla();

                inicioMenu.setVisible(true);

                pacientes.setVisible(false);
                citas.setVisible(false);
                tratamientos.setVisible(false);
                pagos.setVisible(false);
                proformas.setVisible(false);
                PanelSistema.add(inicioMenu);
                PanelSistema.validate();
                deshabilitar_Boton_Menu();
            } catch (SQLException ex) {
                Logger.getLogger(F_Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelSistema = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCasa = new javax.swing.JLabel();
        btnPacientes = new javax.swing.JButton();
        btnTratamientos = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnMenuPrincipal = new javax.swing.JButton();
        lblPacientes = new javax.swing.JLabel();
        lblTratamientos = new javax.swing.JLabel();
        lblCitas = new javax.swing.JLabel();
        lblPagos = new javax.swing.JLabel();
        lblProforma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clínica Dental Calderón");
        setMinimumSize(new java.awt.Dimension(1655, 770));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSistema.setBackground(new java.awt.Color(255, 255, 255));
        PanelSistema.setMinimumSize(new java.awt.Dimension(1365, 770));
        PanelSistema.setPreferredSize(new java.awt.Dimension(1365, 770));
        PanelSistema.setLayout(new java.awt.BorderLayout());
        getContentPane().add(PanelSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1365, 770));

        jPanel2.setBackground(new java.awt.Color(62, 134, 203));
        jPanel2.setMinimumSize(new java.awt.Dimension(290, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(290, 450));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCasa.setMaximumSize(new java.awt.Dimension(32, 32));
        lblCasa.setMinimumSize(new java.awt.Dimension(32, 32));
        lblCasa.setPreferredSize(new java.awt.Dimension(32, 32));
        lblCasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCasaMouseClicked(evt);
            }
        });
        jPanel2.add(lblCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 50, 50));

        btnPacientes.setBackground(new java.awt.Color(60, 133, 203));
        btnPacientes.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnPacientes.setForeground(new java.awt.Color(255, 255, 255));
        btnPacientes.setText("PACIENTES");
        btnPacientes.setBorder(null);
        btnPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 200, 70));

        btnTratamientos.setBackground(new java.awt.Color(60, 133, 203));
        btnTratamientos.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnTratamientos.setForeground(new java.awt.Color(255, 255, 255));
        btnTratamientos.setText("TRATAMIENTOS");
        btnTratamientos.setBorder(null);
        btnTratamientos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTratamientosActionPerformed(evt);
            }
        });
        jPanel2.add(btnTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 200, 70));

        btnReportes.setBackground(new java.awt.Color(60, 133, 203));
        btnReportes.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("PROFORMA");
        btnReportes.setBorder(null);
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel2.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, 200, 70));

        btnPagos.setBackground(new java.awt.Color(60, 133, 203));
        btnPagos.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnPagos.setForeground(new java.awt.Color(255, 255, 255));
        btnPagos.setText("PAGOS");
        btnPagos.setBorder(null);
        btnPagos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });
        jPanel2.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 200, 70));

        btnCitas.setBackground(new java.awt.Color(60, 133, 203));
        btnCitas.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnCitas.setForeground(new java.awt.Color(255, 255, 255));
        btnCitas.setText("CITAS");
        btnCitas.setBorder(null);
        btnCitas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });
        jPanel2.add(btnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 200, 70));

        lblLogo.setText("jLabel2");
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 300));

        btnMenuPrincipal.setBackground(new java.awt.Color(60, 133, 203));
        btnMenuPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnMenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuPrincipal.setText("MENU PRINCIPAL");
        btnMenuPrincipal.setBorder(null);
        btnMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        jPanel2.add(btnMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 210, 70));

        lblPacientes.setText("jLabel3");
        jPanel2.add(lblPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 70, 70));

        lblTratamientos.setText("jLabel3");
        jPanel2.add(lblTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 50, 50));

        lblCitas.setText("jLabel3");
        jPanel2.add(lblCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 50));

        lblPagos.setText("jLabel3");
        jPanel2.add(lblPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 50, 50));

        lblProforma.setText("jLabel3");
        jPanel2.add(lblProforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed

    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTratamientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTratamientosActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed

    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void lblCasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCasaMouseClicked
        pacientes.setVisible(false);
        citas.setVisible(false);
        tratamientos.setVisible(false);
        proformas.setVisible(false);
        pagos.setVisible(false);
        inicioMenu.setVisible(true);
        PanelSistema.add(inicioMenu);
        //            pacientes.cerrarRecursos();
//            citas.cerrarRecursos();
//            tratamientos.cerrarRecursos();
//            pagos.cerrarRecursos();
//            proformas.cerrarRecursos();

        btnPacientes.setEnabled(true);
        btnTratamientos.setEnabled(true);
        btnCitas.setEnabled(true);
        btnPagos.setEnabled(true);
        btnReportes.setEnabled(true);
    }//GEN-LAST:event_lblCasaMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new F_Sistema().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSistema;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnTratamientos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCasa;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPacientes;
    private javax.swing.JLabel lblPagos;
    private javax.swing.JLabel lblProforma;
    private javax.swing.JLabel lblTratamientos;
    // End of variables declaration//GEN-END:variables

    public void deshabilitar_Boton_Pacientes() {
        if (pacientes.isVisible()) {
            btnPacientes.setEnabled(false);
            btnCitas.setEnabled(true);
            btnTratamientos.setEnabled(true);
            btnPagos.setEnabled(true);
            btnReportes.setEnabled(true);
            btnMenuPrincipal.setEnabled(true);

        } else if (!pacientes.isVisible()) {
            btnPacientes.setEnabled(true);
        }
    }

    public void deshabilitar_Boton_Citas() {
        if (citas.isVisible()) {
            btnCitas.setEnabled(false);
            btnPacientes.setEnabled(true);
            btnTratamientos.setEnabled(true);
            btnPagos.setEnabled(true);
            btnReportes.setEnabled(true);
            btnMenuPrincipal.setEnabled(true);

        } else if (!citas.isVisible()) {
            btnCitas.setEnabled(true);
        }
    }

    public void deshabilitar_Boton_Tratamientos() {
        if (tratamientos.isVisible()) {
            btnTratamientos.setEnabled(false);
            btnCitas.setEnabled(true);
            btnPacientes.setEnabled(true);
            btnPagos.setEnabled(true);
            btnMenuPrincipal.setEnabled(true);

            btnReportes.setEnabled(true);

        } else if (!tratamientos.isVisible()) {
            btnTratamientos.setEnabled(true);
        }
    }

    public void deshabilitar_Boton_Pagos() {
        if (pagos.isVisible()) {
            btnPacientes.setEnabled(true);
            btnCitas.setEnabled(true);
            btnTratamientos.setEnabled(true);
            btnReportes.setEnabled(true);
            btnMenuPrincipal.setEnabled(true);

            btnPagos.setEnabled(false);
        } else {
            btnPagos.setEnabled(true);
        }
    }

    public void deshabilitar_Boton_Reportes() {
        if (proformas.isVisible()) {
            btnPacientes.setEnabled(true);
            btnTratamientos.setEnabled(true);
            btnCitas.setEnabled(true);
            btnPagos.setEnabled(true);
            btnMenuPrincipal.setEnabled(true);
            btnReportes.setEnabled(false);
        } else if (!proformas.isVisible()) {
            btnReportes.setEnabled(true);
        }
    }

    public void deshabilitar_Boton_Menu() {
        if (inicioMenu.isVisible()) {
            btnPacientes.setEnabled(true);
            btnTratamientos.setEnabled(true);
            btnCitas.setEnabled(true);
            btnPagos.setEnabled(true);
            btnReportes.setEnabled(true);
            btnMenuPrincipal.setEnabled(false);
        } else if (!inicioMenu.isVisible()) {
            btnMenuPrincipal.setEnabled(true);
        }
    }

}
