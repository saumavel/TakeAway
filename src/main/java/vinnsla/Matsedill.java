package vinnsla;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Matsedill class represents a menu of dishes available for ordering.
 * It contains a list of Veitingar objects that represent the individual dishes.
 **/
public class Matsedill {

    /**
     * The list of dishes available for ordering.
     */
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    /**
     * Constructs a new Matsedill object and calls the setjaGogn method to set up the list of dishes.
     */
    public Matsedill() {
        setjaGogn();
    }

    /**
     * Sets up the list of dishes available for ordering.
     */
    public void setjaGogn() {
        String[] rettir = {"Pizza með pepperóní", "Ostahamborgari", "Pulsa með öllu", "Makkarónur með tómatsósu", "Double Spagetti", "Glas af mysu", "Súperdós af appelsín", "Hlandvolgt vatnsglas", "Franskar", "Súper Nachos", "Popp", "Útrunnin sviðasulta"};
        int[] verd = {3490, 2290, 590, 1800, 15000, 240, 500, 49, 400, 1000, 2245, 39};

        for (int i = 0; i < rettir.length; i++) {
            Veitingar veiting = new Veitingar();
            veiting.setMatur(new SimpleStringProperty(rettir[i]));
            veiting.setVerd(new SimpleIntegerProperty(verd[i]));
            veitingar.add(veiting);
        }
    }

    /**
     * Returns the list of dishes available for ordering.
     *
     * @return The list of dishes available for ordering.
     */
    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }
}