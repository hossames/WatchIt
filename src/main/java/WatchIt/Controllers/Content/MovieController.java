package WatchIt.Controllers.Content;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import src.ContentControl.Content;
import src.ContentControl.Movie;
import src.DataBase.DataObject;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class MovieController {

    @FXML
    Label ContentName, Language, Duration, Country, ReleaseDate, Genres, Views, Rate;
    @FXML
    ImageView poster;

    Content movie;

    public MovieController(Content movie){
        this.movie = movie;
    }

    public void initialize(){
        ContentName.setText(movie.contentTitle);
        Language.setText(movie.language);
//        Duration.setText(String.valueOf(movie.));
        Country.setText(movie.country);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        ReleaseDate.setText(formatter.format((TemporalAccessor) movie.datePublished));
        for(String genre: movie.genres)
            Genres.setText(genre + " ");
//        Views.setText(movie.);
        Rate.setText(String.valueOf(movie.TotalRate()));
        try {
            poster.setImage(movie.poster);
        }catch (Exception e){
            System.out.println("nulllllllllll");
        }
    }











}
