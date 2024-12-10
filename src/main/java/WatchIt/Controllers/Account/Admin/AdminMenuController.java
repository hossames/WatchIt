package WatchIt.Controllers.Account.Admin;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AdminMenuController {

    @FXML
    private BorderPane borderPane;

    @FXML
    void goToMovieController(MouseEvent event) throws IOException {
       addToCenter(AdminView.MovieControllerScene());
    }

    @FXML
    void goToSeriesController(MouseEvent event) throws IOException {
      //  addToCenter(AdminView.SeriesControllerScene());
    }

    @FXML
    void goToUserController(MouseEvent event) throws IOException {
        //addToCenter(AdminView.UserControllerScene());
    }
    private void addToCenter(FXMLLoader loader) throws IOException {
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        borderPane.setCenter(pane);
    }

}
