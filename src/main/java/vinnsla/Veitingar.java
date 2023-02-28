package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */

/**
 * Klasi sem inniheldur mat og verð!
 */
public class Veitingar {
    private StringProperty matur = new SimpleStringProperty();
    private IntegerProperty verd = new SimpleIntegerProperty();
    private StringProperty flokkur = new SimpleStringProperty();

    /**
     * setur Margarita Pizzuna og verð í viðeigandi property.
     * @return a string in the format "<i>food item</i> : <i>price</i>kr"
     */
    public Veitingar(){
        matur.set("Margarita Pizza");
        verd.set(2990);
    }
    /**
     * @return Streng í því formi sem við viljum."
     */
    public String toString(){
        return matur.get() + " : " + verd.get() + "kr";
    }
    public void setMatur(StringProperty matur){
        this.matur.bind(matur);
    }

    public void setVerd(IntegerProperty verd) {
        this.verd.bind(verd);
    }

    public String getMatur() {
        return matur.get();
    }

    public StringProperty maturProperty() {
        return matur;
    }

    public int getVerd() {
        return verd.get();
    }

    public IntegerProperty verdProperty() {
        return verd;
    }
    public void setFlokkur(StringProperty flokkur) {
        this.flokkur.bind(flokkur);
    }

    public String getFlokkur() {
        return flokkur.get();
    }

    public StringProperty flokkurProperty() {
        return flokkur;
    }
}
