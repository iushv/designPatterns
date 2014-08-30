package com.premaseem.client;

import java.util.Random;
import java.util.Scanner;

import com.premaseem.javaapi.observable.ObservableShare;
import com.premaseem.javaapi.observable.ObserverShareBroker;
import com.premaseem.observable.SharePriceObservable;
import com.premaseem.observable.impl.Company1Share;
import com.premaseem.observable.impl.Company2Share;
import com.premaseem.observer.ShareBrokerObserver;
import com.premaseem.observer.impl.ShareBroker1;

public class JavaAPIClient {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int repeatRunFlag = 1;
		while (repeatRunFlag == 1) {

			System.out
					.println("This is the Client Main file for Observer Pattern where user can attach and detech subject on runtime without hard coded data");
			System.out
					.println("User is acting as a borker here and he can choose to turn on notification from 2 different companies");

			ObservableShare subject = new ObservableShare();
			ObserverShareBroker subscriber1 = new ObserverShareBroker();
			
			System.out
					.println("Do you want to observer / get notification of share price updates of shares ? ");
			System.out.println("Press 1 for yes and 0 or other digits for no ");
			int observeInfosysShareFlag = scan.nextInt();
			
			if(observeInfosysShareFlag==1){
				subject.addObserver(subscriber1);
				subscriber1.setSubject(subject);
			}else{
				subject.deleteObserver(subscriber1);
			}

			System.out.println("Simulating price change for share  ");
			subject.setShareprice(14);
			subject.setShareprice(420);
			

			System.out.println();
			System.out.println(" $$$$$$$$$$$$$$$$$$$$  Thanks by Prem Aseem $$$$$$$$$$$$$$$$$$$$$$");

			System.out.println();

			System.out
					.println("Do you want to Re-run this program - Press 1 for yes and 0 or other digits to EXIT ");
			repeatRunFlag = scan.nextInt();
		}
	}

	public static void simulateSharePriceChange(
			SharePriceObservable sharePriceObservable) {
		Random rnd = new Random();
		for (int i = 0; i < 2; i++) {
			sharePriceObservable.setCurrentMarketPrice(rnd.nextInt());
		}
	}
}
