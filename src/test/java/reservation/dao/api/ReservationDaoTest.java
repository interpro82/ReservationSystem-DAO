package reservation.dao.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import reservation.entities.Car;
import reservation.entities.CarSpecification;
import reservation.entities.Reservation;
import reservation.entities.User;

public class ReservationDaoTest {

	private ReservationDao reservationDao;
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("reservation_system");
	private EntityManager manager;
	private Reservation reservation;

	@Before
	public void setUp() {
		manager = FACTORY.createEntityManager();
		reservationDao = DaoFactory.createReservationDao(manager);
		Car car = new Car("CAR", new CarSpecification("RENT_A_CAR"));
		User user = new User("User");
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + 1000 * 60 * 60 * 24);
		reservation = new Reservation(startDate, endDate, user, car);
		reservationDao.save(reservation);
	}

	@After
	public void tearDown() {

		reservationDao.delete(reservation);
		manager.close();
	}

	@Test
	public void testGetReservationByCar() {

		List<Reservation> reservations = reservationDao.getReservationsByCar(reservation.getCar());
		assertEquals(reservation, reservations.get(0));

	}

	@Test
	public void testGetReservationByUser() {

		List<Reservation> reservations = reservationDao.getReservationsByUser(reservation.getUser());
		assertEquals(reservation, reservations.get(0));

	}

	@Test
	public void testGetReservationWithinDates() {

		Date startDate = new Date(reservation.getStartDate().getTime() - 1000 * 60 * 60);
		Date endDate = new Date(reservation.getEndDate().getTime() + 1000 * 60 * 60);
		List<Reservation> reservations = reservationDao.getReservationWithinDates(startDate, endDate);
		assertFalse(reservations.isEmpty());
	}

}
