import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileSize {

	public static void main(String[] args) {
		fileInfo(new File("c:/temp/x64a.rpf"));
	
	}

	public static void fileInfo(File file) {
		System.out.println("File name: " + file.getName());
		long fileSize = file.length();
		System.out.println("File size: " + fileSize);
		String fileSizeDisplay = FileUtils.byteCountToDisplaySize(fileSize);
		System.out.println("Size Display: " + fileSizeDisplay);
		System.out.println();
	}
}