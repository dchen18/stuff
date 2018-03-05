import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{	
	Man man;
	ArrayList<Ballin> Ballins;
	
	public WalkingFrame()
	{
		setBounds(100, 100, 600, 400);
		setLayout(null);
		man = new Man(0, 0);
		add(man);
		Timer timer = new Timer(10, this);
		timer.start();
		Ballins = new ArrayList<Ballin>();
		addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) 
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(-2);
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(-2);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(2);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(2);
						}
						if(e.getKeyCode() == e.VK_SPACE)
						{
							Ballin newBall = new Ballin(man.getX() + 10, man.getY() + 10);
							Ballins.add(newBall);
							add(newBall);
						}

					}
					
					public void keyReleased(KeyEvent e) {
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(0);
						}
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						
					}
			
				});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


	public static void main(String[] args)
	{
		new WalkingFrame();
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		man.update();
		for (int i = 0; i < Ballins.size(); i++)
		{
			Ballins.get(i).update();
			if (Ballins.get(i).getX() > 600)
			{
				remove(Ballins.get(i));
			}
		}
		repaint();
		
	}
}