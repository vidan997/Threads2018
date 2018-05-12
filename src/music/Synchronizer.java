/*
 * Created on May 10, 2018
 *
 */
package music;

public class Synchronizer {
    
    private boolean firstVoiceFlag;
    private boolean secondVoiceFlag;
    private boolean backVoiceFlag;

    public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag,boolean backVoiceFlag) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag = secondVoiceFlag;
        this.backVoiceFlag = backVoiceFlag;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (secondVoiceFlag || backVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay) {
        while (firstVoiceFlag || backVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void backVoice(String lyrics, int delay) {
        while (firstVoiceFlag || secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    private void sing(String lyrics, int delay) {
        System.out.println(lyrics);
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(firstVoiceFlag){
        	secondVoiceFlag = !secondVoiceFlag;
        	firstVoiceFlag = !firstVoiceFlag;
        }else if(secondVoiceFlag) {
        	backVoiceFlag = !backVoiceFlag;
        	secondVoiceFlag = !secondVoiceFlag;
        }else if(backVoiceFlag) {
        	firstVoiceFlag = !firstVoiceFlag;
        	backVoiceFlag = !backVoiceFlag;
        }
        notifyAll();
       
    }

}

