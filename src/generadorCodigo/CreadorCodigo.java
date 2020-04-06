package generadorCodigo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/*
 * Class which creates the QR code with the assistance of 
 * the google.zxing, java.util, java.io, java.imageio, 
 * java.swing and java.awt packages.
 */
public class CreadorCodigo{	
	/*
	 * Description : Generates the QR Code with a given information
	 * 				and creates a .png image containing the 
	 * 				most recent input.
	 * Input : String ingreso : the incoming information to be printed
	 * 						  in a QR Code.
	 * 		  String referencia : The name of the file where the image
	 * 							  is going to be saved.
	 * Output : An ImageIcon which represents the QR Code Generated.
	 */
	public ImageIcon crearCodigoQR(String ingreso,String referencia){
	  BufferedImage img = null;
	  try {
            String qrCodeData =ingreso;
            String filePath = "Sources/"+referencia+".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
            
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix,"PNG", pngOutputStream);
            img = ImageIO.read(new ByteArrayInputStream(pngOutputStream.toByteArray()));
            System.out.println("QR Code created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
	  	return new ImageIcon(img);
	}
}


