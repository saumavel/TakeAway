package vidmot;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vinnsla.Karfa;
import vinnsla.Vidskiptavinur;

/**
 * The GreidslaController class is responsible for handling the payment and order confirmation
 * process in the takeaway ordering system. It contains buttons for confirming the order and
 * processing payment, as well as a label for displaying the total cost of the order and the
 * expected delivery time.
 *
 * This class retrieves information about the customer and their order from the Vidskiptavinur and
 * Karfa classes, respectively. It also updates the cart and switches back to the main ordering
 * screen after payment has been processed.
 */
public class GreidslaController{
    @FXML
    private Button fxStadfestaButton;
    @FXML
    private Button fxGreidaButton;

    /**
     * Initializes the GreidslaController by retrieving the customer and cart information and
     * displaying it in the payment confirmation dialog.
     */
    public void initialize(){
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        Vidskiptavinur vidskiptavinur = new Vidskiptavinur();
        fxLabel.setText(vidskiptavinur.getNafn() + " karfan þín kostar " +
                pontunController.getKarfaVerd() + " kr. Þetta verður afhent á " +
                vidskiptavinur.getHeimilisfang() + " eftir 45 mínútur");
    }
    @FXML
    private Label fxLabel;

    /**
     * Event handler for the "Cancel" button. Switches back to the main ordering screen without
     * processing payment or updating the cart.
     */
    @FXML
    private void fxHaettaVidButton() {
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Event handler for the "Confirm Order" button. Enables the "Process Payment" button.
     */
    @FXML
    public void fxStadfestaButton() {
        // enable the fxGreidaButton after fxStadfestaButton is clicked
        fxGreidaButton.setDisable(false);
        fxStadfestaButton.setDisable(true);
    }

    /**
     * Event handler for the "Process Payment" button. Updates the cart, clears it, and switches
     * back to the main ordering screen.
     */
    @FXML
    public void fxGreidaButton() {
        fxGreidaButton.setDisable(true);
        fxStadfestaButton.setDisable(false);
        Karfa karfa = new Karfa();
        karfa.setjaGogn();
        karfa.taemaKorfu();
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        pontunController.getKarfa().taemaKorfu(); // empty the cart
        ViewSwitcher.switchTo(View.PONTUN);
    }
}
