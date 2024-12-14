package WatchIt.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewFactory {
    public boolean type;
    public Stage PrimaryStage;
    public ViewFactory() {
        this.type = type;
        PrimaryStage = new Stage();
        PrimaryStage.initStyle(StageStyle.UNDECORATED);
    }
    public void Show(FXMLLoader ShowingScene){
        try {
            Scene scene = new Scene(ShowingScene.load());
            PrimaryStage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error: while rendering view");
        }
        PrimaryStage.show();
    }
    public void setType(boolean type){
        this.type = type;
    }
}
