package com.Rishabh.Security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Table(name = "tbl_user")
@Entity
public class UserEntity {
    @Id
    private String userName;
    private String password;
}

