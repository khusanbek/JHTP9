// ButtonFrame.java
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame
{
	private JButton plainJButton;
	private JButton fancyJButton;
	
	public ButtonFrame()
	{
		super("Testing Buttons");
		setLayout(new FlowLayout());
		
		plainJButton = new JButton("Plain Button");
		add(plainJButton);
		
		Icon elon = new ImageIcon(getClass().getResource("elon.gif"));
		Icon elonBW = new ImageIcon(getClass().getResource("elon-bw.gif"));		
		fancyJButton = new JButton("Fancy Button", elon);
		fancyJButton.setRolloverIcon(elonBW);
		add(fancyJButton);
		
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener(handler);
		plainJButton.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
				"You pressed: %s", event.getActionCommand()));
		}
	}
	
	public static void main(String[] myArgs)
	{
		ButtonFrame buttonFrame = new ButtonFrame();
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setSize(420, 250);
		buttonFrame.setVisible(true);
	}
}