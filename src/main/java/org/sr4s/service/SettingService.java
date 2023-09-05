package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.SettingDto;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.domain.entity.Keypad;
import org.sr4s.domain.entity.Setting;
import org.sr4s.domain.entity.UserMaster;
import org.sr4s.domain.repository.KeypadRepository;
import org.sr4s.domain.repository.SettingRepository;
import org.sr4s.domain.repository.ThemeRepository;
import org.sr4s.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class SettingService {

    private final SettingRepository settingRepository;

    private final UserRepository userRepository;

    private final ThemeRepository themeRepository;

    private final KeypadRepository keypadRepository;

    @Transactional
    public Response<Object> getSetting(Long userSeq) {
        UserMaster user = userRepository.findOneByUserSeq(userSeq);
        Setting setting = settingRepository.findOneByUser(user);

        SettingDto settingDto = SettingDto.builder()
                .settingSeq(setting.getSettingSeq())
                .userSeq(user.getUserSeq())
                .keypadSeq(ObjectUtils.isEmpty(setting.getKeypad()) ? null : setting.getKeypad().getKeypadSeq())
                .themeSeq(ObjectUtils.isEmpty(setting.getTheme()) ? null : setting.getTheme().getThemeSeq())
                .build();


        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(settingDto)
                .build();
    }

    @Transactional
    public Response<Object> setSetting(SettingDto request) {
        Setting setting  = settingRepository.findOneByUser(userRepository.findOneByUserSeq(request.getUserSeq()));
        setting.setKeypad(keypadRepository.findOneByKeypadSeq(request.getKeypadSeq()));
        setting.setTheme(themeRepository.findOneByThemeSeq(request.getThemeSeq()));

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .build();
    }
}
