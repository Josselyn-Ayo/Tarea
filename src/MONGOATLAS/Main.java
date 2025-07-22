package MONGOATLAS;

import com.mongodb.client.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // URI de conexión (reemplaza <tu_contraseña> con la real)
        String uri = "mongodb+srv://anabelayo2017:123456789Dios@cluster0.yytyyy1.mongodb.net/clientes?retryWrites=true&w=majority&appName=Cluster0";


        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Accede a la base de datos (cambia el nombre si es distinto)
            MongoDatabase database = mongoClient.getDatabase("Cliente");

            // Accede a la colección
            MongoCollection<Document> collection = database.getCollection("tablas");

            // Imprime los documentos de la colección
            for (Document doc : collection.find()) {
                System.out.println("ID: " + doc.getObjectId("_id"));
                System.out.println("Nombre: " + doc.getString("nombre"));
                System.out.println("Apellido: " + doc.getString("apellido"));
                System.out.println("Edad: " + doc.getInteger("edad"));
                System.out.println("---------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
    }
}



