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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableClientes = new com.mycompany.app.pdv.views.components.TableDark();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void atualizarLista() throws InterruptedException, ApiException {
        List<ClienteDTO> listaClientes = clienteService.findAll(GlobalVariables.acessToken);
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
    private javax.swing.JScrollPane jScrollPane2;
    private com.mycompany.app.pdv.views.components.TableDark jTableClientes;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
