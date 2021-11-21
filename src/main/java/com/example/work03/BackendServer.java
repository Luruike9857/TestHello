package com.example.work03;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.buffer.ByteBufOutputStream;

// 创建了一个固定大小的线程池处理请求
public class BackendServer {
    public static void main(String[] args) throws IOException{
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final ServerSocket serSocket = new ServerSocket(9801);
        while (true) {
            try {
                final Socket socket = serSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
    
    private static void service(Socket socket) {
    	    
    	    try {
    	    	ByteArrayOutputStream out= new ByteArrayOutputStream();
				InputStream input=socket.getInputStream();
				byte[]buffer=new byte[8*1024];
				int length=input.read(buffer);
				out.write(buffer,0,length);
				byte[] inputByte=out.toByteArray();
				String inputContent=new String(inputByte,"utf-8");
				System.out.println("BackendServer收到请求:\n" + inputContent);
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,world";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}