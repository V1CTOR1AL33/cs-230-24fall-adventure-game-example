/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

import java.util.*;

public class Treasure{

    private String name;
    private String desc;
    
    public Treasure(String aName, String aDescription) {
        this.name = aName;
        this.desc = aDescription;
    }
    
    /**
     * @return the value
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the value
     */
    public String getDescription() {
        return desc;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }else if (obj instanceof Treasure){
            Treasure objToCompare = (Treasure) obj;
            if(objToCompare.getName().equals(this.getName())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return name+" ("+desc+")";
    }

}
