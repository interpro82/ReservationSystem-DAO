package reservation.dao.api;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import reservation.entities.Car;
import reservation.entities.Reservation;
import reservation.entities.User;

/**
 * Implementation of the reservationDao.
 * 
 * @author inikolov
 *
 */
class ReservationDaoImpl extends BasicDaoIml<Reservation>implements ReservationDao {

	public ReservationDaoImpl(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reservation.dao.api.ReservationDao#getReservationsByCar(reservation.
	 * entities.Car)
	 */
	@Override
	public List<Reservation> getReservationsByCar(Car car) {
		String queryText = "SELECT r from Reservation r WHERE r.car = :car";
		TypedQuery<Reservation> query = getManager().createQuery(queryText, Reservation.class);
		query.setParameter("car", car);
		return Collections.unmodifiableList(query.getResultList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * reservation.dao.api.ReservationDao#getReservationsByUser(reservation.
	 * entities.User)
	 */
	@Override
	public List<Reservation> getReservationsByUser(User user) {
		String queryText = "SELECT r from Reservation r WHERE r.user = :user";
		TypedQuery<Reservation> query = getManager().createQuery(queryText, Reservation.class);
		query.setParameter("user", user);
		return Collections.unmodifiableList(query.getResultList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * reservation.dao.api.ReservationDao#getReservationWithinDates(java.util.
	 * Date, java.util.Date)
	 */
	@Override
	public List<Reservation> getReservationWithinDates(Date startDate, Date endDate) {
		String queryText = "SELECT r from Reservation r WHERE r.startDate BETWEEN :startDate AND :endDate";
		TypedQuery<Reservation> query = getManager().createQuery(queryText, Reservation.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return Collections.unmodifiableList(query.getResultList());
	}

}
