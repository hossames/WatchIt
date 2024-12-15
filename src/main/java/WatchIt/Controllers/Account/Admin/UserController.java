package WatchIt.Controllers.Account.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import src.AccountControl.Admin;
import src.AccountControl.User;
import src.DataBase.DataBase;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fill the list of users
        ArrayList<User> users = (ArrayList<User>) DataBase.getInstance().usersData.getData();
        ArrayList<Admin> admins = (ArrayList<Admin>) DataBase.getInstance().adminsData.getData();
        users.stream()
          .forEach(usr-> listOfUsers.getItems().add(usr.getUserName()));
        admins.stream()
          .forEach(admin-> listOfAdmins.getItems().add(admin.getUserName()));
    }

    @FXML
    private ListView<String> listOfUsers,listOfAdmins;

    @FXML
    void addAdmin(MouseEvent event) {
        // make the selected user admin
        Admin admin;
        User user = DataBase.getInstance().usersData.getDataById((long) listOfUsers.getSelectionModel().getSelectedIndex()+1);
        listOfUsers.getItems().remove(listOfUsers.getSelectionModel().getSelectedIndex());
        //System.out.println(list.getSelectionModel().getSelectedIndex()+1);
        admin = new Admin(user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getFavoriteName());
        DataBase.getInstance().adminsData.addData(admin);
        listOfAdmins.getItems().add(admin.getUserName());
        DataBase.getInstance().usersData.removeData(user);
        DataBase.getInstance().Save();
    }

    @FXML
    void removeUser(MouseEvent event) {
        listOfUsers.getItems().remove(listOfUsers.getSelectionModel().getSelectedIndex());
        DataBase.getInstance().usersData.removeData(DataBase.getInstance().usersData.getDataById((long) listOfUsers.getSelectionModel().getSelectedIndex()+1));
        DataBase.getInstance().Save();
    }
    @FXML
    void removeAdmin(MouseEvent event){
        listOfAdmins.getItems().remove(listOfAdmins.getSelectionModel().getSelectedIndex());
        DataBase.getInstance().adminsData.removeData(DataBase.getInstance().adminsData.getDataById((long) listOfAdmins.getSelectionModel().getSelectedIndex()+1));
        DataBase.getInstance().Save();
    }
}
