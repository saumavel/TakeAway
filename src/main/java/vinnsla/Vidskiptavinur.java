package vinnsla;

import javafx.scene.control.TextField;

/**
 * @Author Kári Einarsson
 * @Email: saumavel@gmail.com
 */
public class Vidskiptavinur {
    private static String nafn;
    private static String heimilisfang;

    public Vidskiptavinur(){
        System.out.println("Það kallast ekki á neitt");
    }
    public Vidskiptavinur(String nafn, String heimilisfang){
        this.nafn = nafn;
        this.heimilisfang = heimilisfang;
    }
    public String getNafn() {
        return this.nafn;
    }

    public String getHeimilisfang() {
        return heimilisfang;
    }

    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    public void setHeimilisfang(String heimilisfang) {
        this.heimilisfang = heimilisfang;
    }

}
