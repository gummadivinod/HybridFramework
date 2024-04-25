package keywords;

import org.testng.Assert;

public class ValidationKeyword extends GenericKeyWord{
	
	public void validType(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(),expTitle);
	}

}
