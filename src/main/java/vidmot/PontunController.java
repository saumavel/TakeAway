package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vinnsla.*;

import java.io.IOException;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */

/**
 * Controller klasi fyrir Pontun.fxml file, sem sýnir hvernig veitingar birtast á pöntunarglugga á matseðli.
 * This class is responsible for handling the user's interactions with the ordering screen and updating the display
 * accordingly.
 */
public class PontunController {
    /**
     * The ListView that displays the available menu items.
     */
    @FXML
    private ListView matsedill;

    /**
     * Sérhæfði klasinn sem birtir körfuna.
     */
    @FXML
    private ListView fxKarfa;

    @FXML
    private Button borgaButton;

    /**
     * The Label that displays the total price of the items in the user's cart.
     */
    @FXML
    private Label verdIKorfuLabel;

    /**
     * MatsedillView er hluturinn sem birtir matseðillinn
     */
    private MatsedillView matsedillView;
    /**
     * Karfan sem við setjum vörur í
     */
    private Karfa karfa;

    /**
     * Adds the selected item to the user's cart.
     * @param event The event that triggered the method call.
     */
    @FXML
    private void fxSetjaKorfuHandler(ActionEvent event){
        Veitingar selected = (Veitingar) matsedill.getSelectionModel().getSelectedItem();
        if (selected != null) {
            fxKarfa.getItems().add(selected);
        }
    }

    /**
     * Removes the selected item from the user's cart.
     * @param event The event that triggered the method call.
     */
    @FXML
    private void fxTakaUrKorfuHandler(ActionEvent event) {
        Veitingar selected = (Veitingar) fxKarfa.getSelectionModel().getSelectedItem();
        if (selected != null) {
            fxKarfa.getItems().remove(selected);
        }
    }
    /**
     *
     * @param event The event that triggered the method call.
     */
    @FXML
    private void fxInnskraningHandler(ActionEvent event){
        ViewSwitcher.switchTo(View.VIDSKIPTAVINUR);
    }
    @FXML
    private void fxNyrNotandihandler(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.VIDSKIPTAVINUR);
    }

    /**
     * Displays a message indicating that the user has completed their purchase.
     * @param event The event that triggered the method call.
     */
    @FXML
    private void fxBorgaHandler(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

    public int getKarfaVerd() {
        return karfa.getHeildarVerd();
    }

    public Karfa getKarfa() {
        return karfa;
    }


    public void buttonPusher(){
        borgaButton.setDisable(false);
    }

    /**
     * Initializes the ordering screen when it is first displayed.
     * Creates the data models for the menu and cart, sets up the displays of the ListViews, and adds a listener to
     * update the cart data model when the user selects an item in the menu ListView.
     */
    @FXML
    public void initialize() {
        // býr til viðmót fyrir matseðilinn
        Matsedill matsedillModel = new Matsedill();

        // Setur veitingar í list view til að sýna veitingarnar
        matsedill.setItems(matsedillModel.getVeitingar());

        // Segir til um hvernig gögn birtast í matsedill list view
        matsedill.setCellFactory(param -> new VeitingarCell());

        // býr til viðmót fyrir körfuna
        this.karfa = new Karfa();

        // Bætir við event listener á matsedill ListView til að uppfæra verdIKorfuLabel þegar notandi velur vöru
        matsedill.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                verdIKorfuLabel.setText("Bæta í körfu? " + ((Veitingar) newValue).getVerd() + " kr.");
            }
        });

        // Bindar textann á Borga button á total price property í körfunni
        borgaButton.textProperty().bind(karfa.getTotalPriceProperty().asString("Borga (%d kr)"));

        // Lætur körfuna okkar birtast í fxKarfa
        fxKarfa.setItems(karfa.getVeitingar());

        // Segir til um hvernig gögn birtast í fxKarfa list view
        fxKarfa.setCellFactory(param -> new VeitingarCell());

        // Bætir event listener á matsedill ListView til að uppfæra verdIKorfuLabel þegar notandi velur vöru
        fxKarfa.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                verdIKorfuLabel.setText("Taka úr körfu? " + ((Veitingar) newValue).getVerd() + " kr.");
            }
        });
    }
    /**
     * Custom cell factory to define how to display the items in the matsedill and fxKarfa list views.
     * Displays the name and price of a Veitingar object.
     */
    private class VeitingarCell extends ListCell<Veitingar> {
        /**
        Updates the text of the list cell to display the name and price of the given food item.
        If the item is empty or null, the text of the cell is set to null.
        @param item the food item to display
        @param empty whether the cell is empty
        */
        @Override
        protected void updateItem(Veitingar item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(item.getMatur() + " - " + item.getVerd() + " kr");
            }
        }
    }


}