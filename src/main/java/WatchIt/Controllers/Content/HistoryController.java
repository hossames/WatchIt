package WatchIt.Controllers.Content;

import WatchIt.Views.HistoryView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import src.AccountControl.User;
import src.ContentControl.Content;
import src.ContentControl.Movie;
import src.ContentControl.Series;
import src.DataBase.DataBase;
import src.DataBase.DataObject;

import java.io.IOException;
import java.util.List;

public class HistoryController {
    @FXML
      private HBox moviesBox;

    @FXML
     private HBox seriesBox;
    User user;

    public HistoryController(User user) {
        this.user=user;
    }

    public void initialize() {
        AddItemToHBox();
    }

    private void AddItemToHBox() {
        try {
            List<String> history = user.getHistory();
            DataBase data = new DataBase();
            List<Movie> movieList = data.moviesData.getData();
            List<Series> seriesList = data.seriesData.getData();
            Content content;
            Node node;
            for (int i = 0; i < history.size(); i++) {
                boolean found = false;
                for (var mov : movieList) {
                    if (mov.getName(2) == history.get(i)) {
                        found = true;
                        content = mov;
                        node = HistoryView.ContentCard(content).load();
                        moviesBox.getChildren().add(node);
                        break;
                    }
                }
                if (!found) {
                    for (var ser : seriesList) {
                        if (ser.getName(2) == history.get(i)) {
                            found = true;
                            content = ser;
                            node = HistoryView.ContentCard(content).load();
                            seriesBox.getChildren().add(node);
                            break;
                        }
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println("Error Loading Histroy");
        }
    }
}
