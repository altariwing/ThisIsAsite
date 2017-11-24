package com.house.crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BugMissionsFactory implements Runnable {
	Date date = new Date();

	// �x�s����쪺�C�өФl�W�p��
	private static Vector<String> urlList = new Vector<>(7000);
	static int CurrentMissionPageNumber = 1;
	static int totalPages;
	String yuching = "https://buy.yungching.com.tw/region";
	static {
		// �h�q���̭����CHROM��DRIVER�A�o��]�w�����|��D:/chromeDriver/chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "D:/chromeDriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String yuching = "https://buy.yungching.com.tw/region";
		// �s����üy���R�έ���
		driver.get(yuching);
		// ����̫�@�����s�A�q�W�p���̭��h����`����
		WebElement lastPage = driver.findElementByPartialLinkText("�̥���");
		String finalPage = lastPage.getAttribute("href");
		String currentPage = finalPage.substring(finalPage.lastIndexOf("=") + 1);
		totalPages = Integer.valueOf(currentPage);
		System.out.println("�üy�����@��" + totalPages + "��");
		driver.quit();
	}

	public int currentUrlsQuantity() {
		return urlList.size();
	}

	public synchronized void AddurlList(String url) {
		urlList.add(url);
	}	
			
	public synchronized String popUrlList() {
		String tempString = urlList.get(0);
		urlList.remove(0);
		return tempString;
	}

	// �h�C�Ӥ�����W�p��
	public void getYuchingHouseData(int pageNumber) throws IOException {

		// �˭�DRIVER

		ChromeDriver driver = new ChromeDriver();
		// �˭Ӥ��
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String currentTime = sf.format(date);
		// �˭�WRITER�A�g�i�o��txt�ɸ̭�

		FileWriter fw = new FileWriter("D:/IOtest/Yunching" + currentTime + ".txt", true);
		BufferedWriter bw = new BufferedWriter(fw);

		// �s�W����
		String currentUrl = yuching + "?pg=" + pageNumber;
		driver.get(currentUrl);

		// ���ݤG�Q��s�uor���X���~
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".l-item-list")));

		// ��C�@�Ӥ����̪�������}�̧Ǧs�JurlList
		List<WebElement> webElements = driver.findElements(By.cssSelector(".l-item-list > .m-list-item > a"));
		for (int j = 0; j < webElements.size(); j++) {
			String url = webElements.get(j).getAttribute("href");
			urlList.add(url);
			bw.write(url);
			bw.newLine();
		}
		System.out.println(Thread.currentThread().getName() + "�w�g���" + pageNumber + "��������W�p���x�s��UrlList");
		bw.flush();
		bw.close();
		fw.close();
		driver.quit();
	}

	@Override // ����Ƕi�J�I
	public void run() {
		try {// �p�G�٦��S�����檺�����A�N�h���Ӥ����u�@�A�p�G���w�g���槹���N����
			int pageNumber = 0;
			while (CurrentMissionPageNumber <= totalPages) {
				// �u�{�w��
				synchronized (this) {
					if (CurrentMissionPageNumber <= totalPages) {
						pageNumber = CurrentMissionPageNumber++;
					}
				}
				if (pageNumber != 0) {
					System.out.println(Thread.currentThread().getName() + "���b�B�z��" + pageNumber++ + "��");
					getYuchingHouseData(pageNumber);
				} else {
					System.out.println("�����w�gŪ������" + Thread.currentThread().getName() + "�w�g�U�Z");
				}
			}
			System.out.println(Thread.currentThread().getName() + "�w�g�U�Z");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	};
}
