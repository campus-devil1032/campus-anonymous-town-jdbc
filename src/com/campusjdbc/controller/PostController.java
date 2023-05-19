package com.campusjdbc.controller;

import com.campusjdbc.exceptions.InvalidPostUpdateException;
import com.campusjdbc.service.PostDAOImpl;
import com.campusjdbc.dto.PostDTO;
import com.campusjdbc.views.ApplicationInteractionView;
import com.campusjdbc.views.PostResponseView;

import java.util.List;
import java.util.Scanner;

public class PostController {
    private final PostDAOImpl postDAO = new PostDAOImpl();
    private final PostResponseView postResponseView = new PostResponseView();
    private final ApplicationInteractionView applicationInteractionView = new ApplicationInteractionView();
    private final Scanner scanner = new Scanner(System.in);

    public void createPost() {
        applicationInteractionView.displayEnterTitle();
        String title = scanner.nextLine();

        applicationInteractionView.displayEnterContent();
        String content = scanner.nextLine();

        applicationInteractionView.displayEnterPassword();
        String password = scanner.nextLine();

        PostDTO newPost = new PostDTO();
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setPassword(password);

        int postId = postDAO.insertPost(newPost).getId();
        newPost.setId(postId); // 새로 생성 된 게시물의 아이디
        postResponseView.displayCreateSuccess(newPost);
    }

    public void getPost() {
        applicationInteractionView.displayEnterId();
        int id = scanner.nextInt();
        PostDTO post = postDAO.selectPost(id);

        if (post != null) {
            postResponseView.displayPost(post);
        } else {
            postResponseView.displayNotFoundPost();
        }
    }

    public void getAllPosts() {
        List<PostDTO> posts = postDAO.selectAllPosts();
        postResponseView.displayAllPosts(posts);
    }

    public void updatePost() throws InvalidPostUpdateException {
        applicationInteractionView.displayEnterId();
        int id = scanner.nextInt();

        applicationInteractionView.displayEnterTitle();
        scanner.nextLine();  // consume leftover newline
        String title = scanner.nextLine();

        applicationInteractionView.displayEnterContent();
        String content = scanner.nextLine();

        applicationInteractionView.displayEnterPassword();
        String password = scanner.nextLine();

        PostDTO post = new PostDTO();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setPassword(password);

        if (postDAO.updatePost(post)) {
            postResponseView.displayUpdateSuccess();
        } else {
            postResponseView.displayUpdateFailed();
        }
        throw new InvalidPostUpdateException("설정되지 않은 옵션이 있습니다. 게시물 업데이트 조건에서 바뀐 내용이 있는지 확인해주세요.");
    }

    public void deletePost() {
        applicationInteractionView.displayEnterId();
        int id = scanner.nextInt();

        applicationInteractionView.displayEnterPassword();
        scanner.nextLine();  // consume leftover newline
        String password = scanner.nextLine();

        if (postDAO.deletePost(id, password)) {
            postResponseView.displayDeleteSuccess();
        } else {
            postResponseView.displayDeleteFailed();
        }
    }
}