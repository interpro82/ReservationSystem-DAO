package reservation.dao.api;

/**
 * @author inikolov Basic CRUD.
 * @param <T>
 *            - type of the entity.
 */
public interface BasicDao<T> {

	/**
	 * Persist the entity.
	 * 
	 * @param entity
	 *            - to be persisted.
	 */
	public void save(T entity);

	/**
	 * To be deleted.
	 * 
	 * @param entity
	 *            - to be removed.
	 */
	public void delete(T entity);

	/**
	 * Merges and existing entity.
	 * 
	 * @param entity
	 *            - to be updated.
	 */
	public void update(T entity);
}
