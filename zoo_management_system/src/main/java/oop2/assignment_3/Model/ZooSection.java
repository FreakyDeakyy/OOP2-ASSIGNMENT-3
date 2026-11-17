package oop2.assignment_3.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a section of the zoo that can contain sections and inclosures
 *
 * 
 * Acts as the largest grouping of animals within the Zoo.
 *
 * @author Owen Huxter
 */
public class ZooSection implements ZooComponent {
    private String aName;
    private final List<ZooComponent> aComponents = new ArrayList<>();

    @Override
    public String getName() {
        return this.aName;
    }

    @Override
    public int countAnimals() {
        int totalAnimals = 0;
        for (ZooComponent component : aComponents) {
            totalAnimals += component.countAnimals();
        }
        return totalAnimals;
    }

    public ZooSection(String pName) {
        this.aName = pName;
    }

    // POLYMORPHISM
    public void addComponent(ZooComponent pComponent) {
        if (pComponent != null) {
            this.aComponents.add(pComponent);
        }
    }

    public List<ZooComponent> getComponents() {
        return this.aComponents;
    }

    @Override
    public String toString() {
        return this.aName + " (" + this.countAnimals() + " animals)";
    }
}
