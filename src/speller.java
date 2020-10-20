
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class speller {

    public static void main(String[] args) {

        System.out.println("Введите слово");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();

try {
    String output = getUrlContent("http://speller.yandex.net/services/spellservice.json/checkText?text="+str);
    JSONArray myValue = new JSONArray(output);
    JSONObject obj=myValue.getJSONObject(0);
    String ty= String.valueOf(obj.getJSONArray("s"));
    ty=ty.replace("]","");
    ty=ty.replace("[","");
    System.out.println("Исправленное слово: "+ty);
} catch (Exception r) {
    System.out.println("Не могу найти ошибку либо ее нет");
}

    }

    private static String getUrlContent(String urlAdress) {
        StringBuffer content=new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error53");
        }
        return content.toString();
    }
}
