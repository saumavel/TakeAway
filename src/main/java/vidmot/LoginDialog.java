package vidmot;

import javafx.scene.control.*;

import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import vinnsla.Vidskiptavinur;

import java.util.Optional;

public class LoginDialog extends TextInputDialog {

    private TextField nameLabel;
    private PasswordField passwordField;


    public LoginDialog() {
        super();
        init();
    }

    public LoginDialog(String username) {
        super(username);
        init();
    }

    private void init() {
        this.setTitle("Login Dialog");
        this.setHeaderText("Please enter your password.");

        // Create text field for name
        nameLabel = new TextField("Kári Einarsson");

        // Create password field
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        // Set custom content for dialog
        GridPane grid = new GridPane();
        grid.add(nameLabel, 0, 0);
        grid.add(passwordField, 0, 1);
        this.getDialogPane().setContent(grid);

        // Tekur út OK button
        this.getDialogPane().getButtonTypes().clear();

        // Setur event handler á nýja takkan okkar.
        ButtonType okButtonType = new ButtonType("Skrá inn", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().add(okButtonType);

        this.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                Vidskiptavinur Kari = new Vidskiptavinur(String.valueOf(nameLabel.getText()), "Hringbraut 58");
                PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
                pontunController.buttonPusher();

            }
            return null;
        });
    }

    public Optional<String> showDialog() {
        return this.showAndWait();
    }
}

