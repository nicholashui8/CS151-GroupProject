package controller;

public class NewGameMessage implements Message {

}


class RightClickMessage implements Message {
    int x;
    int y;

    RightClickMessage(int x, int y) {
        System.out.println("right click");
    }
}