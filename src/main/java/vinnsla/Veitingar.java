package vinnsla;
/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Represents a food item in the menu, with a name and price.
 * Provides methods for getting and setting the name and price.
 */
public class Veitingar {
    private final StringProperty matur = new SimpleStringProperty();
    private final IntegerProperty verd = new SimpleIntegerProperty();

    /**
     * Constructs a new food item with default values.
     */
    public Veitingar(){
        matur.set("Margarita Pizza");
        verd.set(2990);
    }

    /**
     * Returns a string representation of the food item, in the format "name : pricekr".
     *
     * @return a string representation of the food item
     */
    public String toString(){
        return matur.get() + " : " + verd.get() + "kr";
    }

    /**
     * Sets the name of the food item.
     *
     * @param matur the name of the food item
     */
    public void setMatur(StringProperty matur){
        this.matur.bind(matur);
    }

    /**
     * Sets the price of the food item.
     *
     * @param verd the price of the food item
     */
    public void setVerd(IntegerProperty verd) {
        this.verd.bind(verd);
    }

    /**
     * Returns the name of the food item.
     *
     * @return the name of the food item
     */
    public String getMatur() {
        return matur.get();
    }

    /**
     * Returns the price of the food item.
     *
     * @return the price of the food item
     */
    public int getVerd() {
        return verd.get();
    }

}
