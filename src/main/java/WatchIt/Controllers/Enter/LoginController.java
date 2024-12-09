package WatchIt.Controllers.Enter;

import WatchIt.Models.Model;
import WatchIt.Views.MainView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.DataBase.DataBase;
import java.io.IOException;
public class LoginController {
    // Fx Entities
    public BorderPane LoginPage;
    public TextField Email;
    public PasswordField Password;
    public Button LoginButton;
    public Hyperlink Register;
    public Hyperlink Forget;

    //Variables
    double mousePressedX,mousePressedY;

    //init Fx
    public void initialize() {
        try {
            LoginPage.setTop(MainView.TitleBar().load());
        }catch (IOException e){
            e.printStackTrace();
        }
        LoginPage.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mousePressedX = mouseEvent.getX();
                mousePressedY = mouseEvent.getY();
            }
        });
        LoginPage.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double crrX = mouseEvent.getScreenX();
                double crrY = mouseEvent.getScreenY();
                Model.getInstance().getViewFactory().PrimaryStage.setX(crrX - mousePressedX);
                Model.getInstance().getViewFactory().PrimaryStage.setY(crrY - mousePressedY);
            }
        });
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
        if(DataBase.getInstance().Login(Email.getText(),Password.getText()))
            System.out.println("Login Successful");
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

    }

    //Forget PasswordPage
    public void Forget(){

    }
}

