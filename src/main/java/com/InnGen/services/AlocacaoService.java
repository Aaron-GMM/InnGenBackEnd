package com.InnGen.services;

import com.InnGen.models.Alocacao;
import com.InnGen.models.Cliente;
import com.InnGen.models.Quarto;
import com.InnGen.models.User;
import com.InnGen.repositories.AlocacaoRepository;
import com.InnGen.repositories.ClienteRepository;
import com.InnGen.repositories.QuartoRepository;
import com.InnGen.repositories.UserRepository;
import com.InnGen.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlocacaoService {
    @Autowired
    private AlocacaoRepository alocacaoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Alocacao> findAll(){return  alocacaoRepository.findAll();}

    public Alocacao findById(Long id){
        Optional<Alocacao> obj = alocacaoRepository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }


    public Alocacao alocacao(Long userId, Long clienteId,Long quartoId){
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Invalid user ID"));
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new IllegalArgumentException("Invalid cliente ID"));
        Quarto quarto = quartoRepository.findById(quartoId).orElseThrow(()-> new IllegalArgumentException("Invalid quarto ID"));
        if (quarto.getStatus().equals("ocupado")){
            throw  new IllegalStateException("Quarto está ocupado");
        }
        Alocacao alocacao =new Alocacao(null,user, cliente, quarto, LocalDateTime.now());
        quarto.setStatus("ocupado");
        quartoRepository.save(quarto);
        return alocacaoRepository.save(alocacao);
    }

    public void desalocacao(Long alocacaoId){
        Alocacao alocacao = alocacaoRepository.findById(alocacaoId).orElseThrow(()-> new IllegalArgumentException("Invalid alocação ID"));
        Quarto quarto = alocacao.getQuarto();
        quarto.setStatus("disponivel");
        quartoRepository.save(quarto);
        alocacaoRepository.delete(alocacao);
    }

}
