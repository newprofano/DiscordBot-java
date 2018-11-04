package Connect;


import Commands.cmdFlood;
import Commands.cmdHelp;
import Commands.cmdLimpar;
import Commands.cmdPing;
import Core.commandHandler;
import Core.messageListener;
import Listenners.readyListener;
import com.sun.corba.se.impl.activation.CommandHandler;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC-PC
 */
public class Online {
    
    static JDA jda;
    public static void main(String[] args) {
        //coloque logo embaixo o token do seu bot
        String token = "";
        
        JDABuilder builder = new JDABuilder(AccountType.BOT)
                .setToken(token)
                .setAutoReconnect(true).setGame(Game.of(Game.GameType.DEFAULT, "Digite -help || Tetrix Online"));
                
        builder.addEventListener(new readyListener());
        builder.addEventListener(new messageListener());
        
        commandHandler.commands.put("help",new cmdHelp());
        commandHandler.commands.put("ping",new cmdPing());
        commandHandler.commands.put("clear",new cmdLimpar());
        commandHandler.commands.put("flod",new cmdFlood());
        
        
        try{
            builder.buildBlocking();
    }catch(LoginException e){
            System.out.println("deu ruim ao login, verifique se você colocou o token do seu bot");
    }catch(InterruptedException e){
            System.out.println("interrompido");
    }
  }
    
}
