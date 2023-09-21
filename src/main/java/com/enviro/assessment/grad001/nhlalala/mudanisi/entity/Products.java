package com.enviro.assessment.grad001.nhlalala.mudanisi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
    Use @Table annotation to specify the name for your Table.
    @Id annotation is used to annotate a field as the id of an entity, this will be an auto generated value.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "productId")
    private String productId;

    @Column(name = "productType")
    private String productType;

    @Column(name = "productName")
    private String productName;

    @Column(name = "balance")
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private InvestorInformation investorInformation;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String withdrawalNotice(String productName) {
        return null;
    }


}

