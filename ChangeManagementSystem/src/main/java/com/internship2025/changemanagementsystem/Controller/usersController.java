package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.users;
import com.internship2025.changemanagementsystem.Services.userService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class usersController {

    public  final userService usersService;

    public usersController(userService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("findUsers")
    public ApiResponse<?> findUsers(){
       return usersService.findUsers();
    }

    @PostMapping("loginUsers")
    public ApiResponse<?> loginUsers(users user){
        return  usersService.loginUsers(user);
    }

    @PostMapping("saveUsers")
    public ApiResponse<?> saveUsers(@RequestBody users user) {

      return   usersService.saveUsers(user);
    }



}
