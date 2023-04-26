package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='Cell phones']"),"Cell phones");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //2.3 Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Nokia Lumia 1020");
        //2.7 Verify the price “$349.00”
        verifyExpectedAndActual(By.xpath("//span[@id='price-value-20']"),"$349.00");
        //2.8 Change quantity to 2
        //clearText(By.cssSelector("#product_enterdQuantity_20"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(2000);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.12 Verify the message "Shopping cart"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //2.13 Verify the quantity is 12

        //verifyMessage("(12)",getTextFromElement(By.xpath("//span[contains(text(),'(12)')]")));
        //(By.name("itemquantity11329"),"12");
        //Thread.sleep(2000);
        //2.14 Verify the Total $4,188.00
        verifyExpectedAndActual(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$4,188.00')]"),"$4,188.00");
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register')]"),"Register");
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "gautam");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "patel");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), "17");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), "05");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), "1984");
        sendTextToElement(By.xpath("//input[@id='Email']"), "gautampatel11@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "Password1");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Password1");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(2000);
        //2.22 Verify the message “Your registration completed”
        verifyExpectedAndActual(By.xpath("//div[text()='Your registration completed']"),"Your registration completed");
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);
        //2.24 Verify the text “Shopping card”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "10, Luton Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA8 9HU");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "020456783");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.31 Select Radio Button “Credit Card”
        sendTextToElement(By.xpath("//input[@id='paymentmethod_1']"),"Credit Card");
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "gautam patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "08");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "678");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Payment Method:')]"),"\n" +
                "                                Payment Method:\n" +
                "                            ");
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"),"\n" +
                "                                Credit Card\n" +
                "                            ");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/" +
                "div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"),"2nd Day Air");
        //2.37 Verify Total is “$698.00”
        verifyExpectedAndActual(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"),"$698.00");
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
        //2.43 Click on “Logout” link
        clickOnElement(By.linkText("Log out"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}
