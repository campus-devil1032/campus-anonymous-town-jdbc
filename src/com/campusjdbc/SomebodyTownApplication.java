package com.campusjdbc;

import com.campusjdbc.common.MenuOptionType;
import com.campusjdbc.controller.PostController;
import com.campusjdbc.exceptions.InvalidPostUpdateException;
import com.campusjdbc.views.ApplicationInteractionView;

import java.util.Scanner;

public class SomebodyTownApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PostController postController = new PostController();
    private static final ApplicationInteractionView applicationInteractionView = new ApplicationInteractionView();

    /**
     * @throws InvalidPostUpdateException - 개발단계에서 잡아야 하는 에러다. catch 하면 안되고 이 에러가
     *                                    발생하면 조건을 반드시 확인하자
     */
    public static void main(String[] args) throws InvalidPostUpdateException {
        boolean run = true;
        while (run) {
            applicationInteractionView.displayMenu();

            int option = scanner.nextInt();
            MenuOptionType menuOptionType = MenuOptionType.fromInt(option);

            if (menuOptionType == null) {
                applicationInteractionView.displayWrongOption();
                continue;
            }

            switch (menuOptionType) {
                case CREATE_POST:
                    postController.createPost();
                    break;
                case VIEW_POST:
                    postController.getPost();
                    break;
                case VIEW_ALL_POSTS:
                    postController.getAllPosts();
                    break;
                case VIEW_POSTS_PAGES:
                    postController.getPostsPages();
                    break;
                case UPDATE_POST:
                    postController.updatePost();
                    break;
                case DELETE_POST:
                    postController.deletePost();
                    break;
                case EXIT:
                    run = false;
                    break;
            }
        }
    }
}