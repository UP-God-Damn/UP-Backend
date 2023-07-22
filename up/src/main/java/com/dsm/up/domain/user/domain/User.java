package com.dsm.up.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 12, unique = true)
    private String userId;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 12)
    private String nickname;

    @Column(nullable = false, length = 10)
    private String major;

    @Builder
    public User(String userId, String password, String nickname, String major) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.major = major;
    }
}
