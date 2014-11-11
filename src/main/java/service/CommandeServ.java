package service;

import org.hibernate.Session;
import model.Commande;
import model.Detail;

public class CommandeServ implements CommandeInt {

	@Override
	public void add_commande(Commande cmd) {
		Session ses = HibernateUtil.getSession();
		try {
		ses.beginTransaction();
		ses.save(cmd);
		ses.getTransaction().commit();
		System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion commande" + e.getMessage());
		}
		
	}
	public void Add_Detail(Detail   etd) {
		Session ses = HibernateUtil.getSession();
		try {
		ses.beginTransaction();
		ses.save(etd);
		ses.getTransaction().commit();
		} catch (Exception e) {
			System.err.print("erreur Ajout note" + e.getMessage());
			ses.beginTransaction().rollback();
		}
	}
	}

