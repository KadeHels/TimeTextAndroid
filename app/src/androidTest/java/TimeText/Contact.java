package TimeText;

/**
 *
 * @author LauraKrebs
 * @author Kade Helseth
 */
public class Contact {

   /**
    *
    * @param name the Contact's name as a String provided by the user.
    * @param number a String representation of the Contact's phone number as
    * provided by the user.
    */
   public Contact(String name, String number) {
      this.name = name;
      String[] Split = name.split("\\s+");
      this.firstName = Split[0];
      this.lastName = Split[1];
      this.number = numberFormater(number);
   }

   public Contact(String firstName, String LastName, String number) {
      this.firstName = firstName;
      this.lastName = LastName;
      this.number = numberFormater(number);
   }

   public String getName() {
      if (firstName == null || lastName == null) {
         return name;
      } else {
         return firstName + " " + lastName;
      }
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setName(String newName) {
      this.name = newName;
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String newNumber) {
      this.number = newNumber;
   }

   /**
    * assumes the string coming is only numbers and not non integer values
    *
    * @param number The original number sent in
    * @return the String of the phone number in the format (XXX) XXX-XXX
    *
    */
   private String numberFormater(String number) {
      String retNumber;

      if (number.length() == 10) {
         retNumber = "(";
         retNumber += number.substring(0, 3);
         retNumber += ")";
         retNumber += number.substring(3, 6);
         retNumber += "-";
         retNumber += number.substring(6);
      } else {
         retNumber = number;
      }
      return retNumber;

   }

   private String firstName;

   private String lastName;

   /**
    * The Contact's name.
    */
   private String name;

   /**
    * The Contact's telephone number.
    */
   private String number;
}
