/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import gui.GlavniProzor;
import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Synchronizer1;
import music.Text;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer backVoice;
	private Text pattiSmith1;
	private Text bruceSpringsteen1;
	private Text backVoice1;
	private GlavniProzor gp;

	public Test() {
	}

	public Test(GlavniProzor gp) {
		this.gp = gp;
	}

	private void initializeSingingInThreads() {
		String lyrics1 = "Because the night belongs to lovers";
		String lyrics2 = "Because the night belongs to us";
		String lyrics3 = "(Because the night)";

		boolean stopIt = false;
		Synchronizer synch = new Synchronizer(true, false, false);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance backVoicePerformance = new Performance(lyrics3, 1500);

		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		backVoice = new Singer("BackVoice", Voice.BACKGROUND, backVoicePerformance, stopIt, synch);
	}

	private void initializeSingingInThreadsGP() {
		String lyrics1 = "Because the night belongs to lovers";
		String lyrics2 = "Because the night belongs to us";
		String lyrics3 = "(Because the night)";

		boolean stopIt = false;
		Synchronizer1 synch = new Synchronizer1(true, false, false, gp);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance backVoicePerformance = new Performance(lyrics3, 1500);

		pattiSmith1 = new Text("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch, gp);
		bruceSpringsteen1 = new Text("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch, gp);
		backVoice1 = new Text("BackVoice", Voice.BACKGROUND, backVoicePerformance, stopIt, synch, gp);
	}

	public void testSingInThreads() {

		initializeSingingInThreads();

		pattiSmith.start();
		bruceSpringsteen.start();
		backVoice.start();

		IN.nextLine();
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		backVoice.setStopIt(true);

	}

	public void pokreni() {
		initializeSingingInThreadsGP();

		pattiSmith1.start();
		bruceSpringsteen1.start();
		backVoice1.start();
	}

	public void stop() {
		if (pattiSmith1 != null)
			pattiSmith1.setStopIt(true);
		if (bruceSpringsteen1 != null)
			bruceSpringsteen1.setStopIt(true);
		if (backVoice != null)
			backVoice.setStopIt(true);
	}

	public void pokreniPattiSmith() {
		String lyrics1 = "Because the night belongs to lovers";
		boolean stopIt = false;
		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		pattiSmith1 = new Text("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, gp);
		pattiSmith1.start();
	}

	public void pokrenibruceSpringsteen() {
		String lyrics2 = "Because the night belongs to us";
		boolean stopIt = false;
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		bruceSpringsteen1 = new Text("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, gp);
		bruceSpringsteen1.start();
	}

	public void pokrenibackVoice() {
		String lyrics3 = "(Because the night)";
		boolean stopIt = false;
		Performance backVoicePerformance = new Performance(lyrics3, 1500);
		backVoice1 = new Text("BackVoice", Voice.BACKGROUND, backVoicePerformance, stopIt, gp);
		backVoice1.start();
	}

	public void simpleDelay() {
		long l1 = System.currentTimeMillis();
		System.out.println("Wait 2sec...");
		while (System.currentTimeMillis() < (l1 + 2000)) {
		}
		System.out.println("Done.");
	}

	public synchronized void waitDelay() {
		System.out.println("Wait 2sec...");
		try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

	public synchronized void loopDelay() {
		System.out.println("Wait 5 times 2sec...");
		for (int i = 0; i < 4; i++) {
			try {
				wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + 1);
		}
		System.out.println("Done.");
	}

	public synchronized void threadWaitDelay() {
		WaitThread w1 = new WaitThread("t1");
		WaitThread w2 = new WaitThread("t2");
		System.out.println("Two threads...");
		w1.start();
		try {
			wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w2.start();
	}

}
