module watchit {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    //requires fontawesomefx;
    requires java.desktop;
    exports WatchIt;
    opens WatchIt.Controllers.Enter to javafx.fxml;
    opens WatchIt.Controllers.Account.Admin to javafx.fxml;
    opens WatchIt.Controllers.Account.Client to javafx.fxml;
    opens WatchIt.Controllers.Account to javafx.fxml;
    opens WatchIt.Controllers.Content to javafx.fxml;
    opens WatchIt.Controllers.Utils to javafx.fxml;
    opens WatchIt.Controllers.Cast to javafx.fxml;
    opens WatchIt.Views to javafx.fxml;
}