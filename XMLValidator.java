import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XMLValidator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage : java XMLValidator <chemin_fichier.xml>");
            return;
        }

        String filePath = args[0];

        if (isWellFormedXML(filePath)) {
            System.out.println("Le fichier XML est bien formé.");
        } else {
            System.out.println("Le fichier XML n'est pas bien formé !");
        }
    }

    public static boolean isWellFormedXML(String filePath) {
        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                System.out.println("Erreur : Le fichier n'existe pas !");
                return false;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            return true; // Si on arrive ici, le fichier est bien formé
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            return false;
        }
    }
}
