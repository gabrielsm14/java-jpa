package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Guilherme");
		conta.setNumero(5567);
		conta.setAgencia(5416);
		conta.setSaldo(1000.0);
		
		em.getTransaction().begin();

		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da Conta da Guilherme: " + conta.getId());
		conta.setSaldo(500.0);
		
		em2.getTransaction().begin();
		
		em2.merge(conta); // transforma a conta em Manager novamente e faz a alteração do saldo 
		em2.getTransaction().commit();
		
		
		
	
	}
}
