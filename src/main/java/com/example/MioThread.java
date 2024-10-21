package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MioThread extends Thread {

    Socket s = new Socket();
    BufferedReader in;//input
    DataOutputStream out;
    public MioThread(Socket s) throws IOException{
        this.s = s;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new DataOutputStream(s.getOutputStream());
    }
    
    @Override
    public void run() {
        String scelta = "";
        String n1 = "";
        String n2 = "";
        do{
            //assegno un valore alla scelta
            try {
                scelta = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            switch (scelta) {
               
                case "1": // somma di 2 numeri
                    try {
                        n1 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        n2 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int int1 = Integer.parseInt(n1);
                    int int2 = Integer.parseInt(n2);
                    int somma = int1 + int2;
                    System.out.println(somma);
                    try {
                        out.writeBytes("La somma dei 2 numeri è: " + somma + "\n");
                        
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    break;

                    case "2": // sottrazione
                    try {
                        n1 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        n2 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int s1 = Integer.parseInt(n1);
                    int s2 = Integer.parseInt(n2);
                    int sottrazione = s1 - s2;
                    System.out.println(sottrazione);
                    try {
                        out.writeBytes("La sottrazione dei 2 numeri è: " + sottrazione + "\n");
                        
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    break;



                    case "3": //moltiplicazione
                    try {
                        n1 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        n2 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int m1 = Integer.parseInt(n1);
                    int m2 = Integer.parseInt(n2);
                    int moltiplicazione =  m1 * m2;
                    System.out.println(moltiplicazione);
                    try {
                        out.writeBytes("La moltiplicazione dei 2 numeri è: " + moltiplicazione + "\n");
                        
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    break;



                    case "4": //divisione
                    try {
                        n1 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        n2 = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Float d1 = Float.parseFloat(n1);
                    Float d2 = Float.parseFloat(n2);
                    Float divisione =  d1 / d2;
                    System.out.println(divisione);
                    try {
                        out.writeBytes("La divisione dei 2 numeri è: " + divisione + "\n");
                        
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    break;

            
                    case "!":
                    break;

                default:
                System.out.println("Errone, Valore non riconosciuto");
                    break;
            }


        }while(!scelta.equals("!"));
        try {
            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
