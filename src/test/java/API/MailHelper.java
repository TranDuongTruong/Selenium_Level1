package API;

import com.Railway.constant.Constants;
import com.Railway.model.Email;
import com.Railway.until.Helpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class MailHelper {
    private static String API_KEY=System.getenv("MAIL_SLURP");
    private static RequestSpecification requestSpecification;

    private static RequestSpecification baseAPI() {
        return RestAssured.given()
                .baseUri(Constants.MAIL_SLURP_URL)
                .header("accept", "*/*")
                .header("x-api-key", API_KEY)
                .urlEncodingEnabled(true)
                .param("unreadOnly", false);
    }

    public static String getEmailId(String emailTitle){
        Response response;
        long startTime = System.currentTimeMillis();
        long timeoutMillis = 5000;
        List contents;
        do {
            requestSpecification = baseAPI().basePath("emails")
                    .param("page", 0)
                    .param("size", 10)
                    .param("sort", "ASC")
                    .param("searchFilter", emailTitle);
             response = requestSpecification.get();
            contents=response.jsonPath().getList("content.id");
            if (contents.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (System.currentTimeMillis() - startTime > timeoutMillis) {
                System.out.println("Cannot find email.");
                return null;
            }
        } while (contents.size()==0);

        return  contents.get(0).toString();


    }
    public static String getEmailBody(String emailTitle){
        String emailId=getEmailId(emailTitle);
        if(emailId ==null)return  null;
        requestSpecification=baseAPI().basePath("emails/"+emailId+"/body");
        Response response = requestSpecification.get();
        return response.getBody().print().toString();
    }

    public static Email createNewInbox(){
        requestSpecification=baseAPI().basePath("inboxes")
                .param("useShortAddress",true);
        Response response=requestSpecification.post();
        Email email=new Email(response.jsonPath().get("id").toString(),response.jsonPath().get("emailAddress").toString(),response.jsonPath().get("expiresAt").toString());
        return email;
    }
    public  static  void deleteInbox(String inboxId){
        requestSpecification=baseAPI().basePath("inboxes/"+inboxId);
        requestSpecification.delete();

    }
    public static Boolean isInboxExpried(String inboxId){
        requestSpecification=baseAPI().basePath("expired/inbox/"+inboxId);
        Response response=requestSpecification.get();
        if(response.statusCode()==200) return true;
        return false;
    }
    public static String getEmailAddress(){
        Email email= Helpers.readEmailFromFile();

        if(email==null||isInboxExpried(email.getInboxId())) {
            email=createNewInbox();
            Helpers.saveEmailToFile(email);
            return Helpers.addRandomTagToEmail(email.getEmailAddress());
        }
        return Helpers.addRandomTagToEmail(email.getEmailAddress());
    }


}
