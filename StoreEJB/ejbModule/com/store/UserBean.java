package com.store;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(mappedName = "userBean")
@LocalBean
public class UserBean {

	@PersistenceContext(unitName = "StoreJPA")
	private EntityManager em;

	public UserBean() {
	}

	public void add(User u) {
		em.persist(u);
	}

	public void remove(User u) {
		em.remove(u);
	}

	public List<User> getUsers() {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User as u", User.class);
		return q.getResultList();
	}
}
