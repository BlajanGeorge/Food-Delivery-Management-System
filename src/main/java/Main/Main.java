package Main;
import BusinessLayer.Model;
import PresentationLayer.Controller;
import PresentationLayer.UserGraphicalInterface.UserGraphicalInterface;

public class Main {
    public static void main(String[] args) {

        UserGraphicalInterface userGraphicalInterface = new UserGraphicalInterface();
        Model model = new Model();
        new Controller(userGraphicalInterface,model);

    }
}
