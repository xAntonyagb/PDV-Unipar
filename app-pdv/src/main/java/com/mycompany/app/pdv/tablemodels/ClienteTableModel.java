package com.mycompany.app.pdv.tablemodels;

import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ClienteTableModel extends DefaultTableModel {

    public ClienteTableModel() {
        this.addColumn("ID");
        this.addColumn("Nome");
        this.addColumn("Email");
        this.addColumn("Telefone");
    }
    
    public ClienteTableModel(List<ClienteResponseDTO> listCliente) {
        this();
        
        for (ClienteResponseDTO cliente : listCliente) {
            
            this.addRow(new String[] {
                Integer.toString(cliente.getId()),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone()
            });
        }
    }
    
    public ClienteResponseDTO getSelectedCliente(JTable table, List<ClienteResponseDTO> clientes) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            for (ClienteResponseDTO cliente : clientes) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
        }

        return null;
    }
    
}
