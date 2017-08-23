import java.util.Scanner;

public class VoteCounter {

  public static void main( String[] args ) {
    Scanner scanner = new Scanner( System.in );
    Candidate[] cand;
    /*
     *   Läs in kandidater
     */
    System.err.print( "Hur många kandidater? " );
    int k = scanner.nextInt();
    cand = new Candidate[k];
    for ( int i = 0; i < k; i++ ) {
      System.err.print( "Namn på kandidat " + i + ": " );
      String n = scanner.next();
      cand[i] = new Candidate( n );
    }
    /*
     *   Läs in röster
     */
    System.err.print( "En röst på kandidat nr: " );
    int n = scanner.nextInt();
    while ( n >= 0 && n < cand.length ) {
      cand[n].addVote();
      System.err.print( "En röst på kandidat nr: " );
      n = scanner.nextInt();
    }
    /*
     *   Skriv ut resultat
     */
    for ( int i = 0; i < cand.length; i++ ) {
      System.out.println( cand[i].getVotes() + " röster på " + cand[i].getName() );
    }
  }
}
