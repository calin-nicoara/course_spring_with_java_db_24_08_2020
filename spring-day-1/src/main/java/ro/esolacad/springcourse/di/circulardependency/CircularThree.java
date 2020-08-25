package ro.esolacad.springcourse.di.circulardependency;

import org.springframework.stereotype.Component;

//@Component
public class CircularThree {
    private final CircularOne circularOne;

    public CircularThree(CircularOne circularTwo) {
        this.circularOne = circularTwo;
    }

    public void callThree() {
        circularOne.callOne();
    }
}
