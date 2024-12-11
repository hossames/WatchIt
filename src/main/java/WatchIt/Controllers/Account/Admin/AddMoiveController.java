package WatchIt.Controllers.Account.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.Cast.CastMember;
import src.ContentControl.Movie;
import src.DataBase.DataBase;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddMoiveController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          genres.getItems().addAll(
                  "Action", "Adventure", "Comedy", "Drama", "Horror",
                  "Romance", "Science Fiction", "Fantasy", "Mystery",
                  "Thriller", "Documentary", "Animation", "Family",
                  "Musical", "Crime", "Historical", "War", "Western");
          // fill the list of cast members
        }

    @FXML
    private TextField budget;

    @FXML
    private ChoiceBox<String> castMembers;

    @FXML
    private TextField content;

    @FXML
    private TextField country;

    @FXML
    private TextField duration;

    @FXML
    private ChoiceBox<String> genres;

    @FXML
    private TextField language;

    @FXML
    private TextField revenue;

    @FXML
    void addCastMember(MouseEvent event) {
    }
    ArrayList<String> addedGenre = new ArrayList<>();
    @FXML
    void addGenre(MouseEvent event) {
        addedGenre.add(genres.getSelectionModel().getSelectedItem());
    }
    @FXML
    void addMovie(MouseEvent event) {
        // create a movie and add it
       // DataBase.contentsData.addData(new Movie(content.getText(),language.getText(),country.getText(),null,0,0,0,addedGenre,null,null));
    }
}
