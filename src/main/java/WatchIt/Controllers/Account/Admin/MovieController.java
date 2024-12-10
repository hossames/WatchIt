package WatchIt.Controllers.Account.Admin;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MovieController {
    @FXML
    private BorderPane borderPane;
    @FXML
    void goToAddMovie(MouseEvent event) {
        Model.getInstance().getViewFactory().Show(AdminView.AdminMenuControllerScene(AdminView.AddMovieControllerScene()));
     }
    @FXML
    void goToRemoveMovie(MouseEvent event) {

    }
}
