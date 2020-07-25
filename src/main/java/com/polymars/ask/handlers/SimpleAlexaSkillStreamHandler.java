package com.polymars.ask.handlers;

import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class SimpleAlexaSkillStreamHandler extends SkillStreamHandler {

    public SimpleAlexaSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandler(new HelpIntentHandler())
                .addRequestHandler(new CustomLaunchRequestHandler())
                .addRequestHandler(new ChooseCardIntentHandler())
                .addRequestHandler(new RequestHandIntentHandler())
                .addRequestHandler(new RequestPlayerBankIntentHandler())
                .addRequestHandler(new RequestOpponentBankIntentHandler())
                .addRequestHandler(new YesIntentHandler())
                .addRequestHandler(new NoIntentHandler())
                .addRequestHandler(new CancelIntentHandler())
                .addRequestHandler(new StopIntentHandler())
                .build());
    }
}