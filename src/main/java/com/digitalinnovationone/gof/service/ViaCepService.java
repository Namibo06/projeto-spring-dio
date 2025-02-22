package com.digitalinnovationone.gof.service;

import com.digitalinnovationone.gof.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name = "viacep",url = "https://viacep.com.br/ws")
public interface ViaCepService {
    //@RequestMapping(method = RequestMethod.GET,value="/{cep}/json/")
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
