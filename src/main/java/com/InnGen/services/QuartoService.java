package com.InnGen.services;

import com.InnGen.models.Quarto;
import com.InnGen.repositories.QuartoRepository;
import com.InnGen.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository repository;

    public List<Quarto> findAll(){return repository.findAll();}

    public Quarto findById(Long id){
        Optional<Quarto> obj = repository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }

    public Quarto insert(Quarto quarto){return  repository.save(quarto);}

    public void delete(Long id){repository.deleteById(id);}

    public Quarto update(Quarto  newQuarto){
        Quarto quarto = findById(newQuarto.getId());
        quarto.setNumero(newQuarto.getNumero());
        quarto.setTamanho(newQuarto.getTamanho());
        quarto.setStatus(newQuarto.getStatus());
        quarto.setValor(newQuarto.getValor());
        quarto.setDescricao(newQuarto.getDescricao());
        return  repository.save(quarto);
            }
}
