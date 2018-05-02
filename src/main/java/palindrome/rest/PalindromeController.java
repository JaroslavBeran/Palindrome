package palindrome.rest;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import palindrome.model.PalindromeModel;
import palindrome.model.PalindromeModelFactory;
import palindrome.model.PalindromeModelFactory.PalindromeModelType;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.exception.InvalidPalindromeException;
import palindrome.rest.json.FilterRequest;
import palindrome.rest.json.FilterResponse;
import palindrome.rest.json.SaveRequest;
import palindrome.rest.json.SaveResponse;


@RestController
public class PalindromeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeController.class);

    // application cmdline option: --palindrome.model.type=ENTITY
    @Value("${palindrome.model.type}")
    public PalindromeModelType palindromeModelType = PalindromeModelFactory.PalindromeModelType.ENTITY;

    private PalindromeModel palindromeModel;


    @PostConstruct
    public void init() {
        LOGGER.info("PalindromeController is being initialized, palindrome model type = {}", palindromeModelType);
        palindromeModel = new PalindromeModelFactory().create(palindromeModelType);
        LOGGER.info("PalindromeController was initialized.");
    }


    @RequestMapping(path = "/save")
    public SaveResponse save(@RequestBody String request) {
        LOGGER.info("Incoming save request: " + request);
        SaveRequest saveRequest;

        try {
            saveRequest = new ObjectMapper().readValue(request, SaveRequest.class);
        } catch (JsonParseException e) {
            LOGGER.error("Cannot parse incoming save request : ", e);
            return SaveResponse.cannotParseJSONStructure();
        } catch (JsonMappingException e) {
            LOGGER.error("Cannot map incoming save request : ", e);
            return SaveResponse.cannotMapJSONStructure();
        } catch (IOException e) {
            LOGGER.error("Cannot read incoming save request : ", e);
            return SaveResponse.ioError();
        }

        try {
            palindromeModel.save(saveRequest.getSequence());
            LOGGER.info("Incoming save request was saved");
        } catch (InvalidPalindromeException e) {
            LOGGER.warn("Cannot save the invalid palindrome!", e);
            return SaveResponse.invalidPalindrome();
        } catch (AlreadyExistingPalindromeException e) {
            LOGGER.warn("Already existing palindrome!", e);
            return SaveResponse.alreadyExists();
        }

        return SaveResponse.ok();
    }


    @RequestMapping(path = "/filter")
    public FilterResponse filter(@RequestBody String request) {
        LOGGER.info("Incoming filter request: " + request);
        FilterRequest filterRequest;

        try {
            filterRequest = new ObjectMapper().readValue(request, FilterRequest.class);
        } catch (JsonParseException e) {
            LOGGER.error("Cannot parse incoming save request : ", e);
            return FilterResponse.cannotParseJSONStructure();
        } catch (JsonMappingException e) {
            LOGGER.error("Cannot map incoming save request : ", e);
            return FilterResponse.cannotMapJSONStructure();
        } catch (IOException e) {
            LOGGER.error("Cannot read incoming save request : ", e);
            return FilterResponse.ioError();
        }

        LOGGER.info("Request: filter, parameter sequence={}", filterRequest.getSequence());
        return FilterResponse.ok(palindromeModel.getPalindromes(filterRequest.getSequence()));
    }

}
