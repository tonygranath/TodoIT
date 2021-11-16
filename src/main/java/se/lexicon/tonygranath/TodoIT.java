package se.lexicon.tonygranath;

import se.lexicon.tonygranath.data.PropertiesDAO;
import se.lexicon.tonygranath.data.PropertiesDAOManager;

import java.nio.file.Paths;

public class TodoIT
{
    public static void main(String[] args) {
        PropertiesDAO props = PropertiesDAOManager.getInstance();
     //   props.set("testProp1", "testValue1");
     //   props.set("testProp2", "testValue2");
       // props.set("testProp2", "testValue222");
     //   props.save("test.config");
     //   props.remove("testProp1");
        props.read("test.config");
        System.out.println("s" + props.getProperties());
    }
}
