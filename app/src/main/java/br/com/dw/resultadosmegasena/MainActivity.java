package br.com.dw.resultadosmegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] texto = new String[1];
        new Thread() {
            public void run() {
                Document doc = null;
                String f ;
                try {
                    doc = Jsoup.connect("https://g1.globo.com/loterias/megasena.ghtml").get();
                    Elements pagina = doc.select("div#lottery");

                    for (Element el : pagina) {
                        //Dentro da div, encontramos o item que possui class igual a 'js-tweet-text-container'.
                        texto[0] = el.getElementsByClass ("content-lottery__info").toString();

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Toast.makeText(this, "Resultado: "+texto[0].toString(), Toast.LENGTH_SHORT).show();

    }
}
