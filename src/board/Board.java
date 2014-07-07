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
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Board {
    public static void main(String[] args) {
          SnakeFrame board = new SnakeFrame();
          board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          board.setVisible(true);
          
    }
}
     class SnakeFrame extends JFrame {
    private static class NewMenuListener implements ActionListener {
        public NewMenuListener() {
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }	        int i = 0;
	        SnakePanel panel;
	        boolean live = true;
	        Snake snake = new Snake();
	        SnakeDirection direction = new SnakeDirection(0);
	        public food f = new food();
                public wall w = new wall();
                public wall w1 = new wall();
	        public static  boolean eaten = false;
	        public boolean alive = true;
	        public boolean done = true;
                public int countFood = 0;
                private JMenuBar menu = null;
                private final String fileItems[] = new String []{"Новая игра", "Выход"};
	    public  SnakeFrame(){
	        setSize(517,362);
	        setTitle("Змейка");
                createMenu();
                setJMenuBar(menu);
	        panel = new SnakePanel();
	        panel.setBackground(new Color(10, 10, 10));
	        add(panel);
	 	}
            public static boolean getEaten(){
	        return eaten;
	    }
	    public static void setEaten(boolean eat){
	        eaten = eat;
	    }
	    
	    class SnakeThread implements Runnable{
	        Graphics p = null;
	        public SnakeThread(){
	            Thread t;
	            t = new Thread(this);
	            t.start();
	        }
	         public void run(){
	        while(alive == true){
	 	            try {
                                if (countFood < 30)
                                    Thread.sleep(150 - countFood*5);
	 	                Thread.sleep(40);
	           	        }
	            catch (InterruptedException e) {
	            	            }
	             snake.moveSnake(direction);
	             eat();
	             death();
	             panel.repaint();
	             done = true;	        
                             }	        
                }	    
            }
	 	    class SnakePanel extends JPanel  {
	 	     public SnakePanel(){
	          new SnakeThread();
	          KeyHendler listener =  new KeyHendler();
	          addKeyListener(listener);
	          setFocusable(true);
	 	    }
	        public void paintComponent(Graphics g){
	       
	            g.clearRect(0,0,500,300);
	            snake.displaySnake(g);
                    w.displayWall(g);
                    w1.displayWall(g);
	             if(eaten == true)
	            f.changePosition();
	            f.displayFood(g);	        
                }	    
                    }
public void death(){
        if(snake.Body.getLast().x > 49 || snake.Body.getLast().x < 0  ||
	    snake.Body.getLast().y > 29 ||snake.Body.getLast().y < 0 )
	        alive = false;
        
        if(snake.Body.getLast().x >= w.wallx && snake.Body.getLast().x <= w.wallx + w.weight -1 &&
	    snake.Body.getLast().y >= w.wally && snake.Body.getLast().y <= w.wally+ w.height -1 )
	        alive = false;
        
        if(snake.Body.getLast().x >= w1.wallx && snake.Body.getLast().x <= w1.wallx + w1.weight -1 &&
	    snake.Body.getLast().y >= w1.wally && snake.Body.getLast().y <= w1.wally+ w1.height -1 )
	        alive = false;
	        for(int i = 1; i < snake.Body.size()-1; i++){
	              
	        	 System.out.println("игра");
	 if(snake.Body.getLast().x ==snake.Body.get(i).x && snake.Body.getLast().y ==snake.Body.get(i).y){
	                alive = false;	            
                            }	 	        
                }
                if (alive == false) {
                    String title = "Snake";
                    String msg = "Game over!\n";
                    msg += "Score " + countFood;
                    int type = JOptionPane.ERROR_MESSAGE;
                    JOptionPane.showMessageDialog(null, msg, title, type);
                }
                    
}
public void eat(){
	        
	         if(f.foodx == snake.Body.getLast().x && f.foody == snake.Body.getLast().y){
	             Point APoint = new Point (f.foodx,f.foody);
	             
	             snake.Body.add(0,APoint);
	             eaten = true;  
                     countFood++;
	         }
	     }
             
	 	    private class KeyHendler implements KeyListener{
	        public void keyPressed(KeyEvent event){
	 	            int keyCode = event.getKeyCode();
	 	            if(keyCode == KeyEvent.VK_RIGHT && done == true)
                    { direction.changeToRight();
                            done = false;}
	            if(keyCode == KeyEvent.VK_LEFT&&done == true)
                    { direction.changeToLeft();
                        done = false;}
	            if(keyCode == KeyEvent.VK_UP&&done == true)
                    { direction.changeToUp();
                        done = false;}
	            if(keyCode == KeyEvent.VK_DOWN&&done == true) 
                    {direction.changeToDown();
                    done = false;}
	 
	        }
	        public void keyReleased(KeyEvent event){
	 	        }
	        public void keyTyped(KeyEvent event){
	 
	        }        
	    }
	     public class SnakeDirection{	  
                public final  int right = 0;
	        public final  int down = 1;
	        public final  int left = 2;
	        public final  int up = 3;
	 	        public int state = 0;
	 	        public SnakeDirection(int s ){
	            state =s;
	        }
	 
	        public void changeToRight(){
                    if(state != left)
	            state = right;
	        }
	        public void changeToLeft(){
	            if(state != right)
	            state = left;
	        }
	        public void changeToUp(){
	            if(state != down)
	            state = up;
	        }
	        public void changeToDown(){
	            if(state != up)
	            state = down;	        }	    }

             
private void createMenu() {
menu = new JMenuBar();
JMenu fileMenu = new JMenu("Игра");


for (int i = 0; i < fileItems.length; i++) {
JMenuItem item = new JMenuItem(fileItems[i]);
item.setActionCommand(fileItems[i].toLowerCase());
item.addActionListener(new NewMenuListener());

if(fileItems[i] == "Новая игра"){                  // Новая игра
item.addActionListener(new ActionListener()
{
 public void actionPerformed(ActionEvent e)
 {
	 
      SnakeFrame frame = new SnakeFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
 }
});
}

if(fileItems[i] == "Выход"){       // Выход из игры
item.addActionListener(new ActionListener()
{
 public void actionPerformed(ActionEvent e)
 {
	 
	 System.exit(0);

 }
});}


//////////////
fileMenu.add(item);
}
fileMenu.insertSeparator(1);
menu.add(fileMenu);}    
    
   
    
}
