/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Core.Command;
import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author PC-PC
 */
public class cmdPing implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
       return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
       event.getTextChannel().sendMessage(
               new EmbedBuilder()
                       .setColor(new Color(234,244,200))
                       .setAuthor("Ping!", null, event.getJDA().getSelfUser().getAvatarUrl())
                       .setThumbnail("https://cdn.pixabay.com/photo/2012/04/13/00/23/tower-31235_960_720.png")
                       .setDescription("Pong! :ping_pong:")
                       .addField("Latency", event.getJDA().getPing()+"ms", true)
                       .build()
       ).queue();
    }
//cor 
    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        
    }

    @Override
    public String help() {
        return null;
    }
    
}
