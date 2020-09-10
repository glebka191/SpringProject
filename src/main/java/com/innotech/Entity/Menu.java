package com.innotech.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private Integer idTypeFood;
    private String name;
    private Integer price;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menus")
    private Set<MenuBooking> menuBookings;

    @ElementCollection(targetClass = TypeFood.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "type_menu", joinColumns = @JoinColumn(name = "menu_id"))
    @Enumerated(EnumType.STRING)
    private Set<TypeFood> typeFoods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTypeFood() {
        return idTypeFood;
    }

    public void setIdTypeFood(Integer idTypeFood) {
        this.idTypeFood = idTypeFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<MenuBooking> getMenuBookings() {
        return menuBookings;
    }

    public void setMenuBookings(Set<MenuBooking> menuBookings) {
        this.menuBookings = menuBookings;
    }

    public Set<TypeFood> getTypeFoods() {
        return typeFoods;
    }

    public void setTypeFoods(Set<TypeFood> typeFoods) {
        this.typeFoods = typeFoods;
    }
}
