package eti.policarto.jpa.dao;

import eti.policarto.jpa.commons.EntityManagerFactory;
import eti.policarto.jpa.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoDAO {

    private final EntityManager entityManager;

    public ProdutoDAO() {
        this.entityManager = EntityManagerFactory.getEntityManager();
    }

    public Produto findById(Long id){
        return this.entityManager.find(Produto.class, id);
    }

    public List<Produto> findAll(){
        return this.entityManager
                .createQuery(" SELECT * FROM PRODUTO ", Produto.class)
                .getResultList();
    }

    public void save(Produto produto){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(produto);
        this.entityManager.getTransaction().commit();
    }

    public void remove(Long id){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(findById(id));
        this.entityManager.getTransaction().commit();
    }

    public List<Produto> findAllWithCategoria(){
        final String jpql = " select p from Produto p left join fetch p.categoria ";
        final TypedQuery<Produto> query = this.entityManager.createQuery(jpql, Produto.class);
        return query.getResultList();
    }

}
