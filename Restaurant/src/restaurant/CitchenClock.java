/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author Thomas Weber
 */
public class CitchenClock {
    
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
