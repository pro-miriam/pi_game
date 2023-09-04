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
public class ScoreDto {
    private String cntryCd;
    private int score;
    @QueryProjection
    public ScoreDto(String cntryCd, int score) {
        this.cntryCd = cntryCd;
        this.score = score;
    }
}
