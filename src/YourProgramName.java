import controller.Controller;
import controller.Message;
import view.View;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class YourProgramName {
    private static final BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException {
        View view = View.init(queue);
        Controller controller = new Controller(view, queue);
        controller.mainLoop();
        view.dispose();
        queue.clear();
    }
}

