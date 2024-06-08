package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.dtos.request.ItemVendaRequestDTO;
import com.mycompany.app.pdv.dtos.response.ItemVendaResponseDTO;
import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;
import com.mycompany.app.pdv.services.ProdutoService;
import com.mycompany.app.pdv.tablemodels.ProdutoTableModel;
import com.mycompany.app.pdv.utils.PDVUtils;
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

    private ItemVendaResponseDTO itemVenda;
    private JframeVenda frameVenda;
    
    
    public JFrameConsultaProduto(JframeVenda frameVenda) {
        this.frameVenda = frameVenda;
        initComponents();
        jTableProdutos.fixTable(jScrollPane6);
        
        try {
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
        jTextPaneVlSubtotal = new javax.swing.JTextField();
        jLabelDesconto = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextPaneVlTotal = new javax.swing.JTextField();
        jTextFieldQtd2 = new javax.swing.JTextField();
        jTextPaneVlUnit = new javax.swing.JTextField();
        jTextFieldDesconto = new javax.swing.JTextField();
        jTextPaneDSProduto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 35, 45));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(25, 35, 45));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setForeground(new java.awt.Color(25, 35, 45));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel2.setBackground(new java.awt.Color(25, 35, 45));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setForeground(new java.awt.Color(25, 35, 45));
        jPanel2.setPreferredSize(new java.awt.Dimension(550, 393));

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
        jButtonCancelar.setText("Voltar");
        jButtonCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jScrollPane6.setBackground(new java.awt.Color(25, 35, 45));
        jScrollPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane6.setForeground(new java.awt.Color(25, 35, 45));

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
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel1.setBackground(new java.awt.Color(25, 35, 45));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setForeground(new java.awt.Color(25, 35, 45));

        jLabelInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(204, 204, 204));
        jLabelInfo.setText("Produto");

        jLabelQtd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelQtd.setForeground(new java.awt.Color(204, 204, 204));
        jLabelQtd.setLabelFor(jTextPaneVlSubtotal);
        jLabelQtd.setText("Qtd:");

        jTextPaneVlSubtotal.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneVlSubtotal.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneVlSubtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jTextPaneVlSubtotal.setEnabled(false);

        jLabelDesconto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDesconto.setForeground(new java.awt.Color(204, 204, 204));
        jLabelDesconto.setLabelFor(jTextFieldDesconto);
        jLabelDesconto.setText("Desconto (%):");

        btVoltar.setBackground(new java.awt.Color(40, 46, 56));
        btVoltar.setForeground(new java.awt.Color(204, 204, 204));
        btVoltar.setText("Voltar");
        btVoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btConfirmar.setBackground(new java.awt.Color(40, 46, 56));
        btConfirmar.setForeground(new java.awt.Color(204, 204, 204));
        btConfirmar.setText("Confirmar");
        btConfirmar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setLabelFor(jTextPaneVlUnit);
        jLabel1.setText("Vl. Unit.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setLabelFor(jTextPaneVlSubtotal);
        jLabel2.setText("Vl. SubTotal");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setLabelFor(jTextPaneVlTotal);
        jLabel3.setText("Vl. Total");

        jTextPaneVlTotal.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneVlTotal.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneVlTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jTextPaneVlTotal.setEnabled(false);

        jTextFieldQtd2.setBackground(new java.awt.Color(40, 46, 56));
        jTextFieldQtd2.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldQtd2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));

        jTextPaneVlUnit.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneVlUnit.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneVlUnit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));

        jTextFieldDesconto.setBackground(new java.awt.Color(40, 46, 56));
        jTextFieldDesconto.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldDesconto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));

        jTextPaneDSProduto.setBackground(new java.awt.Color(40, 46, 56));
        jTextPaneDSProduto.setForeground(new java.awt.Color(204, 204, 204));
        jTextPaneDSProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPaneDSProduto)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextPaneVlUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelQtd)
                                    .addComponent(jTextFieldQtd2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextPaneVlSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(13, 13, 13))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextPaneVlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextPaneDSProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDesconto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelQtd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldQtd2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextPaneVlUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(88, 88, 88))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextPaneVlSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextPaneVlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("tab2", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 550, 450));

        jPanel3.setBackground(new java.awt.Color(25, 35, 45));
        jPanel3.setForeground(new java.awt.Color(25, 35, 45));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        int selectedRow = jTableProdutos.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) jTableProdutos.getValueAt(selectedRow, 0));
            for (ProdutoResponseDTO produto : PDVUtils.produtos) {
                if (produto.getId() == id) {
                    this.itemVenda = new ItemVendaResponseDTO();
                    this.itemVenda.setProduto(produto);
                    
                    jTextPaneDSProduto.setText(produto.getDescricao());
                    jTextPaneVlUnit.setText(Double.toString(produto.getValor()));
                    
                    jTextPaneVlSubtotal.setText("0");
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
            this.itemVenda.setQuantidade(Integer.parseInt(jTextFieldQtd2.getText()));
            this.itemVenda.setDesconto(Double.parseDouble(jTextFieldDesconto.getText()));

            this.frameVenda.addNovoItemToTable(
                    ItemVendaRequestDTO.toRequestDTO(itemVenda)
            );

            jTabbedPane1.setSelectedIndex(0);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Dados informados de forma inádequada! Porfavor informe números", "Erro ao continuar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void filtrarTabela(String termoPesquisa) {
        DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableProdutos.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + termoPesquisa);
        sorter.setRowFilter(rowFilter);
    }
    
    private void atualizarLista(){
        ProdutoService produtoService = new ProdutoService();
        
        List<ProdutoResponseDTO> listaProdutos = PDVUtils.produtos;
        
        ProdutoTableModel model = 
               new ProdutoTableModel(listaProdutos);
        
        jTableProdutos.setModel(model);
    }
    
    private void atualizarCampos() {
        String descontoText = jTextFieldDesconto.getText();
        String qtdText = jTextPaneVlSubtotal.getText();
        String vlUnitText = jTextPaneVlUnit.getText();

        try {
            int qtd = Integer.parseInt(qtdText);
            double vlUnit = Double.parseDouble(vlUnitText);
            double desconto = Double.parseDouble(descontoText);
            double subtotal = qtd * vlUnit;
            double total = Math.round(subtotal - (subtotal * (desconto / 100)));
            
            jTextPaneVlSubtotal.setText(Double.toString(subtotal));
            jTextPaneVlTotal.setText(Double.toString(total));
//            this.itemVenda.setDescontoProduto(desconto);
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.mycompany.app.pdv.views.components.TableDark jTableProdutos;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldQtd2;
    private javax.swing.JTextField jTextPaneDSProduto;
    private javax.swing.JTextField jTextPaneVlSubtotal;
    private javax.swing.JTextField jTextPaneVlTotal;
    private javax.swing.JTextField jTextPaneVlUnit;
    // End of variables declaration//GEN-END:variables
}
