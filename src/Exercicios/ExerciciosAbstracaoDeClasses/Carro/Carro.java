package Exercicios.ExerciciosAbstracaoDeClasses.Carro;

public class Carro {
    private boolean isCarCreated = false;
    private boolean isCarStarted = false;
    private int carSpeed = 0;
    private int carGear = 0;

    public void createCar() {
        this.isCarCreated = true;
    }

    public boolean isCarCreated() {
        return isCarCreated;
    }

    public boolean isCarStarted() {
        return isCarStarted;
    }

    public void turnOnCar() {
        if (!this.isCarStarted) {
            this.isCarStarted = true;
            System.out.println("\nO carro foi ligado.\n");
            return;
        }
        System.out.println("\nO carro já está ligado.\n");
    }

    public void turnOffCar() {
        if (this.isCarStarted) {
            if(this.carSpeed > 0) {
                System.out.println("\nO carro está em movimento. Por favor, reduza a velocidade para 0 antes de desligar o carro.\n");
                return;
            }
            this.isCarStarted = false;
            System.out.println("\nO carro foi desligado.\n");
        }
        System.out.println("\nO carro já está desligado.\n");
        return;
    }

    public int getCarSpeed() {
        System.out.println("\nA velocidade atual do carro é: " + this.carSpeed + " km/h.\n");
        return carSpeed;
    }

    public int getCarGear() {
        if(this.carGear > 0) {
            System.out.println("\nO carro está na marcha: " + this.carGear + ".\n");
        } else {
            System.out.println("\nO carro está em ponto morto.\n");
        }
        
        return carGear;
    }

    public void changeUpCarGear() {
        if (this.isCarStarted) {
            if(this.carGear < 6) {
                if(this.carSpeed == 0) {
                    this.carGear += 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 20 && this.carGear == 1) {
                    this.carGear += 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 40 && this.carGear == 2) {
                    this.carGear += 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 60 && this.carGear == 3) {
                    this.carGear += 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 80 && this.carGear == 4) {
                    this.carGear += 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 100 && this.carGear == 5) {
                    this.carGear += 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 120 && this.carGear == 6) {
                    System.out.println("\nO carro esta na marcha máxima.\n");
                    return;
                } else {
                    System.out.println("\nA marcha atual do carro não é adequada para mudar para a próxima marcha. Por favor, ajuste a velocidade antes de mudar a marcha.\n");
                    return;
                }
            }
            System.out.println("\nO carro já está na marcha máxima.\n");
            return;
        }
        System.out.println("\nO carro está desligado. Por favor, ligue o carro antes de mudar a marcha.\n");
        return;
    }

    public void changeDownCarGear() {
        if (this.isCarStarted) {
            if(this.carGear < 0) {
                if (this.carSpeed == 100 && this.carGear == 6) {
                    this.carGear -= 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 80 && this.carGear == 5) {
                    this.carGear -= 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 60 && this.carGear == 4) {
                    this.carGear -= 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 40 && this.carGear == 3) {
                    this.carGear -= 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 20 && this.carGear == 2) {
                    this.carGear -= 1;
                    System.out.println("\nO carro mudou para a marcha: " + this.carGear + ".\n");
                    return;
                } else if (this.carSpeed == 0 && this.carGear == 1) {
                    this.carGear -= 1;
                    System.out.println("\nO carro esta em ponto morto.\n");
                    return;
                } else {
                    System.out.println("\nA marcha atual do carro não é adequada para mudar para a próxima marcha. Por favor, ajuste a velocidade antes de mudar a marcha.\n");
                    return;
                }
            }
        }
        System.out.println("\nO carro está desligado. Por favor, ligue o carro antes de mudar a marcha.\n");
        return;
    }

    public void accelerateCar() {
        if (this.isCarStarted) {
            if(this.carGear > 0) {
                var speed = this.carSpeed;
                if(carGear == 1 && speed <= 20) {
                    this.carSpeed += 1;
                    System.out.println("\nO carro acelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 2 && speed <= 40) {
                    this.carSpeed += 1;
                    System.out.println("\nO carro acelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 3 && speed <= 60) {
                    this.carSpeed += 1;
                    System.out.println("\nO carro acelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 4 && speed <= 80) {
                    this.carSpeed += 1;
                    System.out.println("\nO carro acelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 5 && speed <= 100) {
                    this.carSpeed += 1;
                    System.out.println("\nO carro acelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 6 && speed <= 120) {
                    this.carSpeed += 1;
                    System.out.println("\nO carro acelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 6 && speed == 120) {
                    System.out.println("\nO carro está em sua velocidade máxima de " + this.carSpeed + " km/h.\n");
                    return;
                }   else {
                    System.out.println("\nA marcha atual do carro não é adequada para acelerar. Por favor, ajuste a marcha antes de acelerar.\n");
                    return;
                }
            }

            System.out.println("\nO carro está em ponto morto. Por favor, mude a marcha antes de acelerar.\n");
        }
        System.out.println("\nO carro está desligado. Por favor, ligue o carro antes de acelerar.\n");
    }

    public void decelerateCar() {
        if (this.isCarStarted) {
            if(this.carGear > 0) {
                var speed = this.carSpeed;
                if(carGear == 6 && speed > 100) {
                    this.carSpeed -= 1;
                    System.out.println("\nO carro desacelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 5 && speed > 80) {
                    this.carSpeed -= 1;
                    System.out.println("\nO carro desacelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 4 && speed > 60) {
                    this.carSpeed -= 1;
                    System.out.println("\nO carro desacelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 3 && speed > 40) {
                    this.carSpeed -= 1;
                    System.out.println("\nO carro desacelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 2 && speed > 20) {
                    this.carSpeed -= 1;
                    System.out.println("\nO carro desacelerou para " + this.carSpeed + " km/h.\n");
                    return;
                } else if(carGear == 1 && speed > 0) {
                    this.carSpeed -= 1;
                    System.out.println("\nO carro desacelerou para " + this.carSpeed + " km/h.\n");
                    return;
                }  else {
                    System.out.println("\nA marcha atual do carro não é adequada para desacelerar. Por favor, ajuste a marcha antes de desacelerar.\n");
                    return;
                }
            }

            System.out.println("\nO carro está em ponto morto. Por favor, mude a marcha antes de desacelerar.\n");
        }
        System.out.println("\nO carro está desligado. Por favor, ligue o carro antes de acelerar.\n");
    }

    public void turnLeft() {
        if (this.isCarStarted) {
            if(this.carSpeed < 41) {
                System.out.println("\nO carro virou para a esquerda.\n");
                return;
            }
            System.out.println("\nMuito rapido para virar.\n");
            return;
        }
    }

    public void turnRight() {
        if (this.isCarStarted) {
            if(this.carSpeed < 41) {
                System.out.println("\nO carro virou para a direita.\n");
                return;
            }
            System.out.println("\nMuito rapido para virar.\n");
            return;
        }
    }
}
