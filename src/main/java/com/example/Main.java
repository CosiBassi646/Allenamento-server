package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("server partito");

        do{
            Socket s = serverSocket.accept();

            MioThread thread = new MioThread(s);
            thread.start();

        }while(true);
 

    }
}