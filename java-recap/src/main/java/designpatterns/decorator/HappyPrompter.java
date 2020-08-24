package designpatterns.decorator;

public class HappyPrompter implements Prompter{
    @Override
    public void saySomething(final String message) {
        System.out.println("Happy to say: " + message);
    }

    @Override
    public void dontCare() {
        System.out.println("really don't care...");
    }
}
