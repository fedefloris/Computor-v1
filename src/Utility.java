public class Utility {

  public static double sqrt(double x) {
    double epsilon = 1e-15;
    double guess;

    guess = x;
    while (Math.abs(guess - x / guess) > epsilon * guess)
      guess = (x / guess + guess) / 2.0;
    return (guess);
  }

}
