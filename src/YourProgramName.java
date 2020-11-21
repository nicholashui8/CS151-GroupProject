import ProjectStarterCode.controller.Controller;
import ProjectStarterCode.controller.Message;
import ProjectStarterCode.model.Model;
import ProjectStarterCode.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class YourProgramName {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static View view;
    private static Model model;

    public static void main(String[] args) {
        view = View.init(queue);
        model = new Model();
        Controller controller = new Controller(view, model, queue);

        controller.mainLoop();
        view.dispose();
        queue.clear();
        System.out.println("Hello Git Hub!");
        System.out.println("Helloer Git Hub!");
    }
}

