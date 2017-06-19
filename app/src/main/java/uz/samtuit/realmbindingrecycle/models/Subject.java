package uz.samtuit.realmbindingrecycle.models;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amin on 09.06.17.
 */

public class Subject extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }
}
