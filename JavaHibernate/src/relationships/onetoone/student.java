
package relationships.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class student {
    @Id
    private int id;
    private String name; 
    
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book")
    private book bo;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public book getBo() {
        return bo;
    }

    public void setBo(book bo) {
        this.bo = bo;
    }
    
    
    
    
    
    
}
