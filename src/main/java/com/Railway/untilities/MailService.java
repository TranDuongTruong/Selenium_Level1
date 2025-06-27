package com.Railway.untilities;

import com.Railway.constant.Constants;
import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.CreateInboxDto;
import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailService {
    private  String apiKey = Constants.MaiLService.API_KEY;
    private  ApiClient client;
    private InboxControllerApi inboxApi;
    private  WaitForControllerApi waitApi;

    public MailService() {
        client = Configuration.getDefaultApiClient();
        client.setApiKey(apiKey);
        inboxApi = new InboxControllerApi(client);
        waitApi = new WaitForControllerApi(client);
    }

    public InboxDto createInbox() throws Exception {
        InboxDto inbox = inboxApi.createInboxWithDefaults().execute();
        return inbox;
    }


    public InboxDto createShortInbox() throws Exception {
        String prefix = "";
        return inboxApi.createInbox().prefix(prefix).useShortAddress(true).execute();
    }



    public String getEmailContent(InboxDto inbox, long timeoutMillis,String titlePrefix, String sender) throws Exception {
        WaitForControllerApi waitForControllerApi = new WaitForControllerApi(client);
        Email email= waitForControllerApi.waitForLatestEmail().inboxId(inbox.getId()).timeout(timeoutMillis).unreadOnly(true).execute();
        if (email.getSubject().contains(titlePrefix) &&
                email.getFrom().equalsIgnoreCase(sender)) {
            return email.getBody();
        }

        return null;
    }

    public String extractLinkFromBody(String body) {
        Pattern pattern = Pattern.compile("href=[\"'](http[s]?://[^\"']+(resetToken|confirmationCode)=[^\"']+)[\"']");
        Matcher matcher = pattern.matcher(body);
        if (matcher.find()) {
            return matcher.group(1); // Chỉ lấy phần URL trong href
        }
        return null;
    }



/*    public static void  main(String [] args) throws Exception {
        MailService mailService=new MailService();
        System.out.println(mailService.getNewEmailAdress());
        System.out.println(mailService.extractLinkFromBody("Use this password reset token to reset your password. The token is: NjcyaHYZQD6InvT29CK+MA==. Visit http://www.saferailway.somee.com/Account/PasswordReset?resetToken=NjcyaHYZQD6InvT29CK%2bMA%3d%3d to reset your password."));
        System.out.println(mailService.extractLinkFromBody("Your confirmation code is: 2toW3VSjicuR9WTGbNqedw==. Visit http://www.saferailway.somee.com/Account/Confirm?confirmationCode=2toW3VSjicuR9WTGbNqedw%3d%3d to activate your account."));

    }*/




}
