package WatchIt.Controllers.Content;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.scene.image.WritableImage;
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
        poster.setPreserveRatio(true);
        poster.setImage(resizeImage(content.getImage(), 150,200));
    }

    public Image resizeImage(Image originalImage, double width, double height) {
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(originalImage, 0, 0, width, height);

        // Create a WritableImage to hold the resized image
        WritableImage resizedImage = new WritableImage((int) width, (int) height);
        canvas.snapshot(null, resizedImage);

        return resizedImage;
    }
}
