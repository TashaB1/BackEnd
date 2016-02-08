package administrate.entity;


import javax.persistence.*;

/**
 * Created by USER on 03.02.2016.
 */

@Entity
@Table(name = "BackEnd")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String birhtDay;
    private String birthPlace;

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

    public String getBirhtDay() {
        return birhtDay;
    }

    public void setBirhtDay(String birhtDay) {
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
                ", birhtDay='" + birhtDay + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
