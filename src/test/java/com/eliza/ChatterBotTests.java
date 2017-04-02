package com.eliza;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Andrew on 4/1/2017.
 */
public class ChatterBotTests {
    private final Logger log = LoggerFactory.getLogger(ChatterBotTests.class);
    private final String message = "Hello.";

    @Test
    public void test_jabberwacky() throws  Exception{
        ChatterBot bot = new ChatterBotFactory().create(ChatterBotType.JABBERWACKY);
        ChatterBotSession session = bot.createSession();
        log.info("Jabberwacky message generated: {}", session.think(message));
    }

    @Test
    public void test_cleverbot() throws Exception{
        ChatterBot bot = new ChatterBotFactory().create(ChatterBotType.CLEVERBOT);
        ChatterBotSession session = bot.createSession();
        log.info("Cleverbot message generated: {}", session.think(message));
    }

    @Test
    public void test_pandorabots() throws Exception{
        ChatterBot bot = new ChatterBotFactory().create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
        ChatterBotSession session = bot.createSession();
        log.info("Message generated: {}", session.think(message));
    }
}
