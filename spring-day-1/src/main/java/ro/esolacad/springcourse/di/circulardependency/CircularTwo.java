package ro.esolacad.springcourse.di.circulardependency;

import org.springframework.stereotype.Component;

//@Component
public class CircularTwo {
    private final CircularThree circularThree;

    public CircularTwo(CircularThree circularTwo) {
        this.circularThree = circularTwo;
    }

    public void callTwo() {
        circularThree.callThree();
    }
}
