/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Core.Command;
import java.awt.Color;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author PC-PC
 */
public class cmdLimpar implements Command {
    
    EmbedBuilder error = new EmbedBuilder().setColor(Color.RED);
    
    private int getInt (String string){
        try{
            return Integer.parseInt(string);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        
        
        
        if (args.length < 1) {
            event.getTextChannel().sendMessage(
                    error.setDescription("Me ajuda ai né, me diz quantas mensagens quer apagar se não vai dar néh, sou um bot, não um vidente").build()
            ).queue();
        } 
            int numb = getInt(args[0]);
        
            if (numb >1 && numb <=1000000000) {
                try{
                MessageHistory history = new MessageHistory(event.getChannel());
                List<Message> msgs;
                
                event.getMessage().delete().queue();
                
                msgs = history.retrievePast(numb).complete();
                
                event.getTextChannel().deleteMessages(msgs).queue();
                
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                
            }
        
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
     
    }

    @Override
    public String help() {
        return null;
    }
    
}
