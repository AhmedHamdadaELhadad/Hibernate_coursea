
package POJO.Collection;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
    String states;
    String city;
    String street;

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    
}
