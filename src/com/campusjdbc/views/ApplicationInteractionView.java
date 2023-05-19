package com.campusjdbc.views;

public class ApplicationInteractionView {
    public void displayMenu() {
        System.out.println("\n1. Create post");
        System.out.println("2. View post");
        System.out.println("3. View all posts");
        System.out.println("4. Update post");
        System.out.println("5. Delete post");
        System.out.println("6. Exit");
        System.out.println("Enter an option:");
    }
    public void displayWrongOption(){
        System.out.println("잘못된 옵션입니다. 다시 시도해 주세요.");
    }
    public void displayEnterTitle(){
        System.out.println("Enter title:");
    }

    public void displayEnterContent(){
        System.out.println("Enter content:");
    }

    public void displayEnterPassword(){
        System.out.println("Enter password:");
    }

    public void displayEnterId(){
        System.out.println("Enter Post ID:");
    }
        
}
