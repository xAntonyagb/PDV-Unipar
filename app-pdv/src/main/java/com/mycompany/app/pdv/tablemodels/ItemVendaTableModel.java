package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.response.ItemVendaResponseDTO;
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
            
            String vlSubtotal = Double.toString(itemVenda.getValorSubtotal());
            vlSubtotal = vlSubtotal.substring(0, vlSubtotal.indexOf(".")+3);

            String vlTotal = Double.toString(itemVenda.getValorTotal());
            vlTotal = vlTotal.substring(0, vlTotal.indexOf(".")+3);

            String vlDesconto = Double.toString(itemVenda.getDesconto());
            vlDesconto = vlDesconto.substring(0, vlDesconto.indexOf(".")+3);
            
            this.addRow(new String[] {
                
                itemVenda.getProduto().getDescricao(),
                Double.toString(itemVenda.getValorUnitario()),
                vlSubtotal,
                Double.toString(itemVenda.getQuantidade()),
                vlDesconto,
                vlTotal});
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
