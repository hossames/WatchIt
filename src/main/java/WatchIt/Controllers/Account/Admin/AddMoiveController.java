package WatchIt.Controllers.Account.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.Cast.CastMember;
import src.ContentControl.Movie;
import src.DataBase.DataBase;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddMoiveController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          genres.getItems().addAll(
                  "Action", "Adventure", "Comedy", "Drama", "Horror",
                  "Romance", "Science Fiction", "Fantasy", "Mystery",
                  "Thriller", "Documentary", "Animation", "Family",
                  "Musical", "Crime", "Historical", "War", "Western");
        ArrayList<CastMember> Cast = (ArrayList<CastMember>)DataBase.getInstance().castMemberData.getData();
        Cast.stream()
                .forEach(cast->castMembers.getItems().add(cast.firstName+" "+cast.lastName));
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
    private TextField director;
    @FXML
    private DatePicker date;
    @FXML
    void addCastMember(MouseEvent event) {
        addedCastMember.add(castMembers.getSelectionModel().getSelectedItem());
    }
    ArrayList<String> addedGenre = new ArrayList<>();
    ArrayList<String> addedCastMember = new ArrayList<>();
    @FXML
    void addGenre(MouseEvent event) {
        addedGenre.add(genres.getSelectionModel().getSelectedItem());
    }
    @FXML
    void addMovie(MouseEvent event) {
        DataBase.getInstance().moviesData.addData(new Movie(content.getText(),language.getText(),country.getText(),"test",Integer.valueOf(budget.getText()).intValue(),Integer.valueOf(revenue.getText()).intValue(),Integer.valueOf(duration.getText()).intValue(),addedGenre,addedCastMember,java.util.Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())));
        DataBase.getInstance().Save();
    }
}
