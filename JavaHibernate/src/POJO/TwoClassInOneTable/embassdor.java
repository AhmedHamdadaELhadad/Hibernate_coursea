package POJO.TwoClassInOneTable;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity

public class embassdor implements Serializable{

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  
    private String fullname;
  

   @Embedded
   @Id
    private location lo;
   /* @Embedded
    @AttributeOverrides({
    @AttributeOverride(name="form_Loacation", column =@Column(name="form_Loacation_home")),
    @AttributeOverride(name = "To_location",column = @Column(name ="TO_Loacation_Home")),
    })
    private location lop;
      public location getLop() {
        return lop;
    }

    public void setLop(location lop) {
        this.lop = lop;
    }
    */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public location getLo() {
        return lo;
    }

    public void setLo(location lo) {
        this.lo = lo;
    }
    
}
