import java.util.regex.Pattern;

public class TokenPattern
{
  public final Pattern regex;
  public final int id;

  public TokenPattern(Pattern regex, int id)
  {
    this.regex = regex;
    this.id = id;
  }

}
