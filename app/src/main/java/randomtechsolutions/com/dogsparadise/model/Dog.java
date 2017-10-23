package randomtechsolutions.com.dogsparadise.model;


/**
 * Created by nande on 10/17/2017.
 */

public class Dog {
   
    public String breed;
    public String imagePath;
    
    
    public Dog(String breed , String imagePath) {
        
        this.breed = breed;
        this.imagePath = imagePath;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
}
