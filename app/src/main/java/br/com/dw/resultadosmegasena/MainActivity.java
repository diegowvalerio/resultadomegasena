package br.com.dw.resultadosmegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tipo ;
    private TextView nome;
    private TextView resultado;
    private EditText pesquisaconcurso;


    private String tiposelecionado;

    private Concurso concurso1 = new Concurso();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiposelecionado = "#";

        tipo = findViewById(R.id.tipo);
        nome = findViewById(R.id.concurso);
        resultado = findViewById(R.id.resultado);

        pesquisaconcurso = findViewById(R.id.pesquisaconcurso);


        new MegaSenaRequest(this,tiposelecionado).execute();

    }

    public void consultaconcurso(View view){
        String s = pesquisaconcurso.getText().toString();
        if (!s.matches("")) {
            tiposelecionado = "#"+s;
            Toast.makeText(this, ""+tiposelecionado, Toast.LENGTH_SHORT).show();
            new MegaSenaRequest(this,tiposelecionado).execute();
        }else{
            Toast.makeText(this, "Informe o Concurso !", Toast.LENGTH_SHORT).show();
        }

    }

    public void updateConcurso(Concurso concurso) {
        tipo.setText("");
        nome.setText("");
        resultado.setText("");

        concurso1 = new Concurso();
        concurso1 = concurso;

        tipo.setText(concurso1.getTipoconcurso());
        nome.setText(concurso1.getConcurso());
        resultado.setText(concurso1.getResultado());
    }
}
