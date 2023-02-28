package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The TakeAwayApplication class is responsible for launching the application and setting up the main stage
 * for the takeaway ordering system. It extends the Application class from the JavaFX library.
 *
 * This class loads the main FXML file and sets up a scene for it. It also sets the title of the stage, and
 * initializes the ViewSwitcher which is used for navigating between different views of the application.
 *
 * To launch the application, simply call the main method which in turn calls the launch method from the
 * Application class.
 */
public class TakeAwayApplication extends Application {

    /**
     * Starts the JavaFX application by setting up the main stage and showing it.
     *
     * @param stage the primary stage for the JavaFX application
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TakeAwayApplication.class.getResource("pontun-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Matseðill");
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.PONTUN);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method that launches the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}