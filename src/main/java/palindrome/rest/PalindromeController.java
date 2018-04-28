package palindrome.rest;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import palindrome.model.PalindromeModel;
import palindrome.model.PalindromeModelFactory;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.exception.InvalidPalindromeException;
import palindrome.rest.json.FilterResponse;
import palindrome.rest.json.PalindromeFilterRequest;
import palindrome.rest.json.SaveRequest;
import palindrome.rest.json.SaveResponse;


@RestController
public class PalindromeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeController.class);

    @Value("${palindrome.model.type}")
    public String palindromeModelType;

    private PalindromeModel palindromeModel;


    @PostConstruct
    public void init() {
        LOGGER.info("PalindromeController is being initialized, palindrome model type = {}", palindromeModelType);
        palindromeModel = new PalindromeModelFactory().create(palindromeModelType);
        LOGGER.info("PalindromeController was initialized.");
    }


    @RequestMapping(path = "save")
    public SaveResponse save(@RequestBody SaveRequest request) {

        try {
            palindromeModel.save(request.getSequence());
        } catch (InvalidPalindromeException e) {
            LOGGER.warn("Cannot save the invalid palindrome!", e);
            return SaveResponse.RESPONSE_INVALID_PALINDROME;
        } catch (AlreadyExistingPalindromeException e) {
            LOGGER.warn("Already existing palindrome!", e);
            return SaveResponse.RESPONSE_PALINDROME_ALREADY_EXISTS;
        }

        return SaveResponse.RESPONSE_OK;
    }


    @RequestMapping(path = "filter")
    public FilterResponse filter(@RequestBody PalindromeFilterRequest palindromeFilterRequest) {
        LOGGER.info("Request: filter, parameter sequence={}", palindromeFilterRequest.getSequence());
        return new FilterResponse(palindromeModel.getPalindromes(palindromeFilterRequest.getSequence()));
    }


    @RequestMapping(path = "/")
    public String index() {
        LOGGER.info("Request: index.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("Enter the palindrome.");
        stringBuilder.append("<br>");
        stringBuilder.append("Use /save?sequence=\"palindrome sequence\" to save it.");
        stringBuilder.append("<br>");
        stringBuilder.append("Use /filter?sequence=\"token\" to filter saved palindromes.");
        return stringBuilder.toString();
    }

//    /**
//     * Standard html GET request to save new palindrom.
//     * 
//     * @param sequence
//     *            to be saved
//     * @return the response
//     */
//    @RequestMapping(method = RequestMethod.GET, path = "save")
//    public SaveResponse save(@RequestParam(name = "sequence") String sequence) {
//        LOGGER.info("Request: save, parameter sequence={}", sequence);
//
//        try {
//            palindromeModel.save(sequence);
//        } catch (InvalidPalindromeException e) {
//            LOGGER.warn("Cannot save the invalid palindrome!", e);
//            return SaveResponse.RESPONSE_INVALID_PALINDROME;
//        } catch (AlreadyExistingPalindromeException e) {
//            LOGGER.warn("Already existing palindrome!", e);
//            return SaveResponse.RESPONSE_PALINDROME_ALREADY_EXISTS;
//        }
//
//        return SaveResponse.OK;
//    }
//
//
//    /**
//     * Standard html GET request to filter stored palindromes.</br>
//     * Example: <code>http://localhost:8080/filter?sequence=asdf</code>
//     * 
//     * @param sequence
//     *            used to filter already stored palindromes. Can be <code>null</code> and at that case all saved
//     *            palindromes are returned.
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.GET, path = "filter")
//    public FilterResponse filter(@RequestParam(name = "sequence", required = false) String sequence) {
//        LOGGER.info("Request: filter, parameter sequence={}", sequence);
//        return new FilterResponse(palindromeModel.getPalindromes(sequence));
//    }

}
