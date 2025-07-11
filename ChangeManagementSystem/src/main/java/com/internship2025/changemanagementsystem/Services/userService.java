package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.risk_assessment;
import com.internship2025.changemanagementsystem.Modal.users;
import com.internship2025.changemanagementsystem.Repostory.usersRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class userService  implements Constant {

    private  final usersRepo usersRepo;

    public userService(usersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }


    public ApiResponse<?> saveUsers(users user) {
        try {
            boolean results = usersRepo.save(user);
            if (results) {
                log.info("users save successful");
                return  ApiResponse.builder().message(SUCCESS_MESSAGE).build();
            }else  {
                log.info("users save failed");
                return ApiResponse.builder().message(FAILED_MESSAGE).build();
            }

        }catch (Exception e){
            log.error(e.getMessage(),e);
            return ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> loginUsers(users user) {

        try {
            boolean results = usersRepo.login(user);
            if (results) {
                System.out.println("users login successful");
                log.info("users login successful");
                return  ApiResponse.builder().message(SUCCESS_MESSAGE).build();
            }else   {
                System.out.println("users login failed");
                log.info("users login failed");
                return ApiResponse.builder().message(FAILED_MESSAGE).build();
            }

        } catch (Exception e) {
            System.out.println("Login No Match" + e.getMessage());
            return  ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }

    }


    public ApiResponse<?> findUsers(){
        try {

            List<users> usersList = usersRepo.findAllUsers();

            if(!usersList.isEmpty()){
                System.out.println("users find successful");
                return ApiResponse.builder().message(SUCCESS_MESSAGE)
                        .data(usersList).build();
            }else {
                System.out.println("users find failed");
                return ApiResponse.builder().message(NO_DATA_FOUND_MESSAGE).build();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            return  ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }




}
