package vinnsla;

import javafx.beans.Observable;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Karfa extends Matsedill {
    private IntegerProperty heildarVerd = new SimpleIntegerProperty(0);

    public Karfa() {
        this.veitingar = FXCollections.observableArrayList(); // Create a new, empty list
        veitingar.addListener((ListChangeListener<Veitingar>) change -> updateVerd());
        updateVerd();
    }
    public void takaUr(Veitingar veiting) {
        if (veiting != null) {
            veitingar.remove(veiting);
            updateVerd();
        }
    }
    public void taemaKorfu() {
        veitingar.clear();
        updateVerd();
    }

    public IntegerProperty getTotalPriceProperty() {
        return heildarVerd;
    }

    public int getHeildarVerd() {
        return heildarVerd.get();
    }

    private void updateVerd() {
        int total = 0;
        for (Veitingar veiting : veitingar) {
            total += veiting.getVerd();
        }
        heildarVerd.set(total);
    }
    public static void main(String[] args) {
        Matsedill matsedill = new Matsedill();


        System.out.println("Matsedill:");
        for (Veitingar veiting : matsedill.veitingar) {
            System.out.println(veiting);
        }

        Karfa karfa = new Karfa();
        karfa.setjaGogn();

        System.out.println("Karfa:");
        for (Veitingar veiting : karfa.veitingar) {
            System.out.println(veiting);
        }

        System.out.println("Total price: " + karfa.getHeildarVerd());
    }


}
