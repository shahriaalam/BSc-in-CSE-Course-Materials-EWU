/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-dab6b48 modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// line 26 "../../../../../TAMASPersistence.ump"
// line 11 "../../../../../model.ump"
public class Person implements Serializable
{
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 29 ../../../../../TAMASPersistence.ump
  private static final long serialVersionUID = 8896099581655989380L ;
  // line 30 ../../../../../TAMASPersistence.ump
  private static Map<String, Person> PersonsByUsername = new HashMap<String, Person>() ;
	  
  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private String username;
  private String password;

  //Person Associations
  private Tamas tamas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, String aUsername, String aPassword, Tamas aTamas)
  {
    name = aName;
    username = aUsername;
    password = aPassword;
    boolean didAddTamas = setTamas(aTamas);
    if (!didAddTamas)
    {
      throw new RuntimeException("Unable to create person due to tamas");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public Tamas getTamas()
  {
    return tamas;
  }

  public boolean setTamas(Tamas aTamas)
  {
    boolean wasSet = false;
    if (aTamas == null)
    {
      return wasSet;
    }

    Tamas existingTamas = tamas;
    tamas = aTamas;
    if (existingTamas != null && !existingTamas.equals(aTamas))
    {
      existingTamas.removePerson(this);
    }
    tamas.addPerson(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Tamas placeholderTamas = tamas;
    this.tamas = null;
    placeholderTamas.removePerson(this);
  }

  // line 33 "../../../../../TAMASPersistence.ump"
   public static  void reinitializeUsername(List<Person> persons){
    PersonsByUsername = new HashMap<String, Person>();
    for (Person person : persons) {
      PersonsByUsername.put(person.getUsername(), person);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tamas = "+(getTamas()!=null?Integer.toHexString(System.identityHashCode(getTamas())):"null")
     + outputString;
  }  


  
}