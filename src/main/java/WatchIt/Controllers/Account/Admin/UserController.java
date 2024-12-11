package WatchIt.Controllers.Account.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fill the list of users
    }

    @FXML
    private ListView<String> list;

    @FXML
    void addAdmin(MouseEvent event) {
        // make the selected user admin
    }

    @FXML
    void removeUser(MouseEvent event) {
        list.getItems().remove(list.getSelectionModel().getSelectedIndex());
    }

}
