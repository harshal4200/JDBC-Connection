import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDb {
    public static void main(String[] args) {
       
        String connectionString = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
           
            MongoDatabase database = mongoClient.getDatabase("testDB");

            MongoCollection<Document> collection = database.getCollection("users");

            Document doc = new Document("name", "Harshal")
                    .append("age", 21)
                    .append("city", "Nagpur");
            collection.insertOne(doc);

            System.out.println("Data inserted!");

            for (Document curDoc : collection.find()) {
                System.out.println(curDoc.toJson());
            }
        } catch (Exception e) {
            System.err.println("एरर: " + e.getMessage());
        }
    }
}
