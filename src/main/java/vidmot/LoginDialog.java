package vidmot;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import vinnsla.Vidskiptavinur;

/**
 * The LoginDialog class is responsible for displaying a dialog box that allows the user to
 * enter their password to log in to the takeaway ordering system. It extends the TextInputDialog
 * class from the JavaFX library.
 *
 * This class creates a custom dialog box with a text field for the user's name and a password
 * field for their password. It also sets up an event handler for the "Sign In" button which creates
 * a new Vidskiptavinur object and switches to the main ordering screen if the entered password
 * is correct.
 */
public class LoginDialog extends TextInputDialog {

    private TextField nameLabel;

    /**
     * Initializes the LoginDialog by setting the title and header text, creating the text
     * field and password field, and setting up the event handler for the "Sign In" button.
     */
    public LoginDialog() {
        super();
        init();
    }

    private void init() {
        this.setTitle("Login Dialog");
        this.setHeaderText("Sláðu inn lykilorð.");

        // Create text field for name
        nameLabel = new TextField("Kári Einarsson");

        // Create password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Lykilorð");

        // Set custom content for dialog
        GridPane grid = new GridPane();
        grid.add(nameLabel, 0, 0);
        grid.add(passwordField, 0, 1);
        this.getDialogPane().setContent(grid);

        // Remove the default "OK" button
        this.getDialogPane().getButtonTypes().clear();

        // Add custom "Sign In" button and set event handler
        ButtonType okButtonType = new ButtonType("Skrá inn", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().add(okButtonType);

        // Add custom "Sign In" button and set event handler
        this.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                new Vidskiptavinur(String.valueOf(nameLabel.getText()), "Hringbraut 58");
                PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
                pontunController.buttonPusher();

            }
            return null;
        });
    }
}

