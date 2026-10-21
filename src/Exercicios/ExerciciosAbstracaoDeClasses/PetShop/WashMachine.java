package Exercicios.ExerciciosAbstracaoDeClasses.PetShop;

public class WashMachine {
    private int washMachineRoom = 0;
    private int washMachineWater = 0;
    private int washMachineShampoo = 0;
    private boolean washMachineClean = true;
    private boolean washMachinePower = false;

    public void checkWashMachine() {
        if(washMachineClean) {
            System.out.println("\nA maquina está limpa\n");
            return;
        }
        System.out.println("\nA maquina está suja\n");
    }

    public void checkWashMachineRoom() {
        if(washMachineRoom == 0) {
            System.out.println("\nA maquina está vazia\n");
            return;
        }
        System.out.println("\nA maquina está ocupada\n");
    }

    public void checkWashMachineProducts() {
        System.out.printf("\n %s de agua e %s de shampoo\n\n", this.washMachineWater, this.washMachineShampoo);
    }

    public void refilWashMachine() {
        if(this.washMachineWater < 30 || this.washMachineShampoo < 10) {
            this.washMachineWater += 2;
            this.washMachineShampoo += 2;

            if(this.washMachineWater > 30) {
                this.washMachineWater = 30;
            }

            if(this.washMachineShampoo > 10) {
                this.washMachineShampoo = 10;
            }

            System.out.printf("\nAbastencimento concluido temos %s de agua e %s de shampoo\n\n", this.washMachineWater, this.washMachineShampoo);
            return;
        }

        System.out.println("\nOs tanques estão cheios\n");
    }

    public void putDogInMachine() {
        if(this.washMachineRoom > 0) {
            System.out.println("\nJá existe um cachorro na maquina\n");
            return;
        }

        this.washMachineRoom = 1;
        System.out.println("\nO cachorro foi colocado na maquina\n");
    }

    public void removeDogInMachine() {
        if(this.washMachineRoom == 0) {
            System.out.println("\nNão existe cachorro na maquina\n");
            return;
        }

        if(this.washMachinePower) {
            System.out.println("\nDesligue a maquina primeiro\n");
            return;
        }

        this.washMachineRoom = 0;
        System.out.println("\nO cachorro foi removido na maquina\n");
    }

    public void turnOnMachine(Dog dog) {
        if(this.washMachinePower) {
            System.out.println("\nA maquina já esta ligada\n");
            return;
        }

        if(this.washMachineRoom > 0) {
            if(!this.washMachineClean) {
                System.out.println("\nA maquina esta suja para lavar outro cachorro\n");
                return;
            }

            if(this.washMachineWater >= 10 && this.washMachineShampoo >= 2) {
                this.washMachinePower = true;
                this.washMachineWater -= 10;
                this.washMachineShampoo -= 2;
                this.washMachineClean = false;
                dog.cleanDog();
                System.out.println("\nO cachorro foi limpo com sucesso\n");
                return;
            }
            System.out.println("\nA maquina precisa de abastecimento\n");
            return;
        }
        System.out.println("\nA maquina esta vazia\n");
        return;
    }

    public void turnOffMachine() {
        if(!this.washMachinePower) {
            System.out.println("\nA maquina ja esta desligada\n");
            return;
        }

        this.washMachinePower = false;
        System.out.println("\nA maquina foi desligada\n");
        return;
    }

    public void washWashMachine() {
        if(washMachineClean) {
            System.out.println("\nA maquina já esta limpa\n");
            return;
        }

        if(this.washMachineWater < 3 || this.washMachineShampoo < 1) {
            System.out.println("\nA maquina não esta abastecida o suficiente para lavar\n");
            return;
        }

        this.washMachineWater -= 3;
        this.washMachineShampoo -= 1;
        this.washMachineClean = true;

        System.out.println("\nA maquina foi lavada com sucesso\n");
    }
}
