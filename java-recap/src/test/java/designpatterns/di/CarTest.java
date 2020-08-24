package designpatterns.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testStartCar() {
        Car car = new Car(new NormalMotor());

        car.setAirConditioner(new SimpleAirConditioner());

        car.startCar();
    }
}
