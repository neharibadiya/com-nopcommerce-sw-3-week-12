package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']"));
        // 1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        //Select select = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        //select.selectByVisibleText("Name: Z to A");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        verifyExpectedAndActual(By.xpath("//option[contains(text(),'Name: Z to A')]"), "Name: Z to A");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
       //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        //sendTextToElement(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");
        Thread.sleep(3000);
        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //2.5 Verify the Text "Build your own computer"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
        Thread.sleep(1000);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        sendTextToElement(By.xpath("//select[@id='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);

        //2.11 Verify the price "$1,475.00"
        verifyExpectedAndActual(By.xpath("//span[@id='price-value-1']"),"$1,420.00");
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Thread.sleep(3000);
        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(1000);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.15 Verify the message "Shopping car
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearText(By.xpath("//input[@value='1']"));
        sendTextToElement(By.xpath("//input[@value='1']"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //2.17 Verify the Total"$2,840.00"
        verifyExpectedAndActual(By.xpath("//span[@class='product-subtotal']"),"$2,840.00");
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service')]"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        Thread.sleep(3000);
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "gautam");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "patel");
        sendTextToElement(By.id("BillingNewAddress_Email"), "gautampatel@gmail.com");
        //Select country = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "21 Luton Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA8 9HU");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0202345678");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.name("save"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.26 Select Radio Button “Credit Card”
        sendTextToElement(By.id("paymentmethod_1"),"Credit Card");
        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"),"Master card");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "gautam patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"10");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "789");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/" +
                "div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"),"Next Day Air");
        //2.33 Verify Total is “$2,840.00”
        verifyExpectedAndActual(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/" +
                "div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"),"$2,840.00");
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("//html/body/div[6]/div[3]/div/div/div/div[1]/h1"),"Checkout");
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}
