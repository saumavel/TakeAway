package vidmot;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.*;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class LoginDialog extends TextInputDialog {

    private Label nameLabel;
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
        this.setHeaderText("Please enter your credentials.");

        // Create label for name
        nameLabel = new Label("Name: Kári Einarsson");

        // Create password field
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        // Set custom content for dialog
        GridPane grid = new GridPane();
        grid.add(nameLabel, 0, 0);
        grid.add(getEditor(), 1, 0);
        grid.add(passwordField, 1, 1);
        this.getDialogPane().setContent(grid);

    }
}
