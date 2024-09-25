package com.pavcore.plumbing.mapper;

import com.pavcore.plumbing.dto.requestTo.UserInfoRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserInfoResponseTO;
import com.pavcore.plumbing.dao.postgres.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    UserInfo mapReq(UserInfoRequestTO userInfoRequestTO);

    UserInfoRequestTO mapReq(UserInfo userInfo);

    UserInfo mapResp(UserInfoResponseTO userInfoResponseTO);

    UserInfoResponseTO mapResp(UserInfo userInfo);

}
