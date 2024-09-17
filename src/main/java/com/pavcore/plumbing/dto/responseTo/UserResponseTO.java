package com.pavcore.plumbing.dto.responseTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseTO {

    private int id;
    private String name;
    private String email;
    private OrderResponseTO orderResponseTO;
    private UserInfoResponseTO userInfoResponseTO;

}
