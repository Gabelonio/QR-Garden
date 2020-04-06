package interfaz;
/*
	Packages usage:
	1. Java.awt imports : Color configuration.
						  Fonts.
						  Action listeners.
						  Events.
	2. Javax.swing imports : Text inputs.
							 Buttons deployment.
							 Frame deployment.
							 Label deployment.
	3. clasesCultivo.Cortador : Sets the information brought from
							    the graphical user interface.
	4. generadorCodigo.CreadorCodigo : Creates the QR code with the
									   given information.	
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import clasesCultivo.Cortador;
import generadorCodigo.CreadorCodigo;

/*
 * Graphic User Interface which generates a Cutter QR code.
 */
public class CreadorCortador extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	//Buttons to navigate or execute options
	private JButton crearCodigo,volverMenu;
	//Text fields setting the information of a cutter.
	private JTextField nombres,apellidos,ID; 
	//Signs showing the information in the frame.
    private JLabel letreroNombres,letreroApellidos,letreroID,codigoQR;
    private JTextArea letreroFaltadeDatos;
    
    /*
     * This class avoids the user to introduce 
     * different characters from letters and spaces.
     */
    public class presionAlfabetica implements KeyListener{
		@Override
		/*
		 * Description : Consumes every character given in the key event
		 * 				which is not letter or space.
		 * Input : A KeyEvent containing the character introduced.
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
		public void keyTyped(KeyEvent e) {
			//!(Character.isLetter(e.getKeyChar()))    Letter manager
			//e.getKeyChar()!=' '                      Space manager 
		 if(!(Character.isLetter(e.getKeyChar()))&&
				 e.getKeyChar()!=' '){
                e.consume();
         }
		}
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent arg0) {
		}
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyReleased(KeyEvent arg0) {
		}
    }
    /*
     * This class avoids the user to introduce 
     * different characters from numbers.
     */
    public class presionNumero implements KeyListener{
    	/*
		 * Description : Consumes every character given in the key event
		 * 				 which is not number.
		 * Input : A KeyEvent containing the character introduced.
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
    	@Override
		public void keyTyped(KeyEvent e) {
			try {
				//Gets the full text.
                Double.parseDouble(ID.getText()+e.getKeyChar());
                /*
                 * Compares if it doesn't introduce letters
                 * or spaces between numbers.
                 */
                if((ID.getText()+e.getKeyChar()).length()>8){
                	e.consume();
                }
            }catch (NumberFormatException ex) {
                e.consume();
            }
			finally{
				//Special cases.
				if(e.getKeyChar()=='d'||e.getKeyChar()=='f')
					e.consume();
			}
		}
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent arg0) {
		}
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyReleased(KeyEvent arg0) {
		}
    }
    /*
     * Description : Configures the window, displaying the incoming and outcoming
     * 				 information.
     */
    public CreadorCortador()
    {
    	//Title
		this.setTitle("Cutter Generator");
		//Size
		this.setSize(550,350);
		//Null layout to configure freely the environment
		this.setLayout(null);
		//Default exit by closing the window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Deploy at the center of the screen
		this.setLocationRelativeTo(null);
		//Non re-sizable
		this.setResizable(false);
		
		//Configuring the panel
		/*
		 * Text fields
		 */
        nombres=new JTextField();
        nombres.setBounds(105,82,175,25);
        nombres.setFont(new Font("Serif", Font.PLAIN, 17));
        nombres.addKeyListener(new presionAlfabetica());
        apellidos=new JTextField();
        apellidos.setBounds(105,142,175,25);
        apellidos.setFont(new Font("Serif", Font.PLAIN, 17));
        apellidos.addKeyListener(new presionAlfabetica());
        ID=new JTextField();
        ID.setBounds(105,197,80,25);
        ID.setFont(new Font("Serif", Font.PLAIN, 17));
        ID.addKeyListener(new presionNumero());
        
        /*
		 * Labels
		 */
        letreroNombres=new JLabel("First Name(s): ");
        letreroNombres.setFont(new Font("Serif", Font.PLAIN, 14));
        letreroNombres.setBounds(15,75,100,40);
        letreroApellidos=new JLabel("Family Name(s): ");
        letreroApellidos.setFont(new Font("Serif", Font.PLAIN, 14));
        letreroApellidos.setBounds(5,132,100,40);
        letreroID=new JLabel("ID: ");
        letreroID.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroID.setBounds(78,189,80,40);
        letreroFaltadeDatos=new JTextArea("There is an empty space");
        letreroFaltadeDatos.setFont(new Font("Monospaced", Font.PLAIN, 12));
        letreroFaltadeDatos.setForeground(Color.RED);
        letreroFaltadeDatos.setOpaque(false);
        letreroFaltadeDatos.setBounds(80,225,200,50);
        letreroFaltadeDatos.setVisible(false);  
        codigoQR=new JLabel();
        codigoQR.setBounds(315,45,200,200);
        codigoQR.setBackground(Color.WHITE);
        codigoQR.setOpaque(true);
        
        /*
         * Buttons
         */
		crearCodigo=new JButton(); 
		crearCodigo.setBounds(335,250,150,30);
		crearCodigo.setText("Create QR Code");
		crearCodigo.addActionListener(this);		
		volverMenu=new JButton(); 
		volverMenu.setBounds(85,250,150,30);
		volverMenu.setText("Main Menu");
		volverMenu.addActionListener(this);
		
		/*
		 * Adding the components to the window
		 */
		this.add(letreroNombres);
		this.add(letreroApellidos);
		this.add(letreroFaltadeDatos);
		this.add(letreroID);
		this.add(codigoQR);
    	this.add(apellidos);
        this.add(nombres); 
		this.add(ID);
        this.add(crearCodigo);
		this.add(volverMenu);
    }
    
    /*
     * Description : Executes the action given by pressing a button.
     * Input : an Actionevent which gives the button pressed information. 
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Controls the input depending on the button's text.
		 */
		if(e.getActionCommand().equals("Create QR Code")){
			//Verifies if a Text field is empty.
			if(nombres.getText().length()==0||apellidos.getText().length()==0||ID.getText().length()==0){
				letreroFaltadeDatos.setVisible(true);
			}
			else{
				letreroFaltadeDatos.setVisible(false);
				//Sets the information to print in QR Code.
				Cortador cort=new Cortador();
				cort.setNombres(nombres.getText().trim());
				cort.setApellidos(apellidos.getText().trim());
				cort.setID(ID.getText().trim());
				//Generates the QR Code with the given information.
				this.codigoQR.setIcon(new CreadorCodigo().crearCodigoQR(cort.getNombres()+"$"+cort.getApellidos()+"$"+cort.getID(),"cortador"));
			}
		}
		if(e.getActionCommand().equals("Main Menu")){
			this.dispose();
			MenuPrincipal m=new MenuPrincipal(); 
			m.setVisible(true);
		}
	}
}
