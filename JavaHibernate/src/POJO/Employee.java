package POJO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Temporal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "employee")
@SecondaryTable(name = "traning")
public class Employee {

    @Id
    @Column(name = "Employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OrderBy("fullName des")
    @Column(name = "Employee_Name")
    private String fullName;

    @Column(name = "Date", unique = false)
    @Temporal(TemporalType.DATE)
    private Date hireData;

    @Column(name = "Time")
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(name = "Employee_Age")
    private String age;

    @Column(name = "Employee_Address")
    private String address;

    @Column(table = "traning")
    private String location;

    @Column(table = "traning")
    private String postion;

    public Date getHireData() {
        return hireData;
    }

    public void setHireData(Date hireData) {
        this.hireData = hireData;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public Employee(String fullName, String hireData, Date time, String age, String address) throws ParseException {
        this.fullName = fullName;
        this.hireData = new SimpleDateFormat("dd-MM-yyyy").parse(hireData);
        this.time = time;
        this.age = age;
        this.address = address;
    }

}
