package music;

import gui.GlavniProzor;

public class Text extends Thread {

	private String singerName;
	private Voice voice;
	private Performance performance;

	private boolean stopIt;
	private Synchronizer1 synch;
	private GlavniProzor gp;

	public Text(String singerName, Voice voice, Performance performance, boolean stopIt, Synchronizer1 synch2,
			GlavniProzor gp) {
		super();
		this.gp = gp;
		this.singerName = singerName;
		this.voice = voice;
		this.performance = performance;
		this.stopIt = stopIt;
		this.synch = synch2;
	}

	public Text(String singerName, Voice voice, Performance performance, boolean stopIt, GlavniProzor gp) {
		super();
		this.gp = gp;
		this.singerName = singerName;
		this.voice = voice;
		this.performance = performance;
		this.stopIt = stopIt;
	}

	public Text() {
		super();
	}

	@Override
	public void run() {
		napisi();
	}

	private void sing(String lyrics, int delay) {
		String s = gp.textArea.getText() + "\n";
		s += lyrics;
		gp.textArea.setText(s);
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private synchronized void napisi() {
		while (!stopIt) {
			if (synch == null) {
				if (this.voice == Voice.FIRST) {
					sing(performance.getLyrics(), performance.getDelay());
				} else if (this.voice == Voice.SECOND) {
					sing(performance.getLyrics(), performance.getDelay());
				} else {
					sing(performance.getLyrics(), performance.getDelay());
				}
			} else {
				if (this.voice == Voice.FIRST) {
					this.synch.singFirstVoice(performance.getLyrics(), performance.getDelay());
				} else if (this.voice == Voice.SECOND) {
					this.synch.singSecondVoice(performance.getLyrics(), performance.getDelay());
				} else {
					this.synch.backVoice(performance.getLyrics(), performance.getDelay());
				}
			}
		}
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public boolean isStopIt() {
		return stopIt;
	}

	public void setStopIt(boolean stopIt) {
		this.stopIt = stopIt;
	}

	public Synchronizer1 getSynch() {
		return synch;
	}

	public void setSynch(Synchronizer1 synch) {
		this.synch = synch;
	}

}
