package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("traduce a español(es)  - ES el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
