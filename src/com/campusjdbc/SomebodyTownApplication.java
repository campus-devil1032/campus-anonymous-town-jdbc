package com.campusjdbc;

import com.campusjdbc.common.MenuOptionType;
import com.campusjdbc.controller.PostController;
import com.campusjdbc.exceptions.InvalidPostUpdateException;

import java.util.Scanner;

public class SomebodyTownApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PostController postController = new PostController();

    /**
     * @throws InvalidPostUpdateException - 개발단계에서 잡아야 하는 에러다. catch 하면 안되고 이 에러가 발생하면 조건을 반드시 확인하자
     */
    public static void main(String[] args) throws InvalidPostUpdateException {
        boolean run = true;
        while (run) {
            System.out.println("\n1. 게시물 등록");
            System.out.println("2. 게시물 하나 읽기");
            System.out.println("3. 모든 게시물 읽기");
            System.out.println("4. 게시물 수정");
            System.out.println("5. 게시물 삭제");
            System.out.println("6. 종료");
            System.out.println("메뉴 입력:");

            int option = scanner.nextInt();
            MenuOptionType menuOptionType = MenuOptionType.fromInt(option);

            if (menuOptionType == null) {
                System.out.println("잘못된 옵션입니다. 다시 시도해 주세요.");
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