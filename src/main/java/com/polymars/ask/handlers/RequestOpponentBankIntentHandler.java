package com.polymars.ask.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.polymars.game.*;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class RequestOpponentBankIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("RequestOpponentBankIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return handlerInput.getResponseBuilder()
                .withSpeech(Game.game("opponentbank"))
                .build();
    }
}