package com.jennilyn.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "calc_user")
public class CalcUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Operation> operations;

    public CalcUser() {}

    public CalcUser(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
