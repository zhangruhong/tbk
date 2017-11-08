package com.bukaxi.tbk.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppIdFilterUtil {
	
	public static void main(String[] args){
		try {
			FilterAppIds();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void FilterAppIds() throws IOException {
		
		//读取文件
		File file = new File("d:\\锁定的appId.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String lineText;
		StringBuilder builer = new StringBuilder();
		Set<String> set = new HashSet<String>();
		while((lineText = reader.readLine()) != null){
			lineText = lineText.trim().replaceAll("\\[", "'").replaceAll(", ", "','").replaceAll("]", "',");
			String[] appIds = lineText.split(",");
			set.addAll(Arrays.asList(appIds));
			System.out.println(lineText);
		}
		set.stream().forEach( l -> {
//			System.out.println("遍历set:" + l);
			builer.append(",\n").append(l);
		});
		System.out.println("===============================处理后的文件=============================");
		System.out.println(builer.toString());
		reader.close();
		
		
		//写入新文件
		File newFile = new File("d:\\处理完锁定的appId.txt");
		if(!newFile.exists()){
			newFile.createNewFile();
		}
		FileWriter fw = new FileWriter(newFile);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(builer.toString());
		bw.flush();
		fw.close();
	}

}
