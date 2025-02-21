import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.io.File;
import java.util.Collections;

public class Servidor {

    public static void main(String[] args) throws FtpException {
        // Crear el servidor FTP
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory lf = new ListenerFactory();
        lf.setPort(2121);
        serverFactory.addListener("default", lf.createListener());
        // Crear un usuario
        BaseUser user = new BaseUser();
        user.setName("user"); // Nombre de usuario
        user.setPassword("user"); // Contraseña
        user.setHomeDirectory("src/main"); // Directorio raíz
        user.setAuthorities(Collections.singletonList(new WritePermission())); // Permiso de escritura

        // Agregar el usuario al servidor
        serverFactory.getUserManager().save(user);

        // Iniciar el servidor FTP
        FtpServer server = serverFactory.createServer();
        try {
            server.start();
            System.out.println("Servidor FTP iniciado en el puerto 21.");
            System.out.println("Usuario: usuario, Contraseña: contraseña");
            System.out.println("Directorio raíz: " + user.getHomeDirectory());
        } catch (FtpException e) {
            e.printStackTrace();
        }
    }
}
