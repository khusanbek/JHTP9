// DesktopFrame.java
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class DesktopFrame extends JFrame
{
	private JDesktopPane theDesktop;
	
	public DesktopFrame()
	{
		super("Using a JDesktopPane");
		
		JMenuBar bar = new JMenuBar();
		JMenu addMenu = new JMenu("Add");
		JMenuItem newFrame = new JMenuItem("Internal Frame");
		
		addMenu.add(newFrame);
		bar.add(addMenu);
		
		setJMenuBar(bar);
		
		theDesktop = new JDesktopPane();
		add(theDesktop);
		
		newFrame.addActionListener(
			
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					JInternalFrame frame = new JInternalFrame(
						"Internal Frame", true, true, true, true);
						
					MyJPanel panel = new MyJPanel();
					frame.add(panel, BorderLayout.CENTER);
					frame.pack();
					
					theDesktop.add(frame);
					frame.setVisible(true);
				}
			}
		);
	}
	
	class MyJPanel extends JPanel
	{
		private SecureRandom generator = new SecureRandom();
		private ImageIcon picture;
		private String[] images = {
				"book.jpg", "toy.jpg", "brick.jpg", 
				"motobike.jpg", "spoon.jpg"};
				
		public MyJPanel()
		{
			int randomNumber = generator.nextInt(images.length);
			picture = new ImageIcon(images[randomNumber]);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			picture.paintIcon(this, g, 0, 0);
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(picture.getIconWidth(),
				picture.getIconHeight());
		}
	}
	
	
	public static void main(String[] args)
	{
		try {
			
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}		
		}
		catch (Exception e) {
		// If Nimbus is not available, you can set the GUI to another look and feel.
		}
	
		DesktopFrame desktopFrame = new DesktopFrame();
		desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopFrame.setSize(600, 480);
		desktopFrame.setVisible(true);
	}
}
