package WatchIt.Controllers.Enter;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import WatchIt.Views.ClientView;
import WatchIt.Views.MainView;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.AccountControl.Admin;
import src.AccountControl.User;
import src.DataBase.DataBase;
import java.io.IOException;

public class LoginController {
    // Fx Entities
    public BorderPane LoginPage;
    public TextField Email;
    public PasswordField Password;

    //Variables
    double mousePressedX,mousePressedY;

    //init Fx
    public void initialize() {
        try {
            LoginPage.setTop(MainView.TitleBar().load());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Enter transitions
    public void GoToNext(KeyEvent keyEvent){
        if(keyEvent.getCharacter().charAt(0)==System.lineSeparator().charAt(0)&&Password.isFocused())
            Login();
        if(keyEvent.getCharacter().charAt(0)==System.lineSeparator().charAt(0))
            Password.requestFocus();
    }

    //Login Check
    public void Login(){
        if(DataBase.getInstance().Login(Email.getText(),Password.getText())) {
            System.out.println("Login Successful");
            if(DataBase.getInstance().CurrentUser instanceof Admin)
                System.out.println("Admin logged in");
            else
            {
                System.out.println("User logged in");
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Email or Password is incorrect");
            alert.showAndWait();
        }
    }

    //Register Page
    public void Register(){
        Model.getInstance().getViewFactory().Show(MainView.RegisterScene());
    }

    //Forget PasswordPage
    public void Forget(){
        Model.getInstance().getViewFactory().Show(MainView.FavoriteNameScene(Email.getText()));
    }
}

