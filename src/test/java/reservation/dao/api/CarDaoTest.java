package reservation.dao.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import reservation.entities.Car;
import reservation.entities.CarSpecification;

public class CarDaoTest {

	private CarDao carDao;
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("reservation_system");
	private EntityManager manager;
	private static final String CAR_REG = "RENTACAR";
	private CarSpecification carSpecs = new CarSpecification("COOLCAR");

	@Before
	public void setUp() {
		manager = FACTORY.createEntityManager();
		carDao = DaoFactory.createCarDao(manager);
	}

	@After
	public void tearDown() {
		manager.close();
	}

	@Test
	public void testSameCarRegNumber() {

		Car car = new Car(CAR_REG, carSpecs);
		carDao.save(car);
		Car otherCar = carDao.getCarByRegNumber(CAR_REG);
		carDao.delete(car);
		assertEquals(car, otherCar);
	}

	@Test(expected = NoResultException.class)
	public void testCarDelete() {
		Car car = new Car(CAR_REG, carSpecs);
		carDao.save(car);
		carDao.delete(car);
		carDao.getCarByRegNumber(CAR_REG);

	}

	@Test
	public void testCarSpecifSearch() {
		Car car = new Car(CAR_REG, carSpecs);
		carDao.save(car);
		Car otherCar = new Car("OTHER", new CarSpecification("OTHER_SPECS"));
		carDao.save(otherCar);
		List<Car> cars = carDao.getCarsBySpecs(carSpecs);
		carDao.delete(car);
		carDao.delete(otherCar);
		assertTrue(cars.size() == 1);
	}

}
