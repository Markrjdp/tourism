package com.wx.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author XuQiHao
 */
@Entity
@Table(name = "destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int ever;
    @Column(name = "thumb_up")
    private int thumbUp;
    @Column(name = "search_num")
    private int searchNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
    private Set<Feature> featureSet=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
    private Set<Information> information=new HashSet<>();

    public Set<Information> getInformation() {
        return information;
    }

    public void setInformation(Set<Information> information) {
        this.information = information;
    }

    public Set<Feature> getFeatureSet() {
        return featureSet;
    }

    public void setFeatureSet(Set<Feature> featureSet) {
        this.featureSet = featureSet;
    }

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

    public int getEver() {
        return ever;
    }

    public void setEver(int ever) {
        this.ever = ever;
    }

    public int getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(int thumbUp) {
        this.thumbUp = thumbUp;
    }

    public int getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(int searchNum) {
        this.searchNum = searchNum;
    }
}
