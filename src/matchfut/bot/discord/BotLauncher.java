package matchfut.bot.discord;

import java.util.EnumSet;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;
import matchfut.bot.discord.commands.PingCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class BotLauncher extends ListenerAdapter{
    
    public static JDA jda;
    public static void main(String[] args) throws LoginException{
        Dotenv dotenv = Dotenv.load();
        String TOKEN = dotenv.get("TOKEN");
        jda = JDABuilder.createDefault(TOKEN, EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new BotLauncher());
        jda.addEventListener(new PingCommand());
    }
}
