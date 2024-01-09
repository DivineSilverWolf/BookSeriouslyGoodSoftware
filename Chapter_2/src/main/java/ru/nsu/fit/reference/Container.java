package ru.nsu.fit.reference;

import java.util.HashSet;
import java.util.Set;

public class Container {
    private Set<Container> group; // Резервуары, соединенные с текущим
    private double amount; // Объём воды в резервуаре

    /* Создаёт пустой резервуар. Также должен быть комментарий Javadoc */
    public Container() {
        group = new HashSet<>();
        group.add(this); // Группа начинается с этого резервуара
    }
    public double getAmount() {
        return amount;
    }
    public void connectTo(Container other) {
        // Если резервуары уже соединены, ничего не делать
        if (group == other.group) return;
        int size1 = group.size();
        int size2 = other.group.size();
        double tot1 = amount * size1;
        double tot2 = other.amount * size2;
        double newAmount = (tot1 + tot2) / (size1 + size2); // Вычислить новый объём воды в каждом резервуаре
        // Объединить две группы
        group.addAll(other.group);
        // Обновить группу резервуаров, соединенных с other
        // Также!!! Эти комментарии можно заменить вспомогательным методом с информативным именем.
        for (Container c : other.group) {
            c.group = group;
        }
        // Обновить amount для всех вновь присоединенных резервуаров
        for (Container c : group) {
            c.amount = newAmount;
        }
    }
    public void addWater(double amount) {
        double amountPerContainer = amount / group.size();
        for (Container c : group) c.amount += amountPerContainer;
    }
}
