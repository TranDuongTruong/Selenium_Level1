package com.Railway.until;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.model.Email;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {
    public static void waitElementToBeClickable(By elementBy, int duration){
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public static void waitDropdownValue(By dropdownBy, int timeoutInSeconds) {

        fluentWait(dropdownBy);

        String currentId=((RemoteWebElement) DriverManager.get_driver().findElement(dropdownBy)).getId();
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(timeoutInSeconds));

        try {
            wait.until(driver -> {
                String newId=((RemoteWebElement) DriverManager.get_driver().findElement(dropdownBy)).getId();
                return !newId.equals(currentId);
            });
        } catch (TimeoutException e) {
            System.out.println("Drop down do not change");
        }
    }
    public static void fluentWait(By by) {
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.get_driver())
                .withTimeout(Duration.ofSeconds(5))          // tổng thời gian chờ
                .pollingEvery(Duration.ofMillis(500))         // tần suất kiểm tra lại
                .ignoring(NoSuchElementException.class)       // bỏ qua nếu chưa thấy phần tử
                .ignoring(StaleElementReferenceException.class);
        try {
            wait.until(d -> {
                WebElement element = d.findElement(by);
                return (element.isDisplayed()) ? element : null;
            });
        } catch (TimeoutException e){
            System.out.println("No such elements during 5s");
        }
    }


    public static void waitPage(int duration){
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(duration));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static String[] splitString(String str, String delimiter) {
        if (str == null) return new String[]{};
        return str.split(delimiter);
    }
    public  static  void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.get_driver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public static String getTimestamp(){
        return   new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

    }

    public static String extractLinkFromBody(String body) {
        Pattern pattern = Pattern.compile("href=[\"'](http[s]?://[^\"']+(resetToken|confirmationCode)=[^\"']+)[\"']");
        Matcher matcher = pattern.matcher(body);
        if (matcher.find()) {
            return matcher.group(1); // Chỉ lấy phần URL trong href
        }
        return null;
    }
    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomCharacters(int length) {
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }
        return sb.toString();
    }
    public static String addRandomTagToEmail(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex == -1) return email;
        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex);
        return local + "+" + generateRandomCharacters(4) + domain;
    }
    public static boolean isEmailExpired(String expiresAt) {
        Instant expiryTime = Instant.parse(expiresAt);
        Instant now = Instant.now();
        return now.isAfter(expiryTime);
    }
    public static void saveEmailToFile(Email email) {
        try (FileWriter writer = new FileWriter(Constants.EMAIL_FILE_PATH)) {
            JSONObject json = new JSONObject();
            json.put("inboxId", email.getInboxId());
            json.put("emailAddress", email.getEmailAddress());
            json.put("expiresAt", email.getExpiresAt());

            writer.write(json.toString(2)); // pretty print
            System.out.println("✅ Đã lưu email vào file JSON (thủ công)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Email readEmailFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.EMAIL_FILE_PATH))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            JSONObject json = new JSONObject(jsonContent.toString());
            return new Email(
                    json.getString("inboxId"),
                    json.getString("emailAddress"),
                    json.getString("expiresAt")
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
