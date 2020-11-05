package com.maze.room;

import com.maze.Content;
import com.maze.Wall;

public interface Room {
    String getName();

    void setName(String name);
    String getDesrc();

    void setDesrc(String desrc);
    Content[] getContent();

    void setContent(Content[] contents);
    Wall getWall();

    Integer getX();
    Integer getY();

    boolean isLock();

    void cancelLock();

    void tip();
}
