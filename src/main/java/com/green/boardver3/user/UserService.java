package com.green.boardver3.user;

import com.green.boardver3.user.model.PatchPasswordUser;
import com.green.boardver3.user.model.PostUserReq;
import com.green.boardver3.user.model.SignInPost;
import com.green.boardver3.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(PostUserReq p){
        String hashPassword = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashPassword);
        return mapper.postUser(p);
    }
    public int getUserById(SignInPost p){
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null){
            return 2;
        }
        if(BCrypt.checkpw(p.getUpw(), entity.getUpw())){
            return 1;
        }
        return 3;
    }
    public int patchPassswordUser(PatchPasswordUser p){
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null){
            return 2;
        } else if (!BCrypt.checkpw(p.getCurrentPw(), entity.getUpw())){
            return 3;
        }
        String hashPassword = BCrypt.hashpw(p.getNewPw(), BCrypt.gensalt());
        p.setNewPw(hashPassword);
        p.setUserId(entity.getUserId());
        return mapper.patchPassword(p);
    }
}
