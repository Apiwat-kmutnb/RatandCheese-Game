package miniGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame implements ActionListener
{
	Homegames hg = new Homegames();
	GamePanel gp;
	JFrame window = new JFrame();
	JButton jbt_exit = new JButton("Exit");
	Window(){
		
		this.add(hg);
		hg.jbt_map1.addActionListener(this);
		hg.jbt_map2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.dispose();
		
		if(e.getSource()==hg.jbt_map1) {
			gp = new GamePanel(1);
		}
		else if(e.getSource()==hg.jbt_map2) {
			gp = new GamePanel(2);
		}
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("RatAndCheese");
		
		window.add(gp);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}
	
	public static void main(String[] args)
	{
		JFrame wd = new Window();
		wd.setSize(1300,700);
		wd.setTitle("Rat and Cheese");
		wd.setLocationRelativeTo(null);
		wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wd.setVisible(true);

	}
	

}
