package com.maze.role;

import com.maze.Content;

public class User {
    private Content[] contents = new Content[0];
    private Integer x;
    private Integer y;
    public User(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Content[] getContents() {
        return contents;
    }

    public void addContents(Content content) {
        Content[] tmp = new Content[contents.length + 1];
        for (int i = 0; i < contents.length; i++) {
            tmp[i] = contents[i];
        }
        tmp[contents.length] = content;
        contents = tmp;
    }

    public void setXY(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() { return x; }

    public Integer getY() {
        return y;
    }


    public void showGoods() {
        if (contents.length == 0) {
            System.out.println("You have nothing in the bag!");
        }
        for (Content c : contents) {
            System.out.println("name:" + c.getGetName() + ",type:" + c.getGetType());
        }
    }
}