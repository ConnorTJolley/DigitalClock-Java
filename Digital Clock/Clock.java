import javax.swing.JOptionPane.*;

import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import javax.swing.*;

/**
 * Class Clock - write a description of the class here
 * 
 * @author (Connor J) 
 * @version (V.1)
 */
public class Clock extends Applet implements Runnable
{
    // Variables
    
    Thread t;
    
    
    //Tried to fix this error by doing this ----> digitalNum(hour1, hour2, min1, min2, sec1, sec2);
    
    int totalSeconds;
    digitalNum hour1,hour2,min1,min2,sec1,sec2;
    
    Thread f = null;
    boolean threadSuspended;
    int userHours=0, userMinutes=0, userSeconds=0;
    int UserHoursInt=0, UserMinutesInt=0, UserSecondsInt=0;
    
    String timeString;
    
    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
       setBackground(Color.black);
       
       //User input
       String UserHours = JOptionPane.showInputDialog(null, "Please input the Hours");
       UserHoursInt =Integer.parseInt(UserHours);
       
       //Original code to show the inputs the user inserted
       //JOptionPane.showMessageDialog(null, UserHoursInt);
       
       String UserMinutes = JOptionPane.showInputDialog(null, "Please input the Minutes");
       UserMinutesInt =Integer.parseInt(UserMinutes);
       
       //Original code to show the inputs the user inserted
       //JOptionPane.showMessageDialog(null, UserMinutesInt);
       
       String UserSeconds = JOptionPane.showInputDialog(null, "Please input the Seconds");
       UserSecondsInt =Integer.parseInt(UserSeconds);
       
       
       //Original code to show the inputs the user inserted
       //JOptionPane.showMessageDialog(null, UserHoursInt + UserMinutesInt + UserSecondsInt);
       
