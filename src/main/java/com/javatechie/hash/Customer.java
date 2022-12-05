package com.javatechie.hash;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("CustomersInfo")
public class Customer implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dob;
    private String phone;
}
