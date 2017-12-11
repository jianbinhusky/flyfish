package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest1 {

	public static void toSerialize(Object obj , String filePath) throws IOException{
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(filePath));
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			bos.close();
			oos.close();
		}
	}
	
	public static Object revertSerialize(String filePath) throws IOException{
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(filePath));
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			bis.close();
			ois.close();
		}
		
		return obj;
	}
	
	public static void main(String[] args){
		Person p1 = new Person();
		p1.setName("tan xiao niao ");
		p1.setAge(24);
		String filePath1 = "/Users/hujianbin/test/p.txt";
		try {
			toSerialize(p1, filePath1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Person p0 = (Person) revertSerialize(filePath1);
			System.out.println(p0.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
