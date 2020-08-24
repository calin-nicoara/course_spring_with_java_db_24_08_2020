package designpatterns.decorator;

public abstract class PrompterDecorator implements Prompter{
    protected Prompter prompter;

    public PrompterDecorator(final Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public void saySomething(final String message) {
        this.prompter.saySomething(message);
    }

    @Override
    public void dontCare() {
        this.prompter.dontCare();
    }
}
