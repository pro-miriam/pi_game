package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.SettingDto;
import org.sr4s.service.SettingService;

@RestController
@RequestMapping(value = "/api/v1/setting")
@RequiredArgsConstructor
@Slf4j
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/get/{userSeq}")
    public Response<Object> getSetting(@PathVariable(value = "userSeq") Long userSeq) {
        return settingService.getSetting(userSeq);
    }

    @PutMapping("/set")
    public Response<Object> setSetting(@RequestBody SettingDto request) {
        return settingService.setSetting(request);
    }
}
