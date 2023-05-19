package com.campusjdbc.views;

public class ApplicationInteractionView {
    public void displayMenu() {
        System.out.println("\n1. Create post");
        System.out.println("2. View post");
        System.out.println("3. View all posts");
        System.out.println("4. View selected page");
        System.out.println("5. Update post");
        System.out.println("6. Delete post");
        System.out.println("7. Exit");
        System.out.println("Enter an option:");
    }

    public void displayWrongOption() {
        System.out.println("잘못된 옵션입니다. 다시 시도해 주세요.");
    }

    public void displayEnterTitle() {
        System.out.println("Enter title:");
    }

    public void displayEnterContent() {
        System.out.println("Enter content:");
    }

    public void displayEnterPassword() {
        System.out.println("Enter password:");
    }

    public void displayEnterId() {
        System.out.println("Enter Post ID:");
    }

    public void displayEnterPage(int pageSize) {
        System.out.println("마지막 페이지는 " + pageSize + "입니다.");
        System.out.println("몇페이지를 보시겠습니까?");
    }

    public void displayWrongNumber() {
        System.out.println("마지막 페이지의 범위를 넘어갔습니다.");
    }
}
