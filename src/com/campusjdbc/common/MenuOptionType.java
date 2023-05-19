package com.campusjdbc.common;

public enum MenuOptionType {
    CREATE_POST(1),
    VIEW_POST(2),
    VIEW_ALL_POSTS(3),
    VIEW_POSTS_PAGES(4),
    UPDATE_POST(5),
    DELETE_POST(6),
    EXIT(7);

    private final int value;

    MenuOptionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOptionType fromInt(int i) {
        for (MenuOptionType option : values()) {
            if (option.getValue() == i) {
                return option;
            }
        }
        return null;
    }
}