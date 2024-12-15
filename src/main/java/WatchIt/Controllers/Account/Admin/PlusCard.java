package WatchIt.Controllers.Account.Admin;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class PlusCard{

    @FXML
    void addMovie(MouseEvent event) {
        Model.getInstance().getViewFactory().Show(AdminView.AdminMenuControllerScene(AdminView.AddMovieControllerScene()));
    }

}
