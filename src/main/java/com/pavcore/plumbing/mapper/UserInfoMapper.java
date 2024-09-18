package com.pavcore.plumbing.mapper;

import com.pavcore.plumbing.dto.requestTo.UserInfoRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserInfoResponseTO;
import com.pavcore.plumbing.entiy.UserInfo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserInfoMapper {

    UserInfo mapReq(UserInfoRequestTO userInfoRequestTO);

    UserInfoRequestTO mapReq(UserInfo userInfo);

    UserInfo mapResp(UserInfoResponseTO userInfoResponseTO);

    UserInfoResponseTO mapResp(UserInfo userInfo);

}
