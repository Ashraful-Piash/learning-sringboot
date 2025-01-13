package com.piashraful.learning.sringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;

}
