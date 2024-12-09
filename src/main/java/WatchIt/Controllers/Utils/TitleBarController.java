package WatchIt.Controllers.Utils;


import WatchIt.Models.Model;
import javafx.scene.input.MouseEvent;

public class TitleBarController {
    public void CloseButton(MouseEvent e){
        Model.getInstance().getViewFactory().PrimaryStage.close();
    }
}
