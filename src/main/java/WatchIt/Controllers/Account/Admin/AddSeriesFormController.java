package WatchIt.Controllers.Account.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.Cast.CastMember;
import src.DataBase.DataBase;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddSeriesFormController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genres.getItems().addAll(
                "Action", "Adventure", "Comedy", "Drama", "Horror",
                "Romance", "Science Fiction", "Fantasy", "Mystery",
                "Thriller", "Documentary", "Animation", "Family",
                "Musical", "Crime", "Historical", "War", "Western");
        ArrayList<CastMember> Cast = (ArrayList<CastMember>) DataBase.getInstance().castMemberData.getData();
        Cast.stream()
                .forEach(cast->castMembers.getItems().add(cast.firstName+" "+cast.lastName));
    }
    @FXML
    private Button add_btn;

    @FXML
    private Button add_cast_member;

    @FXML
    private Button add_genre;

    @FXML
    private TextField budget;

    @FXML
    private ChoiceBox<String> castMembers;

    @FXML
    private TextField country;

    @FXML
    private TextField director;

    @FXML
    private TextField duration;

    @FXML
    private DatePicker first_date;

    @FXML
    private ChoiceBox<String> genres;

    @FXML
    private TextField id;

    @FXML
    private CheckBox is_going;

    @FXML
    private DatePicker last_date;

    @FXML
    private TextField num_of_episodes;

    @FXML
    private TextField num_of_seasons;

    @FXML
    private TextField revenue;

    @FXML
    void addCastMember(MouseEvent event) {

    }

    @FXML
    void addGenre(MouseEvent event) {

    }

}
