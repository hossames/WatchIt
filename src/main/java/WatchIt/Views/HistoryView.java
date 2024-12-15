package WatchIt.Views;

import WatchIt.Application;
import WatchIt.Controllers.Account.AccountController;
import WatchIt.Controllers.Content.ContentCardController;
import WatchIt.Controllers.Content.HistoryController;
import javafx.fxml.FXMLLoader;
import src.AccountControl.User;
import src.ContentControl.Content;
import src.DataBase.DataObject;

public class HistoryView {
    public static FXMLLoader ContentCard(Content content) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Content/ContentCard.fxml"));
        fxmlLoader.setController(new ContentCardController(content));
        return fxmlLoader;
    }

    public static FXMLLoader HistoryController(User ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Content/History.fxml"));
        fxmlLoader.setController(new HistoryController(ob));
        return fxmlLoader;
    }
}
