
package POJO.Collection;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ElementCollection
    @JoinTable(name="addres_EMP",joinColumns = @JoinColumn(name = "addres_EMP_ID"))
    @GenericGenerator(name="increment" ,strategy ="increment" )
    @CollectionId(columns = {@Column(name="id_EMp")},generator = "increment" ,type = @Type(type = "int") )
    private List<Adress> ad;

    public Student() {
        this.ad = new ArrayList();
    }

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
    public List<Adress> getAd() {
        return ad;
    }

    public void setAd(List<Adress> ad) {
        this.ad = ad;
    }
    
    
    
    
}
