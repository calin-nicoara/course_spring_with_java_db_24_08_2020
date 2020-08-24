package designpatterns.decorator;

public class FrameMessagePrompterDecorator extends PrompterDecorator{

    public FrameMessagePrompterDecorator(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public void saySomething(final String message) {
        System.out.println("--------------------------------------");
        this.prompter.saySomething(message);
        System.out.println("--------------------------------------");
    }
}
