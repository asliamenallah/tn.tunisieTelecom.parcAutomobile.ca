package tn.tunisieTelecom.parcAutomobile.ca.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.tunisieTelecom.parcAutomobile.ca.entity.User;
import tn.tunisieTelecom.parcAutomobile.ca.service.local.UserEJBLocal;
import tn.tunisieTelecom.parcAutomobile.ca.service.remote.UserEJBRemote;

/**
 * Session Bean implementation class UserEJB
 */
@Stateless
public class UserEJB implements UserEJBRemote, UserEJBLocal {

	@PersistenceContext(unitName = "tn.tunisieTelecom.parcAutomobile.ca")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserEJB() {
		
	}

	@Override
	public User authentication(String login,String pass) {
		User user2 = null ;
		Query q = entityManager
				.createQuery(
						"SELECT u FROM utilisateur u WHERE u.login=:login AND u.passwd=:pass",
						User.class).setParameter("login", pass)
				.setParameter("pass", login);
		try{
			user2 = (User) q.getSingleResult();
		}catch(Exception e){
			System.err.println("user not fou,f ");
		}
		return user2;
	}

}
