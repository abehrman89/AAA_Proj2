import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project2 {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "proj02test.txt";
		String line = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			char level = line.charAt(0);
			String tag = "";
			String valid = "N";
			String arguments = "";
			
			for (int i = 2; i < line.length(); i++) {
				if (line.charAt(i) != ' ') {
					tag = tag + line.charAt(i);
				}
				else {
					break;
				}
			}
			
			for (int j = tag.length() + 3; j < line.length(); j++) {
				arguments += line.charAt(j);
			}
			
			if (tag.equals("INDI") || tag.equals("FAM")) {
				System.out.println("--> " + line);
				System.out.println("<-- " + level + "|" + tag + "|" + valid + "|" + arguments);
			}
			else {
				if (arguments.equals("INDI") || arguments.equals("FAM")) {
					String tempTag = tag;
					tag = arguments;
					arguments = tempTag;
				}
				
				if (level == '0') {
					if (tag.equals("INDI") || tag.equals("FAM") || tag.equals("NONE") || tag.equals("HEAD") || tag.equals("TRLR") || tag.equals("NOTE")) {
						valid = "Y";
					}
				} else if (level == '1') {
					if (tag.equals("NAME") || tag.equals("SEX") || tag.equals("BIRT") || tag.equals("DEAT") || tag.equals("FAMC") || tag.equals("FAMS") 
							|| tag.equals("MARR") || tag.equals("HUSB") || tag.equals("WIFE") || tag.equals("CHIL") || tag.equals("DIV")) {
						valid = "Y";
					}
				} else if (level == '2' && tag.equals("DATE")) {
						valid = "Y";
				}
				
				System.out.println("--> " + line);
				System.out.println("<-- " + level + "|" + tag + "|" + valid + "|" + arguments);
			}
		}
		
		bufferedReader.close();
	}

}
