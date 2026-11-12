package oop2.assignment_3.Model;

public class ZooSection implements ZooComponent {
    private String aSectionName;

    // TODO
    @Override
    public String getName() {
        return aSectionName;
    }

    // TODO
    @Override
    public int countAnimals() {
        return 0;
    }

    public ZooSection(String aSectionName) {
        this.aSectionName = aSectionName;
    }

    public void addComponent(ZooComponent component) {
        // TODO
    }
}
