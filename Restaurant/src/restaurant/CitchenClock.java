package restaurant;

/**
 *
 * @author Thomas Weber
 */
public class CitchenClock extends Thread {
    
    public int i = 0;

    public void run(int dauer){
        while(i < dauer){
            try{
                i++;
                sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
