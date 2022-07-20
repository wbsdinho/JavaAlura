import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
    String url = UrlGet.getUrl();
    URI endereco = URI.create(url);
    HttpClient cliente = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
    String corpo = response.body();
    
    JsonRead parser = new JsonRead();
    List<Map<String, String>> listaDeFilmes = parser.parse(corpo);
    // System.out.println(listaDeFilmes);

    for (Map<String,String> filmes : listaDeFilmes) {
        System.out.println("\u001b[1m \u001b[31m Título: \u001b[0m " + filmes.get("title"));
        System.out.println("\u001b[1m \u001b[37m Poster: \u001b[0m " + filmes.get("image"));
        
        if (Float.parseFloat(filmes.get("imDbRating")) <= 6) {
            //imprime Classificação em vermelho se for menor que 6
            System.out.println("\u001b[1m \u001b[31m Classificação: \u001b[0m " + "\u001b[31m" + filmes.get("imDbRating"));
            System.out.println("\u001b[1m \u001b[33m"+ BuildStar.star(Float.parseFloat(filmes.get("imDbRating"))));        
        }else if(Float.parseFloat(filmes.get("imDbRating")) <= 8){
            //imprime Classificação em amarelo se for menor que 6
            System.out.println("\u001b[1m \u001b[33m Classificação: \u001b[0m " + "\u001b[33m" + filmes.get("imDbRating"));
            System.out.println("\u001b[1m \u001b[33m"+ BuildStar.star(Float.parseFloat(filmes.get("imDbRating"))));
        } else{
            //imprime Classificação em verde se for menor que 6
            System.out.println("\u001b[1m \u001b[32m Classificação: \u001b[0m " + "\u001b[32m" + filmes.get("imDbRating"));   
            System.out.println("\u001b[1m \u001b[33m"+ BuildStar.star(Float.parseFloat(filmes.get("imDbRating"))));
        }   
        System.out.println();
        

        
    }

    }
}
