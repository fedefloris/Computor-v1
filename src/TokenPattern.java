import java.util.regex.Pattern;

public class TokenPattern {

  public final Pattern regex;
  public final TokenType type;

  public TokenPattern(Pattern regex, TokenType type) {
    this.regex = regex;
    this.type = type;
  }

}
