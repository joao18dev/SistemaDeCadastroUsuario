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
            System.out.println("3 - Usuário por ID");
            System.out.println("4 - Remover usuário por ID");
            System.out.println("5 - Editar usuário por ID");
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

            } else if (opcao == 3) {
                System.out.println("Digite o ID do usuário: ");
                int idbuscado = scanner.nextInt();
                scanner.nextLine();

                boolean encontrado = false;

                for (Usuario u: usuarios) {
                    if (u.getId() == idbuscado) {
                        System.out.println("Usuário encontrado: ");
                        System.out.println("Id: " + u.getId() +
                               " Nome: " + u.getNome() +
                                " Email: " + u.getEmail());
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Usuário não encontrado.");
                }


            } else if (opcao == 4) {
                System.out.println("Digite o ID do usuário que deseja remover: ");
                int idRemover = scanner.nextInt();
                scanner.nextLine();

                boolean removido = false;

                for ( Usuario u : usuarios) {
                    if (u.getId() == idRemover) {
                        usuarios.remove(u);
                        removido = true;
                        System.out.println("Usuário removido com sucesso.");
                        break;
                    }
                }

                if (!removido) {
                    System.out.println("Usuário não encontrado");
                }


            } else if (opcao == 5) {
                System.out.println("Digite o ID do usuário que deseja editar");
                int ideditar = scanner.nextInt();
                scanner.nextLine();

                boolean encontrado = false;

                for (Usuario u : usuarios) {
                    if (u.getId() == ideditar) {
                        System.out.print("Digite o novo Nome: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("Digite o novo Email: ");
                        String novoEmail = scanner.nextLine();

                        u.setNome(novoNome);
                        u.setEmail(novoEmail);

                        System.out.println("Dados do usuário editado com sucesso.");
                        encontrado = true;
                        break;

                    }
                } if (!encontrado) {
                    System.out.println("Usuário não encontrado.");
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
