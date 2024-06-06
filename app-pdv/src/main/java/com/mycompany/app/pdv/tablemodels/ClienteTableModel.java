package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.ClienteDTO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ClienteTableModel extends DefaultTableModel {

    public ClienteTableModel() {
        this.addColumn("ID");
        this.addColumn("Nome");
        this.addColumn("Telefone");
        this.addColumn("CPF");
    }
    
    public ClienteTableModel(List<ClienteDTO> listCliente) {
        this();
        
        for (ClienteDTO cliente : listCliente) {
//            this.addRow(new String[] {
//                Integer.toString(cliente.getId()),
//                cliente.getNome(),
//                cliente.getTelefone(),
//                cliente.getCpf()});
            
            this.addRow(new String[] {
                Integer.toString(cliente.getId()),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail()
            });
        }
    }
    
    public ClienteDTO getSelectedCliente(JTable table, List<ClienteDTO> clientes) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            for (ClienteDTO cliente : clientes) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
        }

        return null;
    }
    
}
