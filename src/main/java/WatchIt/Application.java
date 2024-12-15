package WatchIt;

import WatchIt.Models.Model;
import WatchIt.Views.AccountView;
import WatchIt.Views.AdminView;
import WatchIt.Views.MainView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.stage.Stage;
import src.DataBase.DataBase;
public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
      // Model.getInstance().getViewFactory().Show(MainView.LoginScene());
        Model.getInstance().getViewFactory().Show(AccountView.AccountController(DataBase.getInstance().usersData.getDataById((long)1)));
       // Model.getInstance().getViewFactory().Show(AdminView.AdminMenuControllerScene(AdminView.UserControllerScene()));
    }

    public static void main(String[] args) {
        launch();
        DataBase.getInstance().Save();
    }
}