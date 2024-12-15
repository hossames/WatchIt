package WatchIt.Controllers.Content;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GenreCardController {

    @FXML
    private Label genre;

    String genreName;
    public GenreCardController(String genreName){
        this.genreName=genreName;
    }
    public void initialize() {
        genre.setText(genreName);
    }
}