package WatchIt.Controllers.Account.Admin;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MovieController {
    @FXML
    void goBack(MouseEvent event) {
        System.out.println("Menu");
        Model.getInstance().getViewFactory().Show(AdminView.AdminMenuControllerScene());
    }

}
