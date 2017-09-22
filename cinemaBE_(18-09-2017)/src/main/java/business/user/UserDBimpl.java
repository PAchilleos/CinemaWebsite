package business.user;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import persistence.User;
import util.JSONUtil;

@Default
@Stateless
public class UserDBimpl implements UserService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public String addUser(String jsonUser) {
		User newUser = util.getObjectForJSON(jsonUser, User.class);
		em.persist(newUser);
		return jsonUser;
	}

	public String getUsers() {
		Query query = em.createQuery("SELECT u FROM User u");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}

}
