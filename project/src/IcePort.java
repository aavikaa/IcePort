import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class IcePort extends JFrame {
	JMenuBar menuBar;
	JMenu helpMenu;
	JMenuItem about;
	JLayeredPane desktop;
	JPanel textBoxPanel,option,textPanel, zoomPanel;
	JTextField textBox,usernameField, passwordField,zoom;
	JButton send,soundSetting,zoomIn,zoomOut,loginButton,refresh;
	JCheckBox chat,shout,muteBGM,muteSFX;
	JSlider SFXSlider,BGMSlider;
	Dimension d;
	public static int n=1;
    JLabel titleLabel, usernameLabel, passwordLabel, userLabel, passLabel;
  
	
	public IcePort(){
	d=this.getSize();
	desktop=new JLayeredPane();
	setContentPane(desktop);
	setJMenuBar(makeMenuBar());
	desktop.setLayout(new BorderLayout());
	makeTextBoxPanel().setPreferredSize(new Dimension(400,1000));
	desktop.add(makeTextBoxPanel(),BorderLayout.SOUTH);
	//desktop.add(makeLoginPanel(),BorderLayout.CENTER);
	desktop.add(makeZoomPanel(),BorderLayout.EAST);
	desktop.setBackground(Color.BLUE);
	desktop.setOpaque(true);
	} 
	
	public JMenuBar makeMenuBar(){
		menuBar=new JMenuBar();
		helpMenu=new JMenu("help");
		about=new JMenuItem("about");
		menuBar.add(helpMenu);
		helpMenu.add(about);
		return menuBar;
	}
	public JPanel makeTextBoxPanel(){
		textBoxPanel= new JPanel();
		option=new JPanel();
		chat=new JCheckBox("chat");
		shout=new JCheckBox("shout");
		option.setLayout(new FlowLayout());
		textBoxPanel.setLayout(new BorderLayout());
		textBox= new JTextField();
		textBoxPanel.add(textBox,BorderLayout.CENTER);
		send=new JButton("send");
		soundSetting=new JButton("sound setting");
		soundSetting.addActionListener(new SoundControl());
		textBoxPanel.add(send,BorderLayout.EAST);
		textBoxPanel.add(option,BorderLayout.NORTH);
		option.add(chat);
		option.add(shout);
		option.add(soundSetting);	
		refresh=new JButton("refresh");
		option.add(refresh);
		return textBoxPanel;	
	}

	public JPanel makeLoginPanel(){
		JPanel totalGUI = new JPanel();
        totalGUI.setLayout(new BorderLayout(10, 10));
        titleLabel = new JLabel("Login Screen");
        titleLabel.setPreferredSize(new Dimension(290, 30));
        titleLabel.setHorizontalAlignment(0);
        totalGUI.add(titleLabel, BorderLayout.PAGE_START);
        // Creation of a Panel to contain the JLabels
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(200, 80));
        totalGUI.add(textPanel, BorderLayout.CENTER);
        // Username Label&Text Field
        usernameLabel = new JLabel("Username");
        usernameField = new JTextField(8);
        usernameField.setPreferredSize(new Dimension(100, 30));
        usernameLabel.setPreferredSize(new Dimension(70, 30));
        usernameLabel.setHorizontalAlignment(4);
        JPanel line1=new JPanel();
        line1.add(usernameLabel);
        line1.add(usernameField);
        textPanel.add(line1);

        // Password Label&Text Field
        
        passwordLabel = new JLabel("Password");
        passwordField = new JTextField(8);
        passwordField.setPreferredSize(new Dimension(100, 30));
        passwordLabel.setPreferredSize(new Dimension(70, 30));
        passwordLabel.setHorizontalAlignment(4);
        JPanel line2=new JPanel();
        line2.add(passwordLabel);
        line2.add(passwordField);
        textPanel.add(line2);
       // textPanel.setBackground(Color.WHITE);

        // Button for Logging in
        loginButton = new JButton("Login");
       // loginButton.addActionListener(this);
        textPanel.add(loginButton);
       // totalGUI.setBackground(Color.WHITE);
        totalGUI.setOpaque(true);
       
        return totalGUI;		
		
	}
	public JPanel makeZoomPanel(){
		
		zoomPanel=new JPanel();
		zoomIn=new JButton("+");
		zoomIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(n == 10){
					
				}else{

					n+=1;
					zoom.setText(""+n);
				}
		}
	});
		zoomOut=new JButton("-");
		zoomOut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(n>1){

					n-=1;
					zoom.setText(""+n);
				}
			}
			
		});
		zoom=new JTextField("1",2);
		zoom.setEditable(true);
		JLabel x=new JLabel("X");
		JLabel x1=new JLabel("zoom");
		JPanel numberPanel=new JPanel();
		numberPanel.add(x1);
		numberPanel.add(zoom);
		numberPanel.add(x);
		zoomPanel.setLayout(new GridLayout(3,1,2,2));
		zoomPanel.add(zoomIn);
		zoomPanel.add(zoomOut);
		zoomPanel.add(numberPanel);
		return zoomPanel;
	}
	

	public class SoundControl implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JDialog soundControl=new JDialog();
			soundControl.setLocation(270, 380);
			soundControl.setVisible(true);
			soundControl.setSize(400, 100);
			soundControl.setAlwaysOnTop(true);
			soundControl.setLayout(new GridLayout(2,3,10,10));
			BGMSlider=new JSlider();
			JLabel BGM=new JLabel("BGM:");
			SFXSlider=new JSlider();
			JLabel SFX=new JLabel("SFX:");
			muteBGM=new JCheckBox("mute");
			muteSFX=new JCheckBox("mute");
			soundControl.add(BGM);
			soundControl.add(BGMSlider);
			soundControl.add(muteBGM);
			soundControl.add(SFX);
			soundControl.add(SFXSlider);
			soundControl.add(muteSFX);
				
		}
	}	
	public class ZoomInEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			IcePort x=new IcePort();
			
			n+=1;
			System.out.print(""+n);
			
			x.zoom.setText(""+n);
			
		}
	}
	
	/*
	public class ZoomOutEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			n-=1;
			System.out.print(""+n);
			
			.zoom.setText(""+n);
			
		}
	}
	*/
	
	public static void main(String[] args){
		IcePort gui=new IcePort();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setSize(1000, 700);
		
	}
}
