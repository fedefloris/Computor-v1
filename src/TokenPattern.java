import java.util.regex.Pattern;

public class TokenPattern {

  private final Pattern regex;
  private final TokenType type;

  public TokenPattern(Pattern regex, TokenType type) {
    this.regex = regex;
    this.type = type;
  }

  public Pattern getRegex() {
    return (regex);
  }

  public TokenType getType() {
    return (type);
  }

}
