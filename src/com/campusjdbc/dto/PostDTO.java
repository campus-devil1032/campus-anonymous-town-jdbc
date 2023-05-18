package com.campusjdbc.dto;

// DTO for Post
public class PostDTO {
    private int id; // 게시글 ID
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private String password; // 게시글 비밀번호

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "com.campusjdbc.dto.PostDTO [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
}