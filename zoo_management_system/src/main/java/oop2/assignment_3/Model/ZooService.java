package oop2.assignment_3.Model;

/**
 * Management system service for the zoo, allowing access to the root section of
 * the zoo.
 * 
 * @author Owen Huxter
 */
public class ZooService {
    private ZooSection aRootSection;

    public void setRootSection(ZooSection pRootSection) {
        this.aRootSection = pRootSection;
    }

    public ZooSection getRootSection() {
        return this.aRootSection;
    }
}
