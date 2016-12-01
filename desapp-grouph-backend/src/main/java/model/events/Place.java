package model.events;

import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="Place")
public class Place extends model.Entity {
    private String name;
    private String address;

    public Place() {}

    public Place(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
