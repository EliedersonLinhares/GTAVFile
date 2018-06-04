import java.io.File;

import javax.swing.JFileChooser;

public class file2 {
  public static void main(String[] argv) throws Exception{
    JFileChooser chooser = new JFileChooser();
    File f = new File(new File("filename.txt").getCanonicalPath());
    chooser.setSelectedFile(f);
    chooser.showOpenDialog(null);
    File curFile = chooser.getSelectedFile();
  }
}