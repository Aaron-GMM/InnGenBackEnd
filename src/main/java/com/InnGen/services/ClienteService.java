package com.InnGen.services;

import com.InnGen.models.Cliente;
import com.InnGen.repositories.ClienteRepository;
import com.InnGen.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente>  findAll(){return repository.findAll();}

    public  Cliente findeById(Long id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente cliente){return repository.save(cliente);}

    public void delete(long id){repository.deleteById(id);}

    public Cliente update(Cliente newcliente){
        Cliente cliente  = findeById(newcliente.getId());
        cliente.setNome(newcliente.getNome());
        cliente.setTelefone(newcliente.getTelefone());
        cliente.setDt_nascimento(newcliente.getDt_nascimento());

        return  repository.save(cliente);
    }
}
