package matchfut.bot.discord.commands;

import matchfut.bot.discord.BotLauncher;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        
        String[] args = event.getMessage().getContentRaw().split(" ");
        int ping = (int) BotLauncher.jda.getGatewayPing();

        if (args[0].equalsIgnoreCase("/" + "ping")){
            event.getMessage().reply("**:ping_pong: | Pong!**" + "\nLatência de: "+ "**" + ping + "ms**").queue(null, null);
        }
    }
    
}
