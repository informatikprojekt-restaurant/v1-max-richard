package restaurantverwaltung;

/**
 *
 * @author Thomas Weber
 */

//Clock fungiert mit seiner Run methode als Timer
public class Clock extends Thread {
    
    public void run(){
        for (int i = 0; i < 5; i++) {
            try{
                sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
