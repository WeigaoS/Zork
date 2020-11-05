package com.maze;
public class Content {

    private String getName;
    private String getType;
    private boolean isExisit=true;

    public void dissolve() {
        isExisit = false;
    }

    public Content(String getName, String getType) {
        this.getName = getName;
        this.getType = getType;
    }

    public String getGetName() {
        return getName;
    }
    public void setGetName(String getName) {
        this.getName = getName;
    }
    public String getGetType() {
        return getType;
    }
    public void setGetType(String getType) {
        this.getType = getType;
    }
    public boolean isExisit() {
        return isExisit;
    }
    public void setExisit(boolean exisit) {
        isExisit = exisit;
    }
}
