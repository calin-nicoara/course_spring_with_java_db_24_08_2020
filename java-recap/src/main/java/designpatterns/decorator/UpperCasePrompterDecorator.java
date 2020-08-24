package designpatterns.decorator;

public class UpperCasePrompterDecorator extends PrompterDecorator{

    public UpperCasePrompterDecorator(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public void saySomething(final String message) {
        this.prompter.saySomething(message.toUpperCase());
    }
}
