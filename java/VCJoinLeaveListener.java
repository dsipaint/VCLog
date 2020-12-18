import java.time.Instant;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class VCJoinLeaveListener extends ListenerAdapter
{
	public void onGuildVoiceJoin(GuildVoiceJoinEvent e)
	{
		e.getGuild().getTextChannelById(Main.LOG_CHANNEL).sendMessage(
				":loud_sound: " + Instant.now().toString().replace("T", " ").replace("Z", "UTC") + " - " 
						+ e.getMember().getUser().getAsTag() + " joined #" + e.getChannelJoined().getName()).queue();
	}
	
	public void onGuildVoiceLeave(GuildVoiceLeaveEvent e)
	{
		e.getGuild().getTextChannelById(Main.LOG_CHANNEL).sendMessage(
				":loud_sound: " + Instant.now().toString().replace("T", " ").replace("Z", "UTC") + " - " 
						+ e.getMember().getUser().getAsTag() + " left #" + e.getChannelLeft().getName()).queue();
	}
	
	public void onGuildVoiceMove(GuildVoiceMoveEvent e)
	{
		e.getGuild().getTextChannelById(Main.LOG_CHANNEL).sendMessage(
				":loud_sound: " + Instant.now().toString().replace("T", " ").replace("Z", "UTC") + " - " 
						+ e.getMember().getUser().getAsTag() + " moved from #" + e.getChannelLeft().getName() + " to #" + e.getChannelJoined().getName()).queue();
	}
}
