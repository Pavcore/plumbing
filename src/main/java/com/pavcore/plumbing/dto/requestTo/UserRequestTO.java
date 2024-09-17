package com.pavcore.plumbing.dto.requestTo;

import com.pavcore.plumbing.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestTO {

    private String login;
    private String password;
    private String email;
    private Role role;

}
