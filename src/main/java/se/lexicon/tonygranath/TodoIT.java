package se.lexicon.tonygranath;

import se.lexicon.tonygranath.data.*;
import se.lexicon.tonygranath.io.JSONManager;
import se.lexicon.tonygranath.io.PropertiesManager;

public class TodoIT
{
    public static void main(String[] args) {
        JSONManager j = JSONManager.getInstance();
        PropertiesManager props = PropertiesManager.getInstance();
        PersonDAOCollection people = PersonDAOCollection.getInstance();
        TodoItemDAOCollection items = TodoItemDAOCollection.getInstance();
        TodoItemTaskDAOCollection tasks = TodoItemTaskDAOCollection.getInstance();
        AppUserDAOCollection users = AppUserDAOCollection.getInstance();

     //   props.set("testProp1", "testValue1");
     //   props.set("testProp2", "testValue2");
       // props.set("testProp2", "testValue222");
     //   props.save("test.config");
     //   props.remove("testProp1");
     //   props.read("test.config");
     //   System.out.println("s" + props.getProperties());


        
    }
}
