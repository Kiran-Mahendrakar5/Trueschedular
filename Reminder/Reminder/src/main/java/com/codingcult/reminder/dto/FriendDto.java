package com.codingcult.reminder.dto;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "friends")
public class FriendDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
  
    private String phone;
  
    private LocalDate birthday;
    
    private boolean isLinkedToGroup;  // Whether friend is part of a group
    private boolean isEventShared;    // Whether the event is shared or private

    // Default constructor
    public FriendDto() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isLinkedToGroup() {
        return isLinkedToGroup;
    }

    public void setLinkedToGroup(boolean linkedToGroup) {
        isLinkedToGroup = linkedToGroup;
    }

    public boolean isEventShared() {
        return isEventShared;
    }

    public void setEventShared(boolean eventShared) {
        isEventShared = eventShared;
    }

    @Override
    public String toString() {
        return "FriendDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", isLinkedToGroup=" + isLinkedToGroup +
                ", isEventShared=" + isEventShared +
                '}';
    }
}
