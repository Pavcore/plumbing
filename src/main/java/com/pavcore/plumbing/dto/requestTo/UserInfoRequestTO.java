package com.pavcore.plumbing.dto.requestTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoRequestTO {

    private long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

}
