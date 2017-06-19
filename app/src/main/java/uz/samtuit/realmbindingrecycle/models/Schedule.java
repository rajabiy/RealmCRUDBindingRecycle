package uz.samtuit.realmbindingrecycle.models;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amin on 09.06.17.
 */

public class Schedule extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private Date date;
    private int day;
    private Group group;
    private Subject subject;

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public Group getGroup() {
        return group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
