
package relationships.manytoone;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      private String phone;
      @ManyToOne(cascade = CascadeType.ALL,targetEntity = Man.class)
      @JoinColumn(name = "id_Student")
      private Man man;

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

 

  

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
      
      
      
      
}
