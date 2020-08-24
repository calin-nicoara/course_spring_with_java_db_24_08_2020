package designpatterns.di;

public class Car {

    private final Motor motor;
    private AirConditioner airConditioner;

    public Car(final Motor motor) {
        this.motor = motor;
    }

    public void setAirConditioner(final AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void startCar() {
        motor.startEngine();

        if(airConditioner != null) {
            airConditioner.startAC();
        }

        System.out.println("Started car");
    }
}
