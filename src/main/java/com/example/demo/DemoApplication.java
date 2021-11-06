package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication extends ClassLoader{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader classLoader=new DemoApplication();
		Class<?> clazz =classLoader.loadClass("Hello");
		for(Method m:clazz.getDeclaredMethods()){
			System.out.print(clazz.getSimpleName()+"."+m.getName());
		}
		}
	public Class<?>findClass(String name){
		String renamePath=name.replace(".", "/");
		String suffix=".xlass";
		InputStream inputStream =this.getClass().getClassLoader().getResourceAsStream(renamePath+suffix);
		int length;
		try {
			length = inputStream.available();
			byte[] byteArray=new byte[length];
			inputStream.read(byteArray);
			byte[] classBytes=decode(byteArray);
			return defineClass(name,classBytes,0,classBytes.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
    }
	private byte[] decode(byte[] byteArray) {
		byte[] targetArray=new byte[byteArray.length];
		for(int i=0;i<byteArray.length;i++){
			targetArray[i]=(byte) (255-byteArray[i]);
		}
		return targetArray;
	}
	}
