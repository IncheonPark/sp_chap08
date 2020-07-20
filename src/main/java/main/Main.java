package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요 : ");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
			} else if (command.equals("list")) {
				processListCommand();
			} else if (command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
			} else {
				printHelp();
			}
		}
	}
	
	private static void processNewCommand(String[] strings) {
		
	}
	
	private static void processChangeCommand(String[] strings) {
		
	}

	private static void processListCommand() {
		
	}
	
	private static void processInfoCommand(String[] strings) {
		
	}
	
	private static void printHelp() {
		
	}
}
