/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.UTILS;

/**
 *
 * @author PC-PC
 */
public class commandParser {
    
    public commandContainer parse(String raw, MessageReceivedEvent event){
        
        String beheaded = raw.replaceFirst(UTILS.getPrefix,"");
        String[] splitBeHeaded = beheaded.split(" ");
        String invoke = splitBeHeaded[0];
        
        ArrayList<String>split = new ArrayList<>();
        for (String s : splitBeHeaded) {
            split.add(s);
            
        }
        String[] args = new String[split.size()-1];
        split.subList(1, split.size()).toArray(args);
        
        return new commandContainer(raw,beheaded,splitBeHeaded,invoke,args,event);
        
        
    }
    
    public class commandContainer{
        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[]args;
        public final MessageReceivedEvent event;
        
        public commandContainer(String rw, String beHeaded, String[]splitBeHeaded, String invoke, String[] args, MessageReceivedEvent event){
            this.raw = rw;
            this.beheaded = beHeaded;
            this.splitBeheaded = splitBeHeaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
            
            
        }
        
        
    }
}
