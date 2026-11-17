package oop2.assignment_3.Model;

/**
 * Represents a component of the zoo, which can be either a ZooSection or an
 * Enclosure.
 *
 * interface to ensure components have proper method naming and structure
 * 
 * @author Owen Huxter
 */
public interface ZooComponent {
    public String getName();

    public int countAnimals();
}
