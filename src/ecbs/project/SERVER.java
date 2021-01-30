package ecbs.project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SERVER {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            System.out.println("Waiting for Client");            
            serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            System.out.println("Client is Connected");
            
            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String pReader = reader.readLine();
            String cReader = reader.readLine();
            int Creader = Integer.parseInt(cReader);
            int Preader = Integer.parseInt(pReader);
            int ConUnit =  Creader - Preader;
            int DCharge = 90;
            int SCharge = 20;
            int MCharge = 0;
            if (ConUnit <= 0) {
                MCharge = 50;
            }
            int UnitCharge = ConUnit * 9;
            int Vat = 5 * (UnitCharge / 100);
            int total = Vat + DCharge + SCharge + MCharge + UnitCharge;
            writer.write(ConUnit+" ");
            writer.newLine();
            writer.write(DCharge+" ");
            writer.newLine();
            writer.write(SCharge+" ");
            writer.newLine();
            writer.write(MCharge+" ");
            writer.newLine();
            writer.write(Vat+" ");
            writer.newLine();
            writer.write(total+" ");
            writer.newLine();
            writer.flush();
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
