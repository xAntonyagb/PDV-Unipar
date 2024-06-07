package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.dtos.ItemVendaDTO;
import com.mycompany.app.pdv.dtos.ProdutoDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.services.ProdutoService;
import com.mycompany.app.pdv.tablemodels.ProdutoTableModel;
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
public class JFrameConsultaProduto extends javax.swing.JFrame {

    private ItemVendaDTO itemVenda;
    private List<ProdutoDTO> produtos;
    private JframeVenda frameVenda;
    
    public JFrameConsultaProduto(JframeVenda frameVenda) {
        this.frameVenda = frameVenda;
        initComponents();
        jTableProdutos.fixTable(jScrollPane2);
        
        try {
            atualizarLista();
        
        jTextFieldPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabela(jTextFieldPesquisa.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) { }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabela(jTextFieldPesquisa.getText());
            }
        });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar produtos: \n\n"+ ex.getMessage(), "Produtos", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            return;
        } 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableProdutos = new com.mycompany.app.pdv.views.components.TableDark();
        jPanel1 = new javax.swing.JPanel();
        jLabelInfo = new javax.swing.JLabel();
        jLabelQtd = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jLabelDesconto = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneVlUnit = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneVlSubtotal = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPaneDSProduto = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPaneVlTotal = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 35, 45));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(25, 35, 45));
        jTabbedPane1.setForeground(new java.awt.Color(25, 35, 45));

        jPanel2.setBackground(new java.awt.Color(25, 35, 45));
        jPanel2.setForeground(new java.awt.Color(25, 35, 45));
        jPanel2.setPreferredSize(new java.awt.Dimension(550, 393));

        jTextFieldPesquisa.setBackground(new java.awt.Color(40, 46, 56));
        jTextFieldPesquisa.setForeground(new java.awt.Color(204, 204, 204));

        jButtonSelecionar.setBackground(new java.awt.Color(40, 46, 56));
        jButtonSelecionar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(40, 46, 56));
        jButtonCancelar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonCancelar.setText("Voltar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTableProdutos.setForeground(new java.awt.Color(204, 204, 204));
        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTableProdutos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisa)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel1.setBackground(new java.awt.Color(25, 35, 45));
        jPanel1.setForeground(new java.awt.Color(25, 35, 45));

        jLabelInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(204, 204, 204));
        jLabelInfo.setText("Produto");

        jLabelQtd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelQtd.setForeground(new java.awt.Color(204, 204, 204));
        jLabelQtd.setLabelFor(jTextFieldQtd);
        jLabelQtd.setText("Qtd:");

        jTextFieldQtd.setBackground(new java.awt.Color(40, 46, 56));
        jTextFieldQtd.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldQtdKeyReleased(evt);
            }
        });

        jLabelDesconto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDesconto.setForeground(new java.awt.Color(204, 204, 204));
        jLabelDesconto.setLabelFor(jTextFieldDesconto);
        jLabelDesconto.setText("Desconto (%):");

        jTextFieldDesconto.setBackground(new java.awt.Color(40, 46, 56));
        jTextFieldDesconto.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDescontoKeyReleased(evt);
            }
        });

        btVoltar.setBackground(new java.awt.Color(40, 46, 56));
        btVoltar.setForeground(new java.awt.Color(204, 204, 204));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btConfirmar.setBackground(new java.awt.Color(40, 46, 56));
        btConfirmar.setForeground(new java.awt.Color(204, 204, 204));
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setLabelFor(jTextPaneVlUnit);
        jLabel1.setText("Vl. Unit.");

        jTextPaneVlUnit.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneVlUnit.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneVlUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPaneVlUnitKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextPaneVlUnit);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setLabelFor(jTextPaneVlSubtotal);
        jLabel2.setText("Vl. SubTotal");

        jTextPaneVlSubtotal.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneVlSubtotal.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneVlSubtotal.setEnabled(false);
        jTextPaneVlSubtotal.setPreferredSize(new java.awt.Dimension(64, 20));
        jScrollPane3.setViewportView(jTextPaneVlSubtotal);

        jTextPaneDSProduto.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneDSProduto.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneDSProduto.setEnabled(false);
        jScrollPane4.setViewportView(jTextPaneDSProduto);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setLabelFor(jTextPaneVlTotal);
        jLabel3.setText("Vl. Total");

        jTextPaneVlTotal.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneVlTotal.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneVlTotal.setEnabled(false);
        jTextPaneVlTotal.setPreferredSize(new java.awt.Dimension(64, 20));
        jScrollPane5.setViewportView(jTextPaneVlTotal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelQtd)
                                            .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(8, 8, 8))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelQtd)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );

        jTabbedPane1.addTab("tab2", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        int selectedRow = jTableProdutos.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) jTableProdutos.getValueAt(selectedRow, 0));
            for (ProdutoDTO produto : this.produtos) {
                if (produto.getId() == id) {
                    this.itemVenda = new ItemVendaDTO();
                    this.itemVenda.setProduto(produto);
                    
                    jTextPaneDSProduto.setText(produto.getDescricao());
                    jTextPaneVlUnit.setText(Double.toString(produto.getValorUnitario()));
                    
                    jTextFieldQtd.setText("1");
                    jTextFieldDesconto.setText("0");
                    atualizarCampos();
                    
                    jTabbedPane1.setSelectedIndex(1);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecione algum produto", "Erro ao continuar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        try {
            this.frameVenda.addNovoItemToTable(itemVenda);
            
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!", "Produto adicionado", JOptionPane.INFORMATION_MESSAGE);
            jTabbedPane1.setSelectedIndex(0);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Input inválido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescontoKeyReleased
        atualizarCampos();
    }//GEN-LAST:event_jTextFieldDescontoKeyReleased

    private void jTextFieldQtdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQtdKeyReleased
        atualizarCampos();
    }//GEN-LAST:event_jTextFieldQtdKeyReleased

    private void jTextPaneVlUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPaneVlUnitKeyReleased
        atualizarCampos();
    }//GEN-LAST:event_jTextPaneVlUnitKeyReleased

    private void filtrarTabela(String termoPesquisa) {
        DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableProdutos.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + termoPesquisa);
        sorter.setRowFilter(rowFilter);
    }
    
    private void atualizarLista() throws ApiException, InterruptedException {
        ProdutoService produtoService = new ProdutoService();
        
        List<ProdutoDTO> listaProdutos = produtoService.findAll(GlobalVariables.acessToken);
        this.produtos = listaProdutos;
        
        ProdutoTableModel model = 
               new ProdutoTableModel(listaProdutos);
        
        jTableProdutos.setModel(model);
    }
    
    private void atualizarCampos() {
        String descontoText = jTextFieldDesconto.getText();
        String qtdText = jTextFieldQtd.getText();
        String vlUnitText = jTextPaneVlUnit.getText();

        try {
            int qtd = Integer.parseInt(qtdText);
            double vlUnit = Double.parseDouble(vlUnitText);
            double desconto = Double.parseDouble(descontoText);
            double subtotal = qtd * vlUnit;
            double total = Math.round(subtotal - (subtotal * (desconto / 100)));
            
            jTextPaneVlSubtotal.setText(Double.toString(subtotal));
            jTextPaneVlTotal.setText(Double.toString(total));
            this.itemVenda.setDescontoProduto(desconto);
            this.itemVenda.setQuantidade(qtd);
            this.itemVenda.setValorTotal(total);
            this.itemVenda.setValorUnitario(vlUnit);
        } 
        catch (NumberFormatException ex) {
            System.out.println("Erro ao transformar números");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Input inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDesconto;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelQtd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.mycompany.app.pdv.views.components.TableDark jTableProdutos;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JTextPane jTextPaneDSProduto;
    private javax.swing.JTextPane jTextPaneVlSubtotal;
    private javax.swing.JTextPane jTextPaneVlTotal;
    private javax.swing.JTextPane jTextPaneVlUnit;
    // End of variables declaration//GEN-END:variables
}
