## Inspiration
Originally, I had an idea for making a web app that communicated through SMS for using as a hotline. 
However, as there are already resources for that which don't require developing a new web app, 
I strayed away from that but still wanted to build on the tools for making something similar. 
Then, I thought about making a simple chat bot to talk to, 
however parsing English and understanding it seemed daunting. 
My coworker linked me to [ELIZA](https://en.wikipedia.org/wiki/ELIZA) after I mentioned the idea to him, 
and I found it fascinating. I was sure that it would be something manageable to do on my own, 
and what better way to try it out than at a hackathon?

## What it does
I created an account for Twilio, which gave me access to a phone number to communicate with. 
By texting it, it hits a REST endpoint GET request which is connected to a Spring Framework backend 
that accepts the text message. The backend takes the payload and uses an open source Java implementation 
of [Pandorabots](http://docs.pandorabots.com/) to create a reply message. 
After the bot generates this message, it is sent back through as a POST request which replies to 
the number that sent the initial message.

## How I built it
I built this project with Maven dependencies, building a [Spring Framework](https://spring.io/) 
backend controller that used [Twilio's REST API](https://www.twilio.com/docs/) to 
receive HTTP requests. I let Twilio do the work for handling passing text messages around, 
and I let an open source [ELIZA]](https://github.com/pierredavidbelanger/chatter-bot-api) 
implementation do the actual response generation.

## Challenges I ran into
The very first challenge I ran into was time. This wasn't my first project idea, 
but I quickly changed my game plan after realizing that my other project idea was not 
feasible by myself, and maybe not even with a team in just 36 hours 
(at least not without prior knowledge and experience). 
As such, I started this project with a decent chunk of time exhausted into a completely 
different project idea that wouldn't transfer over. 
Despite this, I struggled onwards. I think the biggest problem I had was just setting up 
the project. Most of my time was spent trying to test whether I could actually effectively 
hit endpoints with the REST calls. I spent a substantial amount of time reading over the tutorials, 
guides, and docs for Twilio but none of them really answered my questions. After quite a 
lot of struggling, and many breaks, I finally managed to figure out how to connect 
Twilio to my Spring app. The next challenge, and last one for this hack, that came up 
was using the open source ELIZA implementation because although there was an example of usage, 
there were 3 different types of bots to choose from and it didn't really specify which would 
do what. I ended up resolving this by writing unit tests that logged the responses of each 
bot type for the same string to see which one I wanted to use.

## Accomplishments that I'm proud of
This is my second hackathon ever, and my first done solo. My first one was with a team of 4, 
so as such I definitely tried to gauge how much work I could actually accomplish on my own. 
Although this is not my first time using Spring, this was my first time successfully 
starting a Spring app from scratch, rather than maintaining one. Also, I think that 
being able to fumble my way through Twilio for the first time is also something to be proud of. 

## What I learned
I learned a bit about using the Reddit API, and using Python for a backend 
(the project I started initially), but after switching gears, I definitely feel more 
confident with Spring, and I learned a lot about Twilio, as I explored my options with 
their different supported languages in case I wasn't able to get it set up with Java and 
Spring to support the backend. I also learned a little more about Git pushing the project 
to my GitHub - don't want to be posting my phone number or the Twilio number open to 
the public on GitHub. To top it all off, I learned a lot about the sponsors that came out 
to the event. Completely unrelated, I also learned that W&M has a large campus and that 
I can get lost very easily here. 

## What's next for Modern ELIZA
In it's current state, the ELIZA bot I hacked together for this event simply uses a Java 
implementation for ELIZA, which has been around since the 1960's. 
One of the things I was most concerned about was exposing people's phone numbers. 
When I started messing around with the Twilio API, I followed tutorials, and some of them 
had me storing my authentication key and phone number as strings in the code. I was wary of 
pushing this code to GitHub as I progressed because of that, so I waited until I finished the 
project in it's entirety before I pushed it all to GitHub, making sure that I removed all of 
my personal information from it. 
Another thing that I could look into is other mediums of communication, such as other 
chatting services, i.e.: Twitter, other API's, as well as Twilio's voice communication. 
Something that would really revolutionize this project would be trying to implement a smarter 
version of ELIZA, or rather, an actual learning AI to communicate with. I don't think this is 
something that is within the scope of a 36 hour hackathon, but it's definitely something I'd 
be interested in tackling. 