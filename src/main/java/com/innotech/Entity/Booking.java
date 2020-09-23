package com.innotech.Entity;

import javax.persistence.*;
import java.awt.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numberBooking;

    @Temporal(TemporalType.DATE)
    private Date dateStart;

    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    private String status;

    @OneToOne
    private SideTable sideTable;

    @OneToMany(mappedBy = "booking")
    private Set<MenuBooking> menuBookings;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

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

    public Set<MenuBooking> getMenuBookings() {
        return menuBookings;
    }

    public void setMenuBookings(Set<MenuBooking> menuBookings) {
        this.menuBookings = menuBookings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}