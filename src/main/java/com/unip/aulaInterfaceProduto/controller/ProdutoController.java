package com.unip.aulaInterfacePoduto.controller;

import com.unip.aulaInterfacePoduto.model.Produto;
import com.unip.aulaInterfacePoduto.model.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping("/listarProdutos")
    public String listarProdutos(Model model) {
        model.addAttribute("lista", produtoService.listarProdutos());
        model.addAttribute("produto", new Produto());
        return "produto"; // Volta a ser apenas "produto"
    }

    @PostMapping("/salvarProduto")
    public String salvarProduto(@ModelAttribute("produto") Produto produto) {
        produtoService.salvarProduto(produto);
        return "redirect:/listarProdutos";
    }
}