package WatchIt;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import WatchIt.Views.ClientView;
import WatchIt.Views.MainView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.stage.Stage;
import src.AccountControl.User;
import src.ContentControl.Movie;
import src.DataBase.DataBase;

import java.util.ArrayList;
import java.util.List;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
       Model.getInstance().getViewFactory().Show(MainView.LoginScene());
//       Model.getInstance().getViewFactory().Show(AdminView.AdminMenuControllerScene(AdminView.MovieControllerScene()));

        //Client
//         Model.getInstance().getViewFactory().Show(ClientView.ClientMenuControllerScene());

    }

    public static void main(String[] args) {
        launch();
        DataBase.getInstance().Save();
    }
}
