/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 181710068
 */
public class TelaMedico extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaMedico
     */
    public TelaMedico() {
        initComponents();
    }
    
    private void carregarTabela(){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = { "Código" , "Nome", "" };
        modelo.setColumnIdentifiers( colunas );
        List<ObjPaciente> lista = PacienteDAO.getCidades();
        
        for( ObjPaciente pac : lista ){
            Object[] obj = { pac.getCodigo(), pac.getNome() };
            modelo.addRow( obj );
        }
        tablePacientes.setModel( modelo );
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        btnCadastro = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnConsultas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();

        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablePacientes);

        btnCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastro.setText("Ver Cadastro");

        btnSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSair.setText("Sair");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Pacientes");

        btnConsultas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultas.setText("Consultas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Médico:");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNome.setText("Labél");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnConsultas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastro)
                                .addGap(28, 28, 28)
                                .addComponent(btnSair)))
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnCadastro)
                    .addComponent(btnConsultas)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tablePacientes;
    // End of variables declaration//GEN-END:variables
}