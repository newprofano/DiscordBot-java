/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Core.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author PC-PC
 */
public class cmdHelp implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
       return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
      event.getTextChannel().sendMessage("============COMANDOS============" + 
              "\n '-help' - Já esta usando o.O" + 
              "\n '-ping' - Mostra o ping do bot" +
              "\n '-clear' - Limpa mensagens do chat ex: -clear 10" +
              "\n '-flod' - Floda uma mensagem ex: -flod 10 Alo"+
              "\n =================================")
              .queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
         
    }

    @Override
    public String help() {
        return null;
        
    }
    
}
