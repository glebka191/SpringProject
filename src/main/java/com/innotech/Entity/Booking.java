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

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "side_table_id", nullable = false)
    private SideTable sideTable;

    @OneToOne(optional = false)
    @JoinColumn(name = "menu_booking_id", unique = true, nullable = false, updatable = false)
    private MenuBooking menuBooking;

    @ManyToMany
    @JoinTable(name = "user_booking",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"))
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

    public MenuBooking getMenuBooking() {
        return menuBooking;
    }

    public void setMenuBooking(MenuBooking menuBooking) {
        this.menuBooking = menuBooking;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}