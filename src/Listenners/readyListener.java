/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listenners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author PC-PC
 */
public class readyListener extends ListenerAdapter {
    
    public void onReady(ReadyEvent event){
        String servers = "\n Este Bot esta sendo usado nestes servidores: \n";
        
        
        
        for (Guild g: event.getJDA().getGuilds()) {
            servers += "\n" + g.getName() + "("+ g.getId() + ")";
        }
        
        
        System.out.println(servers);
        event.getJDA().getTextChannelById("501895998084481025")
                .sendMessage("Chegueiii").queue();
       
        
       
     
        
        
        
        
    }
    
}
