package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.dtos.request.VendaRequestDTO;
import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.services.VendaService;
import com.mycompany.app.pdv.utils.TimeUtils;
import javax.swing.JOptionPane;

/**
 *
 * @author Antony
 */
public class JFrameFinalizarVenda extends javax.swing.JFrame {
    
    private VendaResponseDTO venda;
    private JframeVenda frameVenda;

    public JFrameFinalizarVenda(VendaResponseDTO venda, JframeVenda frameVenda) {
        this.venda = venda;
        this.frameVenda = frameVenda;
        initComponents();
        
        jFieldSubTotal.setText(Double.toString(venda.getValorTotal()));
        jFieldDescontoTotal.setText(Double.toString(venda.getDescontoTotal()));
        jFieldVlTotal.setText(Double.toString(venda.getValorTotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btFinalizarVenda = new javax.swing.JButton();
        btCancelarVenda = new javax.swing.JButton();
        jComboBoxMetodoPgmt = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFieldVlTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFieldSubTotal = new javax.swing.JTextField();
        jFieldDescontoTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(25, 35, 45));

        btFinalizarVenda.setBackground(new java.awt.Color(0, 102, 0));
        btFinalizarVenda.setForeground(new java.awt.Color(204, 204, 204));
        btFinalizarVenda.setText("Finalizar");
        btFinalizarVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        btFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarVendaActionPerformed(evt);
            }
        });

        btCancelarVenda.setBackground(new java.awt.Color(153, 0, 0));
        btCancelarVenda.setForeground(new java.awt.Color(204, 204, 204));
        btCancelarVenda.setText("Cancelar");
        btCancelarVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        btCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarVendaActionPerformed(evt);
            }
        });

        jComboBoxMetodoPgmt.setBackground(new java.awt.Color(40, 46, 56));
        jComboBoxMetodoPgmt.setForeground(new java.awt.Color(204, 204, 204));
        jComboBoxMetodoPgmt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito", "Dinheiro" }));
        jComboBoxMetodoPgmt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jComboBoxMetodoPgmt.setFocusable(false);
        jComboBoxMetodoPgmt.setRequestFocusEnabled(false);

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Método de pagamento:");

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Valor Total: R$");

        jFieldVlTotal.setBackground(new java.awt.Color(44, 49, 58));
        jFieldVlTotal.setForeground(new java.awt.Color(204, 204, 204));
        jFieldVlTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jFieldVlTotal.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Descontos: R$");

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("SubTotal: R$");

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("-------------------------------------");

        jFieldSubTotal.setBackground(new java.awt.Color(44, 49, 58));
        jFieldSubTotal.setForeground(new java.awt.Color(204, 204, 204));
        jFieldSubTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jFieldSubTotal.setEnabled(false);

        jFieldDescontoTotal.setBackground(new java.awt.Color(44, 49, 58));
        jFieldDescontoTotal.setForeground(new java.awt.Color(204, 204, 204));
        jFieldDescontoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jFieldDescontoTotal.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Finalizar Venda");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(133, 133, 133)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFieldVlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(15, 15, 15)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jFieldSubTotal)
                                        .addComponent(jFieldDescontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMetodoPgmt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(btFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxMetodoPgmt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFieldDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jFieldVlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarVendaActionPerformed
        VendaRequestDTO vendaRequest = VendaRequestDTO.toVendaRequestDTO(venda);
        VendaService vendaService = new VendaService();

        Object selectedItem = jComboBoxMetodoPgmt.getSelectedItem();
        vendaRequest.setObservacao(selectedItem != null ? selectedItem.toString() : "N/A");
        vendaRequest.setData(TimeUtils.getStringNow());

        vendaService.insertAsync(vendaRequest);

        this.frameVenda.limparVenda();
        dispose();
    }//GEN-LAST:event_btFinalizarVendaActionPerformed

    private void btCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarVendaActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarVendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelarVenda;
    private javax.swing.JButton btFinalizarVenda;
    private javax.swing.JComboBox<String> jComboBoxMetodoPgmt;
    private javax.swing.JTextField jFieldDescontoTotal;
    private javax.swing.JTextField jFieldSubTotal;
    private javax.swing.JTextField jFieldVlTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
