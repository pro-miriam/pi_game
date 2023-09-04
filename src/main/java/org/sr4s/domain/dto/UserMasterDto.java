package org.sr4s.domain.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class UserMasterDto {

    private String userSeq;

    private String userNm;

    private String cntryCd;
    
}
