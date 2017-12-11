package com.hujianbin.codetool.ibatis;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;


public class HistoryManager {
	File file=null;
	File keyFile=null;
	private Cipher   cipher;;
	private KeyGenerator   kg;
	private Key key;
	public HistoryManager(){
		keyFile=new File("key");
		file=new File("history");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!keyFile.exists()){
			try {
				keyFile.createNewFile();
				
				kg=KeyGenerator.getInstance("DES", "SunJCE");
				
				kg.init(56);
				writeKey(kg.generateKey());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				e.printStackTrace();
			}
		}
		try {
			key=readKey();
			cipher=Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取历史
	 * @return java.util.List
	 */
	@SuppressWarnings("unchecked")
	public List<ConnHistory> getHistory(){
		List<ConnHistory> history=null;
		ObjectInputStream ois=null;
		try {
			if(!file.exists()){
				file.createNewFile();
				return history;
			}
			if(file.length()>0){
			cipher.init(Cipher.DECRYPT_MODE,key);
			ois=new ObjectInputStream(new CipherInputStream(new BufferedInputStream(new FileInputStream(file)),cipher));
			
			Object obj=ois.readObject();
			if(obj!=null)
				history=(List<ConnHistory>) obj;
			ois.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return history;
	}
	
	/**
	 * 添加历史
	 * @param connHistory 连接历史
	 * @return boolean
	 */
	public boolean addHistory(ConnHistory connHistory){
		boolean flag=false;
		ObjectOutputStream oos=null;
		try {
			if(!file.exists()){
				file.createNewFile();
				return flag;
			}
			List<ConnHistory> history=getHistory();
			if(history==null){
				history=new ArrayList<ConnHistory>();
			}
			history.add(connHistory);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			oos=new ObjectOutputStream(new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(file)),cipher));
			oos.writeObject(history);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	/**
	 * 检查连接名是否已存在
	 * @param name 连接名
	 * @return boolean
	 */
	public boolean checkNameExists(String name){
		boolean flag=false;
		List<ConnHistory> history=this.getHistory();
		if(history!=null){
			for (ConnHistory connHistory : history) {
				if(name.equals(connHistory.getName()))
					return true;
			}
		}
		return flag;
	}
	
	/**
	 * 通过连接名获得连接
	 * @param name 连接名
	 * @return ConnHistory
	 */
	public ConnHistory getConnHistoryByName(String name){
		ConnHistory history=null;
		List<ConnHistory> list=this.getHistory();
		if(list!=null){
			for (ConnHistory connHistory : list) {
				if(name.equals(connHistory.getName())){
					return connHistory;
				}
			}
		}
		return history;
	}
	
	
	/**
	 * 清除历史
	 */
	public void clearHistory(){
		file.delete();
	}
	
	/**
	 * 
	 * @param key 
	 */
	private void writeKey(Key key){
		ObjectOutputStream out = null;
		try {
			out = new   ObjectOutputStream(new 
			        BufferedOutputStream(new FileOutputStream(keyFile)));
			out.writeObject(key); 
	        out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
         
	}
	
	/**
	 * 
	 * @return
	 */
	private Key readKey(){
		Key key=null;
		ObjectInputStream in = null;
		try {
			in = new   ObjectInputStream(new BufferedInputStream(new   FileInputStream(keyFile)));
			key=(Key)in.readObject(); 
	        in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        
		return key;
	}
}
