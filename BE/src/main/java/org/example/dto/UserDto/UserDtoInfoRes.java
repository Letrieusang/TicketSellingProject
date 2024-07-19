package org.example.dto.UserDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoInfoRes {
//    private Integer userId;
    private String username;
//    private Integer roleId;
    private String rolename;
//    private String password;
    private Boolean blocked;
}
