package WatchIt.Controllers.Account.Client;

import WatchIt.Views.ClientView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.ContentControl.Content;
import src.ContentControl.Movie;
import src.ContentControl.Series;
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
        List <Movie> Movies =  recommendationEngine.getMovieBasedRecommendations();
        List <Series> Series =  recommendationEngine.getSeriesBasedRecommendations();
        for (int i = 0; i < 10; i++) {
            try {
                if(i < Movies.size()) {
                    System.out.println(Movies.size());
                    Content movie = Movies.get(i);
                    Node NodeMovies = ClientView.ContentCard(movie).load();
                    NodeMovies.setOnMouseClicked(event -> handlePosterClick(movie, event));
                    MoviesHBox.getChildren().add(NodeMovies);
                }
                if(i < Series.size()) {
                    Series series = Series.get(i);
                    Node NodeSeries = ClientView.ContentCard(series).load();
                    //NodeSeries.setOnMouseClicked(event -> handlePosterClick(series, event));
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
    private void handlePosterClick(Content movie, MouseEvent event) {
        try {
            FXMLLoader loader = ClientView.ContentMenu(movie);
            Parent content = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(content);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading movie menu: " + e.getMessage());
        }
    }
    //-----------------------------------------------------------//

}

