package reservation.dao.api;

import java.util.List;

import reservation.entities.Car;
import reservation.entities.CarSpecification;

/**
 * Dao for car entity.
 * 
 * @author inikolov
 *
 */
public interface CarDao extends BasicDao<Car> {

	/**
	 * Retrieves car by it's regNumber.
	 * 
	 * @param regNumber
	 *            - registration number.
	 * @return - car entity.
	 */
	Car getCarByRegNumber(String regNumber);

	/**
	 * Retrieves all cars that match the specifications provided.
	 * 
	 * @param carSpecs
	 *            - car specs.
	 * @return - list of cars.
	 */
	List<Car> getCarsBySpecs(CarSpecification carSpecs);
}
