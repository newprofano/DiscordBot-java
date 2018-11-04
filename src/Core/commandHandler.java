/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.HashMap;

/**
 *
 * @author PC-PC
 */
public class commandHandler {
    
    public static HashMap<String, Command> commands = new HashMap<>();
    public static final commandParser parser = new commandParser();
    
    public static void handlerCommand(commandParser.commandContainer cmd){
        if(commands.containsKey(cmd.invoke)){
           boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
           
            if (!safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }else{
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }
    
}
