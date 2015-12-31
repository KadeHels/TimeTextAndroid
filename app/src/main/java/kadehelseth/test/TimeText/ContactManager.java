/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadehelseth.test.TimeText;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LauraKrebs
 */
public class ContactManager {

   public ContactManager() {
      contactList = new ArrayList<Contact>();
      contactCount = 0;
   }

   /**
    * gets the list of the contacts
    *
    * @return the list of contacts
    */
   public List<Contact> getContacts() {
      return contactList;
   }

   /**
    * Adds a new contact to the list
    *
    * @param newContact The contact to be added at the end of the list
    */
   public void addContact(Contact newContact) {
      contactList.add(newContact);
      ++contactCount;
   }

   public List<Contact> sortFirstName() {
      List<Contact> sortList = contactList;

      if (contactCount == 0) {
         return sortList;
      } else {
         boolean swapped = true;
         int j = 0;
         Contact tmp;
         while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < sortList.size() - j; i++) {
               int letter1 = (int) (sortList.get(i).getFirstName().charAt(0));
               int letter2 = (int) (sortList.get(i + 1).getFirstName().charAt(0));
               if (letter1 > letter2) {
                  tmp = sortList.get(i);
                  sortList.set(i, sortList.get(i + 1));
                  sortList.set(i + 1, tmp);
                  swapped = true;
               }
            }
         }

      }

      return sortList;
   }

   public List<Contact> sortLastName() {
      List<Contact> sortList = contactList;

      if (contactCount == 0) {
         return sortList;
      } else {
         boolean swapped = true;
         int j = 0;
         Contact tmp;
         while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < sortList.size() - j; i++) {
               int letter1 = (int) (sortList.get(i).getLastName().charAt(0));
               int letter2 = (int) (sortList.get(i + 1).getLastName().charAt(0));
               if (letter1 > letter2) {
                  tmp = sortList.get(i);
                  sortList.set(i, sortList.get(i + 1));
                  sortList.set(i + 1, tmp);
                  swapped = true;
               }
            }
         }

      }

      return sortList;
   }

   public String listToString(List<Contact> list) {
      String retString = "";
      int i = 0;
      while (i < list.size()) {
         retString += list.get(i).getName() + " " + list.get(i).getNumber();
         retString += "\n";
         ++i;
      }

      return retString;
   }

   private int contactCount;
   private List<Contact> contactList;
}
