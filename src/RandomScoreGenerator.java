
public class RandomScoreGenerator {

	public String[] generate() {
		String[] randomScore = new String[10];
		for (int i=0 ; i < randomScore.length ; i++) {
			int pins = 11;
			randomScore[i] = "" + (int)(Math.random() * pins);
			pins -= Integer.parseInt(randomScore[i]);
			randomScore[i] = randomScore[i] + (int)(Math.random() * pins);
		}
		return randomScore;
	}
}
