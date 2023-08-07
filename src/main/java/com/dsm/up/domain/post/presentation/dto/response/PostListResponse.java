package com.dsm.up.domain.post.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PostListResponse {
    private final List<PostResponse> postResponses;
    private final int totalPosts;

    @Getter
    @Builder
    public static class PostResponse {
        private final Long id;
        private final String title;
        private final String userNickname;
        private final String state;
        private final String major;
        private final String createDate;
    }
}