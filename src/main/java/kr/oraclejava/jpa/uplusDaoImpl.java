package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class uplusDaoImpl implements uplusDao<Phone> {

	private EntityManager manager;
	
	public uplusDaoImpl(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Phone> getAllEntity() {
		return manager.createQuery("from Uplus").getResultList();
	}

	public List<Phone> findByField(String field, String find) {
		Query query = manager.createQuery("from Uplus WHERE " + field + "='" + find + "'");
		return query.getResultList();
	}

	public void addEntity(Phone entity) {
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(entity);
		manager.flush();
		tran.commit();
		// Rollback은 Exception을 통해 처리
	}

	public void updateEntity(Phone entity) {
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.merge(entity);
		manager.flush();
		tran.commit();
	}

	public void removeEntity(Phone entity) {
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.remove(entity);
		manager.flush();
		tran.commit();
	}

	public void removeEntity(Integer id) {
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		Phone uplus = manager.find(Phone.class, id);
		manager.remove(uplus);
		manager.flush();
		tran.commit();
	}

}
