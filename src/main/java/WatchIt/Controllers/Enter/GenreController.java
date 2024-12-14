package WatchIt.Controllers.Enter;
import WatchIt.Models.Model;
import WatchIt.Views.MainView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenreController {
    public BorderPane GenreChoose;
    public List<String>SelectedGenre = new ArrayList<String>();
    String FirstName,LastName,UserName,Email,Password,FavName;
    public GenreController(String FirstName, String LastName,String UserName,String Email,String Password,String FavName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.FavName = FavName;
    }

    double mousePressedX,mousePressedY;

    //init Fx
    public void initialize() {
        try {
            GenreChoose.setTop(MainView.TitleBar().load());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void Choose(MouseEvent event) {
        HBox parent = (HBox) event.getSource();
        Text txt = (Text)parent.getChildren().getFirst();
        if(SelectedGenre.contains(txt.getText())) {
            SelectedGenre.remove(txt.getText());
            parent.getStyleClass().remove("borderd");
        }else {
            SelectedGenre.add(txt.getText());
            parent.getStyleClass().add("borderd");
        }
    }

    public void Submit(MouseEvent event) {
        Model.getInstance().getViewFactory().Show(MainView.SubscriptionPlan(FirstName,LastName,UserName,Email,Password,FavName,SelectedGenre));
    }
    public void Register(){
        Model.getInstance().getViewFactory().Show(MainView.RegisterScene());
    }

}