       //Code to overwrite the output code shown above in order to show all the user inputs in one dialog box.
       String s = "Hours: "+UserHoursInt+" Minutes: "+UserMinutesInt+" Seconds: "+UserSecondsInt;
       JOptionPane.showMessageDialog(null,s);
       
    }
   
    
    public Clock()
    {
        
        hour1=new digitalNum(20,100,6);
        hour2=new digitalNum(100,100,6);
        min1=new digitalNum(200,100,6);
        min2=new digitalNum(280,100,6);
        sec1=new digitalNum(360,130,3);
        sec2=new digitalNum(400,130,3);
        
        start();
    }
    
    public void stop()
    {
        //d
    }
    
    public void start(){
        if ( f == null ) {  
         f = new Thread( this );  
         f.setPriority( Thread.MIN_PRIORITY );  
         threadSuspended = false;  
         f.start();  
      }  
      else {  
         if ( threadSuspended ) {  
            threadSuspended = false;  
            synchronized( this ) {  
               notify();  
            }  
         }  
      }      
    }
    
    public int setSeconds()
    {
        
        int h=0,m=0,s=0;   
        //         int newh=0, newm=0, news=0;
        //        
        //         h=UserHoursInt*3600;
        //         newh+=3600*12;
        //         m=UserMinutesInt*60;
        //         s=UserSecondsInt;
        
        return h+m+s;
    }
    
    
    public void showDots(Graphics2D g2){
        g2.fill(new Rectangle2D.Double(178,65,14,14));
        g2.fill(new Rectangle2D.Double(178,135,14,14));
    }
    
    int x,y;
    int k;
    led[] led;
    
    public void digitalNum(int x, int y, int k)
    {
        this.x=x;
        this.y=y;
        this.k=k;
        led = new led[7];
        led[0] = new led(x,y,"v");
        led[1] = new led(x,y+10*k,"v");
        led[2] = new led(x+8*k,y,"v");
        led[3] = new led(x+8*k,y+10*k,"v");
        led[4] = new led(x+2*k,y-9*k,"h");
        led[5] = new led(x+2*k,y+k,"h");
        led[6] = new led(x+2*k,y+11*k,"h");
    }
    
    public void setNumber(int num){
        if(num==0){
            led[0].ledOn(true);
            led[1].ledOn(true);
            led[2].ledOn(true);
            led[3].ledOn(true);
            led[4].ledOn(true);
            led[5].ledOn(false);
            led[6].ledOn(true);
        }else if(num==1){
            led[0].ledOn(false);
            led[1].ledOn(false);
            led[2].ledOn(true);
            led[3].ledOn(true);
            led[4].ledOn(false);
            led[5].ledOn(false);
            led[6].ledOn(false);            
        }else if(num==2){
            led[0].ledOn(false);
            led[1].ledOn(true);
            led[2].ledOn(true);
            led[3].ledOn(false);
            led[4].ledOn(true);
            led[5].ledOn(true);
            led[6].ledOn(true);         
        }else if(num==3){
            led[0].ledOn(false);
            led[1].ledOn(false);
            led[2].ledOn(true);
            led[3].ledOn(true);
            led[4].ledOn(true);
            led[5].ledOn(true);
            led[6].ledOn(true);         
        }else if(num==4){
            led[0].ledOn(true);
            led[1].ledOn(false);
            led[2].ledOn(true);
            led[3].ledOn(true);
            led[4].ledOn(false);
            led[5].ledOn(true);
            led[6].ledOn(false);            
        }else if(num==5){
            led[0].ledOn(true);
            led[1].ledOn(false);            
            led[2].ledOn(false);
            led[3].ledOn(true);
            led[4].ledOn(true);
            led[5].ledOn(true);
            led[6].ledOn(true);         
        }else if(num==6){
            led[0].ledOn(true);
            led[1].ledOn(true);         
            led[2].ledOn(false);
            led[3].ledOn(true);
            led[4].ledOn(true);
            led[5].ledOn(true);
            led[6].ledOn(true);         
        }else if(num==7){
            led[0].ledOn(false);
            led[1].ledOn(false);
            led[2].ledOn(true);
            led[3].ledOn(true);
            led[4].ledOn(true);
            led[5].ledOn(false);
            led[6].ledOn(false);        
        }else if(num==8 ){
            led[0].ledOn(true);
            led[1].ledOn(true);
            led[2].ledOn(true);
            led[3].ledOn(true);
            led[4].ledOn(true);
            led[5].ledOn(true);
            led[6].ledOn(true);     
        }else if(num==9){
            led[0].ledOn(true);
            led[1].ledOn(false);
            led[2].ledOn(true);
            led[3].ledOn(true);
            led[4].ledOn(true);
            led[5].ledOn(true);
            led[6].ledOn(true);     
        }
    }
    
    public void run(){
        while(f!=null){
            try{
                //totalSeconds=setSeconds();
                showTime();
                repaint();
                Thread.sleep(1000);
                
                UserSecondsInt++;
                
                
                
               if (UserHoursInt >= 24)
               {
                 UserHoursInt = 0;
               }
               else
               {
                 //Nothing
               }
               
               if (UserMinutesInt >= 60)
               {
                   UserMinutesInt = 0;
                   UserHoursInt += 1;
               }
               else
               {
                   //Nothing
               }
               
               if (UserSecondsInt >= 60)
               {
                   UserSecondsInt = 0;
                   UserMinutesInt += 1;
               }
               else
               {
                   //Nothing
               } 
               
            }catch(Exception e){}
        }
        
         try {  
         while (true) {  
            
            
            
            int hours = UserHoursInt; 
            int minutes = UserMinutesInt;
            int seconds = UserSecondsInt;
            
            if ( hours > 12 ) 
            {
                hours -= 12; 
            }
 
            // Now the thread checks to see if it should suspend itself  
            if ( threadSuspended ) {  
               synchronized( this ) {  
                  while ( threadSuspended ) {  
                     wait();  
                  }  
               }  
            }  
            
            
            f.sleep( 1000 );  // interval specified in milliseconds  
         }  
        }  
        catch (Exception e) { }
    }
    
    public int divide(int a, int b){
        int z = 0;
        int i = a;

        while (i>= b)
          {
            i = i - b;
            z++;
          }
        return z;
    }
   
    public void showTime(){
            
        int hours=divide(totalSeconds,3600);
        int minutes=divide(totalSeconds,60)-hours*60;
        int seconds=totalSeconds-hours*3600-60*divide((totalSeconds-hours*3600),60);

        hours = UserHoursInt;
        minutes = UserMinutesInt;
        seconds = UserSecondsInt;
        
        //set Hours
        if(hours<10){
            hour1.turnOffNumber();
            hour2.setNumber(hours);
        }else if(hours>=10 && hours<20){
            hour1.setNumber(1);
            hour2.setNumber(hours-10);
        }else{
            hour1.setNumber(2);
            hour2.setNumber(hours-20);
        }
        //set Minutes       
        //         int divideM=divide(minutes,10);
        //         if(divideM<6)
        //         {
        //             min1.setNumber(divideM);
        //         }
        //         else
        //         {  
        //           min1.setNumber(0);
        //           min2.setNumber(minutes-divideM*10);
        //         }
        //set Seconds    
        
        min1.setNumber(minutes/10);
        min2.setNumber(minutes%10);
        
        sec1.setNumber(seconds/10);
        sec2.setNumber(seconds%10);
        
            //         int divideS=divide(seconds,10);
                //         if(divideS<6)
                //         {
                    //             sec1.setNumber(divideS);
                    //         }
                    //         else
                    //         {
                        //             sec1.setNumber(0);
                        //             sec2.setNumber(seconds-divideS*10);
                        //         }
                        
        //System.out.println(""+hours+" : "+minutes+" . "+seconds);
    }
    
    class led
    {
        int x, y;
        Polygon p;
        String type;
        boolean On=false;
        
        public led(int x, int y, String type){
            this.x=x;
            this.y=y;
            this.type=type;

            p = new Polygon();
                        
            if(type=="v"){
                p.addPoint(x,y);
                p.addPoint(x+k,y+k);
                p.addPoint(x+2*k,y);
                p.addPoint(x+2*k,y-8*k);
                p.addPoint(x+k,y-9*k);
                p.addPoint(x,y-8*k);
            }
            
            if(type=="h"){
                p.addPoint(x,y);
                p.addPoint(x+k,y+k);
                p.addPoint(x+5*k,y+k);
                p.addPoint(x+6*k,y);
                p.addPoint(x+5*k,y-k);
                p.addPoint(x+k,y-k);                
            }
        }
        
        public void render(Graphics2D g2){
            g2.setColor(new Color(75,75,75));
            if(On)
            {
                g2.setColor(Color.yellow);                
                g2.fillPolygon(p);
            }
            
        }
        
        public void ledOn(boolean s){
            On=s;
        }
        
        
        
        
    }
    public void paint(Graphics g)
        {
            //paint(g);
            Graphics2D g2 = (Graphics2D)g;
            hour1.drawNumber(g2);
            hour2.drawNumber(g2);
            min1.drawNumber(g2);
            min2.drawNumber(g2);
            sec1.drawNumber(g2);
            sec2.drawNumber(g2);
            showDots(g2);
        
            setBackground(Color.black);
        
        }
}
