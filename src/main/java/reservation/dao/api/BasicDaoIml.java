package reservation.dao.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author Java Implementation of the BasicDao interface.
 * @param <T>
 *            - entity for CRUD.
 */
class BasicDaoIml<T> implements BasicDao<T> {

	/**
	 * EntityManager to work with.
	 */
	private EntityManager manager;

	public BasicDaoIml(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public EntityManager getManager() {
		return manager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reservation.dao.api.BasicDao#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reservation.dao.api.BasicDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(entity);
		transaction.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reservation.dao.api.BasicDao#update(java.lang.Object)
	 */
	@Override
	public void update(T entity) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		transaction.commit();

	}

}
