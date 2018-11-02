public class Token {

  public final TokenType type;
  public final String value;

  public Token(String value, TokenType type) {
    this.value = value;
    this.type = type;
  }

}
