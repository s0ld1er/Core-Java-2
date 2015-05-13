import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailSender {
    public static void main(String[] args) throws EmailException {

        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("D:/2014-09-05 00.02.49.jpg");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of me");
        attachment.setName("me");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setAuthenticator(new DefaultAuthenticator("jivkotodorov94", "password"));
        email.setSmtpPort(465);
        email.setSSLOnConnect(true);
        email.setDebug(true);
        email.setHostName("smtp.gmail.com");
        
        email.addTo("jivkotodorov94@gmail.com");
        email.setFrom("jivkotodorov94@gmail.com", "Me");
        email.setSubject("This is the subject");
        email.setMsg("Here is the picture you wanted, A-hole");

        // add the attachment
        email.attach(attachment);

        // send the email
        email.send();
    }
}
