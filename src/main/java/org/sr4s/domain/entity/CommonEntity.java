package org.sr4s.domain.entity;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass
public class CommonEntity {

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

    private boolean deleted;
}
