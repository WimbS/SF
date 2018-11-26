package com.wimb.A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FileChangeName {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileChangeName a = new FileChangeName();

		Map<String, String> map = a.readTxtFile("d:/Program Files/MyeclipseWorkSpace1/SF/src/com/wimb/A/change");

		for (Map.Entry<String,String> entry : map.entrySet()) {
			//根据map的建找到对应的视频文件
			//			 File file = new File("d:/ChangName/"+entry.getKey()+".avi");
			//			 file.renameTo()
			a.renameFile("d:/ChangName/"+entry.getKey()+".avi", "d:/ChangName/"+entry.getValue()+".avi");
		
		}		
	}
	
	public Map<String,String> readTxtFile(String filePath) {

		Map<String,String> filemaps = new HashMap<String,String>();
		try {
			String encoding = "GBK";
			File file = new File(filePath);

			if (file.isFile() && file.exists()) {               
				InputStreamReader read = new InputStreamReader(

				new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println(“lineTxt=” + lineTxt);
					String str = lineTxt;
					String []arr = str.split(" ");
					//System.out.println(arr[0]+"-----");
					//System.out.println(arr[1]);
					filemaps.put(arr[0], arr[1]);
				}

				read.close();
				bufferedReader.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return filemaps;
	}

	public void renameFile(String file, String toFile) {

		File toBeRenamed = new File(file);

		if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {

			System.out.println("File does not exist: " + file);
			return;
		}

		File newFile = new File(toFile);

		if (toBeRenamed.renameTo(newFile)) {
			System.out.println("File has been renamed.");
		} else {
			System.out.println("Error renmaing file");
		}

	}
	

}
