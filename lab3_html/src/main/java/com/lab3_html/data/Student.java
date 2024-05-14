package com.lab3_html.data;


import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @NotBlank(message = "{NotBlank.sv.name}")
    String name;

    @NotBlank(message = "{NotBlank.sv.email}")
    @Email
    String email;

    @Min(value = 0, message = "{Min.sv.marks}")
    @Max(value = 10, message = "{Max.sv.marks}")
    @NotNull(message = "{NotNull.sv.marks}")
    double marks;

    @NotNull(message = "{NotNull.sv.gender}")
    boolean gender;

    @NotNull(message = "{NotBlank.sv.faculty}")
    String faculty;
    String avatar;

    @NotEmpty(message = "{NotEmpty.sv.hobbies}")
    List<String> hobbies;
}
