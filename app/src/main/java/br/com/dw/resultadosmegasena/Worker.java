package br.com.dw.resultadosmegasena;

import android.os.SystemClock;

import java.lang.ref.WeakReference;

public class Worker extends Thread {
    private WeakReference<MainActivity> activity;
    private String tipo;

    public Worker( MainActivity activity, String tipo ){

        this.activity = new WeakReference<>( activity );
        this.tipo = tipo;
    }

    @Override
    public void run() {
        super.run();

        while( activity.get() != null ){
            SystemClock.sleep(20000);
            new MegaSenaRequest( activity.get(),tipo ).execute();
        }
    }
}
