import java.util.List;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationTokenizer {

  private List<TokenPattern> tokenPatterns;
  private List<Token> tokens;

  public EquationTokenizer() {
    tokens = new LinkedList<Token>();
    tokenPatterns = new LinkedList<TokenPattern>();
  }

  public void add(String regex, int id) {
    TokenPattern pattern;

    pattern = new TokenPattern(Pattern.compile("^("+regex+")"), id);
    tokenPatterns.add(pattern);
  }

  public void tokenize(String str) {
    tokens.clear();
    while (!str.equals("")) {
      boolean match = false;
      for (TokenPattern pattern : tokenPatterns) {
        Matcher m = pattern.regex.matcher(str);
        if (m.find()) {
          match = true;
          String tok = m.group().trim();
          str = m.replaceFirst("").trim();
          tokens.add(new Token(tok, pattern.id));
          break;
        }
      }
      if (!match)
        throw new ParserException("Unexpected character in input: " + str);
    }
  }

  public List<Token> getTokens() {
    return tokens;
  }

}
