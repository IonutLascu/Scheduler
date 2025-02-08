import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;
import java.io.IOException;

public class EmailService {

    private static final String SENDGRID_API_KEY = "your-sendgrid-api-key"; // Replace with your SendGrid API key
    private static final String FROM_EMAIL = "your-email@example.com"; // Replace with your email
    private static final String FROM_NAME = "Your Name or Company Name"; // Your name or company name
    
    //TEPA4VMJ59YGXLMNHGS5EG17
    public void sendEmail(String toEmail, String subject, String content) {
        Email from = new Email(FROM_EMAIL, FROM_NAME);
        Email to = new Email(toEmail);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, to, emailContent);

        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Email sent with status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getBody());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error sending email: " + ex.getMessage());
        }
    }
}
