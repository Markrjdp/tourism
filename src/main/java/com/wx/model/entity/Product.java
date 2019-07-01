package com.wx.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int type;
    @Column
    private String image;
    @Column
    private String destination;
    @Column
    private String intro;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Stock> StockSet=new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feature_id")
    private Feature feature;

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Set<Stock> getStockSet() {
        return StockSet;
    }

    public void setStockSet(Set<Stock> stockSet) {
        StockSet = stockSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
