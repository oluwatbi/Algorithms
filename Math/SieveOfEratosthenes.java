/**
 * Use the sieve of eratosthenes to find all the prime
 * numbers up to a certain limit.
 * @author William Fiset, william.alexandre.fiset@gmail.com
 **/

public class SieveOfEratosthenes {

  // Gets all primes up to, but NOT including limit (returned as a list of primes)
  static int[] sieve(int limit) {

    if (limit <= 2) return new int[0];

    // Use the prime number theorem to find an upper 
    // bound on the number of primes up to the limit
    final int numPrimes = (int)(1.25506 * limit / Math.log((double) limit));
    int[] primes = new int[numPrimes];
    int index = 0;

    boolean[] isComposite = new boolean[limit];
    final int sqrtLimit = (int) Math.sqrt(limit);
    for (int i = 2; i <= sqrtLimit; i++) {
      if (!isComposite[i]) {
        primes[index++] = i;
        for (int j = i * i; j < limit; j += i)
          isComposite[j] = true;
      }
    }
    for (int i = sqrtLimit + 1; i < limit; i++)
      if (!isComposite[i])
        primes[index++] = i;
    return java.util.Arrays.copyOf(primes, index);

  }

  public static void main(String[] args) {
    
    // Generate all the primes up to 29 not inclusive
    int[] primes = sieve(29);

    // Prints [2, 3, 5, 7, 11, 13, 17, 19, 23]
    System.out.println(java.util.Arrays.toString(primes));

  }

}