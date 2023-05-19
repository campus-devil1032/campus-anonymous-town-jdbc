package com.campusjdbc.service;// DAO Interface for Post

import com.campusjdbc.dto.PostDTO;

import java.util.List;

public interface PostDAO {
    PostDTO insertPost(PostDTO post); // 새 게시글 추가

    PostDTO selectPost(int id); // 특정 ID의 게시글 가져오기

    List<PostDTO> selectAllPosts(); // 모든 게시글 가져오기

    List<PostDTO> selectPostsPages(int pageSize, int page);

    int getSizeTable();

    boolean updatePost(PostDTO post); // 게시글 수정

    boolean deletePost(int id, String password); // 게시글 삭제
}