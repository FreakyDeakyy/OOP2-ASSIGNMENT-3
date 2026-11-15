package oop2.assignment_3.Model;

import java.util.ArrayList;
import java.util.List;

public class ZooSection implements ZooComponent {
    private String aName;
    private final List<ZooComponent> aComponents = new ArrayList<>();

    @Override
    public String getName() {
        return this.aName;
    }

    @Override
    public int countAnimals() {
        return 0;
    }

    public ZooSection(String pName) {
        this.aName = pName;
    }

    public void addComponent(Enclosure pEnclosure) {
        if (pEnclosure != null) {
            this.aComponents.add(pEnclosure);
        }
    }

    public void addComponent(ZooSection pZooSection) {
        if (pZooSection != null) {
            this.aComponents.add(pZooSection);
        }
    }

    public List<ZooComponent> getComponents() {
        return this.aComponents;
    }

    @Override
    public String toString() {
        return this.aName;
    }
}
