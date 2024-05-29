package com.digitalinnovationone.gof.service.impl;

import com.digitalinnovationone.gof.model.Cliente;
import com.digitalinnovationone.gof.model.ClienteRepository;
import com.digitalinnovationone.gof.model.Endereco;
import com.digitalinnovationone.gof.model.EnderecoRepository;
import com.digitalinnovationone.gof.service.ClienteService;
import com.digitalinnovationone.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    // TODO Singleton: Injetar os componentes do Spring com @AutoWired.
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;
    // TODO Strategy: Implementar os métodos definidos na interface.
    // TODO Facade:Abstrair integrações com  subsistemas,provendo  uma interface simples.

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do cliente já existe (pelo cep)
        String cep= cliente.getEndereco().getCep();
        Endereco endereco=enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista,integrar com o ViaCep e persisitir o retorno
            Endereco novoEndereco=viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir cliente,vinculando o Endereco (novo ou existente)
        clienteRepository.save(cliente);
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar clientes por id
        Optional<Cliente> cliente= clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar cliente por id ,caso exista
        Optional<Cliente> clienteBd= clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar cliente por id
        clienteRepository.deleteById(id);
    }
}
