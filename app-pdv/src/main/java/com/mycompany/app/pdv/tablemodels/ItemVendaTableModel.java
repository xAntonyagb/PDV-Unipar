package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.ItemVendaDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ItemVendaTableModel extends DefaultTableModel {

    public ItemVendaTableModel() {
        this.addColumn("Produto");
        this.addColumn("Valor Unit.");
        this.addColumn("Qtd.");
        this.addColumn("Desconto");
        this.addColumn("Valor Total");
    }
    
    public ItemVendaTableModel(List<ItemVendaDTO> listItemVenda) {
        this();
        
        for (ItemVendaDTO itemVenda : listItemVenda) {
            this.addRow(new String[] {
                itemVenda.getProduto().getDescricao(),
                Double.toString(itemVenda.getValorUnitario()),
                Double.toString(itemVenda.getQuantidade()),
                Double.toString(itemVenda.getDescontoProduto()),
                Double.toString(itemVenda.getValorTotal())});
        }
    }
    
}
