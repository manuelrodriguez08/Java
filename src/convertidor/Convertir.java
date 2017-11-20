
package convertidor;

import java.io.File;
import java.io.IOException;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.FFMPEGLocator;
import it.sauronsoftware.jave.InputFormatException;
import javax.swing.JOptionPane;

public class Convertir {
    
    
    
    
    
   
	static String pathpm3="C:/conversion/tequendama.mp3";
	public static void convertToAudio(File video,String Nombre) throws IllegalArgumentException, InputFormatException, EncoderException, IOException
	{
             
                
		File target = new File("C:/conversion/"+Nombre+".mp3");
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
                
		Encoder encoder = new Encoder();
                
                try {
                    
                    if(video == null){
                        JOptionPane.showMessageDialog(null, "Por Favor Seleccione un video para convertir..");
                    }else{
                        encoder.encode(video, target, attrs);
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                    }
                
            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "El Video no se pudo Convertir");
                    System.err.println(e.toString());
            }
		
		
	}
	public static void convertToMP3(File video) throws IllegalArgumentException, InputFormatException, EncoderException
	{
		File target = new File(pathpm3);
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		Encoder encoder = new Encoder();
		encoder.encode(video, target, attrs);
	}
    
}
