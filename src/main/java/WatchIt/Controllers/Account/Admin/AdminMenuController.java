package WatchIt.Controllers.Account.Admin;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import WatchIt.Views.MainView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AdminMenuController {
    public AdminMenuController(FXMLLoader fxmlLoader)  {
        this.fxmlLoader = fxmlLoader;
    }
    FXMLLoader fxmlLoader;
    @FXML
    public void initialize(){
        addToCenter(fxmlLoader);
    }
    @FXML
    public BorderPane borderPane;
    @FXML
    void goToEpisidesController(MouseEvent event)  {
       //addToCenter(AdminView.MovieControllerScene());
    }
    @FXML
    void goToDashboardController(MouseEvent event)  {
       //addToCenter(AdminView.MovieControllerScene());
    }
    @FXML
    void goToMovieController(MouseEvent event) {
       addToCenter(AdminView.MovieControllerScene());
    }

    @FXML
    void goToSeriesController(MouseEvent event)  {
      //  addToCenter(AdminView.SeriesControllerScene());
    }

    @FXML
    void goToUserController(MouseEvent event)  {
        //addToCenter(AdminView.UserControllerScene());
    }
    public  void  addToCenter(FXMLLoader loader) {

        try {
            borderPane.setCenter(loader.load());
            borderPane.setTop(MainView.TitleBar().load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
