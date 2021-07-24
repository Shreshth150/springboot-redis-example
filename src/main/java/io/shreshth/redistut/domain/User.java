package io.shreshth.redistut.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID")
    private long id ;

    @Column(name = "USER_NAME")
    private String userName ;

    @Column(name = "USER_EMAIL_ID")
    private String emailId ;

    @Column(name = "USER_PHONE_NO")
    private String phoneNo ;



}
