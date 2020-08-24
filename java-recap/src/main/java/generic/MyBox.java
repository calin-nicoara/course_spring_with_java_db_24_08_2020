package generic;

public class MyBox<T> {

    private T myObject;

    public MyBox(final T myObject) {
        this.myObject = myObject;
    }

    public T getMyObject() {
        return myObject;
    }

    public void setMyObject(final T myObject) {
        this.myObject = myObject;
    }
}
