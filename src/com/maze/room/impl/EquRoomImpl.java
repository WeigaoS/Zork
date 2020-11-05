package com.maze.room.impl;

import com.maze.Content;
import com.maze.Wall;
import com.maze.room.EquRoom;

public class EquRoomImpl implements EquRoom {

    private String name;
    private String desrc;
    private Content[] contents;
    private Wall walls;
    private boolean isLock;
    private Integer x;
    private Integer y;
    private String tip;

    public EquRoomImpl(String name, String desrc, Content[] contents, Wall walls, Integer x, Integer y, boolean isLock, String tip) {
        this.name = name;
        this.desrc = desrc;
        this.contents = contents;
        this.walls = walls;
        this.x = x;
        this.y = y;
        this.isLock = isLock;
        this.tip = tip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDesrc() {
        return desrc;
    }

    @Override
    public void setDesrc(String desrc) {
        this.desrc = desrc;
    }

    @Override
    public Content[] getContent() {
        return contents;
    }

    @Override
    public void setContent(Content[] contents) {
        this.contents = contents;
    }

    @Override
    public Wall getWall() {
        return walls;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }


    @Override
    public void equDesrc() {
        System.out.println("There is a weapon：" + name);
    }

    @Override
    public boolean isLock() {
        return isLock;
    }

    @Override
    public void cancelLock() {
        isLock = false;
    }

    @Override
    public void tip() {
        System.out.println(tip);
    }

}
