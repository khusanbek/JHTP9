// TextAreaFrame.java
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame
{
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton copyJButton;
	
	public TextAreaFrame()
	{
		super("TextArea Demo");
		Box box = Box.createHorizontalBox();
		String demo = "This is a demo string to\n" +
			"illustrate copying text\nfrom one textarea to \n" +
			"another textarea using an\nexternal event\n";
			
		textArea1 = new JTextArea(demo, 10, 15);
		box.add(new JScrollPane(textArea1));
	
		copyJButton = new JButton("Copy >>>");
		box.add(copyJButton);
		copyJButton.addActionListener(
			
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					textArea2.setText(textArea1.getSelectedText());
				}
			}
		);
		
		textArea2 = new JTextArea(10, 15);
		textArea2.setEditable(false);
		box.add(new JScrollPane(textArea2));
		
		add(box);
	}
	
	public static void main(String[] args)
	{
		TextAreaFrame textAreaFrame = new TextAreaFrame();
		textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textAreaFrame.setSize(425, 200);
		textAreaFrame.setVisible(true);
	}
}