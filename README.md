## Word Counter SpringBoot Application

##### A Simple word counter application built on Java 8 with spring boot framework. Swagger API specification can be seen on the 
url http://localhost:8080/swagger-ui.html

Have yml files to be able to deploy it on cloud

### Environment:

- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

### Data:

Example of a wordcount data JSON object:

```
    "word": "sample",
    "occurrence": 1,
}
```

### Requirements:

The REST service exposed the `/wordcounter` endpoint, which allows users to add words and find the number of times each
word was added.

**POST** request to `/wordcounter/add`:

- creates a new word
- expects a valid word (alphabetic).
- adds the given word to the collection.
- the response code is 201, and the response body is the created wordcount object.

**GET** request to `/wordcounter/find?word=<sample>`:

- returns a wordcount object with the given word (query param)
- if the matching word exists, the response code is 200 and the response body is the matching wordcount object
- if there is no word with the given word in the collection, the response code is 404

**GET** request to `/wordcounter/findAll`:

- return a collection of all the words
- the response code is 200, and the response body is an array of all wordcount objects

### Commands

- run:

```bash
mvn clean package; java -jar target/wordcounter-1.0.jar
```

- install:

```bash
mvn clean install
```

- test:

```bash
mvn clean test
```
