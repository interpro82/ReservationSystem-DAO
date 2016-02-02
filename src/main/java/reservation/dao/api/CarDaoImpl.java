package reservation.dao.api;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import reservation.entities.Car;
import reservation.entities.CarSpecification;

/**
 * Implementation of the CarDao.
 * 
 * @author inikolov
 *
 */
class CarDaoImpl extends BasicDaoIml<Car>implements CarDao {

	public CarDaoImpl(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reservation.dao.api.CarDao#getCarByRegNumber(java.lang.String)
	 */
	@Override
	public Car getCarByRegNumber(final String regNumber) {
		String queryText = "SELECT c from Car c WHERE c.registrationNumber = :regNum";
		TypedQuery<Car> query = getManager().createQuery(queryText, Car.class);
		query.setParameter("regNum", regNumber);
		return query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reservation.dao.api.CarDao#getCarsBySpecs(reservation.entities.
	 * CarSpecification)
	 */
	@Override
	public List<Car> getCarsBySpecs(final CarSpecification carSpecs) {
		String queryText = "SELECT c from Car c WHERE c.carSpecs = :spec";
		TypedQuery<Car> query = getManager().createQuery(queryText, Car.class);
		query.setParameter("spec", carSpecs);
		return Collections.unmodifiableList(query.getResultList());
	}

}
