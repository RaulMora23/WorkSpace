import org.apache.commons.net.ftp.FTPClient;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        FTPClient ftp = new FTPClient(); // Cliente FTP
        Scanner scanner = new Scanner(System.in); // Para entrada del usuario

        try {
            // Conectar al servidor FTP
            ftp.connect("localhost", 21); // Servidor y puerto
            if (ftp.login("usuario", "contraseña")) { // Autenticación
                System.out.println("Conexión exitosa.");

                // Modo pasivo (evita problemas con firewalls)
                ftp.enterLocalPassiveMode();

                // Menú de opciones
                int opcion;
                do {
                    System.out.println("\n--- Menú FTP ---");
                    System.out.println("1. Listar archivos");
                    System.out.println("2. Descargar archivo");
                    System.out.println("3. Subir archivo");
                    System.out.println("4. Eliminar archivo");
                    System.out.println("0. Salir");
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (opcion) {
                        case 1:
                            listarArchivos(ftp);
                            break;
                        case 2:
                            System.out.print("Nombre del archivo a descargar: ");
                            String archivoRemoto = scanner.nextLine();
                            System.out.print("Nombre del archivo local: ");
                            String archivoLocal = scanner.nextLine();
                            descargarArchivo(ftp, archivoRemoto, archivoLocal);
                            break;
                        case 3:
                            System.out.print("Nombre del archivo local a subir: ");
                            String archivoSubir = scanner.nextLine();
                            System.out.print("Nombre del archivo en el servidor: ");
                            String archivoDestino = scanner.nextLine();
                            subirArchivo(ftp, archivoSubir, archivoDestino);
                            break;
                        case 4:
                            System.out.print("Nombre del archivo a eliminar: ");
                            String archivoEliminar = scanner.nextLine();
                            eliminarArchivo(ftp, archivoEliminar);
                            break;
                        case 0:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } while (opcion != 0);

                // Cerrar sesión
                ftp.logout();
            } else {
                System.out.println("Error de autenticación.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Desconectar
            try {
                if (ftp.isConnected()) {
                    ftp.disconnect();
                    System.out.println("Desconectado del servidor FTP.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close(); // Cerrar el scanner
        }
    }

    // Método para listar archivos
    private static void listarArchivos(FTPClient ftp) throws IOException {
        System.out.println("Archivos en el servidor:");
        for (String archivo : ftp.listNames()) {
            System.out.println(archivo);
        }
    }

    // Método para descargar un archivo
    private static void descargarArchivo(FTPClient ftp, String archivoRemoto, String archivoLocal) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(archivoLocal)) {
            if (ftp.retrieveFile(archivoRemoto, fos)) {
                System.out.println("Archivo descargado: " + archivoLocal);
            } else {
                System.out.println("Error al descargar el archivo.");
            }
        }
    }

    // Método para subir un archivo
    private static void subirArchivo(FTPClient ftp, String archivoSubir, String archivoDestino) throws IOException {
        try (FileInputStream fis = new FileInputStream(archivoSubir)) {
            if (ftp.storeFile(archivoDestino, fis)) {
                System.out.println("Archivo subido correctamente.");
            } else {
                System.out.println("Error al subir el archivo.");
            }
        }
    }

    // Método para eliminar un archivo
    private static void eliminarArchivo(FTPClient ftp, String archivoEliminar) throws IOException {
        if (ftp.deleteFile(archivoEliminar)) {
            System.out.println("Archivo eliminado: " + archivoEliminar);
        } else {
            System.out.println("Error al eliminar el archivo.");
        }
    }
}
