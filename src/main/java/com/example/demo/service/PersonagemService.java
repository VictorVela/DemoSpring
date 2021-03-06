package com.example.demo.service;

import com.example.demo.model.Personagem;
import com.example.demo.repository.PersonagemRepository;
import com.example.demo.model.Personagem;
import com.example.demo.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> findAll(){
        return personagemRepository.findAll();
    }

    public Personagem findById(Long id){
        return personagemRepository.findById(id).get();
    }

    public String saveOrUpdate (Personagem personagem){
        if (personagemRepository.save(personagem) != null){
            return "deu boa";
        }

        return "não deu boa";
    }

    public String delete(Long id){
        if(personagemRepository.existsById(id)){
            personagemRepository.deleteById(id);
            return !personagemRepository.existsById(id) ? "Objeto deletado" : "Erro no delete";
        }

        return  "Não deu boa";
    }
}
