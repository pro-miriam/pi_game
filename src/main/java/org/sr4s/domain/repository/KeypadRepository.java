package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.entity.Keypad;

import java.util.List;

@Repository
public interface KeypadRepository extends JpaRepository<Keypad, Long> {

    Keypad findOneByKeypadSeq(Long keypadSeq);
}
