package dgu.aecofarm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    // 회원 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    // 회원 이름
    @Column(nullable = false)
    private String userName;

    // 이메일
    @Column(nullable = false)
    private String email;

    // 비밀번호
    @Column(nullable = false)
    private String password;

    // 전화번호
    @Column(nullable = false)
    private String phone;

    // 학번
    @Column(nullable = false)
    private Integer schoolNum;

    // 사진
    private String image;

    // 포인트
    @Column(nullable = false)
    private int point;

    // 빌려준 횟수
    private int lendCount;

    // 빌린 횟수
    private int borrowCount;

    // 최근 본 물품
    private String recent;

    @OneToMany(mappedBy = "member")
    private List<Love> likes;

    @OneToMany(mappedBy = "lendMember")
    private List<Contract> lendContracts;

    @OneToMany(mappedBy = "borrowMember")
    private List<Contract> borrowContracts;

    @OneToMany(mappedBy = "lendMember")
    private List<Alarm> lendAlarms;

    @OneToMany(mappedBy = "borrowMember")
    private List<Alarm> borrowAlarms;

    // 수정 메서드
    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}
