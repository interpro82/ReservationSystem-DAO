package reservation.dao.api;

import reservation.entities.User;

/**
 * Dao for user entity.
 * 
 * @author inikolov
 *
 */
public interface UserDao extends BasicDao<User> {

	/**
	 * Returns user by its name.
	 * 
	 * @param userName
	 *            - user's name
	 * @return - user entity.
	 */
	User getUserByName(String userName);
}
