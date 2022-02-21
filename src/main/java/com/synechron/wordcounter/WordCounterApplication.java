package com.synechron.wordcounter;

import com.synechron.wordcounter.repository.WordCounterRepository;
import com.synechron.wordcounter.service.WordCounterService;
import com.synechron.wordcounter.service.WordTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WordCounterApplication implements CommandLineRunner {

    public WordCounterApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(WordCounterApplication.class, args);
    }

    @Autowired
    private WordCounterRepository wordCounterRepository;

    @Autowired
    private WordTranslatorService wordTranslatorService;

    @Bean
    public WordCounterService getWordCountService(){
        return  new WordCounterService(wordCounterRepository, wordTranslatorService);
    }

    //TODO the following method can be extended if this has to run as stand alone application
    // and take ask for input from the users using system.io

    @Override
    public void run(String... args) throws Exception {
        getWordCountService().hello();
    }
}
