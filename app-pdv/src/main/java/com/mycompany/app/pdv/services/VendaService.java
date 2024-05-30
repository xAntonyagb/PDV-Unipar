package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.VendaDTO;
import java.util.ArrayList;
import java.util.List;


public class VendaService {
    
    public VendaDTO insert(VendaDTO venda) throws Exception{
        return new VendaDTO();
    }
    
    public VendaDTO findById(Integer id){
        return new VendaDTO();
    }
    
    public List<VendaDTO> findAll() {
        ArrayList<VendaDTO> vendas = new ArrayList();
        List<VendaDTO> vendasList = null;
        vendasList.addAll(vendas);
        return vendasList;
    }
    
    public VendaDTO update(VendaDTO venda) throws Exception{
        return new VendaDTO();
    }
    
    public boolean delete(VendaDTO venda) throws Exception{
        return true;
    }
}
