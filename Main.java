package ua.edu.sumdu.j2se.mykyta.tasks;

import com.sun.jmx.snmp.SnmpUnknownSubSystemException;

import java.sql.SQLOutput;

public class Main {

	public static void main(String[] args) {

		Task task1 = new Task("meeting",10);
		Task task2 = new Task("walkin",0,15,3);


		task1.setActive(true);
		task2.setActive(true);
//		System.out.println(task1.nextTimeAfter(20));
//		System.out.println(task2.nextTimeAfter(30));
//
//		System.out.println("========================");
		System.out.println( task2.nextTimeAfter(3));
	}
}

