package com.spring.ai.media.services;

import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AudioService {


    private final TranscriptionModel transcriptionModel;

    public AudioService(TranscriptionModel transcriptionModel) {
        this.transcriptionModel = transcriptionModel;
    }

    public String convertAudioToText(Resource inputAudio) {

        //speech to text
        return transcriptionModel.transcribe(inputAudio);

    }

    public String convertAudioToTextWithOptions(Resource inputAudio) {

        return transcriptionModel.transcribe(inputAudio, OpenAiAudioTranscriptionOptions.builder()
                .language("en")
                .temperature(0.7f)
                .prompt("Spring boot ")
                .build());
    }
}
