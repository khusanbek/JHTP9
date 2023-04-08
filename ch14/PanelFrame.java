// PanelFrame.java
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelFrame extends JFrame
{
	private JPanel buttonJPanel;
	private JButton[] buttons;
	
	public PanelFrame()
	{
		super("Panel Demo");
		buttons = new JButton[5];
		buttonJPanel = new JPanel();
		buttonJPanel.setLayout(new GridLayout(1, buttons.length));
		
		for(int count = 0; count < buttons.length; count++)
		{
			buttons[count] = new JButton("Button" + (count + 1));
			buttonJPanel.add(buttons[count]);
		}
		
		add(buttonJPanel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args)
	{
		PanelFrame panelFrame = new PanelFrame();
		panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelFrame.setSize(450, 200);
		panelFrame.setVisible(true);
	}
}