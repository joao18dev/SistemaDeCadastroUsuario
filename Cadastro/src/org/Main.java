package org;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        int opcao = -1;
        int contadorId = 1;

        while (opcao != 0) {
            System.out.println("\n=== SISTEMA DE CADASTRO ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                Usuario usuario = new Usuario(contadorId, nome, email);
                usuarios.add(usuario);
                contadorId++;

                System.out.println("Usuário cadastrado com sucesso!");

            } else if (opcao == 2) {
                System.out.println("\n--- LISTA DE USUÁRIOS ---");

                if (usuarios.isEmpty()) {
                    System.out.println("Nenhum usuário cadastrado.");
                } else {
                    for (Usuario u : usuarios) {
                        System.out.println(
                                "Id: " + u.getId() +
                                        " | Nome: " + u.getNome() +
                                        " | Email: " + u.getEmail()
                        );
                    }
                }

            } else if (opcao == 0) {
                System.out.println("Saindo do sistema...");
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
