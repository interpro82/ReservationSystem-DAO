package reservation.dao.api;

import javax.persistence.EntityManager;

/**
 * Factory for creating Daos.
 * 
 * @author inikolov
 *
 */
public class DaoFactory {

	/**
	 * Creates reservationDao.
	 * 
	 * @param manager
	 *            - entityManager.
	 * @return - reservationDao.
	 */
	public static ReservationDao createReservationDao(EntityManager manager) {
		return new ReservationDaoImpl(manager);
	}

	/**
	 * Creates userDao.
	 * 
	 * @param manager
	 *            -entityManager.
	 * @return - userDao.
	 */
	public static UserDao createUserDao(EntityManager manager) {
		return new UserDaoImpl(manager);
	}

	/**
	 * Creates carDao.
	 * 
	 * @param manager
	 *            - entityManager.
	 * @return - carDao.
	 */
	public static CarDaoImpl createCarDao(EntityManager manager) {
		return new CarDaoImpl(manager);
	}
}
