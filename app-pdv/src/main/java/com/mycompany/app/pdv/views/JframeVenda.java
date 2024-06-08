package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.dtos.request.VendaRequestDTO;
import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;
import com.mycompany.app.pdv.dtos.response.ItemVendaResponseDTO;
import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.services.VendaService;
import com.mycompany.app.pdv.tablemodels.ItemVendaTableModel;
import com.mycompany.app.pdvutils.GlobalVariables;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class JframeVenda extends javax.swing.JFrame {
    
    private VendaResponseDTO venda;
    private VendaService vendaService = new VendaService();
    
    public JframeVenda() {   
        initComponents();
        tableItens.fixTable(jScrollPane2);
        this.venda = new VendaResponseDTO();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Menu PDV");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btAddProdutos = new javax.swing.JButton();
        btSelecionarCliente = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        Divisor = new javax.swing.JPanel();
        jFieldCliente = new javax.swing.JTextField();
        btRemoverProduto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelSubtotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabelDescontos = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItens = new com.mycompany.app.pdv.views.components.TableDark();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemHistorico = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCategoria = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemProduto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel10.setBackground(new java.awt.Color(25, 35, 45));

        jPanel7.setForeground(new java.awt.Color(60, 63, 65));
        jPanel7.setToolTipText("");
        jPanel7.setOpaque(false);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAddProdutos.setBackground(new java.awt.Color(16, 48, 51));
        btAddProdutos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btAddProdutos.setForeground(new java.awt.Color(204, 204, 204));
        btAddProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/adicionar-sacola-de-compras (1).png"))); // NOI18N
        btAddProdutos.setText("Adicionar Produtos");
        btAddProdutos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(15, 45, 48), 2, true));
        btAddProdutos.setFocusable(false);
        btAddProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btAddProdutos.setIconTextGap(15);
        btAddProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProdutosActionPerformed(evt);
            }
        });

        btSelecionarCliente.setBackground(new java.awt.Color(16, 48, 51));
        btSelecionarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSelecionarCliente.setForeground(new java.awt.Color(204, 204, 204));
        btSelecionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Clientes.png"))); // NOI18N
        btSelecionarCliente.setText("Selecionar Cliente");
        btSelecionarCliente.setToolTipText("");
        btSelecionarCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(15, 45, 48), 2, true));
        btSelecionarCliente.setDefaultCapable(false);
        btSelecionarCliente.setFocusable(false);
        btSelecionarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btSelecionarCliente.setIconTextGap(5);
        btSelecionarCliente.setMargin(new java.awt.Insets(20, 14, 20, 14));
        btSelecionarCliente.setPreferredSize(new java.awt.Dimension(166, 35));
        btSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarClienteActionPerformed(evt);
            }
        });

        btNovo.setBackground(new java.awt.Color(24, 81, 53));
        btNovo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btNovo.setForeground(new java.awt.Color(204, 204, 204));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Novo.png"))); // NOI18N
        btNovo.setText("Novo (F9)");
        btNovo.setActionCommand("Novo");
        btNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 76, 50), 2, true));
        btNovo.setDefaultCapable(false);
        btNovo.setFocusable(false);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btNovo.setIconTextGap(5);
        btNovo.setPreferredSize(new java.awt.Dimension(265, 75));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btFinalizar.setBackground(new java.awt.Color(29, 65, 84));
        btFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btFinalizar.setForeground(new java.awt.Color(204, 204, 204));
        btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Checked.png"))); // NOI18N
        btFinalizar.setText("Finalizar (F8)");
        btFinalizar.setActionCommand("Finalizar");
        btFinalizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(27, 61, 79), 2, true));
        btFinalizar.setDefaultCapable(false);
        btFinalizar.setFocusable(false);
        btFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btFinalizar.setIconTextGap(5);
        btFinalizar.setPreferredSize(new java.awt.Dimension(265, 75));
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        Divisor.setBackground(new java.awt.Color(40, 46, 56));
        Divisor.setPreferredSize(new java.awt.Dimension(366, 2));

        javax.swing.GroupLayout DivisorLayout = new javax.swing.GroupLayout(Divisor);
        Divisor.setLayout(DivisorLayout);
        DivisorLayout.setHorizontalGroup(
            DivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DivisorLayout.setVerticalGroup(
            DivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jFieldCliente.setEditable(false);
        jFieldCliente.setBackground(new java.awt.Color(40, 46, 56));
        jFieldCliente.setForeground(new java.awt.Color(204, 204, 204));
        jFieldCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jFieldCliente.setMinimumSize(new java.awt.Dimension(64, 15));
        jFieldCliente.setPreferredSize(new java.awt.Dimension(64, 40));

        btRemoverProduto.setBackground(new java.awt.Color(81, 19, 19));
        btRemoverProduto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btRemoverProduto.setForeground(new java.awt.Color(204, 204, 204));
        btRemoverProduto.setText("Remover");
        btRemoverProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 17, 17), 2, true));
        btRemoverProduto.setFocusable(false);
        btRemoverProduto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btRemoverProduto.setIconTextGap(15);
        btRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFieldCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSelecionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(btRemoverProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(394, 394, 394)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(Divisor, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(btAddProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Divisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btSelecionarCliente.getAccessibleContext().setAccessibleName("Selecionar cliente");
        Divisor.getAccessibleContext().setAccessibleName("Divisor");
        Divisor.getAccessibleContext().setAccessibleDescription("Divisor");

        jPanel4.setOpaque(false);

        jPanel5.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(40, 46, 56));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(181, 60));

        jLabelSubtotal.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSubtotal.setForeground(new java.awt.Color(204, 204, 204));
        jLabelSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSubtotal.setText("0,00");
        jLabelSubtotal.setToolTipText("");

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("R$");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jLabelSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("SUBTOTAL");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
        );

        jPanel6.setOpaque(false);

        jPanel11.setBackground(new java.awt.Color(40, 46, 56));
        jPanel11.setForeground(new java.awt.Color(102, 102, 102));
        jPanel11.setPreferredSize(new java.awt.Dimension(181, 60));

        jLabelDescontos.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDescontos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDescontos.setForeground(new java.awt.Color(204, 204, 204));
        jLabelDescontos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDescontos.setText("0,00");
        jLabelDescontos.setToolTipText("");

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("R$");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jLabelDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDescontos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("DESCONTOS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel12.setBackground(new java.awt.Color(40, 46, 56));
        jPanel12.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(181, 60));

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Venda");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setBackground(new java.awt.Color(25, 35, 45));
        jScrollPane2.setForeground(new java.awt.Color(25, 35, 45));

        tableItens.setForeground(new java.awt.Color(25, 35, 45));
        tableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Teste", "123", "1", "23", "2222"}
            },
            new String [] {
                "Produto", "Valor Unit.", "Qtd.", "Desconto (%)", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItens.setFocusable(false);
        tableItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableItens);
        if (tableItens.getColumnModel().getColumnCount() > 0) {
            tableItens.getColumnModel().getColumn(0).setMinWidth(35);
            tableItens.getColumnModel().getColumn(0).setPreferredWidth(35);
            tableItens.getColumnModel().getColumn(1).setMinWidth(45);
            tableItens.getColumnModel().getColumn(1).setPreferredWidth(45);
            tableItens.getColumnModel().getColumn(2).setMinWidth(45);
            tableItens.getColumnModel().getColumn(2).setPreferredWidth(45);
            tableItens.getColumnModel().getColumn(3).setMinWidth(45);
            tableItens.getColumnModel().getColumn(3).setPreferredWidth(45);
            tableItens.getColumnModel().getColumn(4).setMinWidth(45);
            tableItens.getColumnModel().getColumn(4).setPreferredWidth(45);
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(22, 31, 40));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.setRequestFocusEnabled(false);

        jMenu4.setBackground(new java.awt.Color(0, 0, 0));
        jMenu4.setForeground(new java.awt.Color(204, 204, 204));
        jMenu4.setText("Historico");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(3, 16, 12, 16));

        jMenuItemHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItemHistorico.setBackground(new java.awt.Color(40, 46, 56));
        jMenuItemHistorico.setForeground(new java.awt.Color(204, 204, 204));
        jMenuItemHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Historico.png"))); // NOI18N
        jMenuItemHistorico.setText("Acessar Histórico");
        jMenuItemHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHistoricoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemHistorico);

        jMenuBar1.add(jMenu4);

        jMenu1.setBackground(new java.awt.Color(0, 0, 0));
        jMenu1.setForeground(new java.awt.Color(204, 204, 204));
        jMenu1.setText("Categorias");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(3, 16, 12, 16));

        jMenuItemCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemCategoria.setBackground(new java.awt.Color(40, 46, 56));
        jMenuItemCategoria.setForeground(new java.awt.Color(204, 204, 204));
        jMenuItemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Novo.png"))); // NOI18N
        jMenuItemCategoria.setText("Gerenciar Categorias");
        jMenuItemCategoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenu1.add(jMenuItemCategoria);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(0, 0, 0));
        jMenu2.setForeground(new java.awt.Color(204, 204, 204));
        jMenu2.setText("Produtos");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(3, 16, 12, 16));

        jMenuItemProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItemProduto.setBackground(new java.awt.Color(40, 46, 56));
        jMenuItemProduto.setForeground(new java.awt.Color(204, 204, 204));
        jMenuItemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/adicionar-sacola-de-compras (1).png"))); // NOI18N
        jMenuItemProduto.setText("Gerenciar Produtos");
        jMenu2.add(jMenuItemProduto);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(0, 0, 0));
        jMenu3.setForeground(new java.awt.Color(204, 204, 204));
        jMenu3.setText("Clientes");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(3, 16, 12, 16));

        jMenuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItemCliente.setBackground(new java.awt.Color(40, 46, 56));
        jMenuItemCliente.setForeground(new java.awt.Color(204, 204, 204));
        jMenuItemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Clientes.png"))); // NOI18N
        jMenuItemCliente.setText("Gerenciar Clientes");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemCliente);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        try {
            VendaRequestDTO requisicao = VendaRequestDTO.toVendaRequestDTO(this.venda);
            applyVenda(vendaService.doCalc(requisicao));
            
            JFrameFinalizarVenda frame = new JFrameFinalizarVenda(this.venda, this);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            removerFocoPricipal(frame);
            frame.setVisible(true);
        }
        catch(ApiException ex) {
            JOptionPane.showMessageDialog(null, "Venda incompleta! Faça os ajustes necessários antes de finaliza-la:\n\n" + ex.getMessage(), "Erro ao processar", JOptionPane.ERROR_MESSAGE);
        } 
        catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, "Tempo esgotado! Um erro ocorreu ao finalizar a venda, caso persista, tente novamente mais tarde:\n\n" + ex.getMessage(), "Erro ao processar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparVenda();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarClienteActionPerformed
        JFrameConsultaCliente frameClientes = new JFrameConsultaCliente(this);
        frameClientes.setResizable(false);
        frameClientes.setLocationRelativeTo(null);
        frameClientes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        removerFocoPricipal(frameClientes);
        frameClientes.setVisible(true);
    }//GEN-LAST:event_btSelecionarClienteActionPerformed

    private void btAddProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProdutosActionPerformed
        JFrameConsultaProduto frame = new JFrameConsultaProduto(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        removerFocoPricipal(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btAddProdutosActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void btRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRemoverProdutoActionPerformed

    private void jMenuItemHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistoricoActionPerformed
        JFrameConsultaVendas frame = new JFrameConsultaVendas();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        removerFocoPricipal(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItemHistoricoActionPerformed
    
    public void limparVenda() {
        this.venda = new VendaResponseDTO();
        
        ItemVendaTableModel model = new ItemVendaTableModel();
        tableItens.setModel(model);
        
        jLabelSubtotal.setText("0.0");
        jLabelDescontos.setText("0.0"); 
        
    }
    
    public void addNovoItemToTable(ItemVendaResponseDTO item) {
        try {
            VendaResponseDTO novaVenda = this.venda;
            novaVenda.getItensVenda().add(item);
            
            VendaRequestDTO requisicao = VendaRequestDTO.toVendaRequestDTO(novaVenda);
            applyVenda(vendaService.doCalc(requisicao));
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!", "Produto adicionado", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ApiException ex) {
            JOptionPane.showMessageDialog(this, "Um erro ocorreu no processo de venda:\n\n" + ex.getMessage(), "Erro ao processar", JOptionPane.ERROR_MESSAGE);
        } 
        catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, "Tempo esgotado! Tente novamente mais tarde.\n\n" + ex.getMessage(), "Erro ao processar", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void applyVenda(VendaResponseDTO venda) {
        this.venda = venda;
        
        //Cliente
        ClienteResponseDTO cliente = venda.getCliente();
        jFieldCliente.setText(cliente == null ? "" : cliente.getNome());
        
        //ItensVenda
        List<ItemVendaResponseDTO> itensVenda = venda.getItensVenda();
        ItemVendaTableModel model = new ItemVendaTableModel(itensVenda);
        tableItens.setModel(model);
        
        //Total
        double total = venda.getValorTotal();
        jLabelSubtotal.setText(Double.toString(total));
        
        //Descontos
        double descontos = venda.getValorTotal(); // atualizar dps
        jLabelDescontos.setText(Double.toString(descontos)); 
    }
    
    public VendaResponseDTO getVenda() {
        return venda;
    }

    public void setVenda(VendaResponseDTO venda) {
        this.venda = venda;
    }
    
    
    private void removerFocoPricipal(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                setEnabled(false); //desabilitar janela de venda
            }

            @Override
            public void windowClosed(WindowEvent e) {
                setEnabled(true); //habilitar janela de venda
                requestFocus(); //aplicar foco novamente
            }
        });
    }
    
    //Parar thread de requisições
    @Override
    public void dispose(){
        GlobalVariables.shutdownScheduler();
        super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Divisor;
    private javax.swing.JButton btAddProdutos;
    private javax.swing.JButton btFinalizar;
    public javax.swing.JButton btNovo;
    private javax.swing.JButton btRemoverProduto;
    private javax.swing.JButton btSelecionarCliente;
    private javax.swing.JTextField jFieldCliente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabelDescontos;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCategoria;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemHistorico;
    private javax.swing.JMenuItem jMenuItemProduto;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private com.mycompany.app.pdv.views.components.TableDark tableItens;
    // End of variables declaration//GEN-END:variables


}
