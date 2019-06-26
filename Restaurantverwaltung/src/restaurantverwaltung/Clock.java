package restaurantverwaltung;

/**
 *
 * @author Thomas Weber
 * evtl überarbeiten 
 * clock ???????????
 */
public class Clock extends Thread {
    
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
