package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.ProdutoDTO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProdutoTableModel extends DefaultTableModel {

    public ProdutoTableModel() {
        this.addColumn("ID");
        this.addColumn("Descrição");
        this.addColumn("Qtd");
        this.addColumn("Categoria");
        this.addColumn("Valor unitário");
    }
    
    public ProdutoTableModel(List<ProdutoDTO> listProdutos) {
        this();
        
        for (ProdutoDTO produto : listProdutos) {
            this.addRow(new String[] {
                Integer.toString(produto.getId()),
                produto.getDescricao(),
                Double.toString(produto.getQuantidade()),
                produto.getCategoria().getDescricao(),
                Double.toString(produto.getValorUnitario())});
        }
    }
    
    public ProdutoDTO getSelectedProduto(JTable table, List<ProdutoDTO> produtos) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            for (ProdutoDTO produto : produtos) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
        }

        return null;
    }
    
}
