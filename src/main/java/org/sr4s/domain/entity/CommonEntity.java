package org.sr4s.domain.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass
public class CommonEntity {
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private LocalDateTime createDt;
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private LocalDateTime updateDt;
    @ColumnDefault(value = "false")
    private boolean deleted;
}
