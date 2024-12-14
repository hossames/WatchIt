package WatchIt.Controllers.Content;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import src.ContentControl.Movie;
import src.DataBase.DataBase;
import src.DataBase.DataObject;



public class ContentCardController {

    @FXML
    ImageView poster;


    @FXML
    private Label ContentName;

    DataObject content;

    public ContentCardController(DataObject content) {
        this.content = content;

    }

    public void initialize() {
        ContentName.setText(content.getName(2));
        poster.setImage(content.getImage());
    }
}
