package Exercicios.ExerciciosAbstracaoDeClasses.PetShop;

public class Dog {
    private boolean isADog = false;
    private boolean dogIsClean = false;

    public void getDog() {
        if(!isADog) {
            this.isADog = true;
            System.out.println("\n Um cliente trouxe o cachorro\n");
            return;
        }

        System.out.println("\nJá temos um cachorro para atender\n");
    }

    public void checkDog() {
        if(isADog) {
            if(!dogIsClean) {
            System.out.println("\nO cachorro está sujo\n");
            return;
        }

            System.out.println("\nO cachoro está limpo\n");
            return;
        }
        
        System.out.println("\nAinda não temos um cachorro\n");
    }

    public void cleanDog() {
        this.dogIsClean = true;
    }

    public void deliveryDog() {
        if(this.dogIsClean) {
            this.isADog = false;
            this.dogIsClean = false;
            System.out.println("\nO cachorro foi devolvido\n");
            return;
        }
        
        System.out.println("\nVocê não pode devolver o cachorro sujo\n");
        return;
    }
}


