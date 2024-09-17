package com.pavcore.plumbing.dto.requestTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequestTO {

    private String login;
    private String email;

}
