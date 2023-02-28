package vidmot;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import vinnsla.Vidskiptavinur;

/**
 * The VidskiptavinurDialog class is responsible for displaying a dialog box that allows the user
 * to enter information for a new customer. It extends the Dialog class from the JavaFX library.
 *
 * This class contains a username field, an address field, and two buttons for submitting or
 * cancelling the dialog. It also includes event handlers for the button clicks, which create
 * a new Vidskiptavinur object based on the entered information and switch the view to the main
 * ordering screen.
 */
public class VidskiptavinurDialog extends Dialog<Vidskiptavinur> {
    @FXML
    private TextField fxUsername;
    @FXML
    private TextField fxHeimilisfang;
    @FXML
    private Button fxSkraInnTakki;

    /**
     * Initializes the VidskiptavinurDialog by binding the "Sign In" button's disabled property to
     * the text properties of the username and address fields. This ensures that the button cannot
     * be clicked until both fields have been filled in.
     */
    public void initialize() {
        fxSkraInnTakki.disableProperty().bind(Bindings.isEmpty(fxUsername.textProperty()).or(Bindings.isEmpty(fxHeimilisfang.textProperty())));
    }

    /**
     * Event handler for the "Sign In" button. Creates a new Vidskiptavinur object based on the entered
     * information and switches the view to the main ordering screen.
     */
    @FXML
    private void fxSkraInnTakki() {
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        pontunController.buttonPusher();
        Vidskiptavinur vidskiptavinur = new Vidskiptavinur();
        vidskiptavinur.setNafn(fxUsername.getText());
        vidskiptavinur.setHeimilisfang(fxHeimilisfang.getText());
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Event handler for the "Cancel" button. Closes the dialog without creating a new customer object
     * or switching the view.
     */
    @FXML
    private void fxHaettaVidTakki() {
        ViewSwitcher.switchTo(View.PONTUN);
    }

}
