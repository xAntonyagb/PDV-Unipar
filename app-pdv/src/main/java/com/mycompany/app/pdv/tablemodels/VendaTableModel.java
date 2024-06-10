/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;
import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wallg
 */
public class VendaTableModel extends DefaultTableModel{
    
    public VendaTableModel() {
        this.addColumn("ID");
        this.addColumn("Observações");
        this.addColumn("Data");
        this.addColumn("Valor Total");
    }
    
    public VendaTableModel(List<VendaResponseDTO> listVendas) {
        this();
        DecimalFormat df = new DecimalFormat("#.##");

        for (VendaResponseDTO venda : listVendas) {
            String id = Long.toString(venda.getId());
            String observacao = venda.getObservacao();    
            
            Timestamp timestamp = venda.getData();
            LocalDateTime localDateTime = timestamp.toLocalDateTime();              
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");              
            ZonedDateTime zonedDateTime = localDateTime.atZone
            (ZoneId.systemDefault()).withZoneSameInstant
            (ZoneId.of("America/Sao_Paulo"));
            
            String dataFormatada = zonedDateTime.format(formatter);           
            String valorTotal = df.format(venda.getValorTotal());
            
            this.addRow(new String[]{id, observacao, dataFormatada, valorTotal});
        }
    }
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    
    public VendaResponseDTO getSelectedProduto(JTable table, List<VendaResponseDTO> vendas) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            for (VendaResponseDTO venda : vendas) {
                if (venda.getId() == id) {
                    return venda;
                }
            }
        }

        return null;
    }
}
