package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vinnsla.Karfa;
import vinnsla.Vidskiptavinur;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
public class GreidslaController{
    @FXML
    private Button fxStadfestaButton;
    @FXML
    private Button fxGreidaButton;

    public void initialize(){
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        Vidskiptavinur vidskiptavinur = new Vidskiptavinur();
        fxLabel.setText(vidskiptavinur.getNafn() + " karfan þín kostar " +
                pontunController.getKarfaVerd() + " kr. Þetta verður afhent á " +
                vidskiptavinur.getHeimilisfang() + " eftir 45 mínútur");
    }
    @FXML
    private Label fxLabel;
    @FXML
    private void fxHaettaVidButton(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.PONTUN);
    }
    @FXML
    public void fxStadfestaButton(ActionEvent actionEvent) {
        // enable the fxGreidaButton after fxStadfestaButton is clicked
        fxGreidaButton.setDisable(false);
        fxStadfestaButton.setDisable(true);
    }

    @FXML
    public void fxGreidaButton(ActionEvent actionEvent) {
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
