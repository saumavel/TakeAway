package vidmot;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.fxml.FXMLLoader;
import vinnsla.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.IOException;

/**
 * The MatsedillView class is a custom JavaFX ListView that is used to display the menu of items
 * available for ordering in the takeaway ordering system. It extends the ListView class and
 * contains functionality for populating the list with items from the Matsedill class.
 */
public class MatsedillView extends ListView {
    @FXML
    private ListView<Veitingar> veitingarList;

    @FXML
    private final Matsedill matsedill;

    /**
     * Initializes the MatsedillView by loading the FXML file and setting the root and controller,
     * creating a new Matsedill object and populating the ListView with items from that object.
     */
    public MatsedillView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/matsedill-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exeption) {
            throw new RuntimeException(exeption);
        }

        matsedill = new Matsedill();
        matsedill.setjaGogn();
        veitingarList.setItems(matsedill.getVeitingar());
    }
}
