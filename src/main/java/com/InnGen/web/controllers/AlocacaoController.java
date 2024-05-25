package com.InnGen.web.controllers;

import com.InnGen.models.Alocacao;
import com.InnGen.models.Quarto;
import com.InnGen.services.AlocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alocacao")
public class AlocacaoController {

    @Autowired
    private AlocacaoService alocacaoService;

    @GetMapping
    public ResponseEntity<List<Alocacao>> findAll(){
        List<Alocacao> list_alocacao = alocacaoService.findAll();
        return ResponseEntity.ok().body(list_alocacao);
    }
    /**
     * Aloca um usuário a um cliente e quarto específico.
     *
     * @param userId    ID do usuário a ser alocado
     * @param clienteId ID do cliente
     * @param quartoId  ID do quarto
     * @return Detalhes da alocação realizada
     */
    @PostMapping(value = "/alocar/user/{userId}/cliente/{clienteId}/quarto/{quartoId}")
    public ResponseEntity<Alocacao> alocar(@PathVariable Long userId,
                                           @PathVariable Long clienteId,
                                           @PathVariable Long quartoId) {
        Alocacao alocacao = alocacaoService.alocar(userId, clienteId, quartoId);
        return ResponseEntity.ok().body(alocacao);
    }

    /**
     * Desaloca uma alocação específica.
     *
     * @param id ID da alocação a ser removida
     * @return Resposta sem conteúdo, indicando que a alocação foi removida com sucesso
     */
    @DeleteMapping("/desalocar/{id}")
    public ResponseEntity<Void> desalocar(@PathVariable Long id) {
        alocacaoService.desaloca(id);
        return ResponseEntity.noContent().build();
    }
}
