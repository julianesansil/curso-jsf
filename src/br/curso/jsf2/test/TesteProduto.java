package br.curso.jsf2.test;

import javax.persistence.EntityManager;

import br.curso.jsf2.model.bean.Produto;
import br.curso.jsf2.model.dao.JPAUtil;
import br.curso.jsf2.model.dao.ProdutoDAO;

public class TesteProduto {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

//		ProdutoDAO produtoDAO = new ProdutoDAO(em);
//		Produto produto = new Produto();
//		produto.setNome("Sab�o em p� OMO");
//		produto.setDescricao("Sab�o em p�");
//		
//		produtoDAO.cadastrar(produto);
//		System.out.println(produtoDAO.buscarProdutos("omo"));

		em.getTransaction().commit();
		em.close();
	}
	
}
