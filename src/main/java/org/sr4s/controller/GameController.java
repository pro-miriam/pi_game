package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.GameResultDto;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.service.GameService;

@RestController
@RequestMapping(value = "/api/v1/game")
@RequiredArgsConstructor
@Slf4j
public class GameController {

    private final GameService gameService;

    @PostMapping("/score/create")
    public Response<Object> createScore(@RequestBody GameResultDto score) {
        return gameService.createScore(score);
    }

    @GetMapping("/score/cntry")
    public Response<Object> getCntryScoreList() {
        return gameService.getCntryScoreList();
    }

    @GetMapping("/score/{cntryCd}")
    public Response<Object> getCntryScore(@PathVariable(value = "cntryCd") String cntryCd) {
        return gameService.getCntryScore(cntryCd);
    }

    @GetMapping("/score/list")
    public Response<Object> getScoreList() {
        return gameService.getScoreList();
    }

}
