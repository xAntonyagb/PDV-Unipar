package org.example.pdvapi.controllers;

import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.exceptions.ApiException;
import org.example.pdvapi.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;
    @PostMapping("/'calc")
    public ResponseEntity<VendaDTO> doCalc(VendaDTO vendaDTO) throws ApiException {
        vendaService.doCalc(vendaDTO);
        return ResponseEntity.ok(vendaDTO);
    }
    @PostMapping
    public ResponseEntity<VendaDTO> insert(VendaDTO vendaDTO) throws ApiException {
        vendaService.insert(vendaDTO);
        return ResponseEntity.ok(vendaDTO);
    }
}
