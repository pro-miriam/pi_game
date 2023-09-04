package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.entity.Setting;
import org.sr4s.domain.entity.UserMaster;

import java.util.List;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {

   Setting findOneByUser(UserMaster user);
}
