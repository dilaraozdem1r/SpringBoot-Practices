package com.springbootpractise.springbootrestapi.Entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="USERS")
@Data
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name="user_seq_gen",sequenceName = "user_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @Column(name="ID")
    private long id;
    @Column(name="NAME",length = 100)
    private String name;
    @Column(name="LASTNAME",length=100)
    private String lastname;
}
