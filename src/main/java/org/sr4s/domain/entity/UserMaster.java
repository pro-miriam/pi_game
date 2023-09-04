package org.sr4s.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "user_seq",
        allocationSize = 1)
public class UserMaster extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="USER_SEQ_GENERATOR")
    private Long userSeq;

    @Column(nullable = false)
    private String userNm;

    @Column(nullable = false)
    private String cntryCd;
    
}
