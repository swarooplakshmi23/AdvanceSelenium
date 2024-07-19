package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement plusImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name = "productname")
	private WebElement prdName;

	public WebElement getPrdName() {
		return prdName;
	}


	public WebElement getPlusImg() {
		return plusImg;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void clickPlusImg()
	{
		plusImg.click();
	}
	
	public void enterProductName(String productName)
	{
		prdName.sendKeys(productName);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}
