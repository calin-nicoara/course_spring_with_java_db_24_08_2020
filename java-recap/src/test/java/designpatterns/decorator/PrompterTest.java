package designpatterns.decorator;

import org.junit.jupiter.api.Test;

class PrompterTest {

    @Test
    public void testPrompter() {
        Prompter prompter = new FrameMessagePrompterDecorator(
                new UpperCasePrompterDecorator(new HappyPrompter()));

        prompter.saySomething("Hello there!");
    }
}
