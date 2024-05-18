package login;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUtility.FileUtility;

public class sample {
	
	@Test
	public void demo() throws IOException {
		FileUtility fLib=new FileUtility();
		System.out.println(fLib.getDataFromProperty("url"));
	}

}
