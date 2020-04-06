package interfaz;
/*
	Packages usage:
	1. Java.awt imports : Color configuration.
						  Fonts.
						  Action listeners.
						  Events.
   	2. Java.util imports : Arrays usage.
	3. Javax.swing imports : ComboBoxes (including default model).
							 Buttons deployment.
							 Frame deployment.
							 Label deployment.
	4. clasesCultivo.Bloque : Sets the information brought from
							  the graphical user interface.
	5. generadorCodigo.CreadorCodigo : Creates the QR code with the
									   given information.	
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import clasesCultivo.Bloque;
import generadorCodigo.CreadorCodigo;
/*
 * Graphic User Interface which generates a Block QR code.
 */
public class CreadorBloque extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	//Buttons to navigate or execute options.
	private JButton crearCodigo,volverMenu; 
	//Combo boxes setting the information of a block.
	private JComboBox<String> area,bloque,variedad; 
	//Signs showing the information in the frame.
    private JLabel letreroArea,letreroBloque,letreroVariedad,codigoQR;
    
    /*
     * Each Area's number has a varieties set, it is saved in an
     * array of this class.
     */  
    public class conjuntoVariedades{
    	ArrayList<String[]> variedades;
    	conjuntoVariedades()
    	{
    		variedades=new ArrayList<String[]>();
    	}
    }

    /*
     * Setters of the Areas' number counter.
     * Example: First Area (D) has 14 blocks.
     * 			Seconds Area (E) has 32 blocks.
     * 			Third Area (F) has 17 blocks.
     */
    private final int[] cantidadBloques= {14,32,17,16,14,16,10,18,13,31,37,18,27};
    /*
     * Setters of the Areas' varieties.
     * Example : D3 Has these varieties : "RO04","RO13","RO24","RO82","RO83". 
     */
    private final String[] D3= {"RO04","RO13","RO24","RO82","RO83"};
    private final String[] D4= {"RO04","RO50","RO65"};
    private final String[] D5= {"RO09","RO16","RO17","RO78"};
    private final String[] D6= {"RO33"};
    private final String[] D7= {"RO33"};
    private final String[] D8= {"RO07","RO13","RO16","RO77"};
    private final String[] D9= {"RO07","RO10","RO35","RO54","RO69"};
    private final String[] D10= {"RO54","RO58","RO65"};
    private final String[] D11= {"RO49","RO54","RO78","RO83"};
    private final String[] D12= {"RO16","RO42","RO60","RO86"};
    private final String[] D13= {"RO12","RO61","RO69","RO85"};
    private final String[] D14= {"RO08","RO25","RO78"};
    private final String[] D15= {"RO33"};
    private final String[] D16= {"RO33"};    
    private final String[] E1= {"RO72"};
    private final String[] E2= {"RO16","RO24","RO27","RO28"};
    private final String[] E3= {"RO16","RO27","RO28","RO54","RO86"};
    private final String[] E4= {"RO33"};
    private final String[] E5= {"RO33"};
    private final String[] E6= {"RO33"};
    private final String[] E7= {"RO06","RO15","RO86","RO87"};
    private final String[] E8= {"RO75"};
    private final String[] E9= {"RO25","RO27","RO78"};
    private final String[] E10= {"RO33","RO54"};
    private final String[] E11= {"RO33"};
    private final String[] E12= {"RO65","RO86"};
    private final String[] E13= {"RO16","RO28","RO60","RO70","RO78"};
    private final String[] E14= {"RO45","RO56","RO80","RO86"};
    private final String[] E15= {"RO33"};
    private final String[] E16= {"RO33"};
    private final String[] E17= {"RO24","RO66"};
    private final String[] E18= {"RO37"};
    private final String[] E19= {"RO37","RO54","RO78"};
    private final String[] E20= {"RO16","RO37","RO42","RO54","RO60"};
    private final String[] E21= {"RO22","RO33","RO69"};
    private final String[] E22= {"RO33"};
    private final String[] E23= {"RO35","RO42","RO54"};
    private final String[] E24= {"RO33"};
    private final String[] E25= {"RO33"};
    private final String[] E26= {"RO33"};
    private final String[] E27= {"RO33"};
    private final String[] E28= {"RO35","RO42"};
    private final String[] E29= {"RO33"};
    private final String[] E30= {"RO33"};
    private final String[] E31= {"RO33"};
    private final String[] E32= {"RO33"};
    private final String[] F1= {"RO33"};
    private final String[] F2= {"RO54","RO75","RO76"};
    private final String[] F3= {"RO32","RO33"};
    private final String[] F4= {"RO33"};
    private final String[] F5= {"RO31","RO37","RO49"};
    private final String[] F6= {"RO33"};
    private final String[] F7= {"RO02","RO27","RO29","RO65"};
    private final String[] F8= {"RO13","RO33"};
    private final String[] F9= {"RO02","RO27","RO30"};
    private final String[] F10= {"RO33"};
    private final String[] F11= {"RO33"};
    private final String[] F12= {"RO33"};
    private final String[] F13= {"RO33"};
    private final String[] F14= {"RO33"};
    private final String[] F15= {"RO33"};
    private final String[] F16= {"RO28","RO85"};
    private final String[] F17= {"RO33"};
    private final String[] G1= {"RO33"};
    private final String[] G2= {"RO81","RO89"};
    private final String[] G3= {"RO05","RO09","RO28","RO41","RO54"};
    private final String[] G4= {"RO33","RO49","RO65","RO75"};
    private final String[] G5= {"RO10","RO24","RO35"};
    private final String[] G6= {"RO33"};
    private final String[] G7= {"RO13","RO19","RO35"};
    private final String[] G8= {"RO33"};
    private final String[] G9= {"RO33"};
    private final String[] G10= {"RO27","RO28","RO29","RO78","RO85"};
    private final String[] G11= {"RO33"};
    private final String[] G13= {"RO13","RO27","RO85"};
    private final String[] G14= {"RO33"};
    private final String[] G15= {"RO28"};
    private final String[] G16= {"RO13","RO45","RO64","RO73"};
    private final String[] H1= {"RO24","RO27","RO65","RO69"};
    private final String[] H2= {"RO09","RO13","RO28"};
    private final String[] H3= {"RO04","RO26","RO49","RO75"};
    private final String[] H4= {"RO09","RO25","RO54","RO71","RO86","RO87"};
    private final String[] H5= {"RO13","RO33","RO58","RO60","RO65"};
    private final String[] H6= {"RO45","RO65","RO69","RO86","RO87"};
    private final String[] H7= {"RO13","RO27","RO29","RO85"};
    private final String[] H8= {"RO24","RO42","RO47","RO85"};
    private final String[] H9= {"RO28","RO35","RO37","RO85"};
    private final String[] H10= {"RO13","RO19","RO56","RO60"};
    private final String[] H11= {"RO09","RO61","RO65","RO69"};
    private final String[] H12= {"RO33"};
    private final String[] H13= {"RO75"};
    private final String[] H14= {"PIV"};
    private final String[] I1= {"RO09","RO21","RO33"};
    private final String[] I2= {"RO21","RO65","RO75","RO78"};
    private final String[] I3= {"RO16","RO78"};
    private final String[] I4= {"RO21","RO37","RO43"};
    private final String[] I5= {"RO13","RO28","RO75"};
    private final String[] I6= {"RO16","RO42"};
    private final String[] I7= {"RO76"};
    private final String[] I8= {"RO28","RO42","RO84"};
    private final String[] I9= {"RO33"};
    private final String[] I10= {"RO16"};
    private final String[] I11= {"RO33"};
    private final String[] I12= {"RO33"};
    private final String[] I13= {"RO69"};
    private final String[] I14= {"RO33"};
    private final String[] I15= {"RO35"};
    private final String[] I16= {"RO33"};
    private final String[] J1= {"RO33"};
    private final String[] J2= {"RO31","RO81"};
    private final String[] J3= {"RO33"};
    private final String[] J4= {"RO33"};
    private final String[] J5= {"RO33"};
    private final String[] J6= {"RO33"};
    private final String[] J7= {"RO33"};
    private final String[] J8= {"RO33"};
    private final String[] J9= {"RO33"};
    private final String[] J10= {"RO33"};
    private final String[] K1= {"RO07","RO78"};
    private final String[] K2= {"RO24","RO65"};
    private final String[] K3= {"RO28","RO40","RO78","RO83"};
    private final String[] K4= {"RO42","RO65","RO69"};
    private final String[] K5= {"RO28","RO69","RO78","RO86"};
    private final String[] K7= {"RO07","RO13","RO75","RO85"};
    private final String[] K8= {"RO33"};
    private final String[] K9= {"RO07","RO16","RO54","RO70"};
    private final String[] K10= {"RO04","RO31","RO86"};
    private final String[] K11= {"RO09","RO13","RO42","RO90"};
    private final String[] K12= {"RO24","RO31","RO35","RO66"};
    private final String[] K13= {"RO33","RO66","RO87"};
    private final String[] K14= {"RO28","RO63","RO69"};
    private final String[] K15= {"RO35","RO85"};
    private final String[] K16= {"RO10","RO13","RO24","RO28"};
    private final String[] K17= {"RO33"};
    private final String[] K18= {"RO33","RO44"};
    private final String[] L1= {"RO34","RO35","RO66","RO75"};
    private final String[] L2= {"RO42","RO54","RO83"};
    private final String[] L3= {"RO33","RO75"};
    private final String[] L4= {"RO16","RO28","RO83"};
    private final String[] L5= {"RO09","RO21","RO24","RO28"};
    private final String[] L6= {"RO28","RO54","RO72"};
    private final String[] L7= {"RO33"};
    private final String[] L8= {"RO13","RO25","RO86","RO87"};
    private final String[] L9= {"RO24","RO69"};
    private final String[] L10= {"RO54","RO78","RO83"};
    private final String[] L11= {"RO29","RO54","RO90"};
    private final String[] L12= {"RO83"};
    private final String[] L13= {"RO83"};
    private final String[] N1= {"RO33"};
    private final String[] N2= {"RO13","RO56","RO69","RO88"};
    private final String[] N3= {"RO05","RO09","RO21","RO37","RO75"};
    private final String[] N4= {"RO12","RO75","RO88"};
    private final String[] N5= {"RO07","RO16"};
    private final String[] N6= {"RO33"};
    private final String[] N7= {"RO20","RO33"};
    private final String[] N8= {"RO33","RO54","RO75"};
    private final String[] N9= {"RO26","RO33"};
    private final String[] N10= {"RO72","RO78","RO83"};
    private final String[] N11= {"RO33"};
    private final String[] N12= {"RO33"};
    private final String[] N13= {"RO33"};
    private final String[] N14= {"RO09","RO16","RO33"};
    private final String[] N15= {"RO05","RO33","RO69"};
    private final String[] N16= {"RO24","RO33","RO38"};
    private final String[] N17= {"RO33","RO54"};
    private final String[] N18= {"RO24","RO37","RO54","RO87"};
    private final String[] N19= {"RO33"};
    private final String[] N20= {"RO33"};
    private final String[] N21= {"RO33"};
    private final String[] N22= {"RO69"};
    private final String[] N23= {"RO33"};
    private final String[] N24= {"RO13","RO16","RO54","RO64"};
    private final String[] N25= {"RO37","RO69","RO78"};
    private final String[] N26= {"RO13","RO69","RO78"};
    private final String[] N27= {"RO08","RO14","RO33"};
    private final String[] N28= {"RO14","RO69","RO78"};
    private final String[] N29= {"RO08","RO16","RO41","RO54"};
    private final String[] N30= {"RO33"};
    private final String[] N31= {"RO33"};
    private final String[] O1= {"AS40","AS43","AS47","AS51","AS65"};
    private final String[] O2= {"AS17","AS43"};
    private final String[] O3= {"AS07","AS18","AS19","AS31","AS33","AS40","AS43","AS53","AS61","AS65","AS70"};
    private final String[] O4= {"AS01","AS06","AS08","AS29","AS33","AS54","AS55"};
    private final String[] O5= {"AS07","AS28","AS30","AS34","AS40","AS45"};
    private final String[] O6= {"AS29","AS31","AS39","AS43","AS49"};
    private final String[] O7= {"AS19","AS24","AS30","AS39","AS43","AS52","AS58","AS60"};
    private final String[] O8= {"AS04","AS19","AS24","AS33","AS49","AS52","AS53","AS58"};
    private final String[] O9= {"AS01","AS07","AS09","AS19","AS29","AS31","AS33","AS39","AS43","AS45","AS52"};
    private final String[] O10= {"AS29","AS32","AS39","AS42","AS48","AS52","AS55","AS57","AS58","AS59","AS63"};
    private final String[] O11= {"AS07","AS17","AS20","AS22","AS28","AS33","AS43","AS54","AS56","AS57","AS66","AS67"};
    private final String[] O12= {"RO33"};
    private final String[] O13= {"AS10","AS19","AS29","AS40","AS43","AS47","AS48","AS49","AS56","AS58","AS66","AS67"};
    private final String[] O14= {"AS02","AS12","AS13","AS14","AS39","AS43","AS46","AS62","AS67","AS70"};
    private final String[] O15= {"RO33"};
    private final String[] O16= {"RO33"};
    private final String[] O17= {"RO33"};
    private final String[] O18= {"RO33"};
    private final String[] O19= {"RO33"};
    private final String[] O20= {"GE05","GE11","GE12","GE17","GE19","GE22","GE24","GE26","GE34","GE35","GE38","GE40","GE44","GE54","GE59","GE60","GE62","GE65","GE68","GE69","GE71","GE72","GE75","GE77","GE79","GE81"};
    private final String[] O21= {"RO33"};
    private final String[] O22= {"RO33"};
    private final String[] O23= {"GE01","GE04","GE06","GE07","GE10","GE11","GE17","GE22","GE27","GE28","GE29","GE32","GE35","GE37","GE39","GE40","GE43","GE44","GE48","GE50","GE51","GE54","GE57","GE58","GE62","GE64","GE68","GE71","GE72","GE73","GE75","GE77","GE78","GE79"};
    private final String[] O24= {"GE01","GE02","GE06","GE07","GE10","GE11","GE12","GE13","GE15","GE16","GE18","GE20","GE21","GE22","GE23","GE25","GE27","GE31","GE33","GE34","GE36","GE37","GE38","GE40","GE41","GE42","GE46","GE47","GE48","GE49","GE52","GE53","GE55","GE56","GE57","GE59","GE61","GE62","GE63","GE65","GE66","GE67","GE70","GE72","GE73","GE74","GE76","GE77","GE78","GE80","GE82","GE83"}; 
    private final String[] O25= {"GE01","GE02","GE08","GE09","GE17","GE22","GE24","GE25","GE29","GE30","GE32","GE34","GE37","GE38","GE40","GE44","GE45","GE50","GE54","GE57","GE58","GE59","GE64","GE68","GE71","GE77","GE79"};
    private final String[] O26= {"GE01","GE02","GE03","GE08","GE13","GE14","GE17","GE22","GE24","GE30","GE34","GE37","GE38","GE40","GE43","GE44","GE45","GE48","GE50","GE54","GE58","GE59","GE65","GE68","GE71","GE77"};
    private final String[] O27= {"RO53","RO60"};
    private final String[] O28= {"RO33","RO70"};
    private final String[] O29= {"RO33"};
    private final String[] O30= {"RO33"};
    private final String[] O31= {"RO33"};
    private final String[] O32= {"RO33"};
    private final String[] O33= {"RO24","RO86"};
    private final String[] O34= {"RO33"};
    private final String[] O35= {"RO33"};
    private final String[] O36= {"RO33"};
    private final String[] O37= {"RO33"};
    private final String[] Q1= {"RO59"};
    private final String[] Q2= {"RO13"};
    private final String[] Q3= {"RO33"};
    private final String[] Q4= {"RO69"};
    private final String[] Q5= {"RO13","RO16","RO54","RO69"};
    private final String[] Q6= {"RO33"};
    private final String[] Q7= {"RO16"};
    private final String[] Q8= {"RO54"};
    private final String[] Q9= {"AS04","AS15","AS27","AS43","AS46","AS57","AS68"};
    private final String[] Q10= {"AS17","AS29","AS41","AS44","AS69"};
    private final String[] Q11= {"RO19","RO59","RO69"};
    private final String[] Q12= {"RO13","RO19"};
    private final String[] Q13= {"AS13","AS30","AS40","AS48","AS67"};
    private final String[] Q14= {"AS09","AS10","AS12","AS13","AS41","AS44"};
    private final String[] Q15= {"AS24","AS29","AS30","AS38","AS40","AS43","AS49","AS51","AS57"};
    private final String[] Q16= {"RO33"};
    private final String[] Q17= {"AS05","AS07","AS09","AS15","AS27","AS29","AS30","AS39","AS40","AS44","AS47","AS58"};
    private final String[] Q18= {"RO33"};
    private final String[] R1= {"AS27","AS42","AS43","AS48","AS52","AS58"};
    private final String[] R2= {"AS16","AS23","AS25","AS37","AS68"};
    private final String[] R3= {"AS29","AS31","AS32","AS33","AS35","AS46","AS68"};
    private final String[] R4= {"AS02","AS39","AS42","AS48","AS53","AS70"};
    private final String[] R5= {"AS31","AS48","AS60"};
    private final String[] R6= {"AS16","AS19","AS52","AS55","AS58"};
    private final String[] R7= {"AS01","AS11","AS11S","AS24"};
    private final String[] R8= {"AS03","AS15","AS23","AS27","AS36","AS55","AS64"};
    private final String[] R9= {"AS26","AS43","AS50","AS55","AS56"};
    private final String[] R10= {"AS29","AS33","AS48"};
    private final String[] R11= {"RO48","RO79"};
    private final String[] R12= {""};
    private final String[] R13= {""};
    private final String[] R14= {""};
    private final String[] R15= {""};
    private final String[] R16= {""};
    private final String[] R17= {""};
    private final String[] R18= {"RO32"};
    private final String[] R19= {"RO01","RO03","RO18","RO39","RO62","RO77","RO79"};
    private final String[] R20= {"0"};
    private final String[] R21= {"0"};
    private final String[] R22= {"RO52","RO67","RO77","RO79"};
    private final String[] R23= {"0"};
    private final String[] R24= {"0"};
    private final String[] R25= {"0"};
    private final String[] R26= {"0"};
    private final String[] R27= {"0"};  
    
    /*
     * Description :Sets the block combo box with the given configuration. 
     */
    public class bloqueSetter implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Sets the quantity of the block's number combo box.
			String[] bloques = new String[cantidadBloques[area.getSelectedIndex()]];
	        
			//Sets the numbers inside each combo box option.
			for(int i=0;i<cantidadBloques[area.getSelectedIndex()];i++){
				bloques[i]=(area.getSelectedIndex()==0)?String.valueOf(i+3):String.valueOf(i+1);
	        }
	        bloque.setModel(new DefaultComboBoxModel<>(bloques));
	        //Specific restrictions for the blocks G and K.
	        if(area.getSelectedItem().equals("G"))
	        	bloque.removeItemAt(11);
	        if(area.getSelectedItem().equals("K"))
	        	bloque.removeItemAt(5);
		}	
    }
    /*
     * Description :Sets the variety combo box with the given configuration. 
     */
    public class variedadSetter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * For each set of varieties is a different configuration.
			 * Example: the Area D has 14 numbers and each number an 
			 * 		    individual set of varieties (D3,D4,D6,...).
			 */
			conjuntoVariedades D=new conjuntoVariedades();
			D.variedades.addAll(Arrays.asList(D3,D4,D5,D6,D7,D8,D9,D10,D11,D12,D13,D14,D15,D16));
			conjuntoVariedades E=new conjuntoVariedades();
			E.variedades.addAll(Arrays.asList(E1,E2,E3,E3,E4,E5,E6,E7,E8,E9,E10,E11,E12,E13,E14,E15,E16,E17,E18,E19,E20,E21,E22,E23,E24,E25,E26,E27,E28,E29,E30,E31,E32));
			conjuntoVariedades F=new conjuntoVariedades();
			F.variedades.addAll(Arrays.asList(F1,F2,F3,F3,F4,F5,F6,F7,F8,F9,F10,F11,F12,F13,F14,F15,F16,F17));
			conjuntoVariedades G=new conjuntoVariedades();
			//G12 Does not exist.
			G.variedades.addAll(Arrays.asList(G1,G2,G3,G4,G5,G6,G7,G8,G9,G10,G11,G13,G14,G15,G16));
			conjuntoVariedades H=new conjuntoVariedades();
			H.variedades.addAll(Arrays.asList(H1,H2,H3,H3,H4,H5,H6,H7,H8,H9,H10,H11,H12,H13,H14));
			conjuntoVariedades I=new conjuntoVariedades();
			I.variedades.addAll(Arrays.asList(I1,I2,I3,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16));
			conjuntoVariedades J=new conjuntoVariedades();
			J.variedades.addAll(Arrays.asList(J1,J2,J3,J3,J4,J5,J6,J7,J8,J9,J10));
			conjuntoVariedades K=new conjuntoVariedades();
			//K6 Does not exist.
			K.variedades.addAll(Arrays.asList(K1,K2,K3,K3,K4,K5,K7,K8,K9,K10,K11,K12,K13,K14,K15,K16,K17,K18));
			conjuntoVariedades L=new conjuntoVariedades();
			L.variedades.addAll(Arrays.asList(L1,L2,L3,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13));
			conjuntoVariedades N=new conjuntoVariedades();
			N.variedades.addAll(Arrays.asList(N1,N2,N3,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22,N23,N24,N25,N26,N27,N28,N29,N30,N31));
			conjuntoVariedades O=new conjuntoVariedades();
			O.variedades.addAll(Arrays.asList(O1,O2,O3,O3,O4,O5,O6,O7,O8,O9,O10,O11,O12,O13,O14,O15,O16,O17,O18,O19,O20,O21,O22,O23,O24,O25,O26,O27,O28,O29,O30,O31,O32,O33,O34,O35,O36,O37));
			conjuntoVariedades Q=new conjuntoVariedades();
			Q.variedades.addAll(Arrays.asList(Q1,Q2,Q3,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14,Q15,Q16,Q17,Q18));
			conjuntoVariedades R=new conjuntoVariedades();
			R.variedades.addAll(Arrays.asList(R1,R2,R3,R3,R4,R5,R6,R7,R8,R9,R10,R11,R12,R13,R14,R15,R16,R17,R18,R19,R20,R21,R22,R23,R24,R25,R26,R27));
			
			/*
			 * Each set of varieties is set in an array, so 
			 * it deploys an specific index when the block's number
			 * and area is selected.
			 */
			//Sets the varieties set for each area. 
			conjuntoVariedades[] areas=new conjuntoVariedades[13];
			for(int i=0;i<13;i++){
				areas[i]=new conjuntoVariedades();
			}
			// Puts the areas in an array.
			areas[0]=D; areas[1]=E; areas[2]=F; areas[3]=G; areas[4]=H; areas[5]=I; areas[6]=J; areas[7]=K; areas[8]=L; areas[9]=N; areas[10]=O; areas[11]=Q; areas[12]=R;
			variedad.setModel(new DefaultComboBoxModel<>(areas[area.getSelectedIndex()].
					variedades.get(bloque.getSelectedIndex())));
		}
    	
    }
    /*
     * Description : Configures the window, displaying the incoming and outcoming
     * 				 information.
     */
    public CreadorBloque()
    {
    	//Title
		this.setTitle("Block Generator");
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
		 * Combo boxes 
		 */
        area=new JComboBox<String>();
        area.setBounds(105,67,40,25);
        area.setFont(new Font("Serif", Font.PLAIN, 17));
        String[] areas = {"D","E","F","G","H","I","J","K","L","N","O","Q","R"};
        area.setModel(new DefaultComboBoxModel<>(areas));
        area.setSelectedIndex(0);
        area.addActionListener(new bloqueSetter());
        area.addActionListener(new variedadSetter());
        bloque=new JComboBox<String>();
        bloque.setBounds(105,119,50,25);
        bloque.setFont(new Font("Serif", Font.PLAIN, 17));
        String[] bloques = new String[14];
        for(int i=0;i<14;i++)
        {
        	bloques[i]=String.valueOf(i+3);
        }
        bloque.setModel(new DefaultComboBoxModel<>(bloques));
        bloque.setSelectedIndex(0);
        bloque.addActionListener(new variedadSetter());
        variedad=new JComboBox<String>();
        variedad.setBounds(105,172,80,25);
        variedad.setFont(new Font("Serif", Font.PLAIN, 17));
        String[] variedades = {"RO04","RO13","RO24","RO82","RO83"};
        variedad.setModel(new DefaultComboBoxModel<>(variedades));
        variedad.setSelectedIndex(0);
        
        /*
         * Labels
         */
        letreroArea=new JLabel("Area: ");
        letreroArea.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroArea.setBounds(60,60,80,40);
        letreroBloque=new JLabel("Number: ");
        letreroBloque.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroBloque.setBounds(37,112,80,40);
        letreroVariedad=new JLabel("Variety: ");
        letreroVariedad.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroVariedad.setBounds(36,166,80,40);
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
		this.add(letreroArea);
		this.add(letreroBloque);
		this.add(letreroVariedad);
		this.add(codigoQR);
    	this.add(bloque);
        this.add(area); 
        this.add(variedad);
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
					//Sets the information to print in QR Code.
					Bloque bloq=new Bloque();
					bloq.setArea(area.getItemAt(area.getSelectedIndex()).toCharArray()[0]);
					bloq.setVariedad(variedad.getSelectedItem().toString());
					bloq.setNumero(Integer.parseInt(bloque.getSelectedItem().toString()));
					//Generates the QR Code with the given information.
					this.codigoQR.setIcon(new CreadorCodigo().crearCodigoQR(bloq.getArea()+"$"+bloq.getNumero()+"$"+bloq.getVariedad(),"bloque"));
		}
		if(e.getActionCommand().equals("Main Menu")){
			this.dispose();
			MenuPrincipal m=new MenuPrincipal(); 
			m.setVisible(true);
		}
	}
}
