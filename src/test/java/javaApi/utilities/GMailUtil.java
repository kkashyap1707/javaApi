package javaApi.utilities;

import com.aventstack.extentreports.Status;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class GMailUtil {

    public static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    public static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    public static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */

    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);

    private static final String CREDENTIALS_FILE_PATH = "/client_secret.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */

    public static NetHttpTransport HTTP_TRANSPORT;

    private static Credential getCredentials() throws IOException {
        // Load client secrets.
        InputStream in = GMailUtil.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH))).setAccessType("offline").build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static Gmail getGMailService() throws IOException {
        Credential credential = getCredentials();

        return new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();

    }

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static MimeMessage createEmail(String to, String from, String subject, String bodyText) throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

    public static MimeMessage sendA(String to, String from, String subject, String bodyText,String filePath) throws Exception{

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(bodyText, "text/plain");
        mimeBodyPart.attachFile(new File(filePath));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);



        return email;

    }

    public static Message createMessageWithEmail(MimeMessage emailContent) throws MessagingException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

    public static MimeMessage createEmailWithAttachment(String to, String from, String subject, String bodyText, File file) throws MessagingException, IOException {

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(bodyText, "text/plain");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        mimeBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(file);

        mimeBodyPart.setDataHandler(new DataHandler(source));
        mimeBodyPart.setFileName(file.getName());

        multipart.addBodyPart(mimeBodyPart);
        email.setContent(multipart);

        return email;
    }

    public static Message sendMessage(Gmail service, String userId, MimeMessage emailContent) throws MessagingException, IOException {

        Message message = createMessageWithEmail(emailContent);
        message = service.users().messages().send(userId, message).execute();

        System.out.println("Message id: " + message.getId());
        System.out.println(message.toPrettyString());
        return message;
    }

    public static boolean sendMessage(String recipientAddress, String subject, String body) throws MessagingException, IOException {

        Message message = createMessageWithEmail(createEmail(recipientAddress, "keshav.kashyap@allyo.com", subject, body));

        return getGMailService().users().messages().send("keshav.kashyap@allyo.com", message).execute().getLabelIds().contains("SENT");
    }

    public static void sendMessage1(Gmail service,String recipientAddress,String senderEmailID, String subject, String body) throws Exception{

        Message message = createMessageWithEmail(createEmail(recipientAddress, senderEmailID, subject, body));
        message = service.users().messages().send(senderEmailID, message).execute();

        System.out.println("Message id: " + message.getId());
        System.out.println(message.toPrettyString());

    }

    public static void sendFileAsAttachments(Gmail service,String recipientAddress,String senderEmailID, String subject, String body,File file) throws Exception{

        Message message = createMessageWithEmail(createEmailWithAttachment(recipientAddress, senderEmailID, subject, body,file));
        message = service.users().messages().send(senderEmailID, message).execute();

        System.out.println("Message id: " + message.getId());
        System.out.println(message.toPrettyString());
        Reporter.test.log(Status.INFO,"Mail sent. to "+recipientAddress);

    }

    public static File file1(String filePathInString){

        File filePath = new File(filePathInString);

        return filePath;
    }





}
