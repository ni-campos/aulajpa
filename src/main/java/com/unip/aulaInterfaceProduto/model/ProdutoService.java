package com.unip.aulaInterfacePoduto.model;

import java.util.List;

import com.unip.aulaInterfacePoduto.model.db.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    ProdutoDAO produtoDAO;
    public List<Produto> listarProdutos() {
        List<Produto> lista = null;
        try {
            lista = produtoDAO.listarProdutos();
        } catch (Exception e) {
            System.err.println("Falha ao listar os produtos: " +
                    e.getMessage());
        }
        return lista;
    }
    public boolean salvarProduto(Produto produto) {
        boolean salvo = false;
        try {
            produtoDAO.incluirProduto(produto);
            salvo = true;
        } catch (Exception e) {
            System.err.printf("Falha ao incluir o produto com código %d %n: ", produto.getCodigo());
            System.err.println(e.getMessage());
        }
        return salvo;
    }
}