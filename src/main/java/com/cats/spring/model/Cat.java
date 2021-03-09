package com.cats.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private float weight;

    public Cat(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public void setCat(Cat cat) {
        this.ID = cat.getID();
        this.name = cat.getName();
        this.weight = cat.getWeight();
    }
}
