package com.digitalinnovationone.gof.service;

import com.digitalinnovationone.gof.model.Cliente;
import com.digitalinnovationone.gof.model.ClienteRepository;
import org.springframework.stereotype.Service;

/**
 * Interface que define <b>Strategy</b> no domínio de cliente.Com
 * isso,se necessário,podemos ter multiplas implementações dessa
 * mesma interface.
 * */

@Service
public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id,Cliente cliente);

    void deletar(Long id);
}
