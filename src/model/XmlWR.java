package model;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlWR {


    public static void WriteToXML (Properties settings) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("resources/settings.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(settings);
        encoder.close();
        fos.close();
    }



    public static Properties deserializeFromXML(String path) throws Exception{
        FileInputStream fis = new FileInputStream(path);
        XMLDecoder decoder = new XMLDecoder(fis);
        Properties decodedSettings = (Properties) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedSettings;
    }
}
