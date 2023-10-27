package q2_LucasLevi;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao programa de login!");

        // Cadastro de usuário
        System.out.print("Digite o login desejado: ");
        String login = scanner.nextLine();

        System.out.print("Digite a senha desejada: ");
        String senha = scanner.nextLine();

        // Armazenamento das informações em arquivo
        try {
            FileWriter fileWriter = new FileWriter("usuarios.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(login + "," + senha);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao armazenar as informações de login e senha.");
            return;
        }

        System.out.println("Cadastro realizado com sucesso!");

        // Login
        System.out.println("\nFaça o login");

        System.out.print("Login: ");
        String loginInput = scanner.nextLine();

        System.out.print("Senha: ");
        String senhaInput = scanner.nextLine();

        // Verificação das informações de login
        try {
            File file = new File("usuarios.txt");
            Scanner fileScanner = new Scanner(file);

            boolean loginSucesso = false;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 2 && parts[0].equals(loginInput) && parts[1].equals(senhaInput)) {
                    loginSucesso = true;
                    break;
                }
            }

            if (loginSucesso) {
                System.out.println("SUCESSO: Login realizado com sucesso!");
            } else {
                System.out.println("FRACASSO: Login ou senha incorretos.");
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao ler o arquivo de usuários.");
        }
    }
}