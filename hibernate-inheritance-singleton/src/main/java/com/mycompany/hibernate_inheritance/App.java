package com.mycompany.hibernate_inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_inheritance.model.Account;
import com.mycompany.hibernate_inheritance.model.CurrentAccount;
import com.mycompany.hibernate_inheritance.model.SavingsAccount;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Session session;
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Account.class)
					.addAnnotatedClass(CurrentAccount.class).addAnnotatedClass(SavingsAccount.class)
					.buildSessionFactory();
			session = factory.openSession();

			Account account = new Account("John", "State Bank Of India", 10000);
			SavingsAccount savingsAccount = new SavingsAccount("Madhu", "IDBI", 20000, 500, 5);
			CurrentAccount currentAccount = new CurrentAccount("Kabir", "HDFC", 15000, 2000);
			session.getTransaction().begin();
			session.save(account);
			session.save(savingsAccount);
			session.save(currentAccount);
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
