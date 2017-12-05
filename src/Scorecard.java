
public class Scorecard {
	private String[] frames;

	public Scorecard(String[] perfectGame) {
		this.frames = perfectGame;
	}
	
	public int getScore() {
		int score = 0;
		for (int i = 0; i < 10; i++) {
			int frame = getFrame(frames[i], i);
			score += frame;	
		}
		return score;
	}

	private int getFrame(String pinsRolled, int currentFrame) {
		String[] rolls = pinsRolled.split("");
		if (pinsRolled.equals("X") || pinsRolled.equals("XXX")) {
			int strike = getSrike(currentFrame);
			return strike;
		} else if (rolls[0].equals("/") || rolls[1].equals("/")) {
			int spare = getSpare(currentFrame);
			return spare;
		}
		return addFrame(pinsRolled.split(""));
	}
	
	private int getSpare(int currentFrame) {
		if (currentFrame == 9) {
			return 10 + Integer.parseInt(frames[currentFrame].substring(2));
		} else if (frames[currentFrame + 1].substring(0,  1).equals("X")) {
			return 20;
		}
			return 10 + Integer.parseInt(frames[currentFrame + 1].substring(0, 1));
	}

	private int getSrike(int currentFrame) {
		int score = 10;
		int[] nextRolls = new int[2];
		if (currentFrame < 9 && frames[currentFrame + 1].length() > 1) {
			if (frames[currentFrame + 1].equals("XXX")) {
				return 30;
			}
			nextRolls[0] = frames[currentFrame + 1].substring(0, 1).equals("X") ? 10 : Integer.parseInt(frames[currentFrame + 1].substring(0, 1));
			nextRolls[1] = frames[currentFrame + 1].substring(1, 2).equals("/") ? 10 - nextRolls[0] : Integer.parseInt(frames[currentFrame + 1].substring(1, 2));
			return score + nextRolls[0] + nextRolls[1];
		} else if (currentFrame < 9){
			nextRolls[0] = 10;
			nextRolls[1] = frames[currentFrame + 2].substring(0, 1).equals("X") ? 10 : Integer.parseInt(frames[currentFrame + 2].substring(0, 1));
			return score + nextRolls[0] + nextRolls[1];
		}
		nextRolls[0] = 10;
		nextRolls[1] = 10;
//		nextRolls[0] = frames[currentFrame].substring(1, 2).equals("X") ? 10 : Integer.parseInt(frames[currentFrame].substring(1, 2));
//		nextRolls[1] = frames[currentFrame].substring(2).equals("X") ? 10 : Integer.parseInt(frames[currentFrame].substring(2, 3));
		return score + nextRolls[0] + nextRolls[1];
	}

	private int addFrame(String[] individualRolls) {
		if (individualRolls.length < 3) {
			return Integer.parseInt(individualRolls[0]) + Integer.parseInt(individualRolls[1]);
		}
		return 20;
	}
}
