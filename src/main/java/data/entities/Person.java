package data.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

    protected String name;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
