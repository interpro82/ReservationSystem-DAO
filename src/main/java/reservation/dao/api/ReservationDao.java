package reservation.dao.api;

import java.util.Date;
import java.util.List;

import reservation.entities.Car;
import reservation.entities.Reservation;
import reservation.entities.User;

/**
 * Dao for reservation entity.
 * 
 * @author Java
 *
 */
public interface ReservationDao extends BasicDao<Reservation> {

	/**
	 * Retrieves all reservation connected to a given car.
	 * 
	 * @param car
	 *            - an attached entity.
	 * @return - list of reservations.
	 */
	List<Reservation> getReservationsByCar(Car car);

	/**
	 * Retrieves all reservation connected to a given user.
	 * 
	 * @param user
	 *            - an attached entity.
	 * @return - list of reservations.
	 */
	List<Reservation> getReservationsByUser(User user);

	/**
	 * Retrieves reservations within the specified dates.
	 * 
	 * @param startDate
	 *            - start date
	 * @param endDate
	 *            - end date.
	 * @return - list of reservations.
	 */
	List<Reservation> getReservationWithinDates(Date startDate, Date endDate);

}
