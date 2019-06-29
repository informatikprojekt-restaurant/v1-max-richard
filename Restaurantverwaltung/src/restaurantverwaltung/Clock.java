package restaurantverwaltung;

/**
 *
 * @author Thomas Weber
 */
public class Clock extends Thread {
    
    public int i = 0;
    
    public void run(int j){
        while(i < j){
            try{
                i++;
                sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    
}
