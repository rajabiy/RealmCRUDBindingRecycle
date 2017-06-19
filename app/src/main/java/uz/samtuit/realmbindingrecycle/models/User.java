package uz.samtuit.realmbindingrecycle.models;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amin on 03.06.17.
 */

public class User extends RealmObject{
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    public String firstName;
    public String lastName;

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
