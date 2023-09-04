package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<Object> createUser(@RequestBody UserMasterDto user) {
        return userService.createUser(user);
    }

}
