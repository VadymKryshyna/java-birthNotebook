package com.kryshyna.birthnotebook;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Vadym Kryshyna
 * Date: 18.09.14
 * Time: 12:40
 */
@XmlRootElement(name = "person")
public class Person {

    private int id;
    private String firstName;
    private String secondName;
    private String birthDate;

    public void setId(int id) {
        this.id = id;
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @XmlElement(name = "secondName")
    public String getSecondName() {
        return secondName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @XmlElement(name = "birthDate")
    public String getBirthDate() {
        return birthDate;
    }
}
