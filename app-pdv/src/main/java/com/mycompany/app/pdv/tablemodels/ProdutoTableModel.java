package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProdutoTableModel extends DefaultTableModel {

    public ProdutoTableModel() {
        this.addColumn("ID");
        this.addColumn("Descrição");
//        this.addColumn("Qtd");
        this.addColumn("Categoria");
        this.addColumn("Valor unitário");
    }
    
    public ProdutoTableModel(List<ProdutoResponseDTO> listProdutos) {
        this();
        
        for (ProdutoResponseDTO produto : listProdutos) {
            this.addRow(new String[] {
                Integer.toString(produto.getId()),
                produto.getDescricao(),
//                Double.toString(produto.getQuantidade()),
                produto.getCategoria().getDescricao(),
                Double.toString(produto.getValor())});
        }
    }
    
    public ProdutoResponseDTO getSelectedProduto(JTable table, List<ProdutoResponseDTO> produtos) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            for (ProdutoResponseDTO produto : produtos) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
        }

        return null;
    }
    
}
