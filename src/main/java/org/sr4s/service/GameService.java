package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.GameResultDto;
import org.sr4s.domain.dto.ScoreDto;
import org.sr4s.domain.entity.GameResult;
import org.sr4s.domain.repository.GameRepository;
import org.sr4s.domain.repository.UserRepository;
import org.sr4s.domain.repository.wrapper.GameRepositoryWrapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService {

    private final GameRepository gameRepository;

    private final UserRepository userRepository;

    private final GameRepositoryWrapper gameRepositoryWrapper;

    @Transactional
    public Response<Object> createScore(GameResultDto score) {
        GameResult scoreEntity = GameResult.builder()
                                    .user(userRepository.findOneByUserSeq(score.getUserSeq()))
                                    .score(score.getScore())
                                    .build();
        gameRepository.save(scoreEntity);

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("INSERT SCORE SUCCESS")
                .build();
    }
    @Transactional
    public Response<Object> getCntryScoreList() {
        List<ScoreDto> cntryScoreList = gameRepositoryWrapper.findCntryScoreList();
        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(cntryScoreList)
                .message("SUCCESS")
                .build();
    }
    @Transactional
    public Response<Object> getCntryScore(String cntryCd) {
        ScoreDto score = gameRepositoryWrapper.findCntryScore(cntryCd);
        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(score)
                .message("SUCCESS")
                .build();
    }
    @Transactional
    public Response<Object> getScoreList() {
        List<ScoreDto> score = gameRepositoryWrapper.findScoreList();
        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(score)
                .message("SUCCESS")
                .build();
    }
}
