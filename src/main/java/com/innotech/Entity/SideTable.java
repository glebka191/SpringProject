package com.innotech.Entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class SideTable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer size;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sideTable")
    private Set<Booking> bookings;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
