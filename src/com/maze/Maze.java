package com.maze;

import com.maze.role.User;
import com.maze.room.Room;
import com.maze.room.impl.EmptyRoomImpl;
import java.util.Random;
import java.util.Scanner;

public class Maze {
    private Room[][] rooms;
    private User user;
    public Maze() {
        //create inf0
        rooms = init();
        //create player
        user = new User(2, 0);
    }

    public static void main(String[] args) {
        //create maze
        Maze maze = new Maze();
        //welcome
        maze.welcome();
        //play the maze
        maze.play();

    }

    // create the items (axe, gems, monster, key)
    public Room[][] init() {
        Content axe = new Content("Storm Breaker", Constant.CONTENT_TYPE_EQU);  //Axe name
        Content jewel1 = new Content("Gem1", Constant.CONTENT_TYPE_JEWEL);
        Content jewel2 = new Content("Gem2", Constant.CONTENT_TYPE_JEWEL);
        Content jewel3 = new Content("Gem3", Constant.CONTENT_TYPE_JEWEL);
        Content jewel4 = new Content("Gem4", Constant.CONTENT_TYPE_JEWEL);
        Content boss = new Content("Thanos", Constant.CONTENT_TYPE_MONSTER); //monster
        Content key = new Content("Key", Constant.CONTENT_TYPE_KEY);

        //create the rooms
        String tip1 = "By going west ";
        Wall walls1 = new Wall(false, false, false, true);
        Room room1 = new EmptyRoomImpl("Empty Room", "Nothing in this room", new Content[0], walls1, 1, 1, false, tip1);
        String tip2 = "tip2";
        Wall walls2 = new Wall(false, true, true, false);
        Room room2 = new EmptyRoomImpl("Empty Room", "Nothing in this room", new Content[0], walls2, 1, 2, false, tip2);
        String tip3 = "tip3";
        Wall walls3 = new Wall(true, false, false, true);
        Room room3 = new EmptyRoomImpl("Empty Room", "Nothing in this room", new Content[0], walls3, 3, 0, false, tip3);
        String tip4 = "tip4";
        Wall walls4 = new Wall(true, false, false, false);
        Room room4 = new EmptyRoomImpl("Empty Room", "Nothing in this room", new Content[0], walls4, 3, 1, false, tip4);
        String tip5 = "tip5";
        Wall walls5 = new Wall(false, true, false, false);

        Room room5 = new EmptyRoomImpl("Empty Room", "Nothing in this room", new Content[0], walls5, 3, 2, false, tip5);
        String tip6 = "tip6";

        Content[] contents1 = new Content[2];
        contents1[0] = jewel3;
        contents1[1] = key;
        Wall walls6 = new Wall(false, true, true, true);
        Room room6 = new EmptyRoomImpl("Key and Gem", "", contents1, walls6, 0, 1, false, tip6);


        String tip7 = "You are at the start room please type : go north";
        Wall walls7 = new Wall(false, false, true, true);
        Room room7 = new EmptyRoomImpl("Start Room", "This is start room", new Content[0], walls7, 2, 0, false, tip7);

        String tip8 = "tip8";
        Content[] contents2 = new Content[1];
        contents2[0] = jewel1;
        Wall walls8 = new Wall(false, false, false, false);
        Room room8 = new EmptyRoomImpl("Gem   Room", "", contents2, walls8, 2, 1, false, tip8);

        String tip9 = "tip9";
        String desrc = "Please go north with an axe to kill Thanos";
        Wall walls9 = new Wall(false, false, false, false);
        Room room9 = new EmptyRoomImpl("Warn  Room", desrc, new Content[0], walls9, 2, 2, false, tip9);

        String tip10 = "tip10";
        Content[] contents3 = new Content[1];
        contents3[0] = boss;
        Wall walls10 = new Wall(false, false, false, false);
        Room room10 = new EmptyRoomImpl("ThanosRoom", "", contents3, walls10, 2, 3, false, tip10);

        
        String tip11 = "tip11";
        Content[] contents4 = new Content[1];
        contents4[0] = jewel4;
        Wall walls11 = new Wall(true, true, true, false);
        Room room11 = new EmptyRoomImpl("Gem   Room", "", contents4, walls11, 2, 4, false, tip11);

       
        String tip12 = "tip12";
        Content[] contents5 = new Content[2];
        contents5[0] = jewel2;
        contents5[1] = axe;
        Wall walls12 = new Wall(true, true, false, true);
        Room room12 = new EmptyRoomImpl("Gem    Axe", "", contents5, walls12, 4, 2, true, tip12);


        Room[] allRooms = new Room[12];
        allRooms[0] = room1;
        allRooms[1] = room2;
        allRooms[2] = room3;
        allRooms[3] = room4;
        allRooms[4] = room5;
        allRooms[5] = room6;
        allRooms[6] = room7;
        allRooms[7] = room8;
        allRooms[8] = room9;
        allRooms[9] = room10;
        allRooms[10] = room11;
        allRooms[11] = room12;

        Room[][] mazeArr = new Room[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                mazeArr[i][j] = new EmptyRoomImpl("         ", "", new Content[0], new Wall(true, true, true, true), i, j, false, "");
            }
        }

