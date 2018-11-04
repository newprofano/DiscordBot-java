/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import utils.UTILS;

/**
 *
 * @author PC-PC
 */
public class messageListener extends ListenerAdapter {
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        
        
        if (event.getAuthor().isBot()) {
            return;       
        }
        
        if (event.getChannelType() == ChannelType.PRIVATE ) {
            event.getAuthor().openPrivateChannel().
                    complete().sendMessage
        ("**" + event.getAuthor().getName() + "**, Desculpa mas sou anti-social, não fale comigo!").queue();
           
        }
        
        String message = event.getMessage().getContentDisplay();
        String toUpperCase = message.toUpperCase();
        String antErro = toUpperCase.replaceAll(" ", "");
        if (message.startsWith(UTILS.getPrefix) && event.getAuthor().
                getId() != event.getJDA().getSelfUser().getId() ) {
            
            commandHandler.handlerCommand(commandHandler.parser.parse(message, event));
            
        }
        
        
        if (antErro.contains("PROFANO") || antErro.contains("NEW")) {
             
              event.getTextChannel().sendMessage("Estão falando de você Mestre").queue();
              event.getAuthor().openPrivateChannel().complete().sendMessage("Pare de falar do meu MESTRE, ou terei que tomar providências").queue();
              
              
            
        }
        
       
        
    }
    
}
