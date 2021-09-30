
package POJO.TwoClassInOneTable;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Embeddable
public class location {
    
 
   
    
    private  int id_Loacation;
  private  String form_Loacation;
 
  private  String to_Loacation;
    

    public String getForm_Loacation() {
        return form_Loacation;
    }

    public void setForm_Loacation(String form_Loacation) {
        this.form_Loacation = form_Loacation;
    }

    public String getTo_Loacation() {
        return to_Loacation;
    }

    public void setTo_Loacation(String to_Loacation) {
        this.to_Loacation = to_Loacation;
    }

   

    public location() {
    }

    public int getId_Loacation() {
        return id_Loacation;
    }

    public void setId_Loacation(int id_Loacation) {
        this.id_Loacation = id_Loacation;
    }

  
}
