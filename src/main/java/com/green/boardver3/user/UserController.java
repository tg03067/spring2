package com.green.boardver3.user;

import com.green.boardver3.common.ResultDto;
import com.green.boardver3.user.model.PatchPasswordUser;
import com.green.boardver3.user.model.PostUserReq;
import com.green.boardver3.user.model.SignInPost;
import com.green.boardver3.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    @PostMapping("SignUp")
    public ResultDto<Integer> postUser(@RequestBody PostUserReq p){
        int result = service.postUser(p);
        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }

    @PostMapping("SignIn")
    public ResultDto<Integer> postSignIn(@RequestBody SignInPost p){
        int result = service.getUserById(p);

        String msg = switch (result){
            case 1 -> "로그인 성공";
            case 2 -> "아이디를 확인해 주세요";
            case 3 -> "비밀번호를 확인해 주세요.";
            default -> "ERROE";
        };

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(msg).
                resultData(result).build();
    }
    @PostMapping("password")
    public ResultDto<Integer> patchPassswordUser(@RequestBody PatchPasswordUser p){
        int result = service.patchPassswordUser(p);

        String msg = switch (result){
            case 1 -> "비밀번호 변경 성공";
            case 2 -> "아이디를 확인해 주세요.";
            case 3 -> "기존 비밀번호를 확인해 주세요.";
            default -> "ERROR";
        };
        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(msg).
                resultData(result).build();
    }
}
