import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RenameImages {

	private final static String BEAUTY_GIRL = "beauty_girl_";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "f:/images_before/";
		String destinationPath = "f:/images_after/";
		String extendtionSource = ".jpg";
		String extendtionDestination = ".jpg";

		File file = new File(destinationPath);
		if (!file.isDirectory()) {
			file.mkdir();
		}

		List<String> fileNameList = listFileName(filePath, extendtionSource);
		if (fileNameList != null && fileNameList.size() > 0) {
			for (int i = 0; i < fileNameList.size(); i++) {
				String sourceFileNamePath = filePath + fileNameList.get(i);
				String targeFileNamePath = destinationPath + BEAUTY_GIRL + i
						+ extendtionDestination;
				renameFile(sourceFileNamePath, targeFileNamePath);
			}
		}

	}

	public static List<String> listFileName(String filePath, String extendtion) {
		List<String> list = new ArrayList<String>();

		File file = null;
		try {
			file = new File(filePath);
			File[] listFile = file.listFiles();
			if (listFile != null) {
				if (listFile.length > 0) {
					System.out.println("############################File Information#########################");
					int count = 1;
					for (int i = 0; i < listFile.length; i++) {
						String fileName = listFile[i].getName();
						if(fileName.endsWith(extendtion)){
							list.add(fileName);
						}else{
							System.out.println("Found the " + count
									+ " file not end with " + extendtion
									+ " it's name is " + fileName);
							count++;
						}
					}
				}
			} else {
				System.out.println("No File Found !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void renameFile(String source, String target) {
		File file = null;
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			file = new File(source);
			fileInputStream = new FileInputStream(file);
			fileOutputStream = new FileOutputStream(target);
			byte[] buffer = new byte[1024];
			while (fileInputStream.read(buffer, 0, buffer.length) != -1) {
				fileOutputStream.write(buffer, 0, buffer.length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
