package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestantoEstados {

	public static void main(String[] args) {
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Miguel");
		conta.setAgencia(2222);
		conta.setNumero(56321);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Transformando um objeto transient em Managed, ou seja, sicronização automatica com o banco
		em.persist(conta);
		// Managed -> removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
