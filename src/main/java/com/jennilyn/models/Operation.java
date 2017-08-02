package com.jennilyn.models;

import javax.persistence.*;

@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double operand;
    private double operand2;
    private String operator;

    public Operation() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getOperand() {
        return operand;
    }

    public void setOperand(double operand) {
        this.operand = operand;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
