package com.krazytar;

import java.util.Scanner;

public class Input {
    
    public static String readInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase();
    }
    
    public static void runCommand(String command) {
        String[] com = command.split(" ");
        
        // Go command
        if(com[0].equals("go")) {
            if(com.length > 1) {
                String argument = new String();
                Exit exit = null;
                for(int i = 1; i < com.length; i++) {
                    argument += com[i] + " ";
                }
                argument = argument.trim();
                System.out.println(argument);
                for(Exit e : Player.getCurrentRoom().exits) {
                    for(String c : e.commands) {
                        if(c.equals(argument)) {
                            exit = e;
                            break;
                        }
                    }
                }
                if(exit != null) {
                    Player.setCurrentRoom(Loader.loadRoom(exit.roomID));
                }
                
            } else {
                System.out.println(Loader.commandHelp("go"));
            }
        } 
        
        // Exits command
        else if(com[0].equals("exits")) {
            for(Exit e : Player.getCurrentRoom().exits) {
                System.out.println(e.name + "/");
            }
        }
        
        
    }
}
