package WatchIt.Views;

import WatchIt.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;


public class MainView {
    public static FXMLLoader LoginScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Enter/Login.fxml"));
        return fxmlLoader;
    }
    public static Scene RegisterScene(){
        return null;
    }
    public static FXMLLoader TitleBar() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/titleBar.fxml"));
        return fxmlLoader;
    }
}
