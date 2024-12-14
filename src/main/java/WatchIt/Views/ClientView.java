package WatchIt.Views;

import WatchIt.Application;
import WatchIt.Controllers.Account.Admin.AdminMenuController;
import WatchIt.Controllers.Account.Client.ClientController;
import WatchIt.Controllers.Content.ContentCardController;
import javafx.fxml.FXMLLoader;
import src.DataBase.DataObject;

public class ClientView {

    public static FXMLLoader ClientMenuControllerScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Account/Client/Client.fxml"));
        return fxmlLoader;
    }
    /// ///////////////////////
    public static FXMLLoader ContentCard(DataObject content) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Application.class.getResource("/Fxml/Content/ContentCard.fxml"));
//        if(content != null)
        fxmlLoader.setController(new ContentCardController(content));
        return fxmlLoader;
    }

}
