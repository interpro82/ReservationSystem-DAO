package reservation.dao.api;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import reservation.entities.User;

public class UserDaoTest {

	private UserDao userDao;
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("reservation_system");
	private EntityManager manager;
	private static final String USER_NAME = "username";

	@Before
	public void setUp() {
		manager = FACTORY.createEntityManager();
		userDao = DaoFactory.createUserDao(manager);
	}

	@After
	public void tearDown() {
		manager.close();
	}

	@Test
	public void testSameUserName() {

		User user = new User(USER_NAME);
		userDao.save(user);
		User otherUser = userDao.getUserByName(USER_NAME);
		assertEquals(user, otherUser);
	}

}
