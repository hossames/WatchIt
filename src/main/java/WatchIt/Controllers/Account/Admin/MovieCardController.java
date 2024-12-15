package WatchIt.Controllers.Account.Admin;

import WatchIt.Views.AdminView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import src.AccountControl.User;
import src.ContentControl.Movie;
import src.DataBase.DataBase;

import java.util.ArrayList;
import java.util.List;

public class MovieCardController {

    @FXML
    private AnchorPane movieCard;

    @FXML
    private ImageView movieImage;

    @FXML
    private Label movieName;

    @FXML
    private FontAwesomeIcon s1;
   @FXML
    private FontAwesomeIcon s2;
   @FXML
    private FontAwesomeIcon s3;

    @FXML
    private FontAwesomeIcon s4;

    @FXML
    private FontAwesomeIcon s5;

    ArrayList<Movie> movies = (ArrayList<Movie>) DataBase.getInstance().moviesData.getData();
    @FXML
    void Remove(MouseEvent event) {
        DataBase.getInstance().moviesData.removeData(movies.get(cnt));
        DataBase.getInstance().Save();
        cnt--;
    }
    public static int cnt = 0;
    @FXML
    void initialize() {
        movieName.setText(movies.get(cnt).getName(0));
        movieImage.setImage(movies.get(cnt).getImage());
        s1.setStroke(Color.GOLD);
        s2.setStroke(Color.GOLD);
        s3.setStroke(Color.GOLD);
        s4.setStroke(Color.GOLD);
        s5.setStroke(Color.GOLD);
        cnt++;
    }

}
