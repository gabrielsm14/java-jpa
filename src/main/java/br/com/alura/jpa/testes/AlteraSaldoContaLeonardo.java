package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {

	public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
			EntityManager em = emf.createEntityManager();
			
			Conta contaDoLeonardo = em.find(Conta.class, 1L);
			Conta contaDoLeonardo2 = em.find(Conta.class, 2L);
			
//			System.out.println("Conta do Leonardo " + contaDoLeonardo.getTitular());
			
			em.getTransaction().begin();
			contaDoLeonardo.setAgencia(3210);
			contaDoLeonardo.setNumero(01234);
			contaDoLeonardo2.setSaldo(50.0);
			contaDoLeonardo.setSaldo(20.0);
			em.getTransaction().commit();
	}
}
