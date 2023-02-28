package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Matsedill {
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    public Matsedill() {
        setjaGogn();
    }

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

    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }
}