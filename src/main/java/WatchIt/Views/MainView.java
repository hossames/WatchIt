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
    public static Scene getScene(FXMLLoader fxmlLoader){
        try{
            Scene scene = new Scene(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Error: While Getting Scene");
            e.printStackTrace();
        }
    }
    public static FXMLLoader RegisterScene(){
        return null;
    }
    public static FXMLLoader ForgetScene(){
        return null;
    }
    public static FXMLLoader PasswordResetScene(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Enter/PasswordReset.fxml"));
        return fxmlLoader;
    }
    public static FXMLLoader TitleBar() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/titleBar.fxml"));
        return fxmlLoader;
    }
}
