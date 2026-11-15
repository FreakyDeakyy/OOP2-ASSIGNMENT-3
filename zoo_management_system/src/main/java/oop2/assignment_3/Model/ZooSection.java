package oop2.assignment_3.Model;

public class ZooSection implements ZooComponent {
    private String aName;

    public String getName() {
        return "";
    }

    public int countAnimals() {
        return 0; // Placeholder implementation
    }

    public ZooSection(String pName) {
        this.aName = pName;
    }

    public void addComponent(Enclosure pEnclosure) {

    }

    public void addComponent(ZooSection pZooSection) {

    }
}
