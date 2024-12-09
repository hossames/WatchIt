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
            return scene;
        }catch (IOException e){
            System.out.println("Error: While Getting Scene");
            System.out.println(e);
        }
        return null;
    }
    public static FXMLLoader RegisterScene(){
        return null;
    }
    public static FXMLLoader ForgetScene(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Enter/ForgetPassword.fxml"));
        return fxmlLoader;
    }
    public static FXMLLoader FavoriteNameScene(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Enter/CheckFavoriteName.fxml"));
        return fxmlLoader;
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
