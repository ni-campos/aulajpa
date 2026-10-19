package com.unip.aulaInterfacePoduto.model.db;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.unip.aulaInterfacePoduto.model.Produto;

@Repository
@Transactional
@Primary

public class ProdutoHibernateDAOImpl implements ProdutoDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Produto> listarProdutos() {
        return entityManager.createQuery("FROM Produto",
                Produto.class).getResultList();
    }
    @Override
    public void incluirProduto(Produto produto) {
        entityManager.persist(produto);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
