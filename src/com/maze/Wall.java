package com.maze;

public class Wall {
    private boolean isEastExist;
    private boolean isNorthExist;
    private boolean isWestExist;
    private boolean isSouthExist;

    public Wall(boolean isEastExist, boolean isNorthExist, boolean isWestExist, boolean isSouthExist) {
        this.isEastExist = isEastExist;
        this.isNorthExist = isNorthExist;
        this.isWestExist = isWestExist;
        this.isSouthExist = isSouthExist;
    }

    public boolean isEastExist() {
        return isEastExist;
    }
    public void setEastExist(boolean eastExist) {
        isEastExist = eastExist;
    }
    public boolean isNorthExist() {
        return isNorthExist;
    }
    public void setNorthExist(boolean northExist) {
        isNorthExist = northExist;
    }
    public boolean isWestExist() {
        return isWestExist;
    }
    public void setWestExist(boolean westExist) {
        isWestExist = westExist;
    }
    public boolean isSouthExist() {
        return isSouthExist;
    }
    public void setSouthExist(boolean southExist) {
        isSouthExist = southExist;
    }
}