package WatchIt.Controllers.Account;

import WatchIt.Views.AccountView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import src.AccountControl.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AccountController {

    @FXML
    private Text discription,email,endDate,favName,fullName , plan , price , startDate , userName;

    @FXML
    private HBox favoriteGeners;

    User user;
    public AccountController(User user){
        this.user=user;
    email.setText(user.getEmail());
    discription.setText(user.getSubscriptionPlan().getDescription());
    favName.setText(user.getFavoriteName());
    fullName.setText(user.getName(3));
    plan.setText(user.getSubscriptionPlan().getPlan());
    userName.setText(user.getUserName());
    price.setText(String.valueOf(user.getSubscriptionPlan().getPrice()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(user.getSubscriptionPlan().getStartDate());
    startDate.setText(formattedDate);
        formattedDate = sdf.format(user.getSubscriptionPlan().getEndDate());
        endDate.setText(formattedDate);
    }

    public void initialize() {
        // Automatically called after FXML is loaded
        AddItemToHBox();

    }
    public void AddItemToHBox()  {
        try{
            List<String> geners = user.getFavoriteGenres();
            for(int i =0;i<geners.size();i++){
                Node node = AccountView.GenreCard(geners.get(i)).load();
                favoriteGeners.getChildren().add(node);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
