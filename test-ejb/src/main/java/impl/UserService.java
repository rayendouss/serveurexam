package impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entites.User;
import interf.UserServiceRemote;
@Stateless
public class UserService implements UserServiceRemote {
	@PersistenceContext(unitName = "test-ejb")
	EntityManager em;
	@Override
	public int ajouteruser(User u) {
		em.persist(u);
		return u.getId();
	}
	@Override
	public User getEmployeByEmailAndPassword(String email, String pwd) {
		TypedQuery<User> query =
				em.createQuery("SELECT e FROM User e WHERE e.email=:email AND e.pwd=:pwd ",
				User.class);
				query.setParameter("email", email);
				query.setParameter("pwd", pwd);
				User employe = null;
				try { employe = query.getSingleResult(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return employe;
	}

}
