package src.Engines;

import src.AccountControl.User;
import src.ContentControl.Content;
import src.ContentControl.Movie;
import src.ContentControl.Series;
import src.DataBase.DataBase;

import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {
    private List<String> favouriteGenres;
    private Content[] content;
    public Content[] trending;

    public RecommendationEngine() {
        this.favouriteGenres = ((User) DataBase.getInstance().CurrentUser).getFavoriteGenres();
        this.content = DataBase.contentsData.getData().toArray(new Content[0]);
    }

    public List<Movie> getMovieBasedRecommendations() {
        List<Movie> movieBasedRecommendations = new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            if (content[i] instanceof Movie) {
                Movie movie = (Movie) content[i];
                for (int j = 0; j < favouriteGenres.size(); j++) {
                    if (movie.genres.contains(favouriteGenres.get(j))) {
                        movieBasedRecommendations.add(movie);
                        break;
                    }
                }
            }
        }

        return movieBasedRecommendations;
    }

    public List<Series> getSeriesBasedRecommendations() {
        List<Series> seriesBasedRecommendations = new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            if (content[i] instanceof Series) {
                Series series = (Series) content[i];
                for (int j = 0; j < favouriteGenres.size(); j++) {
                    if (series.genres.contains(favouriteGenres.get(j))) {
                        seriesBasedRecommendations.add(series);
                        break;
                    }
                }
            }
        }

        return seriesBasedRecommendations;
    }
}
