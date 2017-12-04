
public class Scorecard {
	private String[] frames;

	public Scorecard(String[] perfectGame) {
		this.frames = perfectGame;
	}

	public String[] getFrames() {
		return frames;
	}

	public void setFrames(String[] frames) {
		this.frames = frames;
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
		if (pinsRolled.equals("X")) {
			int strike = getSrike(pinsRolled, currentFrame);
			return strike;
		} else if (pinsRolled.equals("/")) {
			return 15;
		}
		return addFrame(pinsRolled.split(""));
	}
	
	private int getSrike(String pinsRolled, int currentFrame) {
		if (currentFrame == 9 || frames[currentFrame + 1].equals("X")) {
			return 30;
		}
		return 10;
	}

	private int addFrame(String[] individualRolls) {
		return (individualRolls[0].equals("_") ? 0 : Integer.parseInt(individualRolls[0])) + (individualRolls[1].equals("_") ? 0 : Integer.parseInt(individualRolls[1]));
	}
}
