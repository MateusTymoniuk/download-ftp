package br.com.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPUtilTest {
	public static void main(String[] args) {
        String server = "YOUR_FTP_ADDRESS";
        int port = 21;
        String user = "YOUR_FTP_USER";
        String pass = "YOUR_FTP_PASS";
 
        FTPClient ftpClient = new FTPClient();
 
        try {
            // connect and login to the server
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
 
            // use local passive mode to pass firewall
            ftpClient.enterLocalPassiveMode();
 
            System.out.println("Connected");
 
            String remoteDirPath = "/PATH_TO_REMOTE_DIR";
            String saveDirPath = "PATH_TO_SAVE_DIR";
 
            FTPUtil.downloadDirectory(ftpClient, remoteDirPath, "", saveDirPath);
 
            // log out and disconnect from the server
            ftpClient.logout();
            ftpClient.disconnect();
 
            System.out.println("Disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
