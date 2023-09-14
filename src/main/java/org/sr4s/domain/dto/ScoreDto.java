package org.sr4s.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Data
@Builder
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDto {
    private String cntryCd;
    private int score;
    private String userNm;
    private int ranking;
    private Long userSeq;

    @QueryProjection
    public ScoreDto(String cntryCd, int score) {
        this.cntryCd = cntryCd;
        this.score = score;
    }

    @QueryProjection
    public ScoreDto(String cntryCd, int score, String userNm) {
        this.cntryCd = cntryCd;
        this.score = score;
        this.userNm = userNm;
    }

    @QueryProjection
    public ScoreDto(int score, String userNm, Long userSeq) {
        this.score = score;
        this.userNm = userNm;
        this.userSeq = userSeq;
    }
}
