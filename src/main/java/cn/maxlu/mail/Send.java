package cn.maxlu.mail;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Send {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.auth", "true");
        //基本的邮件会话
        Session session = Session.getInstance(props);
        //构造信息体
        MimeMessage message = new MimeMessage(session);
        //发件地址
        Address address = new InternetAddress("shmily9301@163.com");
        message.setFrom(address);
        //收件地址
        Address toAddress = new InternetAddress("max.lu@qeeka.com");
        message.setRecipient(MimeMessage.RecipientType.TO, toAddress);

        //主题
        message.setSubject("Hello world");
        //正文
        message.setText("Hello world");

        message.saveChanges(); // implicit with send()
        //Exception in thread "main" javax.mail.NoSuchProviderException: smtp
        session.setDebug(true);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.163.com", "shmily9301@163.com", "");
        //发送
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }
}
