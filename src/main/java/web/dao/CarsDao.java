package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarsDao {
    private static int CARS_COUNT = 0;
    private static List<Car> cars = new ArrayList<>();

    public void putCars() {
        cars.add(new Car(++CARS_COUNT,"model1",123));
        cars.add(new Car(++CARS_COUNT,"model1",345));
        cars.add(new Car(++CARS_COUNT,"model2",345));
        cars.add(new Car(++CARS_COUNT,"model3",345));
        cars.add(new Car(++CARS_COUNT,"model2",123));
        System.out.println(cars.toString());
    }

    public List<Car> getSomeCars(int count) {
        if (count-1 > cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
    public List<Car> getAllCars() {
        return cars;

    }

}