        for (Room room : allRooms) {
            mazeArr[room.getX()][room.getY()] = room;
        }
        return mazeArr;
    }

    public void play() {

        Scanner sc = new Scanner(System.in);
        Room room = rooms[user.getX()][user.getY()];

        String[] commands = new String[]{Command.GO_EAST, Command.GO_NORTH, Command.GO_SOUTH, Command.GO_WEST};
        boolean isAuto = false;
        boolean isTip = false;

        while (true) {

            String option = null;
            if (!isAuto) {
                System.out.println("Please enter " + Command.AUTO + " to enter auto play");
                if (isTip) {
                    System.out.println("Enter " + Command.TIP + " to close tip play");
                } else {
                    System.out.println("Enter " + Command.TIP + " to use tip play");
                }
                option = sc.nextLine();
            } else {
                System.out.println("Auto playing.................");
                Random random = new Random();
                option = commands[random.nextInt(commands.length)];
            }

            switch (option) {
                case Command.AUTO:
                    isAuto = true;
                    isTip = false;
                    break;
                case Command.TIP:
                    isTip = !isTip;
                    break;
                case Command.GO_EAST:
                    room = enterRoom(Command.GO_EAST);
                    break;
                case Command.GO_NORTH:
                    room = enterRoom(Command.GO_NORTH);
                    break;
                case Command.GO_SOUTH:
                    room = enterRoom(Command.GO_SOUTH);
                    break;
                case Command.GO_WEST:
                    room = enterRoom(Command.GO_WEST);
                    break;
                case Command.GET_GOODS:
                    user.showGoods();
                    break;
                case Command.SHOW_POSITION:
                    showMaze();
                    break;
                default:
                    System.out.println("Please reenter");
                    System.out.println("go east -->");
                    System.out.println("go south -->");
                    System.out.println("go west -->");
                    System.out.println("go north -->");
                    System.out.println("show items -->");
                    System.out.println("show maze -->");
                    break;
            }

            if (isGameOver()) {
                System.out.println("You collected all the gem! You win!");
                return;
            }
            if (isTip) {
                room.tip(); //cheat
            }
        }

    }

    public void showMaze() {

        for (int j = 4; j >= 0; j--) {
            for (int i = 0; i <= 4; i++) {

                if (i == user.getX() && j == user.getY()) {
                    System.err.printf("%6s", rooms[i][j].getName());
                } else {
                    System.out.printf("%6s", rooms[i][j].getName());
                }

            }
            System.out.println();
        }
    }

    public Room enterRoom(String direc) {

        //current room
        Room room = rooms[user.getX()][user.getY()];

        Room nextRoom = null;
        if (Command.GO_EAST.equals(direc)) {
            if (user.getX() == 4) {
                System.out.println("Wall");
                return room;
            }
            nextRoom = rooms[user.getX() + 1][user.getY()];
            if (nextRoom.getWall().isWestExist()) {
                System.out.println("Wall");
                return room;
            }
            if (room.getWall().isEastExist()) {
                System.out.println("Wall");
                return room;
            }
        }
        if (Command.GO_NORTH.equals(direc)) {
            if (user.getY() == 4) {
                System.out.println("Wall");
                return room;
            }
            nextRoom = rooms[user.getX()][user.getY() + 1];
            if (nextRoom.getWall().isSouthExist()) {
                System.out.println("Wall");
                return room;
            }
            if (room.getWall().isNorthExist()) {
                System.out.println("Wall");
                return room;
            }
        }
        if (Command.GO_SOUTH.equals(direc)) {
            if (user.getY() == 0) {
                System.out.println("Wall");
                return room;
            }

            nextRoom = rooms[user.getX()][user.getY() - 1];
            if (nextRoom.getWall().isNorthExist()) {
                System.out.println("Wall");
                return room;
            }
            if (room.getWall().isSouthExist()) {
                System.out.println("Wall");
                return room;
            }
        }
        if (Command.GO_WEST.equals(direc)) {
            if (user.getX() == 0) {
                System.out.println("Wall");
                return room;
            }
            nextRoom = rooms[user.getX() - 1][user.getY()];
            if (nextRoom.getWall().isEastExist()) {
                System.out.println("Wall");
                return room;
            }
            if (room.getWall().isWestExist()) {
                System.out.println("Wall");
                return room;
            }
        }

        if (nextRoom.getName().trim() == "") {
            System.out.println("Nothing there");
            return room;
        }

        if (nextRoom.isLock()) {
            System.out.println("You need a key");
            for (Content content : user.getContents()) {
                if (content.getGetName().equals(Constant.CONTENT_TYPE_KEY)) {
                    System.out.println("Opening the lock");
                    System.out.println("You entered the room");
                    nextRoom.cancelLock();
                }
            }
            if (nextRoom.isLock()) {
                System.out.println("It is locked, you need key");
                return room;

            }
        }

        for (Content content : nextRoom.getContent()) {
            if ((Constant.CONTENT_TYPE_MONSTER).equals(content.getGetType()) && content.isExisit()) {
                System.out.println("Monster is in the room!: " + content.getGetName());
                for (Content content1 : user.getContents()) {
                    if (content1.getGetType().equals(Constant.CONTENT_TYPE_EQU)) {
                        System.out.println("You used¡¾" + content1.getGetName() + "¡¿to kill " + content.getGetName());
                        content.dissolve();
                    }

                }
                if (content.isExisit()) {
                    //can not kill monster without axe
                    System.out.println("You need an powerful axe to kill Thanos");
                    return room;
                }

            }
            if (Constant.CONTENT_TYPE_JEWEL.equals(content.getGetType()) && content.isExisit()) {
                System.out.println("You just find " + content.getGetName());
                user.addContents(content);
                content.dissolve();
            }

            if (Constant.CONTENT_TYPE_EQU.equals(content.getGetType()) && content.isExisit()) {
                System.out.println("You just find " + content.getGetName());
                user.addContents(content);
                content.dissolve();
            }

            if (Constant.CONTENT_TYPE_KEY.equals(content.getGetType()) && content.isExisit()) {
                System.out.println("You just find " + content.getGetName());
                user.addContents(content);
                content.dissolve();
            }

        }
        //current room
        user.setXY(nextRoom.getX(), nextRoom.getY());
        System.out.println("Current room:" + nextRoom.getName() + "--" + nextRoom.getDesrc());
        return nextRoom;

    }

//test if the game is over
    public boolean isGameOver() {
        int jewelCount = 0;
        for (Content c : user.getContents()) {
            if (c.getGetType().equals(Constant.CONTENT_TYPE_JEWEL)) {
                jewelCount++;
            }
        }
        if (jewelCount == 4) {
            return true;
        } else {
            return false;
        }
    }

    public void welcome() {
        System.out.println("You are standing in a room, please find four gems to win the game. Welcome To The Zork! ");
    }

}

class Command {
    public static final String GO_EAST = "go east";
    public static final String GO_SOUTH = "go south";
    public static final String GO_WEST = "go west";
    public static final String GO_NORTH = "go north";
    public static final String GET_GOODS = "show goods";
    public static final String SHOW_POSITION = "show maze";
    public static final String AUTO = "auto";
    public static final String TIP = "tip";
}

