package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.dtos.ClienteDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.services.ClienteService;
import com.mycompany.app.pdv.tablemodels.ClienteTableModel;
import com.mycompany.app.pdvutils.GlobalVariables;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Antony
 */
public class JFrameConsultaCliente extends javax.swing.JFrame {

    private JframeVenda frameVenda;
    private List<ClienteDTO> clientes;
    private String tipoPessoa;
    private ClienteService clienteService = new ClienteService();
    
    public JFrameConsultaCliente(JframeVenda frameVenda, String tipoPessoa) {
        try {
            this.frameVenda = frameVenda;
            this.tipoPessoa = tipoPessoa;
            
            initComponents();
            jTableClientes.fixTable(jScrollPane2);
            
            atualizarLista();
            jTextFieldPesquisa.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    filtrarTabela(jTextFieldPesquisa.getText());
                }
                
                @Override
                public void removeUpdate(DocumentEvent e) {
                    filtrarTabela(jTextFieldPesquisa.getText());
                }
                
                @Override
                public void changedUpdate(DocumentEvent e) {
                    filtrarTabela(jTextFieldPesquisa.getText());
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar clientes: \n\n"+ ex.getMessage(), "Clientes", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableClientes = new com.mycompany.app.pdv.views.components.TableDark();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(null);

        jPanel2.setBackground(new java.awt.Color(25, 35, 45));

        jScrollPane2.setBackground(new java.awt.Color(25, 35, 45));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setForeground(new java.awt.Color(25, 35, 45));

        jTableClientes.setForeground(new java.awt.Color(204, 204, 204));
        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableClientes);

        jTextFieldPesquisa.setBackground(new java.awt.Color(40, 46, 56));
        jTextFieldPesquisa.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));

        jButtonSelecionar.setBackground(new java.awt.Color(40, 46, 56));
        jButtonSelecionar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(40, 46, 56));
        jButtonCancelar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        int selectedRow = jTableClientes.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) jTableClientes.getValueAt(selectedRow, 0));
            for (ClienteDTO cliente : this.clientes) {
                if (cliente.getId() == id) {

                    if(this.tipoPessoa.equals("C")) {
                        this.frameVenda.setCliente(cliente);
                    }
                }
            }
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecione algum cliente/vendedor!", "Erro ao continuar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    private void atualizarLista() {
        List<ClienteDTO> listaClientes = GlobalVariables.clientes;/*clienteService.findAll(GlobalVariables.acessToken);*/
        this.clientes = listaClientes;
        
         ClienteTableModel model = 
                new ClienteTableModel(listaClientes);
        
        jTableClientes.setModel(model);
        
    }
    
    private void filtrarTabela(String termoPesquisa) {
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableClientes.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + termoPesquisa);
        sorter.setRowFilter(rowFilter);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.mycompany.app.pdv.views.components.TableDark jTableClientes;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
