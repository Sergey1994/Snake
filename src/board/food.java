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
        
public class food {
      int foodx, foody;
      final int size;
      Random generator = new Random();
      
      public food(){   // начальная установка еды
          foodx = 10;
          foody = 10;
          size = 10;
      }
      public void displayFood(Graphics p){   // еда - красный квадрат
          p.setColor(new Color(255,0,0));      
          p.fillRect(foodx*size,foody*size,size,size);
      }
      public void changePosition(){         // после съедения - смена расположения
	       int Nextx = generator.nextInt(47);
	       int Nexty = generator.nextInt(23);
	       foodx = Nextx;
	       foody = Nexty;
	       SnakeFrame.setEaten(false);
	    }	 
     
	
   
    
}
