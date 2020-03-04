package BasicUsage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.selectObjects;
import resources.base;

public class BasicUsage extends base {
	
	// Drag and drop item 1 to item 0 location 

	@Test
	public void dragdrop() throws IOException
	{
	driver = initializeDriver();
	selectObjects sobj = new selectObjects(driver);
	WebElement target= sobj.itemZero();
	WebElement source=sobj.itemOne();
	String itemZeroBeforeUpdate =target.getText();
	String itemOneBeforeUpdate =source.getText();
	
	System.out.println(itemZeroBeforeUpdate);
	System.out.println(itemOneBeforeUpdate);
	
	Actions a = new Actions(driver);
	a.dragAndDrop(source, target).build().perform();
	
	// and verify the new order is correct
	
	String itemZeroAfterUpdate = sobj.itemZero().getText();
	String itemOneAfterUpdate = sobj.itemOne().getText();
	
	System.out.println(itemZeroAfterUpdate);
	System.out.println(itemOneAfterUpdate);
	
	Assert.assertEquals(itemZeroBeforeUpdate, itemOneAfterUpdate);
	Assert.assertEquals(itemOneBeforeUpdate, itemZeroAfterUpdate);
	
	tearDown();
	}
}
