package WatchIt.Controllers.Enter;

import WatchIt.Models.Model;
import WatchIt.Views.MainView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.AccountControl.Account;
import src.AccountControl.Admin;
import src.DataBase.DataBase;

import java.io.IOException;

public class ForgetPasswordController {

    public Button SubmitButton;
    public BorderPane ForgetPasswordBorderPane;
    public PasswordField ReEnterPassword;
    public PasswordField newPassword;

    //Variables
    double mousePressedX,mousePressedY;

    //init Fx
    public void initialize() {
        try {
            ForgetPasswordBorderPane.setTop(MainView.TitleBar().load());
        }catch (IOException e){
            e.printStackTrace();
        }
        ForgetPasswordBorderPane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mousePressedX = mouseEvent.getX();
                mousePressedY = mouseEvent.getY();
            }
        });
        ForgetPasswordBorderPane.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
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
        if(keyEvent.getCharacter().charAt(0)==System.lineSeparator().charAt(0)&&ReEnterPassword.isFocused())
            Submit();
        if(keyEvent.getCharacter().charAt(0)==System.lineSeparator().charAt(0))
            ReEnterPassword.requestFocus();
    }

    //Login Check
    public void Submit(){
        if(!newPassword.getText().matches(DataBase.getInstance().PasswordRegex)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password Error");
            alert.setHeaderText(null);
            alert.setContentText("Password should contains at least one Capital char,small char,number,special char and it's length more than 8");
            alert.showAndWait();
        }
        else if(newPassword.getText().equals(ReEnterPassword.getText())){
            DataBase db = DataBase.getInstance();
            Account user = DataBase.accountsData.getDataByString(CheckFavoriteNameController.Email,4).getFirst();
            user.setPassword(newPassword.getText());
            if(user instanceof Admin){
                db.adminsData.getDataByString(CheckFavoriteNameController.Email,4).getFirst().setPassword(newPassword.getText());
            }else{
                db.usersData.getDataByString(CheckFavoriteNameController.Email,4).getFirst().setPassword(newPassword.getText());
            }
            Model.getInstance().getViewFactory().Show(MainView.LoginScene());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password Matching Failed");
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match");
            alert.showAndWait();
        }
    }

}
