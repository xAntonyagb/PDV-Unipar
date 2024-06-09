package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.response.ItemVendaResponseDTO;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ItemVendaTableModel extends DefaultTableModel {

    public ItemVendaTableModel() {
        this.addColumn("Produto");
        this.addColumn("Valor Unit.");
        this.addColumn("Qtd.");
        this.addColumn("Subtotal");
        this.addColumn("Desconto");
        this.addColumn("Valor Total");
    }
    
    public ItemVendaTableModel(List<ItemVendaResponseDTO> listItemVenda) {
        this();
        
        for (ItemVendaResponseDTO itemVenda : listItemVenda) {
            DecimalFormat df = new DecimalFormat("#.###");
            String vlSubtotal = df.format(itemVenda.getValorSubtotal());
            String vlTotal = df.format(itemVenda.getValorTotal());
            String vlDesconto = df.format(itemVenda.getDesconto());
            
            this.addRow(new String[] {
                itemVenda.getProduto().getDescricao(),
                Double.toString(itemVenda.getValorUnitario()),
                Double.toString(itemVenda.getQuantidade()),
                vlSubtotal,
                vlDesconto,
                vlTotal});
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
