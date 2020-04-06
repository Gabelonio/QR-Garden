package interfaz;
/*
Packages usage:
1. Java.awt imports : Fonts.
					  Action listeners.
					  Events.
2. Javax.swing imports : Buttons deployment.
						 Frame deployment.
						 Text deployment.	
*/
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * Graphic User Interface which deploys the options to
 * generate a QR Code.
 */
public class MenuPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	//Buttons to navigate or execute options.
	private JButton creadorCortador,creadorMalla,creadorBloque;
	//Sign showing the information in the frame.
	private JTextArea letrero; 
	
    /*
     * Description : Configures the window, displaying the options.
     */
	public MenuPrincipal()
    {
    	//Title
		this.setTitle("Main Menu");
		//Size
		this.setSize(350,350);
		//Null layout to configure freely the environment
		this.setLayout(null);
		//Default exit by closing the window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Deploy at the center of the screen
		this.setLocationRelativeTo(null);
		//Non re-sizable
		this.setResizable(false);
		
        /*
         * Buttons
         */
		creadorCortador=new JButton(); 
		creadorCortador.setBounds(95,100,150,30);
		creadorCortador.setText("Create Cutter");
		creadorCortador.setFont(new Font("Kai", Font.BOLD, 13));
		creadorCortador.addActionListener(this);		
		creadorBloque=new JButton(); 
		creadorBloque.setBounds(95,170,150,30);
		creadorBloque.setText("Create Block");
		creadorBloque.addActionListener(this);
		creadorBloque.setFont(new Font("Kai", Font.BOLD, 13));		
		creadorMalla=new JButton(); 
		creadorMalla.setBounds(95,240,150,30);
		creadorMalla.setText("Create Area");
		creadorMalla.setFont(new Font("Kai", Font.BOLD, 13));
		creadorMalla.addActionListener(this);
		
		letrero=new JTextArea("Garden QR Creator");
		letrero.setFont(new Font("Serif", Font.PLAIN, 17));
        letrero.setBounds(100,50,150,40);
        letrero.setOpaque(false);
        letrero.setEditable(false);
        
        this.add(creadorCortador);
        this.add(creadorBloque);
        this.add(creadorMalla);
        this.add(letrero);
    }

    /*
     * Description : Executes the action given by pressing a button.
     * Input : an Actionevent which gives the button pressed information. 
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ends this window.
		this.dispose();
		/*
		 * Controls the input depending on the button's text.
		 */
		if(e.getActionCommand().equals("Create Cutter")){
			CreadorCortador c=new CreadorCortador(); 
			c.setVisible(true);
		}
		if(e.getActionCommand().equals("Create Block")){
			CreadorBloque c=new CreadorBloque(); 
			c.setVisible(true);
		}
		if(e.getActionCommand().equals("Create Area")){
			CreadorMalla c=new CreadorMalla(); 
			c.setVisible(true);
		}
	}
}
