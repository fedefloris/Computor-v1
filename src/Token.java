public class Token {

  private final TokenType type;
  private final String value;

  public Token(String value, TokenType type) {
    this.value = value;
    this.type = type;
  }

  public TokenType getType() {
    return (type);
  }

  public String getValue() {
    return (value);
  }

}
