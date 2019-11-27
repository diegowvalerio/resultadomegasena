package br.com.dw.resultadosmegasena;

public class Concurso {

    public String tipoconcurso; //mega-sena //loto-facil
    public String concurso; //concurso 000 12/12/200
    public String resultado; //acumulado

    public Concurso() {
    }

    public Concurso(String tipoconcurso, String concurso, String resultado) {
        this.tipoconcurso = tipoconcurso;
        this.concurso = concurso;
        this.resultado = resultado;
    }

    public String getTipoconcurso() {
        return tipoconcurso;
    }

    public void setTipoconcurso(String tipoconcurso) {
        this.tipoconcurso = tipoconcurso;
    }

    public String getConcurso() {
        return concurso;
    }

    public void setConcurso(String concurso) {
        this.concurso = concurso;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
