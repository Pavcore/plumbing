package com.pavcore.plumbing.dto.responseTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoResponseTO {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;

}
