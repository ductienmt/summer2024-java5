package com.minimarvel.model.dto;

import com.minimarvel.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String gender;
    private String phone;
    private String email;
    private String fullname;
    private String avatar;
    private LocalDate birthdate;
}
