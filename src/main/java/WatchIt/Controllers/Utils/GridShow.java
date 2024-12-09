package WatchIt.Controllers.Utils;

import WatchIt.Models.Model;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class GridShow {
    GridPane grid = new GridPane();
    public GridShow(List<HBox>data){
        grid.setHgap(10);
        grid.setVgap(10);
        int cols = (int)(Model.getInstance().getViewFactory().PrimaryStage.getWidth()/(data.get(0).getWidth()));
        for(int i=0;i<data.size();i++){
            grid.add(data.get(i), i%cols, i/cols);
        }
    }
    public GridPane getGrid(){
        return grid;
    }
}
