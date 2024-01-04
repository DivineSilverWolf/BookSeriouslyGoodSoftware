package ru.nsu.fit.api;

public class Container {
    private final Container[] containers;
    private double amount;
    private int countConnects;

    public Container(){
        containers = new Container[1000];
        amount = 0;
        countConnects = 1;
        containers[0] =this;
    }
    public double getAmount(){
        return amount;
    }
    public void connectTo(Container other) {
        double newAmount = (amount * countConnects + other.amount * other.countConnects)
                / (countConnects + other.countConnects); /* суммарное количество воды после соединения двух групп */
        for (int i = 0; i < countConnects; i++) {
            for (int j = 0; j < other.countConnects; j++) {
                containers[i].containers[countConnects + j] = other.containers[j]; /* первой группе трубы со второй */
                other.containers[j].containers[other.countConnects + i] = containers[i]; /* второй группе трубы с первой */
            }
        }
        countConnects += other.countConnects; /* общее количество труб после соединения */
        for (Container container: containers) {
            if(container == null) break;
            container.amount = newAmount; /* обновляем информацию о количестве воды */
            container.countConnects = countConnects; /* обновляем информацию о количестве соединения */
        }
    }
    public void addWater(double amount){
        double newAmount = amount/countConnects;
        for (int i = 0; i < countConnects; i++) {
            containers[i].amount += newAmount;
        }
    }
}