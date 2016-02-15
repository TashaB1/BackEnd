package administrate.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by USER on 03.02.2016.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name = "birthDay")
    private Date birhtDay;
    private String birthPlace;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @OneToMany(targetEntity = Phone.class, mappedBy = "user", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Phone> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirhtDay() {
        return birhtDay;
    }

    public void setBirhtDay(Date birhtDay) {
        this.birhtDay = birhtDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birhtDay=" + birhtDay +
                ", birthPlace='" + birthPlace + '\'' +
                ", phones=" + phones +
                '}';
    }
}
