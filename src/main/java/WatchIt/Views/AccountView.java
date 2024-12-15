package WatchIt.Views;

import WatchIt.Application;
import WatchIt.Controllers.Account.AccountController;
import WatchIt.Controllers.Content.ContentCardController;
import WatchIt.Controllers.Content.GenreCardController;
import javafx.fxml.FXMLLoader;
import src.AccountControl.User;
import src.DataBase.DataBase;
import src.DataBase.DataObject;

public class AccountView {
    public static FXMLLoader AccountController(User user) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Account/Account.fxml"));
        fxmlLoader.setController(new AccountController(user));
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
