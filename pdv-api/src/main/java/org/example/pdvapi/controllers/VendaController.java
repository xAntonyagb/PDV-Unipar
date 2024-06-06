package org.example.pdvapi.controllers;

import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;
    @PostMapping("/calc")
    public ResponseEntity<VendaDTO> doCalc(@RequestBody VendaDTO vendaDTO) throws Exception {
        vendaService.doCalc(vendaDTO);
        return ResponseEntity.ok(vendaDTO);
    }
    @PostMapping
    public ResponseEntity<VendaDTO> insert(@RequestBody VendaDTO vendaDTO) throws Exception {
        vendaService.insert(vendaDTO);
        return ResponseEntity.ok(vendaDTO);
    }
}
