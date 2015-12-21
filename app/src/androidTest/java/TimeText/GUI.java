/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeText;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;

/**
 *
 * @author LauraKrebs
 */
public class GUI extends JComponent {

   public GUI() {
      homePanel = new JPanel();
      contactsPanel = new JPanel();
      outboxPanel = new JPanel();
      tabPane = new JTabbedPane();
      contactsScroller = new JScrollPane();
      contactList = new List();
      contactManager = new ContactManager();
      addContactButton = new JButton();
      editContactButton = new JButton();
      contactSortCB = new JComboBox();
      sortByLabel = new JLabel();
      messageTextPane = new JTextPane();
      sendButton = new JButton();
      contactTextPane = new JTextPane();
      messageScrollPane = new JScrollPane();
      contactScrollPane = new JScrollPane();

      messageTextPane.setText("Enter message here");
      messageScrollPane.setViewportView(messageTextPane);

      sendButton.setText("SEND");

      contactTextPane.setText("Enter contact's name or number");
      contactScrollPane.setViewportView(contactTextPane);

      for (Contact contact : contactManager.getContacts()) {
         contactList.add(contact.getFirstName());
      }

      GroupLayout homePanelLayout = new GroupLayout(homePanel);
      homePanel.setLayout(homePanelLayout);
      homePanelLayout.setHorizontalGroup(
          homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(homePanelLayout.createSequentialGroup()
              .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                  .addGroup(homePanelLayout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(messageScrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homePanelLayout.createSequentialGroup()
                      .addGap(20, 20, 20)
                      .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                          .addComponent(contactScrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
                          .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))
              .addContainerGap(25, Short.MAX_VALUE))
      );
      homePanelLayout.setVerticalGroup(
          homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
              .addContainerGap(67, Short.MAX_VALUE)
              .addComponent(contactScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addGap(18, 18, 18)
              .addComponent(messageScrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
              .addGap(18, 18, 18)
              .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
              .addContainerGap())
      );

      tabPane.addTab("Home", homePanel);

      contactsScroller.setViewportView(contactList);
      sortByLabel.setFont(new Font("Baghdad", 0, 18));
      sortByLabel.setText("Sort By:");

      contactSortCB.setFont(new Font("Baghdad", 0, 16));
      contactSortCB.setModel(new DefaultComboBoxModel(new String[]{"Last Name", "First Name"}));
      contactSortCB.setToolTipText("Sort contacts by last or first name.");

      addContactButton.setFont(new Font("Bangla MN", 0, 16));
      addContactButton.setText("Add Contact");
      addContactButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            //TO DO have a dialog that pops up for adding contacts, possibly a form?
         }
      });

      editContactButton.setFont(new Font("Bangla MN", 0, 16));
      editContactButton.setText("Edit Contact");
      editContactButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            //TO DO have some sort of dialog that pops up here for editing contacts;
         }
      });

      GroupLayout contactsPanelLayout = new GroupLayout(contactsPanel);
      contactsPanel.setLayout(contactsPanelLayout);
      contactsPanelLayout.setHorizontalGroup(
          contactsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(contactsPanelLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(contactsScroller)
              .addContainerGap())
          .addGroup(GroupLayout.Alignment.TRAILING, contactsPanelLayout.createSequentialGroup()
              .addGap(15, 15, 15)
              .addComponent(sortByLabel)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(contactSortCB, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
              .addGroup(contactsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                  .addComponent(editContactButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(addContactButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGap(20, 20, 20))
      );
      contactsPanelLayout.setVerticalGroup(
          contactsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(GroupLayout.Alignment.TRAILING, contactsPanelLayout.createSequentialGroup()
              .addGroup(contactsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(contactsPanelLayout.createSequentialGroup()
                      .addGap(18, 18, 18)
                      .addGroup(contactsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                          .addComponent(sortByLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                          .addComponent(contactSortCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                  .addGroup(contactsPanelLayout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(addContactButton)))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(editContactButton)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(contactsScroller, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
              .addContainerGap())
      );
      tabPane.addTab("Contacts", contactsPanel);

      GroupLayout outboxPanelLayout = new GroupLayout(outboxPanel);
      outboxPanel.setLayout(outboxPanelLayout);
      outboxPanelLayout.setHorizontalGroup(
          outboxPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGap(0, 400, Short.MAX_VALUE)
      );
      outboxPanelLayout.setVerticalGroup(
          outboxPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGap(0, 271, Short.MAX_VALUE)
      );

      tabPane.addTab("Outbox", outboxPanel);

   }

   public JTabbedPane getTabPane() {
      return tabPane;
   }

   public void setTabPane(JTabbedPane tP) {
      this.tabPane = tP;
   }

   public JPanel getHomePanel() {
      return homePanel;
   }

   public void setHomePanel(JPanel newPanel) {
      this.homePanel = newPanel;
   }

   public JPanel getContactsPanel() {
      return contactsPanel;
   }

   public void setContactsPanel(JPanel newPanel) {
      this.contactsPanel = newPanel;
   }

   public JPanel getOutboxPanel() {
      return outboxPanel;
   }

   public void setOutboxPanel(JPanel newPanel) {
      this.outboxPanel = newPanel;
   }

   private JPanel homePanel, contactsPanel, outboxPanel;
   private JTabbedPane tabPane;
   private JScrollPane contactsScroller, messageScrollPane, contactScrollPane;
   private List contactList;
   private ContactManager contactManager;
   private JButton addContactButton, editContactButton, sendButton;
   private JComboBox contactSortCB;
   private JLabel sortByLabel;
   private JTextPane messageTextPane, contactTextPane;
}
