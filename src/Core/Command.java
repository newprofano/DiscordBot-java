/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author PC-PC
 */
public interface Command {
    boolean called(String[]args, MessageReceivedEvent event);
    void action(String[]args, MessageReceivedEvent event);
    void executed(boolean success, MessageReceivedEvent event);
    String help();
}
