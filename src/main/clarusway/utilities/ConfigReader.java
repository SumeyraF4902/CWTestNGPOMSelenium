package clarusway.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {//ezberleme internete config reader  yazarsan bu sayfa gelir zaten olusturdugumuz  config properties dosyamizi bununla okuruz


    public static Properties properties;

    static{
        String filePath="config.properties";
        try {
            FileInputStream fis=new FileInputStream(filePath);// dosyayi okuma islemi

            properties=new Properties();
            properties.load(fis); //dosyayi yukleme islemi

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // getproperty methoduyla istedigimiz anahtarlari cekebiliriz ve parametre olarak gonderebiliriiz
    public static String getProperty(String key){
        return properties.getProperty(key);
    }}