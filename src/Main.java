
public class Main {
	public static void main (String[] args) {
		RandomScoreGenerator r = new RandomScoreGenerator();
		String[] player = r.generate();
		Scorecard scorecard = new Scorecard(player);
		int score = scorecard.getScore();
		System.out.println("Your score is " + score);
	}
}
