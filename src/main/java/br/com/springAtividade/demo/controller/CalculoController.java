package br.com.springAtividade.demo.controller;

import br.com.springAtividade.demo.dto.EntradaDTO;
import br.com.springAtividade.demo.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculo")
public class CalculoController {
    @Autowired
    private CalculoService calculoService;

    @PostMapping("/calcular")
    private ResponseEntity<?> calcular(@RequestBody EntradaDTO entrada){
        calculoService.calcular(entrada);

        return ResponseEntity.ok(calculoService.calcular(entrada));
    }
}
