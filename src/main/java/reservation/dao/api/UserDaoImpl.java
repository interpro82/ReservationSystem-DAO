package reservation.dao.api;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import reservation.entities.User;

/**
 * Implementation of the userDao.
 * 
 * @author inikolov
 *
 */
class UserDaoImpl extends BasicDaoIml<User>implements UserDao {

	public UserDaoImpl(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reservation.dao.api.UserDao#getUserByName(java.lang.String)
	 */
	@Override
	public User getUserByName(String userName) {
		String queryText = "SELECT u from User u WHERE u.name = :name";
		TypedQuery<User> query = getManager().createQuery(queryText, User.class);
		query.setParameter("name", userName);
		return query.getSingleResult();
	}

}
