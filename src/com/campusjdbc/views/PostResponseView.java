package com.campusjdbc.views;

import com.campusjdbc.dto.PostDTO;
import java.util.List;

public class PostResponseView {

    public void displayPost(PostDTO post) {
        System.out.println("\nID: " + post.getId());
        System.out.println("제목: " + post.getTitle());
        System.out.println("내용: " + post.getContent());
        System.out.println("게시물 비밀번호: " + post.getPassword());
    }

    public void displayAllPostsPages(List<PostDTO> posts) {
    }

    public void displayAllPosts(List<PostDTO> posts) {
        for (PostDTO post : posts) {
            displayPost(post);
            System.out.println("-------------");
        }
    }

    public void displayNotFoundPost() {
        System.out.println("게시물을 찾을 수 없습니다.");
    }

    public void displayCreateSuccess(PostDTO post) {
        System.out.println("게시물이 성공적으로 생성되었습니다. 게시물의 아이디는 다음과 같습니다: " + post.getId());
    }

    public void displayUpdateSuccess() {
        System.out.println("게시물 수정 성공!");
    }

    public void displayUpdateFailed() {
        System.out.println("업데이트 실패. 게시물 아이디와 비밀번호를 확인해주세요.");
    }

    public void displayDeleteSuccess() {
        System.out.println("게시물 삭제 성공");
    }

    public void displayInvalidOption() {
        System.out.println("잘못된 옵션. 다시 시도해 주세요");
    }

    public void displayExitMessage() {
        System.out.println("프로그램 종료!");
    }

    public void displayDeleteFailed() {
        System.out.println("삭제에 실패했습니다. 게시물 아이디와 비밀번호를 확인해주세요.");
    }
}