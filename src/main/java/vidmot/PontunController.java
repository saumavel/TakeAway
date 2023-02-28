package vidmot;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vinnsla.*;

/**
 * The PontunController class is the controller for the main view of the takeaway ordering system.
 * It handles user input, populates the menu and cart views, and updates the total price label.
 */
public class PontunController {
    @FXML
    private ListView matsedill;
    @FXML
    private ListView fxKarfa;
    @FXML
    private Button borgaButton;
    @FXML
    private Button innskraningButton;
    @FXML
    private Button nyrNotandiButton;
    @FXML
    private Label verdIKorfuLabel;
    private Karfa karfa;

    /**
     * Initializes the PontunController by populating the menu and cart views, setting up
     * event listeners, and binding the total price label to the Karfa object.
     */
    @FXML
    public void initialize() {
        Matsedill matsedillModel = new Matsedill();

        matsedill.setItems(matsedillModel.getVeitingar());

        matsedill.setCellFactory(param -> new VeitingarCell());

        this.karfa = new Karfa();

        matsedill.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                verdIKorfuLabel.setText("Bæta í körfu? " + ((Veitingar) newValue).getVerd() + " kr.");
            }
        });

        borgaButton.textProperty().bind(karfa.getTotalPriceProperty().asString("Borga (%d kr)"));

        fxKarfa.setItems(karfa.getVeitingar());

        fxKarfa.setCellFactory(param -> new VeitingarCell());

        fxKarfa.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                verdIKorfuLabel.setText("Taka úr körfu? " + ((Veitingar) newValue).getVerd() + " kr.");
            }
        });
    }

    /**
     * Handles the "Setja í körfu" button press event by adding the selected Veitingar item to the Karfa.
     */
    @FXML
    private void fxSetjaKorfuHandler(){
        Veitingar selected = (Veitingar) matsedill.getSelectionModel().getSelectedItem();
        if (selected != null) {
            fxKarfa.getItems().add(selected);
        }
    }

    /**
     * Handles the "Taka úr körfu" button press event by removing the selected Veitingar item from the Karfa.
     */
    @FXML
    private void fxTakaUrKorfuHandler() {
        Veitingar selected = (Veitingar) fxKarfa.getSelectionModel().getSelectedItem();
        if (selected != null) {
            fxKarfa.getItems().remove(selected);
        }
    }

    /**
     * Handles the "Innskráning" button press event by displaying the LoginDialog.
     */
    @FXML
    private void fxInnskraningHandler(){
        LoginDialog dialog = new LoginDialog();
        dialog.showAndWait();
    }

    /**
     * Handles the "Nýr notandi" button press event by switching to the VIDSKIPTAVINUR view.
     */
    @FXML
    private void fxNyrNotandihandler() {
        ViewSwitcher.switchTo(View.VIDSKIPTAVINUR);
    }

    /**
     * Handles the event of clicking on the "Borga" button. Switches the view to the payment view.
     */
    @FXML
    private void fxBorgaHandler() {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

    /**
     * Returns the total value of the cart.
     * @return the total value of the cart as an integer.
     */
    public int getKarfaVerd() {
        return karfa.getHeildarVerd();
    }

    /**
     * Returns the cart object.
     * @return the cart object.
     */
    public Karfa getKarfa() {
        return karfa;
    }

    /**
     * Sets the state of the "Borga", "Innskráning" and "Nýr notandi" buttons.
     * Called when a user logs in.
     */
    public void buttonPusher(){
        borgaButton.setDisable(false);
        innskraningButton.setDisable(true);
        nyrNotandiButton.setDisable(true);
    }

    /**
     *
     * Custom ListCell used to display items in the menu and in the cart.
     * @param <Veitingar> the type of the items to be displayed.
     */
    private class VeitingarCell extends ListCell<Veitingar> {
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