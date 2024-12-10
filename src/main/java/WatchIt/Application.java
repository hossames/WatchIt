package WatchIt;

import WatchIt.Models.Model;
import WatchIt.Views.AdminView;
import WatchIt.Views.MainView;
import javafx.stage.Stage;
import src.DataBase.DataBase;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
       Model.getInstance().getViewFactory().Show(MainView.LoginScene());
       //Model.getInstance().getViewFactory().Show(AdminView.AdminMenuControllerScene());
    }

    public static void main(String[] args) {
        launch();
        DataBase.getInstance().Save();
    }
}