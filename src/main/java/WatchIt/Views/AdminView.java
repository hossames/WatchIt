package WatchIt.Views;

import WatchIt.Application;
import WatchIt.Controllers.Account.Admin.AdminMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class AdminView {
    public static FXMLLoader AdminMenuControllerScene(FXMLLoader fxmlLoader1) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Account/Admin/Controller.fxml"));
        fxmlLoader.setController(new AdminMenuController(fxmlLoader1));
        return fxmlLoader;
    }
    public static FXMLLoader AddMovieControllerScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Account/Admin/AddMovie.fxml"));
        return fxmlLoader;
    }
    public static FXMLLoader MovieControllerScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Account/Admin/MoviesController.fxml"));
        return fxmlLoader;
    }
    public static FXMLLoader UserControllerScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Account/Admin/editUser.fxml"));
        return fxmlLoader;
    }
    public static Scene getScene(FXMLLoader fxmlLoader){
        try{
            Scene scene = new Scene(fxmlLoader.load());
            return scene;
        }catch (IOException e){
            System.out.println("Error: While Getting Scene");
            System.out.println(e);
        }
        return null;
    }
}
