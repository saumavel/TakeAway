package vinnsla;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Represents a shopping cart for the restaurant's menu items.
 * It extends the Matsedill class and overrides the observable list of Veitingar to add the functionality of a cart.
 * The class contains methods for updating the cart's total price and emptying the cart.
 * It also includes a main method for testing purposes.
 */
public class Karfa extends Matsedill {
    private final IntegerProperty heildarVerd = new SimpleIntegerProperty(0);

    /**
     * Constructs an empty shopping cart.
     * Sets the observable list of Veitingar to a new, empty list and listens for changes to update the cart's total price.
     */
    public Karfa() {
        this.veitingar = FXCollections.observableArrayList(); // Create a new, empty list
        veitingar.addListener((ListChangeListener<Veitingar>) change -> updateVerd());
        updateVerd();
    }

    /**
     * Removes all items from the shopping cart and updates the cart's total price.
     */
    public void taemaKorfu() {
        veitingar.clear();
        updateVerd();
    }

    /**
     * Returns the IntegerProperty object for the cart's total price.
     *
     * @return the IntegerProperty object for the cart's total price
     */
    public IntegerProperty getTotalPriceProperty() {
        return heildarVerd;
    }

    /**
     * Returns the cart's total price as an integer.
     *
     * @return the cart's total price as an integer
     */
    public int getHeildarVerd() {
        return heildarVerd.get();
    }

    /**
     * Updates the cart's total price based on its current contents.
     */
    private void updateVerd() {
        int total = 0;
        for (Veitingar veiting : veitingar) {
            total += veiting.getVerd();
        }
        heildarVerd.set(total);
    }

    /**
     * The main method is used for testing purposes.
     * It creates a Matsedill object and a Karfa object, adds items to the cart, and prints the cart's total price.
     *
     * @param args the command line arguments
     */
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
