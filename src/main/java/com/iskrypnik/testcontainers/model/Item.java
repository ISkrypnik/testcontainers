package com.iskrypnik.testcontainers.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String description;
}
