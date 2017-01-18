import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;

class Marosi extends JFrame implements ActionListener{
    
    JTextField txtWord1;
    JTextField txtWord2;
    
    Marosi(){
        
        //create a background panel to put things into, uses BorderLayout & FlowLayout Managers
        JPanel panelMain = new JPanel(new BorderLayout());
        JPanel panelTop = new JPanel(new FlowLayout());
        JPanel panelMiddle = new JPanel(new FlowLayout());
        JPanel panelBottom = new JPanel(new FlowLayout());
        
        //create a button named btnSample with text Sample Button
       
	JButton btnMarosi = new JButton("My Button"); /*Create button with dialog message containing my name*/
        
        //create sample textboxes
        txtWord1 = new JTextField(15);
        txtWord2 = new JTextField(15);
        
        //create a label for display
       
        
        //buttons need to say something(ActionCommand) to someone who's listening

	btnMarosi.setActionCommand("My Button"); /*Creating my own button*/
	btnMarosi.addActionListener(this);
 
        //Add components to proper panels
        
        
        
        //panelMiddle.add(btnYourButton);

       panelTop.add(btnMarosi);
      
        panelBottom.add(txtWord1);
        panelBottom.add(txtWord2);
        
        //Add individual panels to panelMain, applies to BORDERLAYOUT only
        //PAGE_START is top of screen
        //PAGE_END is bottom of screen
        //LINE_START is right side of screen
        //LINE_END is left side of screen
        //CENTER is center
        panelMain.add(panelTop,BorderLayout.PAGE_START);
        panelMain.add(panelMiddle,BorderLayout.CENTER);
        panelMain.add(panelBottom,BorderLayout.PAGE_END);
        
        //created separate method to generate menu, not necessary, but cleaner
        generateMenu();
        
        //set the window size for the app
        setSize(800,600);

        //tells java what to do when the class object closes
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NameGui Title (how original)");

        
        //get visible container and add panelMain to it
        //EVERYTHING has to be arranged and set before adding to ContentPane
        getContentPane().add(panelMain);

        //this centers the window in the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        setLocation(x, y);
        
        //make sure you can actually see it, starts off false
        setVisible(true);
        
    }
    private void generateMenu(){
        //create an empty menu bar
        JMenuBar menuBar = new JMenuBar();

        //create a menu  (file, edit, help, etc)
        JMenu menuHelp = new JMenu("Help");

	JMenu menuFile = new JMenu("File"); /*Add File to menu bar*/
        
        //create a menu item and set up its listeners, similar to buttons
        JMenuItem miHelp = new JMenuItem("Help me");
        miHelp.addActionListener(this);
        miHelp.setActionCommand("help");

	JMenuItem miFile = new JMenuItem("Quit"); /*Create Quit item*/
	miFile.addActionListener(this);
	miFile.setActionCommand("quit");
    
        //put together the pieces
        menuHelp.add(miHelp);
        menuBar.add(menuHelp);

	menuFile.add(miFile);
	menuBar.add(menuFile);

        //add bar to this JFrame
        setJMenuBar(menuBar);    
    
    }
    public void actionPerformed(ActionEvent evt) {
        //this method listens to the JFrame's events and performs appropriately
        switch (evt.getActionCommand()){
            case "sample":
                JOptionPane.showMessageDialog(this,"A Sample message dialog box","A plain message",JOptionPane.PLAIN_MESSAGE);
                break;
            case "quit" :
                System.exit(0);
                break;
            case "swap" :
                String tempString;
                tempString = txtWord1.getText();
                txtWord1.setText(txtWord2.getText());
                txtWord2.setText(tempString);
                break;
            case "help" :
                JOptionPane.showMessageDialog(this,"There is no help for you.","Sorry",JOptionPane.WARNING_MESSAGE);
                break;
	case "My Button" :
	JOptionPane.showMessageDialog(this,"My name is Josh Marosi.","My Name",JOptionPane.WARNING_MESSAGE);
                break;
        }
    }
    
    public static void main(String [] args){
        new Marosi();
    }
    
}
