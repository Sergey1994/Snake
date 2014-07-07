/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

/**
 *
 * @author Админ
 */

import java.awt.*;
import java.util.Random;

public class wall {
      int wallx, wally, weight, height;
      Random generator = new Random();
      
      public wall(){   
          wallx = generator.nextInt(47);
          wally = generator.nextInt(23);
          Rotate();
      }
      public void displayWall(Graphics p){   
          p.setColor(new Color(100,0,0));      
          p.fillRect(wallx*10,wally*10,weight*10,height*10);
      }
     
	private void Rotate(){
            height = generator.nextInt(8)+1;
            if (height == 1){
                weight = generator.nextInt(8)+1;
                return;
            }
            weight = 1;  
        }
       
}
