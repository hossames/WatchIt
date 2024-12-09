package WatchIt.Controllers.Enter;

import WatchIt.Models.Model;
import WatchIt.Views.MainView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.AccountControl.Account;
import src.DataBase.DataBase;

import java.io.IOException;
import java.util.List;

public class CheckFavoriteNameController{

    public TextField FAVNAME;
    public Button SubmitButton;
    public BorderPane CheckFavoriteNameBorderPane;
    public static String Email;
    //Variables
    double mousePressedX,mousePressedY;
    //init Fx
    public void initialize() {
        try {
            CheckFavoriteNameBorderPane.setTop(MainView.TitleBar().load());
        }catch (IOException e){
            e.printStackTrace();
        }
        CheckFavoriteNameBorderPane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mousePressedX = mouseEvent.getX();
                mousePressedY = mouseEvent.getY();
            }
        });
        CheckFavoriteNameBorderPane.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
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
        if(keyEvent.getCharacter().charAt(0)==System.lineSeparator().charAt(0))
            Submit();
    }

    //Submit Check
    public void Submit(){
        List<Account>list = DataBase.accountsData.getDataByString(Email,4);
        if(list.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Email Error");
            alert.setHeaderText(null);
            alert.setContentText("Email not found");
            alert.showAndWait();
        } else if (list.getFirst().getFavoriteName().equals(FAVNAME.getText())) {
            Model.getInstance().getViewFactory().Show(MainView.ForgetScene());
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Favorite Name Error");
            alert.setHeaderText(null);
            alert.setContentText("Favorite Name not matched");
            alert.showAndWait();
        }
    }

}
