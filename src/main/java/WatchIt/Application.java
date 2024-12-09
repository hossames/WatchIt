package WatchIt;

import WatchIt.Models.Model;
import WatchIt.Views.MainView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import src.DataBase.DataBase;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        //DataBase.getInstance();
        Model.getInstance().getViewFactory().Show(MainView.LoginScene());
    }

    public static void main(String[] args) {
        launch();
        //DataBase.getInstance().Save();
    }
}