package WatchIt.Controllers.Account.Admin;

import WatchIt.Views.AdminView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import src.DataBase.DataBase;

import java.awt.*;
import java.io.IOException;

public class MovieController{
    private FXMLLoader fxmlLoader;

    public MovieController(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }

    @FXML
    public void initialize() {
        setGrid();
    }

    //   void goToAddMovie(MouseEvent event) {
    //  Model.getInstance().getViewFactory().Show(AdminView.AdminMenuControllerScene(AdminView.AddMovieControllerScene()));
//     }
    @FXML
    GridPane grid;
    int width = 100+20,totalWidth=1000;
    int cols=totalWidth/width;
    public void addToGrid(FXMLLoader loader) {
        try {
                if (cols > 0)
                    grid.add(loader.load(), grid.getChildren().size() % cols + 1, grid.getChildren().size() / cols);
                else
                    grid.add(loader.load(), 1, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    int sz = DataBase.getInstance().moviesData.getData().size();
    public void setGrid(){
        for(int i = 0; i < sz;i++){
            addToGrid(AdminView.MovieCardControllerScene());
        }
    grid.setHgap(20);
    grid.setVgap(20);
    MovieCardController.cnt=0;
    addToGrid(AdminView.PlusCardScene());
    }
}
