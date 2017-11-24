package com.house.crawler;

import java.io.File;

public class BugKing {

	public static void main(String[] args) {

		 // ������F�賣�b�o��
		 File file = new File("D:/IOtest");
		 if (!file.exists()) {
		 file.mkdirs();
		 }
		
		 // �I�s�T�Ӱ���ǡA��H�q�C�@��������W�p������U��
		 BugMissionsFactory2 getCommoditiesUrl = new BugMissionsFactory2();
		 Thread thread1 = new Thread(getCommoditiesUrl, "�H�q�@��");
		 Thread thread2 = new Thread(getCommoditiesUrl, "�H�q�G��");
		 Thread thread3 = new Thread(getCommoditiesUrl, "�H�q�T��");
		 thread1.start();
		 thread2.start();
		 thread3.start();
		
		 try {
		 thread1.join();
		 thread2.join();
		 thread3.join();
		 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 System.out.println("������}���u�@�����e���F���a���F");
		 }
		
		 // �h�C�өЫΪ��󪺺�����ڭ̻ݭn���Ѽ�
		 System.out.println("��Ʈw�@��" + getCommoditiesUrl.currentUrlsQuantity()
		 + "�����");
		 BugPrincess downloadInfo = new BugPrincess();
		 thread1 = new Thread(downloadInfo, "�H�q�@��");
		 thread2 = new Thread(downloadInfo, "�H�q�G��");
		 thread3 = new Thread(downloadInfo, "�H�q�T��");
		
		 thread1.start();
		 thread2.start();
		 thread3.start();
		
		 try {
		 thread1.join();
		 thread2.join();
		 thread3.join();
		 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 System.out.println("�����e�F���a���F");
		 }
		
		 // �p�G���U�����Ѫ����}�A�b�o��|��ܥX��
		 downloadInfo.describeErrorList();
		 System.out.println("�U���{������");

		// -------------------------�U���O�üy�Ы�-------------------------------

//		System.out.println(BugMissionsFactory.totalPages);
//
//		// �I�s�T�Ӱ���ǡA��üy�C�@��������W�p������U��
//		BugMissionsFactory getCommoditiesUrl = new BugMissionsFactory();
//		Thread thread1 = new Thread(getCommoditiesUrl, "�üy�@��");
//		Thread thread2 = new Thread(getCommoditiesUrl, "�üy�G��");
//		Thread thread3 = new Thread(getCommoditiesUrl, "�üy�T��");
//		thread1.start();
//		thread2.start();
//		thread3.start();
//
//		try {
//			thread1.join();
//			thread2.join();
//			thread3.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("������}���u�@�����e���F���a���F");
//		}
//
//		// �h�C�өЫΪ��󪺺�����ڭ̻ݭn���Ѽ�
//		System.out.println("��Ʈw�@��" + getCommoditiesUrl.currentUrlsQuantity() + "�����");
//		BugPrince downloadInfo = new BugPrince();
//		thread1 = new Thread(downloadInfo, "�@��");
//		thread2 = new Thread(downloadInfo, "�G��");
//		thread3 = new Thread(downloadInfo, "�T��");
//
//		thread1.start();
//		thread2.start();
//		thread3.start();
//
//		try {
//			thread1.join();
//			thread2.join();
//			thread3.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("�����e�F���a���F");
//		}
//
//		// �p�G���U�����Ѫ����}�A�b�o��|��ܥX��
//		downloadInfo.describeErrorList();
//		System.out.println("�U���{������");

	}

}
