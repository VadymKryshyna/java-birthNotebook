package com.kryshyna.birthnotebook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Kryshyna
 * Date: 30.09.14
 * Time: 12:48
 */
@XmlRootElement(namespace = "base")
public class People {
    private List<Person> people;

    public People(){
        people = new ArrayList<Person>();
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @XmlElementWrapper(name = "people")
    @XmlElement(name = "person")
    public List<Person> getPeople() {
        return people;
    }
}
