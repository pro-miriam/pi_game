package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.entity.UserMaster;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserMaster, Long> {

    //Optional<UserMaster> findOneByUserSeq(Long userSeq);
    UserMaster findOneByUserSeq(Long userSeq);
}
