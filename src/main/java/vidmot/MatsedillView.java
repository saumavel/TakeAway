package vidmot;
import javafx.fxml.FXMLLoader;
import vinnsla.*;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
/**
 * A custom JavaFX ListView for displaying a menu of food items.
 *
 * This class extends the JavaFX ListView class and provides functionality for displaying a list of
 * food items using the Matsedill data model. The MatsedillView class is responsible for loading the
 * associated FXML file, initializing the Matsedill data model, and populating the list view with
 * the food items in the menu.
 *
 * The MatsedillView class also provides a reference to the Matsedill data model, which can be used
 * by other classes to access the menu items and perform operations on them.
 *
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
public class MatsedillView extends ListView {
    @FXML
    private ListView<Veitingar> veitingarList;

    @FXML
    private Matsedill matsedill;

    public MatsedillView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/matsedill-view.fxml"));
        fxmlLoader.setRoot(this); //Rótin á viðmótstré
        fxmlLoader.setController(this); //Controller settur hér en ekki í fxml skránni

        try {
            fxmlLoader.load(); //Viðmótstré lesið inn(þe. fxml skráin)
        } catch (IOException exeption) {
            throw new RuntimeException(exeption);
        }

        matsedill = new Matsedill();
        matsedill.setjaGogn();
        veitingarList.setItems(matsedill.getVeitingar());
    }
}
