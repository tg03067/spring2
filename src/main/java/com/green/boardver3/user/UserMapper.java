package com.green.boardver3.user;

import com.green.boardver3.user.model.PatchPasswordUser;
import com.green.boardver3.user.model.PostUserReq;
import com.green.boardver3.user.model.SignInPost;
import com.green.boardver3.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(PostUserReq p);
    UserEntity getUserById(String uid);
    int patchPassword(PatchPasswordUser p);
}
