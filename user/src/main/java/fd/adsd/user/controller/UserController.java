package fd.adsd.user.controller;

import fd.adsd.user.dto.BaseResponse;
import fd.adsd.user.dto.ChangePassRequest;
import fd.adsd.user.dto.LoginRequest;
import fd.adsd.user.dto.RegisterRequest;
import fd.adsd.user.entity.User;
import fd.adsd.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public BaseResponse<User> register(@RequestBody RegisterRequest request){
        return new BaseResponse<>(userService.register(request));
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public BaseResponse<User> login(@RequestBody LoginRequest request){
        return new BaseResponse<>(userService.login(request));
    }

    @PutMapping("/password")
    @ApiOperation("用户更改密码")
    public BaseResponse<User> changePass(@RequestBody ChangePassRequest request){
        return new BaseResponse<>(userService.changePass(request));
    }
}
