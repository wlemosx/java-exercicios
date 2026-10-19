package Exercicios.ExerciciosAbstracaoDeClasses.ContaBancaria;

import java.util.Scanner;

public class Conta {
    private boolean accountCreated = false;
    private double saldo = 0.0;
    private double limiteChequeEspecial = 0.0;
    private double chequeEspecialDisponivel = 0.0;
    private double saldoDevedor = 0.0;

    public boolean isAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(double depositioInical) {
        if(depositioInical <=  0) {
            System.out.println("\nDepósito inicial inválido. A conta não foi criada.\n");
            return;
        }

        if(depositioInical <= 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = depositioInical * 0.5;
        }

        this.chequeEspecialDisponivel = this.limiteChequeEspecial;
        this.saldo = depositioInical;
        this.accountCreated = true;
        System.out.println("\nConta criada com sucesso! Saldo inicial: R$" + this.saldo + ", Limite do Cheque Especial: R$" + this.limiteChequeEspecial + "\n");
    }

    public void getSaldo() {
        System.out.println("\nSeu saldo atual é: R$" + (saldo - (saldoDevedor + saldoDevedor * 0.2)) + "\n");
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("\nValor de depósito inválido.\n");
            return;
        }

        if(saldoDevedor > 0) {
            double dividaComJuros = saldoDevedor + saldoDevedor * 0.2;
            if(valor >= dividaComJuros) {
                valor -= dividaComJuros;
                saldoDevedor = 0;
                chequeEspecialDisponivel = limiteChequeEspecial;
                saldo += valor;
                System.out.println("\nDepósito de R$" + valor + " realizado com sucesso! \n Sua dívida no valor de R$" + dividaComJuros + " foi quitada\n Seu saldo atual é: R$" + saldo + "\n");
            } else {
                saldoDevedor -= valor;
                chequeEspecialDisponivel = limiteChequeEspecial - saldoDevedor;
                System.out.println("\nDepósito de R$" + valor + " realizado com sucesso! \n Sua dívida atual é: R$" + saldoDevedor + "\n");
            }
        } else {
            saldo += valor;
            System.out.println("\nDepósito de R$" + valor + " realizado com sucesso! \n Seu saldo atual é: R$" + saldo + "\n");
        }
    } 

    public double getChequeEspecial() {
        System.out.println("\nSeu limite de cheque especial é: R$" + limiteChequeEspecial + "\n");
        System.out.println("E você ainda tem disponivel: R$" + chequeEspecialDisponivel + "\n");
        return limiteChequeEspecial;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo + chequeEspecialDisponivel) {
            if (valor <= saldo) {
                saldo -= valor;
            } else {
                double valorChequeEspecial = valor - saldo;
                saldo = 0;
                chequeEspecialDisponivel -= valorChequeEspecial;
                saldoDevedor += valorChequeEspecial;
            }
            System.out.println("\nSaque de R$" + valor + " realizado com sucesso!\n");
        } else {
            System.out.println("\nSaldo insuficiente para realizar o saque.\n");
        }
    }

    public void pagarBoleto(double valor) {
        if (valor > 0 && valor <= saldo + chequeEspecialDisponivel) {
            if (valor <= saldo) {
                saldo -= valor;
            } else {
                double valorChequeEspecial = valor - saldo;
                saldo = 0;
                chequeEspecialDisponivel -= valorChequeEspecial;
                saldoDevedor += valorChequeEspecial;
            }
            System.out.println("\nPagamento de boleto de R$" + valor + " realizado com sucesso!\n");
        } else {
            System.out.println("\nSaldo insuficiente para realizar o pagamento do boleto.\n");
        }
    }

    public double getSaldoDevedor() {
        var saldoDevedorTotal = saldoDevedor + saldoDevedor * 0.2;
        System.out.println("\nSeu saldo devedor é: R$" + saldoDevedorTotal + "\n");
        return saldoDevedorTotal;
    }
}
