/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author 181710038
 */
public class TelaSecretraria extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaSecretraria
     */
    public TelaSecretraria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        MenuPacientes = new javax.swing.JMenu();
        PCadastro = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        PListar = new javax.swing.JMenuItem();
        MenuMedicos = new javax.swing.JMenu();
        MListar = new javax.swing.JMenuItem();
        MenuConsultas = new javax.swing.JMenu();
        CAgendar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        CListar = new javax.swing.JMenuItem();

        setTitle("Secretaria");

        MenuPacientes.setText("Pacientes");

        PCadastro.setText("Cadastro");
        MenuPacientes.add(PCadastro);
        MenuPacientes.add(jSeparator1);

        PListar.setText("Listar");
        MenuPacientes.add(PListar);

        jMenuBar1.add(MenuPacientes);

        MenuMedicos.setText("Médicos");

        MListar.setText("Listar ");
        MenuMedicos.add(MListar);

        jMenuBar1.add(MenuMedicos);

        MenuConsultas.setText("Consultas");

        CAgendar.setText("Agendar");
        MenuConsultas.add(CAgendar);
        MenuConsultas.add(jSeparator2);

        CListar.setText("Listar");
        MenuConsultas.add(CListar);

        jMenuBar1.add(MenuConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CAgendar;
    private javax.swing.JMenuItem CListar;
    private javax.swing.JMenuItem MListar;
    private javax.swing.JMenu MenuConsultas;
    private javax.swing.JMenu MenuMedicos;
    private javax.swing.JMenu MenuPacientes;
    private javax.swing.JMenuItem PCadastro;
    private javax.swing.JMenuItem PListar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
