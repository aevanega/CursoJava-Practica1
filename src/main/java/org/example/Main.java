package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //domicilios
        Domicilio domicilioBanco = new Domicilio("Calle 1", 123, "Colonia 1", "Estado 1", 11111);
        Domicilio domicilioCliente1 = new Domicilio("Calle 2", 456, "Colonia 2", "Estado 2", 22222);
        Domicilio domicilioCliente2 = new Domicilio("Calle 2", 456, "Colonia 2", "Estado 2", 22222);

        //Banco
        Banco banco = new Banco("Bancolombia", domicilioBanco, "RFCBANCO", "555-5555");

        //Clientes
        Cliente cliente1 = new Cliente(1, "Juan Perez", domicilioCliente1, "RFC1", "555-1234", "2000-01-01");
        Cliente cliente2 = new Cliente(2, "Maria Lopez", domicilioCliente2, "RFC2", "555-5678",  "1985-02-02");

        // Asignar clientes al banco
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        banco.setClientes(clientes);

        // Crear cuentas para el primer cliente
        CuentaDeAhorro cuentaAhorro1 = new CuentaDeAhorro(1111, 5000.0, 0.01);
        CuentaDeCheque cuentaCheque1 = new CuentaDeCheque(2222, 1500.0, 50.0);
        cuentaAhorro1.setCliente(cliente1);
        cuentaCheque1.setCliente(cliente1);

        // Crear cuentas para el segundo cliente
        CuentaDeAhorro cuentaAhorro2 = new CuentaDeAhorro(2001, 3000.0, 0.01);
        CuentaDeCheque cuentaCheque2 = new CuentaDeCheque(2002, 2500.0, 50.0);
        cuentaAhorro2.setCliente(cliente2);
        cuentaCheque2.setCliente(cliente2);

        // Crear listas de cuentas cliente 1
        List<Cuenta> cuentasCliente1 = new ArrayList<>();
        cuentasCliente1.add(cuentaAhorro1);
        cuentasCliente1.add(cuentaCheque1);
        cliente1.setCuentas(cuentasCliente1);

        // Crear listas de cuentas cliente 1
        List<Cuenta> cuentasCliente2 = new ArrayList<>();
        cuentasCliente2.add(cuentaAhorro2);
        cuentasCliente2.add(cuentaCheque2);
        cliente2.setCuentas(cuentasCliente2);


        System.out.println("Información del Banco:");
        System.out.println(banco);

        System.out.println("\nClientes del Banco:");
        for (Cliente cliente : banco.getClientes()) {
            System.out.println(cliente);
            if (cliente.getCuentas() != null) {
                for (Cuenta cuenta : cliente.getCuentas()) {
                    System.out.println("\t" + cuenta);
                }
            }
        }

    }
}