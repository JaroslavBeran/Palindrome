package palindrome.rest.json;

import java.util.ArrayList;
import java.util.List;


public class FilterResponse {

    private final List<String> palindromes;


    public FilterResponse() {
        palindromes = new ArrayList<>();
    }


    public FilterResponse(List<String> palindromes) {
        this.palindromes = palindromes;
    }


    public List<String> getPalindromes() {
        return palindromes;
    }

}
