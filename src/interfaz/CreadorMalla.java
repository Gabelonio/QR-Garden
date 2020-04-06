package interfaz;
/*
	Packages usage:
	1. Java.awt imports : Color configuration.
						  Fonts.
						  Action listeners.
						  Events.
	2. Javax.swing imports : ComboBoxes (including default model).
							 Buttons deployment.
							 Frame deployment.
							 Label deployment.
							 Text inputs.
	3. clasesCultivo.Malla : Sets the information brought from
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clasesCultivo.Malla;
import generadorCodigo.CreadorCodigo;

/*
 * Graphic User Interface which generates an Area QR code.
 */
public class CreadorMalla extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	//Buttons to navigate or execute options
	private JButton crearCodigo,volverMenu; 
	//Text fields setting the information of an area.
	private JTextField ID;
	//Combo boxes setting the information of an area.
	private JComboBox<String> tipo;
	//Signs showing the information in the frame.
    private JLabel letreroID,letreroTipo,codigoQR;
    private JTextArea letreroFaltadeDatos;
    
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
    public CreadorMalla(){
    	
    	//Title
		this.setTitle("Area Generator");
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
		 * Text field
		 */
        ID=new JTextField();
        ID.setBounds(135,82,70,25);
        ID.setFont(new Font("Serif", Font.PLAIN, 17));
        ID.addKeyListener(new presionNumero());
        
		/*
		 * Combo box
		 */
        tipo=new JComboBox<String>();
        tipo.setBounds(136,138,125,25);
        tipo.setFont(new Font("Serif", Font.PLAIN, 17));
        String[] dir = {"Astromelia","Gerbera","White Mesh","Green Mesh"};
        tipo.setModel(new DefaultComboBoxModel<>(dir));
        tipo.setSelectedIndex(0);
        tipo.setFont(new Font("Serif", Font.PLAIN, 17));
        
        /*
         * Labels
         */
        letreroID=new JLabel("ID: ");
        letreroID.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroID.setBounds(110,75,120,40);
        letreroTipo=new JLabel("Type: ");
        letreroTipo.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroTipo.setBounds(95,132,80,40);
        letreroFaltadeDatos=new JTextArea("There is an empty space");
        letreroFaltadeDatos.setFont(new Font("Monospaced", Font.PLAIN, 12));
        letreroFaltadeDatos.setForeground(Color.RED);
        letreroFaltadeDatos.setOpaque(false);
        letreroFaltadeDatos.setBounds(80,210,200,50);
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
		this.add(letreroID);
		this.add(letreroTipo);
		this.add(letreroFaltadeDatos);
		this.add(codigoQR);
    	this.add(tipo);
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
		if(e.getActionCommand().equals("Create QR Code"))
		{
			//Verifies if a Text field is empty.
			if(ID.getText().length()==0){
				letreroFaltadeDatos.setVisible(true);
			}
			else{
				letreroFaltadeDatos.setVisible(false);
				//Sets the information to print in QR Code.
				Malla mall=new Malla();
				mall.setID("");
				for(int i=ID.getText().length();i<7;i++){
					mall.setID(mall.getID().concat("0"));
				}
				mall.setID(mall.getID().concat(ID.getText()));
				mall.setTipo(tipo.getItemAt(tipo.getSelectedIndex()));
				//Generates the QR Code with the given information.
				this.codigoQR.setIcon(new CreadorCodigo().crearCodigoQR(mall.getID()+"$"+mall.getTipo(),"malla"));
			}
		}
		if(e.getActionCommand().equals("Main Menu"))
		{
			this.dispose();
			MenuPrincipal m=new MenuPrincipal(); 
			m.setVisible(true);
		}
		
	}
}
