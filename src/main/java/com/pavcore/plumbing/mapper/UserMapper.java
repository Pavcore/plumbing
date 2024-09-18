package com.pavcore.plumbing.mapper;

import com.pavcore.plumbing.dto.requestTo.UserRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserResponseTO;
import com.pavcore.plumbing.entiy.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    User mapReq(UserRequestTO userRequestTO);

    UserRequestTO mapReq(User user);

    User mapResp(UserResponseTO userResponseTO);

    UserResponseTO mapResp(User user);

}
