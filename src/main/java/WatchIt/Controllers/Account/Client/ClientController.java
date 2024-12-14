package WatchIt.Controllers.Account.Client;

import WatchIt.Views.ClientView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import src.ContentControl.Movie;
import src.DataBase.DataObject;
import src.Engines.RecommendationEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientController {

    @FXML
    private Button Button;

    @FXML
    private ImageView MyimageView;

    @FXML
    private TextField field;

    protected String Title;
    public void SearchButton(MouseEvent event) {
        Title = field.getText();
        System.out.println(Title);
    }
    //-----------------------------------------------------------//
    @FXML
    public void initialize() {
        // Automatically called after FXML is loaded
        AddItemToHBox();
    }
    @FXML
    HBox MoviesHBox;
    @FXML
    HBox SeriesHBox;
    public void AddItemToHBox() {
        RecommendationEngine recommendationEngine = new RecommendationEngine();
        List Movies =  recommendationEngine.getMovieBasedRecommendations();
        List Series =  recommendationEngine.getSeriesBasedRecommendations();
        for (int i = 0; i < 10; i++) {
            try {
                if(i < Movies.size()) {
                    System.out.println(Movies.size());
                    Node NodeMovies = ClientView.ContentCard((DataObject) Movies.get(i)).load();
                    MoviesHBox.getChildren().add(NodeMovies);
                }
                if(i < Series.size()) {
                    Node NodeSeries = ClientView.ContentCard((DataObject) Series.get(i)).load();
                    SeriesHBox.getChildren().add(NodeSeries);
                }
            }
            catch (IOException e){
                e.printStackTrace(); // This will print the full exception
                System.out.println("Error loading ContentCard: " + e.getMessage());
                return;
            }
        }
    }
    //-----------------------------------------------------------//

//            Label newLabel = new Label("New Node");
//            hbox.getChildren().add(newLabel);
//    List nodelist = new ArrayList();
//    public void getData(List<DataObject> dataList) {
//        nodelist = dataList;
//    }
//    RecommendationEngine recommendationEngine;

}

