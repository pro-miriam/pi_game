package org.sr4s.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

import com.querydsl.core.types.Expression;

/**
 * org.sr4s.domain.dto.QScoreDto is a Querydsl Projection type for ScoreDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QScoreDto extends ConstructorExpression<ScoreDto> {

    private static final long serialVersionUID = 1609150816L;

    public QScoreDto(Expression<String> cntryCd, Expression<Integer> score) {
        super(ScoreDto.class, new Class<?>[]{String.class, int.class}, cntryCd, score);
    }

    public QScoreDto(Expression<String> cntryCd, Expression<Integer> score, Expression<String> userNm) {
        super(ScoreDto.class, new Class<?>[]{String.class, int.class, String.class}, cntryCd, score, userNm);
    }

    public QScoreDto(NumberExpression<Integer> score, StringExpression userNm, NumberExpression<Long> userSeq) {
        super(ScoreDto.class, new Class<?>[]{int.class, String.class, long.class}, score, userNm, userSeq);
    }

}

