package cn.maxlu.mail;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class Delete {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props);
        //取得pop3协议的邮件服务器
        Store store = session.getStore("pop3");
        //连接pop.qq.com邮件服务器
        store.connect("pop.126.com", "shmily9301@126.com", "shmily9301");
        //返回文件夹对象
        Folder folder = store.getFolder("INBOX");
        //设置读写
        folder.open(Folder.READ_WRITE);
        //获取信息
        Message message[] = folder.getMessages();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < message.length; i++) {
            System.out.println(i + ": " + message[i].getFrom()[0] + "\t" + message[i].getSubject());
            System.out.println("Do you want to delete message? [YES to delete]");
            String line = br.readLine();
            if (line.equals("YES")) {
                //设置删除标记
                message[i].setFlag(Flags.Flag.DELETED, true);
            }
        }

        folder.close(true);
        store.close();
    }
}
