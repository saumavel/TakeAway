package vidmot;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import vinnsla.Vidskiptavinur;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
public class VidskiptavinurDialog extends Dialog<Vidskiptavinur> {
    @FXML
    private TextField fxUsername;
    @FXML
    private TextField fxHeimilisfang;

    @FXML
    private Button fxSkraInnTakki;

    public void initialize() {
        fxSkraInnTakki.disableProperty().bind(Bindings.isEmpty(fxUsername.textProperty()).or(Bindings.isEmpty(fxHeimilisfang.textProperty())));
    }
    @FXML
    public void fxSkraInnTakki(ActionEvent actionEvent) {
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        pontunController.buttonPusher();
        Vidskiptavinur vidskiptavinur = new Vidskiptavinur();
        vidskiptavinur.setNafn(fxUsername.getText().toString());
        vidskiptavinur.setHeimilisfang(fxHeimilisfang.getText().toString());
        ViewSwitcher.switchTo(View.PONTUN);

    }
    @FXML
    public void fxHaettaVidTakki(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.PONTUN);
    }

}
