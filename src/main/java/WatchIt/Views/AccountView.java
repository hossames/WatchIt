package WatchIt.Views;

import WatchIt.Application;
import WatchIt.Controllers.Content.ContentCardController;
import WatchIt.Controllers.Content.GenreCardController;
import javafx.fxml.FXMLLoader;
import src.DataBase.DataObject;

public class AccountView {
    public static FXMLLoader AccountController() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Account/Account.fxml"));
        return fxmlLoader;
    }
    public static FXMLLoader GenreCard(String content) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Content/GenreCard.fxml"));
//        if(content != null)
        fxmlLoader.setController(new GenreCardController(content));
        return fxmlLoader;
    }
}
