package ro.esolacad.springcourse.di.circulardependency;

import org.springframework.stereotype.Component;

//@Component
public class CircularOne {

    private final CircularTwo circularTwo;

    public CircularOne(CircularTwo circularTwo) {
        this.circularTwo = circularTwo;
    }

    public void callOne() {
        circularTwo.callTwo();
    }


}
