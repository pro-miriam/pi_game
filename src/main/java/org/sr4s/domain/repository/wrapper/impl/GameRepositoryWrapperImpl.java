package org.sr4s.domain.repository.wrapper.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.sr4s.domain.dto.QScoreDto;
import org.sr4s.domain.dto.ScoreDto;
import org.sr4s.domain.entity.QGameResult;
import org.sr4s.domain.entity.QUserMaster;
import org.sr4s.domain.repository.wrapper.GameRepositoryWrapper;

import java.util.List;

@Repository
public class GameRepositoryWrapperImpl extends QuerydslRepositorySupport implements GameRepositoryWrapper {
    private final JPAQueryFactory query;

    QGameResult game = QGameResult.gameResult;
    QUserMaster user = QUserMaster.userMaster;

    public GameRepositoryWrapperImpl(JPAQueryFactory queryFactory) {
        super(QGameResult.class);
        this.query = queryFactory;
    }

    @Override
    public List<ScoreDto> findCntryScoreList() {
        List<ScoreDto> result = query.select(new QScoreDto(user.cntryCd, game.score.sum()))
                .from(game)
                .leftJoin(game.user, user)
                .groupBy(user.cntryCd)
                .orderBy(game.score.sum().desc(), game.updateDt.max().asc())
                .limit(8)
                .fetch();
        return result;
    }

    @Override
    public ScoreDto findCntryScore(String cntryCd) {
        ScoreDto result = query.select(new QScoreDto(user.cntryCd, game.score.sum()))
                .from(game)
                .leftJoin(game.user, user)
                .where(isCntryCd(cntryCd))
                .groupBy(user.cntryCd)
                .fetchOne();
        return result;
    }

    @Override
    public List<ScoreDto> findScoreList() {
        List<ScoreDto> result = query.select(new QScoreDto(user.cntryCd, game.score, user.userNm))
                .from(game)
                .leftJoin(game.user, user)
                .orderBy(game.score.desc(), game.updateDt.asc())
                .limit(100)
                .fetch();
        return result;
    }

    @Override
    public List<ScoreDto> findScoreListByCntryCd(String cntryCd) {
        List<ScoreDto> result = query.select(new QScoreDto(game.score, user.userNm))
                .from(game)
                .leftJoin(game.user, user)
                .where(isCntryCd(cntryCd))
                .orderBy(game.score.desc(), game.updateDt.asc())
                .limit(100)
                .fetch();
        return null;
    }

    private BooleanExpression isCntryCd(String cntryCd) {
        return StringUtils.hasText(cntryCd) ? user.cntryCd.eq(cntryCd) : null;
    }
}
