package com.synechron.wordcounter.service;

import org.springframework.stereotype.Component;

@Component
public class WordTranslatorService {

    //@Autowired
    //RestTemplate restTemplate;

    public String translate(String word) throws TranslationFailedException {
        //TODO Assuming there will be external API call here that returns an english word for a given word.
        //TODO For now just returning whatever the word is given
        //restTemplate.exchange("https://someopenAPI/translation", HttpMethod.GET, HttpResponse<T>);
        return word;
    }

}
