package com.example.mercadoapi.controller;

import com.example.mercadoapi.model.Cliente;
import com.example.mercadoapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/* classe reponsavel por listar os clientes do nosso banco de dados. */

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
  private ClienteRepository clienteRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

         List<Cliente> clientes = clienteRepository.findAll();
         modelAndView.addObject("clientes",clientes);

         return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");
        Cliente cliente = clienteRepository.findById(id).get();
        modelAndView.addObject("cliente",cliente);
        System.out.println(modelAndView);
        return modelAndView;
    }
}
