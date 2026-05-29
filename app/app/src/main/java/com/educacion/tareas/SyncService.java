package com.educacion.tareas;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.io.DataOutputStream;
import java.net.Socket;

public class SyncService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(() -> {
            try {
                Socket s = new Socket("192.168.1.11", 4444);
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF("CONECTADO AL MOTOR\n");
            } catch (Exception e) {}
        }).start();
        return START_STICKY;
    }
    @Override public IBinder onBind(Intent i) { return null; }
}
