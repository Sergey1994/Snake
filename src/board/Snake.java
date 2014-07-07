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
import java.util.LinkedList;


public class Snake extends Object {
    LinkedList<Point> Body = new LinkedList<Point>(); 
    Point APoint;
    final int size = 10;
    Snake(){      // тело змейки
        for(int i = 5; i < 10; i++){
         APoint = new Point(i,5); 
         Body.add(APoint);
        }
    }
     public void copy(LinkedList x, LinkedList y){   // создание копии змейки
	        for(int i = 0;i < y.size();i++)
	        {
	            Point p =(Point) y.get(i) ;
	            x.add(p.clone());
	        }
	     }
     public void displaySnake(Graphics p){   // отрисовка зеленой змейки
         for(int i = 0; i < Body.size();i++){
	             Point APoint = Body.get(i);
	             int bodyX =(int) APoint.getX();
	             int bodyY =(int) APoint.getY();
	             p.setColor(new Color(125,255,0));
                     if (APoint == Body.getLast()) p.setColor(new Color(0,255,0));
	             p.fillRect(bodyX*size,bodyY*size,size,size);
	            }
     }
    
 public void moveSnake(SnakeFrame.SnakeDirection d){
	        LinkedList<Point> bodyCopy  = new LinkedList<Point>();
	         copy(bodyCopy,Body);
	         for(int i = 0; i < Body.size();i++) {
	             Point APoint = Body.get(i);
	             if(APoint == Body.getLast()){   // условие для головы
	                 if(d.state == d.right )
	                    APoint.x++;
	                 else if(d.state == d.down)
	                    APoint.y++;
	                 else if(d.state == d.up)
	                    APoint.y--;
	                 else if(d.state == d.left)
	                    APoint.x--;                 
	             }
	             else  {    // для хвоста
	                 Point BPoint = bodyCopy.get(i+1);
	                 APoint.x = BPoint.x;
	                 APoint.y = BPoint.y;
	             }
	         }
	 
	     }
    
    
}
