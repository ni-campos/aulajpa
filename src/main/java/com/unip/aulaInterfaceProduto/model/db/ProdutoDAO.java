package com.unip.aulaInterfacePoduto.model.db;

import com.unip.aulaInterfacePoduto.model.Produto;

import java.util.List;

public interface ProdutoDAO {
    public List<Produto> listarProdutos();
    public void incluirProduto(Produto produto);
}
