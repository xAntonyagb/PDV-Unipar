package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.VendaDTO;
import com.mycompany.app.pdv.entities.Venda;
import com.mycompany.app.pdv.repositories.VendaRepositoryImp;
import com.mycompany.app.pdv.util.EntityManagerUtil;
import java.util.List;


public class VendaService {
    
    public VendaDTO insert(VendaDTO venda) throws Exception{
        return new VendaRepositoryImp(EntityManagerUtil.getManager()).insert(venda);
    }
    
    public VendaDTO findById(Integer id){
        return new VendaRepositoryImp(EntityManagerUtil.getManager()).findById(id);
    }
    
    public List<VendaDTO> findAll() {
        return new VendaRepositoryImp(EntityManagerUtil.getManager()).findAll();
    }
    
    public VendaDTO update(VendaDTO venda) throws Exception{
        return new VendaRepositoryImp(EntityManagerUtil.getManager()).update(venda);
    }
    
    public boolean delete(VendaDTO venda) throws Exception{
        return new VendaRepositoryImp(EntityManagerUtil.getManager()).delete(venda);
    }
}
