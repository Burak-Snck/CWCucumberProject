package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties; // Yapılandırma verilerini saklamak için Properties nesnesi oluşturuluyor.

    static {
        String filePath = "configuration.properties"; // Yapılandırma dosyasının yolu belirleniyor.
        try {
            FileInputStream fis = new FileInputStream(filePath); // Dosya okuma işlemi için FileInputStream oluşturuluyor.
            properties = new Properties(); // Yapılandırma verilerini saklamak için yeni bir Properties nesnesi oluşturuluyor.
            properties.load(fis); // FileInputStream ile okunan veriler Properties nesnesine yükleniyor.
            fis.close(); // Dosya kapatılıyor.
        } catch (IOException e) {
            e.printStackTrace(); // Hata durumunda exception yakalanıp konsola yazdırılıyor.
        }
    }

    public static String getProperty(String key) {
        // Belirtilen anahtar (key) ile ilişkili değeri döndüren getProperty metodu oluşturuluyor.
        return properties.getProperty(key);
    }
}
