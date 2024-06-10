package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.dtos.request.ItemVendaRequestDTO;
import com.mycompany.app.pdv.dtos.request.VendaRequestDTO;
import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;
import com.mycompany.app.pdv.dtos.response.ItemVendaResponseDTO;
import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.services.ClienteService;
import com.mycompany.app.pdv.services.VendaService;
import com.mycompany.app.pdv.tablemodels.ItemVendaTableModel;
import com.mycompany.app.pdv.utils.PDVUtils;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.mycompany.app.pdv.views.JFrameConsultaVendas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
        aplicarFocoPrincipal();
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                executaKeyListener(evt);
            }
        });
        
        btSelecionarCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                executaKeyListener(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Principal = new javax.swing.JPanel();
        Direita = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btAddProdutos = new javax.swing.JButton();
        btSelecionarCliente = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        Divisor = new javax.swing.JPanel();
        jFieldCliente = new javax.swing.JTextField();
        btRemoverProduto = new javax.swing.JButton();
        Rodapé = new javax.swing.JPanel();
        Total = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Descontos = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabelDescontos = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Subtotal = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabelSubtotal = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Subtotal1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabelDescontos3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItens = new com.mycompany.app.pdv.views.components.TableDark();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemHistorico = new javax.swing.JMenuItem();

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

        Principal.setBackground(new java.awt.Color(25, 35, 45));

        Direita.setForeground(new java.awt.Color(60, 63, 65));
        Direita.setToolTipText("");
        Direita.setOpaque(false);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAddProdutos.setBackground(new java.awt.Color(16, 48, 51));
        btAddProdutos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btAddProdutos.setForeground(new java.awt.Color(204, 204, 204));
        btAddProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/adicionar-sacola-de-compras (1).png"))); // NOI18N
        btAddProdutos.setText("Adicionar Produtos (T)");
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
        btSelecionarCliente.setText("Selecionar Cliente (Espaço)");
        btSelecionarCliente.setToolTipText("");
        btSelecionarCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(15, 45, 48), 2, true));
        btSelecionarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btSelecionarCliente.setIconTextGap(5);
        btSelecionarCliente.setMargin(new java.awt.Insets(20, 14, 20, 14));
        btSelecionarCliente.setPreferredSize(new java.awt.Dimension(166, 35));
        btSelecionarCliente.setRequestFocusEnabled(false);
        btSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarClienteActionPerformed(evt);
            }
        });

        btNovo.setBackground(new java.awt.Color(24, 81, 53));
        btNovo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btNovo.setForeground(new java.awt.Color(204, 204, 204));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Novo.png"))); // NOI18N
        btNovo.setText("Novo (F5)");
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
        btFinalizar.setText("Finalizar (Enter)");
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
        jFieldCliente.setBackground(new java.awt.Color(44, 49, 58));
        jFieldCliente.setForeground(new java.awt.Color(204, 204, 204));
        jFieldCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 46, 56)));
        jFieldCliente.setEnabled(false);
        jFieldCliente.setMinimumSize(new java.awt.Dimension(64, 15));
        jFieldCliente.setPreferredSize(new java.awt.Dimension(64, 40));

        btRemoverProduto.setBackground(new java.awt.Color(81, 19, 19));
        btRemoverProduto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btRemoverProduto.setForeground(new java.awt.Color(204, 204, 204));
        btRemoverProduto.setText("Remover (Delete)");
        btRemoverProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 17, 17), 2, true));
        btRemoverProduto.setFocusable(false);
        btRemoverProduto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btRemoverProduto.setIconTextGap(15);
        btRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFieldCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSelecionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(btRemoverProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(394, 394, 394)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(Divisor, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(btAddProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Divisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btSelecionarCliente.getAccessibleContext().setAccessibleName("Selecionar cliente");
        Divisor.getAccessibleContext().setAccessibleName("Divisor");
        Divisor.getAccessibleContext().setAccessibleDescription("Divisor");

        Rodapé.setOpaque(false);

        Total.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(40, 46, 56));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(181, 60));

        jLabelTotal.setBackground(new java.awt.Color(204, 204, 204));
        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTotal.setText("0,00");
        jLabelTotal.setToolTipText("");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("TOTAL");

        javax.swing.GroupLayout TotalLayout = new javax.swing.GroupLayout(Total);
        Total.setLayout(TotalLayout);
        TotalLayout.setHorizontalGroup(
            TotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(TotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
        );
        TotalLayout.setVerticalGroup(
            TotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Descontos.setOpaque(false);

        jPanel5.setBackground(new java.awt.Color(40, 46, 56));
        jPanel5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel5.setPreferredSize(new java.awt.Dimension(181, 60));

        jLabelDescontos.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDescontos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDescontos.setForeground(new java.awt.Color(204, 204, 204));
        jLabelDescontos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDescontos.setText("0,00");
        jLabelDescontos.setToolTipText("");

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("R$");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabelDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDescontos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("DESCONTOS");

        javax.swing.GroupLayout DescontosLayout = new javax.swing.GroupLayout(Descontos);
        Descontos.setLayout(DescontosLayout);
        DescontosLayout.setHorizontalGroup(
            DescontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DescontosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(DescontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
        );
        DescontosLayout.setVerticalGroup(
            DescontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DescontosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Subtotal.setOpaque(false);

        jPanel6.setBackground(new java.awt.Color(40, 46, 56));
        jPanel6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel6.setPreferredSize(new java.awt.Dimension(181, 60));

        jLabelSubtotal.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSubtotal.setForeground(new java.awt.Color(204, 204, 204));
        jLabelSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSubtotal.setText("0,00");
        jLabelSubtotal.setToolTipText("");

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("R$");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabelSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("SUBTOTAL");

        javax.swing.GroupLayout SubtotalLayout = new javax.swing.GroupLayout(Subtotal);
        Subtotal.setLayout(SubtotalLayout);
        SubtotalLayout.setHorizontalGroup(
            SubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubtotalLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(SubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
        );
        SubtotalLayout.setVerticalGroup(
            SubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubtotalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Subtotal1.setOpaque(false);

        jPanel7.setBackground(new java.awt.Color(40, 46, 56));
        jPanel7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel7.setPreferredSize(new java.awt.Dimension(181, 60));

        jLabelDescontos3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDescontos3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDescontos3.setForeground(new java.awt.Color(204, 204, 204));
        jLabelDescontos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescontos3.setText("VENDA");
        jLabelDescontos3.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDescontos3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDescontos3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Subtotal1Layout = new javax.swing.GroupLayout(Subtotal1);
        Subtotal1.setLayout(Subtotal1Layout);
        Subtotal1Layout.setHorizontalGroup(
            Subtotal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Subtotal1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
        );
        Subtotal1Layout.setVerticalGroup(
            Subtotal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Subtotal1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout RodapéLayout = new javax.swing.GroupLayout(Rodapé);
        Rodapé.setLayout(RodapéLayout);
        RodapéLayout.setHorizontalGroup(
            RodapéLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RodapéLayout.createSequentialGroup()
                .addComponent(Subtotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Descontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        RodapéLayout.setVerticalGroup(
            RodapéLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(RodapéLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(RodapéLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Subtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Descontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setBackground(new java.awt.Color(25, 35, 45));
        jScrollPane2.setForeground(new java.awt.Color(25, 35, 45));

        tableItens.setForeground(new java.awt.Color(25, 35, 45));
        tableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor Unit.", "Qtd.", "Subtotal", "Desconto (R$)", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItens.setFocusable(false);
        tableItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableItens);
        if (tableItens.getColumnModel().getColumnCount() > 0) {
            tableItens.getColumnModel().getColumn(0).setResizable(false);
            tableItens.getColumnModel().getColumn(0).setPreferredWidth(35);
            tableItens.getColumnModel().getColumn(1).setResizable(false);
            tableItens.getColumnModel().getColumn(1).setPreferredWidth(45);
            tableItens.getColumnModel().getColumn(2).setResizable(false);
            tableItens.getColumnModel().getColumn(2).setPreferredWidth(45);
            tableItens.getColumnModel().getColumn(3).setResizable(false);
            tableItens.getColumnModel().getColumn(4).setResizable(false);
            tableItens.getColumnModel().getColumn(4).setPreferredWidth(45);
            tableItens.getColumnModel().getColumn(5).setResizable(false);
            tableItens.getColumnModel().getColumn(5).setPreferredWidth(45);
        }

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rodapé, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rodapé, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jMenuItemHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void executaKeyListener(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                finalizarVenda();
                break;
            case KeyEvent.VK_F5:
                limparVenda();
                break;
            case KeyEvent.VK_SPACE:
                addCliente();
                break;
            case KeyEvent.VK_T:
                addProduto();
                break;
            case KeyEvent.VK_DELETE:
                removerProduto();
                break;
        }
    }
    
    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        finalizarVenda();
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparVenda();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarClienteActionPerformed
        addCliente();
    }//GEN-LAST:event_btSelecionarClienteActionPerformed

    private void btAddProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProdutosActionPerformed
        addProduto();
    }//GEN-LAST:event_btAddProdutosActionPerformed

    private void btRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverProdutoActionPerformed
        removerProduto();
    }//GEN-LAST:event_btRemoverProdutoActionPerformed

    private void jMenuItemHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistoricoActionPerformed
        JFrameConsultaVendas frame = new JFrameConsultaVendas();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        removerFocoPricipal(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItemHistoricoActionPerformed
    
    public VendaResponseDTO getVenda() {
        return venda;
    }

    public void setVenda(VendaResponseDTO venda) {
        this.venda = venda;
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
        
        // Arredondar
        DecimalFormat df = new DecimalFormat("#.###");

        // Subtotal
        double valorSubtotal = venda.getValorSubtotal();
        String subtotal = df.format(valorSubtotal);
        jLabelSubtotal.setText(subtotal);

        // Total
        double valorTotal = venda.getValorTotal();
        String total = df.format(valorTotal);
        jLabelTotal.setText(total);

        // Descontos
        double descontoTotal = venda.getDescontoTotal();
        String descontos = df.format(descontoTotal);
        jLabelDescontos.setText(descontos);
    }
    
    public void limparVenda() {
        this.venda = new VendaResponseDTO();
        
        ItemVendaTableModel model = new ItemVendaTableModel();
        tableItens.setModel(model);
        
        jLabelTotal.setText("0.0");
        jLabelSubtotal.setText("0.0");
        jLabelDescontos.setText("0.0"); 
        jFieldCliente.setText(""); 
        
    }
    
    public void addNovoItemToTable(ItemVendaRequestDTO item) {
        try {
            VendaRequestDTO requisicao = VendaRequestDTO.toVendaRequestDTO(this.venda);
            
            List<ItemVendaRequestDTO> itensVenda = new ArrayList<>();
            itensVenda.addAll(requisicao.getItensVenda());
            itensVenda.add(item);
            
            requisicao.setItensVenda(itensVenda);
            applyVenda(vendaService.doCalc(requisicao));

            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!", "Produto adicionado", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ApiException ex) {
            JOptionPane.showMessageDialog(this, "Um erro ocorreu no processo de venda:\n" + ex.getMessage(), "Erro ao processar", JOptionPane.ERROR_MESSAGE);
        } 
        catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() + "\nTempo esgotado! Tente novamente mais tarde.", "Erro ao processar", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void removerItemTable(int index) {
        try {
            String nomeProd = this.venda.getItensVenda().get(index).getProduto().getDescricao();
            VendaRequestDTO requisicao = VendaRequestDTO.toVendaRequestDTO(this.venda);

            List<ItemVendaRequestDTO> itensVenda = new ArrayList<>();
            itensVenda.addAll(requisicao.getItensVenda());
            itensVenda.remove(index);

            requisicao.setItensVenda(itensVenda);
            applyVenda(vendaService.doCalc(requisicao));
            
            
            JOptionPane.showMessageDialog(null, "Item removido com sucesso:\n" + nomeProd, "Remover item", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ApiException ex) {
            JOptionPane.showMessageDialog(this, "Um erro ocorreu ao remover esse item da venda:\n" + ex.getMessage(), "Erro ao remover", JOptionPane.ERROR_MESSAGE);
        } 
        catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() + "\nTempo esgotado! Tente novamente mais tarde.", "Erro ao remover", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCliente() {
        JFrameConsultaCliente frameClientes = new JFrameConsultaCliente(this);
        frameClientes.setResizable(false);
        frameClientes.setLocationRelativeTo(null);
        frameClientes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        removerFocoPricipal(frameClientes);
        frameClientes.setVisible(true);
    }
    
    private void addProduto() {
        // Verificar cliente
        try {
            ClienteService clienteService = new ClienteService();
            ClienteResponseDTO consulta = clienteService.findById(this.venda.getCliente().getId());
            this.venda.setCliente(consulta);
        } catch (ApiException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\nPorfavor selecione um cliente! Faça os ajustes necessários antes de continuar.", "Erro ao presseguir", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() + "\nTempo esgotado! Um erro ocorreu ao continuar selecionando produtos, caso persista, tente novamente mais tarde.", "Erro ao processar", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JFrameConsultaProduto frame = new JFrameConsultaProduto(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        removerFocoPricipal(frame);
        frame.setVisible(true);
    }
    
    private void removerProduto() {
        int selectedRow = tableItens.getSelectedRow();

        if (selectedRow != -1) {
            String nome = (String) tableItens.getValueAt(selectedRow, 0);
            for (int i = 0; i < this.venda.getItensVenda().size(); i++) {
                if(nome.equalsIgnoreCase(this.venda.getItensVenda().get(i).getProduto().getDescricao())){
                    removerItemTable(i);
                    return;
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecione algum item", "Erro ao continuar", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void finalizarVenda() {
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
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\nVenda incompleta! Faça os ajustes necessários antes de finaliza-la.", "Erro ao presseguir", JOptionPane.ERROR_MESSAGE);
        } 
        catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() + "\nTempo esgotado! Um erro ocorreu ao finalizar a venda, caso persista, tente novamente mais tarde.", "Erro ao processar", JOptionPane.ERROR_MESSAGE);
        }
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
                aplicarFocoPrincipal();
            }
        });
    }
    
    private void aplicarFocoPrincipal() {
        requestFocus();
        
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                    requestFocusInWindow();
                }
            }
        );
    }
    
    //Parar thread de requisições
    @Override
    public void dispose(){
        PDVUtils.shutdownScheduler();
        super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Descontos;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Divisor;
    private javax.swing.JPanel Principal;
    private javax.swing.JPanel Rodapé;
    private javax.swing.JPanel Subtotal;
    private javax.swing.JPanel Subtotal1;
    private javax.swing.JPanel Total;
    private javax.swing.JButton btAddProdutos;
    private javax.swing.JButton btFinalizar;
    public javax.swing.JButton btNovo;
    private javax.swing.JButton btRemoverProduto;
    private javax.swing.JButton btSelecionarCliente;
    private javax.swing.JTextField jFieldCliente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabelDescontos;
    private javax.swing.JLabel jLabelDescontos3;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemHistorico;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private com.mycompany.app.pdv.views.components.TableDark tableItens;
    // End of variables declaration//GEN-END:variables

}
