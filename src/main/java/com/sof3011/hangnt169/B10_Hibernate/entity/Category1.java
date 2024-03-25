package com.sof3011.hangnt169.B10_Hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category1 {
    /**
     * J3: JDBC(Java Database Connection): Truy van SQL
     * J4: Hibernate :
     * + C1: Truy van tren SQL
     * + C2: Truy van HQL(Hibernate Query Language) => Truy van tren thuc the (tren class)
     * J5: JPA:
     * + C1: native query => Truy van tren SQL
     * + C2: JPQL(JPA Query Languagae) => Truy van tren thuc the (tren class)
     * ORM(Object Relationship Mapping):
     * 1 table:
     * + Table
     * + Column:
     * + Khoa chinh:
     * + Khoa ngoai:
     * + Cot binh thuong trong table
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id1;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
