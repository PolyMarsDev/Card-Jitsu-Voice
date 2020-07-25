package com.polymars.ask.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.polymars.game.*;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class ChooseCardIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("ChooseCardIntent"));
    }
    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {

        Map<String, Slot> slots = ((IntentRequest)handlerInput.getRequestEnvelope().getRequest()).getIntent().getSlots();
        String input = slots.get("element").getValue() + " " + slots.get("number").getValue();
        return handlerInput.getResponseBuilder()
                .withSpeech(Game.game(input))
                .build();
    }
}