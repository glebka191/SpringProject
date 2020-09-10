package com.innotech.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numberBooking;
    private Date dateStart;
    private Date dateEnd;
    private String status;

    @ManyToOne
    private SideTable sideTable;

    @OneToOne
    private MenuBooking menuBookings;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberBooking() {
        return numberBooking;
    }

    public void setNumberBooking(Integer numberBooking) {
        this.numberBooking = numberBooking;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SideTable getSideTable() {
        return sideTable;
    }

    public void setSideTable(SideTable sideTable) {
        this.sideTable = sideTable;
    }

    public MenuBooking getMenuBookings() {
        return menuBookings;
    }

    public void setMenuBookings(MenuBooking menuBookings) {
        this.menuBookings = menuBookings;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}