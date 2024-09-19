package com.pavcore.plumbing.service;

import com.pavcore.plumbing.dto.requestTo.UserInfoRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserInfoResponseTO;
import com.pavcore.plumbing.entiy.UserInfo;
import com.pavcore.plumbing.mapper.UserInfoMapper;
import com.pavcore.plumbing.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    private final UserInfoRepo userInfoRepo;
    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoService(UserInfoRepo userInfoRepo, UserInfoMapper userInfoMapper) {
        this.userInfoRepo = userInfoRepo;
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfoResponseTO getUserInfo(long id) {
        return userInfoMapper.mapResp(userInfoRepo.getReferenceById(id));
    }

    public UserInfoResponseTO createUserInfo(UserInfoRequestTO userInfoRequestTO) {
        UserInfo userInfo = userInfoMapper.mapReq(userInfoRequestTO);
        return userInfoMapper.mapResp(userInfo);
    }

    public void updateUserInfoFirstName(long id , String firstName) {
        UserInfo userInfo = userInfoRepo.getReferenceById(id);
        userInfo.setFirstName(firstName);
        userInfoRepo.save(userInfo);
    }

    public void updateUserInfoLastName(long id , String lastName) {
        UserInfo userInfo = userInfoRepo.getReferenceById(id);
        userInfo.setLastName(lastName);
        userInfoRepo.save(userInfo);
    }

    public void updateUserInfoPhone(long id , int phone) {
        UserInfo userInfo = userInfoRepo.getReferenceById(id);
        userInfo.setPhone(phone);
        userInfoRepo.save(userInfo);
    }

    public void updateUserInfoAddress(long id , String address) {
        UserInfo userInfo = userInfoRepo.getReferenceById(id);
        userInfo.setAddress(address);
        userInfoRepo.save(userInfo);
    }

    public void deleteUserInfo(long id) {
        UserInfo userInfo = userInfoRepo.getReferenceById(id);
        userInfoRepo.delete(userInfo);
    }
}
