package br.com.dw.resultadosmegasena;

import android.os.AsyncTask;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class MegaSenaRequest extends AsyncTask<Void, Void, Concurso> {
    private WeakReference<MainActivity> activity;
    private String tipo;

    public MegaSenaRequest( MainActivity activity, String tipo ){
        this.activity = new WeakReference<>( activity );
        this.tipo = (tipo);
    }

    @Override
    protected Concurso doInBackground(Void... voids) {

        Document html = null;
        Concurso concurso = new Concurso();

        try {

            html = Jsoup.connect("https://g1.globo.com/loterias/megasena.ghtml"+tipo).get();
            Element loteria = null;
            loteria = html.getElementById("lottery");
            concurso.setTipoconcurso(loteria.select("h1.content-lottery__title").text());
            concurso.setConcurso(loteria.select("span.content-lottery__info").text());
            concurso.setResultado(loteria.select("div.content-lottery__ammount").text());


        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return concurso;
    }

    @Override
    protected void onPostExecute(Concurso concurso) {
        super.onPostExecute( concurso );

        if( activity.get() != null ){
            Toast.makeText(activity.get(), ""+tipo+" - "+concurso.getConcurso(), Toast.LENGTH_SHORT).show();
            activity.get().updateConcurso( concurso );
        }
    }
}
