package oakbot.command;

import oakbot.bot.Bot;
import oakbot.bot.ChatCommand;
import oakbot.bot.ChatResponse;
import oakbot.bot.ShutdownException;
import oakbot.util.ChatBuilder;

/**
 * Shuts down the bot.
 * @author Michael Angstadt
 */
public class ShutdownCommand implements Command {

	@Override
	public String name() {
		return "shutdown";
	}

	@Override
	public String description() {
		return "Terminates the bot (admins only).";
	}

	@Override
	public String helpText(String trigger) {
		return description();
	}

	@Override
	public ChatResponse onMessage(ChatCommand chatCommand, boolean isAdmin, Bot bot) {
		if (isAdmin) {
			throw new ShutdownException("Shutting down.  See you later.");
		}

		//@formatter:off
		return new ChatResponse(new ChatBuilder()
			.reply(chatCommand)
			.append("Only admins can shut me down. :P")
		);
		//@formatter:on
	}
}
