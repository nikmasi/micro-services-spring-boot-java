package com.example.company;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private String firstname;
    private String lastname;
    private String email;
}
