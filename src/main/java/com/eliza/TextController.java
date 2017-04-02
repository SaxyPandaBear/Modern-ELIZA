package com.eliza;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import com.twilio.http.TwilioRestClient;
import com.twilio.twiml.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 4/1/2017.
 */
@RestController
public class TextController {
    private static final Logger log = LoggerFactory.getLogger(TextController.class);

    @RequestMapping(method = RequestMethod.GET)
    public void receive(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String message = request.getParameter("Body");
        log.info(String.format("Message received: %s",message));
        MessagingResponse messagingResponse = sendSMS(message);

        response.setContentType("application/xml");

        /* this part handles the reply post method */
        try {
            response.getWriter().print(messagingResponse.toXml());
        } catch (TwiMLException e) {
            log.info("error -> {}", e.getMessage());
        }
    }
/*
    @RequestMapping(method = RequestMethod.POST)
    public MessagingResponse reply(MessagingResponse message) throws Exception{
        return message;
    }
*/
    public MessagingResponse sendSMS(String message){
        try {
            ChatterBot bot = new ChatterBotFactory().create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
            ChatterBotSession session = bot.createSession();

            Message reply = new Message.Builder().body(new Body(session.think(message))).build();
            MessagingResponse twiml = new MessagingResponse.Builder().message(reply).build();
            //reply(twiml);
            return twiml;
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
        return new MessagingResponse.Builder().message(
                new Message.Builder().body(new Body("An error occurred.")).build())
                .build();
    }
}
