package kz.sking.rates;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

// СОЗДАТЕЛЬ КОТИРОВОК ВАЛЮТ
public class RatesReader {


    public static String getRatesData() {
        StringBuilder data = new StringBuilder();
        try {
            data.append("Bitcoin:  " + getRates("bitcoin"));
            data.append("Ethereum: " + getRates("ethereum"));
            data.append("Ripple:   " + getRates("ripple"));
            data.append("EOS:      " + getRates("eos"));
            data.append("Litecoin: " + getRates("litecoin"));
        } catch (Exception ignored) {
            return null; // При ошибке доступа возвращаем null
        }
        return data.toString(); // Возвращаем результат

    }

    public static String getRates (String url) throws IOException {
        String BASE_URL = "https://ru.investing.com/crypto/" + url;
        Document doc = Jsoup.connect(BASE_URL).get();
        Elements e = doc.select("span#last_last");
        return(e.text() + " USD\n\n");
    }

}