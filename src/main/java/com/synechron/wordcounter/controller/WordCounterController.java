package com.synechron.wordcounter.controller;


import com.synechron.wordcounter.model.WordCount;
import com.synechron.wordcounter.service.WordCounterService;
import com.synechron.wordcounter.service.WordValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("wordcounter")
public class WordCounterController {
    private static final Logger LOGGER= LoggerFactory.getLogger(WordCounterController.class);

    @Autowired
    private WordCounterService wordCounterService;

    public WordCounterController(WordCounterService wordCounterService) {
        this.wordCounterService = wordCounterService;
    }

    @PostMapping("/add/{word}")
    public ResponseEntity addWord(@PathVariable String word){
        LOGGER.info("request entered add api with path param : {}" , word);

        if(!WordValidator.isValidWord(word)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        WordCount wordCount = wordCounterService.add(word);
        if(wordCount != null){
            return new ResponseEntity<>(wordCount,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("error occurred",HttpStatus.CONFLICT);
    }

    @GetMapping(value = "/find", produces = "application/json")
    public ResponseEntity find(@RequestParam String word){
        LOGGER.info("request entered find api with req param : {}" , word);
        Optional<WordCount> optionalWordCount = wordCounterService.get(word);
        if(optionalWordCount.isPresent()){
            return new ResponseEntity<>(optionalWordCount.get(),HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Word not found" , HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity findAll(){
        LOGGER.info("request entered findAll api");
        List<WordCount> allWordCounts = wordCounterService.getAll();
        return new ResponseEntity<>(allWordCounts, HttpStatus.OK);
    }

}