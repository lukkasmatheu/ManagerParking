package manager.parking.config;


import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import manager.parking.models.Clients;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Conexao {
    private static MongoCollection<Document> collection;
    private MongoDatabase dataBase;


    public Conexao() {
        try {
            MongoClient mongoConection = new MongoClient("localhost", 27017);
            dataBase = mongoConection.getDatabase("Parking");
            collection = dataBase.getCollection("Clientes");
            System.out.println("Conectado com Sucesso!");
        } catch (Exception e) {
            System.out.println("Error ao conectar ao banco : " + e.getMessage());
        }
    }

    public static MongoCollection<Document> getDataBase() {
        return collection;
    }

    public static void saveClient(@NonNull Clients clients) {
        Gson gson = new Gson();
        Document query = new Document().append("login", clients.getLogin());
        Document client = collection.find(query).first();
        if (client.isEmpty()) {
            System.out.println("Cliente ja cadastrado");
        }
        Document obj = (Document) JSON.parse(gson.toJson(clients));
        collection.insertOne(obj);
    }

    public static List<Clients> findClients() {

        MongoCursor<Document> cursor = collection.find().iterator();
        List<Clients> clientes = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                Document dbobj = cursor.next();
                //Converting BasicDBObject to a custom Class(Employee)
                Clients emp = (new Gson()).fromJson(dbobj.toString(), Clients.class);
                clientes.add(emp);
                System.out.println(emp.getName());
            }
        } catch (Exception e) {
            System.out.println("[Mensage]-Error ao buscar Clientes" + e.getMessage());
        } finally {
            cursor.close();
        }
        return clientes;
    }

    public static Clients findClient(String loginClient) {

        Document query = new Document().append("login", loginClient);
        Document client = collection.find(query).first();
        try {
            return (new Gson()).fromJson(client.toString(), Clients.class);

        } catch (Exception e) {
            System.out.println("[Mensage]-Error ao buscar Cliente" + e.getMessage());
        }
        return null;
    }

    public static boolean updateClient(@NonNull Clients clients) {
        Gson gson = new Gson();
        Document query = new Document().append("login", clients.getLogin());
        Bson updates = Updates.combine(
                Updates.addToSet("historicoEstacionamento", JSON.parse(gson.toJson(clients.getHistoricoEstacionamento()))),
                Updates.currentTimestamp("lastUpdated"));
        try {
            UpdateResult result = collection.updateMany(query, updates);
            System.out.println("Modified document count: " + result.getModifiedCount());
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
            return false;
        }
        return true;
    }

}