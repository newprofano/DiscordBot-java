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
public class cmdFlood implements Command{
    
    EmbedBuilder error = new EmbedBuilder().setColor(Color.red);
    
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
                    error.setDescription("Me ajuda que eu flodo, me diz quantas e qual messagem quer flodar").build()
            ).queue();
        } 
        
        int numb = getInt(args[0]);
        String[] msg = event.getMessage().getContentDisplay().split(" ");
        
       
        
        String messag = event.getMessage().getContentDisplay().replace(msg[0] + "", "").replace(msg[1] + "", "");
       
        
        
        
        int flod = 0;
        
        while(flod <numb){
            
            event.getTextChannel().sendMessage(messag).queue();
        
            flod++;
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
