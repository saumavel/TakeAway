package vinnsla;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */

/**
 * A class representing a customer.
 */
public class Vidskiptavinur {
    private String nafn;
    private String heimilisfang;

    /**
     * Constructs a new Vidskiptavinur object with default values.
     */
    public Vidskiptavinur(){
        System.out.println("Það kallast ekki á neitt");
    }

    /**
     * Constructs a new Vidskiptavinur object with the specified name and address.
     * @param nafn the name of the customer
     * @param heimilisfang the address of the customer
     */
    public Vidskiptavinur(String nafn, String heimilisfang){
        this.nafn = nafn;
        this.heimilisfang = heimilisfang;
    }

    /**
     * Returns the name of the customer.
     * @return the name of the customer
     */
    public String getNafn() {
        return this.nafn;
    }

    /**
     * Returns the address of the customer.
     * @return the address of the customer
     */
    public String getHeimilisfang() {
        return heimilisfang;
    }

    /**
     * Sets the name of the customer.
     * @param nafn the name of the customer
     */
    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    /**
     * Sets the address of the customer.
     * @param heimilisfang the address of the customer
     */
    public void setHeimilisfang(String heimilisfang) {
        this.heimilisfang = heimilisfang;
    }

}
