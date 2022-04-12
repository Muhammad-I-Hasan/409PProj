package edu.ucalgary.ensf409;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GUI {

	private JFrame frmAddHouseholdsTo;
	private JTextField nameText;
	private JSpinner adMaleSpin;
	private JSpinner AdFemaleSpin;
	private JSpinner chOver8Spin;
	private JSpinner chUnder8Spin;
	private JButton addHouseholdButton;
	private JButton btnEditHousehold;
	private JButton btnRemoveSelected;
    private ListSelectionModel listSelectionModel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmAddHouseholdsTo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		frmAddHouseholdsTo.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddHouseholdsTo = new JFrame();
		frmAddHouseholdsTo.setTitle("Add Households to Order");
		frmAddHouseholdsTo.setBounds(100, 100, 614, 462);
		frmAddHouseholdsTo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddHouseholdsTo.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel startPanel = new JPanel();
		frmAddHouseholdsTo.getContentPane().add(startPanel, "name_766832489647500");
		GridBagLayout gbl_startPanel = new GridBagLayout();
		gbl_startPanel.columnWidths = new int[]{231, 259, 170, 66, 0};
		gbl_startPanel.rowHeights = new int[]{97, 65, 92, 62, 0};
		gbl_startPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_startPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		startPanel.setLayout(gbl_startPanel);
		
		JButton newOrderButton = new JButton("New Order...");
		newOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (frmAddHouseholdsTo.getContentPane().getLayout());
				c1.next(frmAddHouseholdsTo.getContentPane());
				
			}
		});
		GridBagConstraints gbc_newOrderButton = new GridBagConstraints();
		gbc_newOrderButton.fill = GridBagConstraints.BOTH;
		gbc_newOrderButton.insets = new Insets(0, 0, 5, 5);
		gbc_newOrderButton.gridx = 1;
		gbc_newOrderButton.gridy = 1;
		startPanel.add(newOrderButton, gbc_newOrderButton);
		
		JButton exit1Button = new JButton("Exit");
		exit1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddHouseholdsTo.dispatchEvent(new WindowEvent(frmAddHouseholdsTo, WindowEvent.WINDOW_CLOSING));
			}
		});
		GridBagConstraints gbc_exit1Button = new GridBagConstraints();
		gbc_exit1Button.fill = GridBagConstraints.BOTH;
		gbc_exit1Button.insets = new Insets(0, 0, 0, 5);
		gbc_exit1Button.gridx = 1;
		gbc_exit1Button.gridy = 3;
		startPanel.add(exit1Button, gbc_exit1Button);
		
		
		
		JPanel houseListCard = new JPanel();
		frmAddHouseholdsTo.getContentPane().add(houseListCard, "name_694640061988500");
		houseListCard.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(13, 11, 429, 353);
		houseListCard.add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("Household 1");
		listModel.addElement("66 Aspen Hills Way");
		listModel.addElement("Household 2");
		
		JList houseList = new JList(listModel);
	    listSelectionModel = houseList.getSelectionModel();
	    listSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    	    if (e.getValueIsAdjusting() == false) {

	    	        if (houseList.getSelectedIndex() == -1) {
	    	        //No selection, disable fire button.
	    	            btnEditHousehold.setEnabled(false);
	    	            btnRemoveSelected.setEnabled(false);
	    	        } else {
	    	        //Selection, enable the fire button.
	    	        	btnEditHousehold.setEnabled(true);
	    	        	btnRemoveSelected.setEnabled(true);
	    	        }
	    	    }
	    	}
	    });
		houseList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		houseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(houseList); 
		
		// ****** EDIT BUTTON ******
		btnEditHousehold = new JButton("Edit Selected");
		btnEditHousehold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fill form with correct values

				//adMaleSpin.setValue(10);
				
				
				// TO MAKE EASY WE ALWAYS DELETE OLD ONE AND ADD NEW
				
				
				//if(houseList.getSelectedIndex() <= 0) {
				//	btnEditHousehold.setEnabled(false);
					
				//}
		        int index = houseList.getSelectedIndex();

				
				String houseName = (String) listModel.elementAt(index);
				//listModel.get(s)
				nameText.setText(houseName);
				
				CardLayout c1 = (CardLayout) (frmAddHouseholdsTo.getContentPane().getLayout());
				c1.last(frmAddHouseholdsTo.getContentPane());
				frmAddHouseholdsTo.setTitle("Edit Household");

			}
		});
		btnEditHousehold.setBounds(454, 71, 136, 26);
		houseListCard.add(btnEditHousehold);
		btnEditHousehold.setEnabled(false);
		
		addHouseholdButton = new JButton("Add Household");
		addHouseholdButton.setBounds(454, 32, 136, 26);
		addHouseholdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) (frmAddHouseholdsTo.getContentPane().getLayout());
				c1.last(frmAddHouseholdsTo.getContentPane());
				frmAddHouseholdsTo.setTitle("Edit Household");
				
				

			}
			
			//list
		});
		houseListCard.add(addHouseholdButton);
		
		JButton createOrder = new JButton("Create Order");
		createOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] options = {"Create new order",
	                    "View order form",
	                    "Exit"};
				int n = JOptionPane.showOptionDialog(frmAddHouseholdsTo,
					    "Order successfully created ",
					    "Success",
					    JOptionPane.YES_NO_CANCEL_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,
					    options,
					    options[2]);
				
				if(n == 0) {
					resetHouseForm();
					CardLayout c1 = (CardLayout) (frmAddHouseholdsTo.getContentPane().getLayout());
					c1.first(frmAddHouseholdsTo.getContentPane());
					
				}else if (n == 2) {
					frmAddHouseholdsTo.dispatchEvent(new WindowEvent(frmAddHouseholdsTo, WindowEvent.WINDOW_CLOSING));
				}
				
			}
		});
		createOrder.setBounds(42, 376, 127, 39);
		houseListCard.add(createOrder);
		
		btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = houseList.getSelectedIndex();
			    listModel.remove(index);

			    int size = listModel.getSize();

			    if (size == 0) { //Nobody's left, disable remove.
			    	btnRemoveSelected.setEnabled(false);

			    } else { //Select an index.
			        if (index == listModel.getSize()) {
			            //removed item in last position
			            index--;
			        }

			        houseList.setSelectedIndex(index);
			        houseList.ensureIndexIsVisible(index);
			    }
				
			}
		});
		btnRemoveSelected.setBounds(452, 132, 138, 26);
		houseListCard.add(btnRemoveSelected);
		btnRemoveSelected.setEnabled(false);
		
		JButton createHamper = new JButton("Create Hamper");
		createHamper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmAddHouseholdsTo,
					    "Failed to create \"Household 1\" hamper.",
					    "Hamper creation error",
					    JOptionPane.ERROR_MESSAGE);
			}
		});
		createHamper.setBounds(181, 376, 127, 39);
		houseListCard.add(createHamper);
		
		JPanel houseEditCard = new JPanel();
		frmAddHouseholdsTo.getContentPane().add(houseEditCard, "name_696550095204400");
		houseEditCard.setLayout(null);
		
		nameText = new JTextField();
		nameText.setBounds(138, 26, 300, 33);
		houseEditCard.add(nameText);
		nameText.setColumns(10);
		
		JButton Done = new JButton("Save");
		Done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 	CHECK THAT INPUT IS ALL GOOD
				
				//  NEEDS TO PUT BACK INTO SAME OBJECT IF IT'S AN EDIT AND NOT NEW
				String houseName = nameText.getText();
				if(houseName.length() == 0) {
					JOptionPane.showMessageDialog(frmAddHouseholdsTo,
						    "The household must have a unique name.",
						    "Check input",
						    JOptionPane.ERROR_MESSAGE);
				}else {
					listModel.add(0, houseName);					
					resetHouseForm();

				}
			}
		});
		Done.setBounds(470, 370, 101, 26);
		houseEditCard.add(Done);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(84, 34, 57, 16);
		houseEditCard.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddHouseholdsTo.setTitle("Add Households to Order");
				CardLayout c1 = (CardLayout) (frmAddHouseholdsTo.getContentPane().getLayout());
				c1.first(frmAddHouseholdsTo.getContentPane());
				
				resetHouseForm();
			}
		});
		btnNewButton_3.setBounds(357, 370, 101, 26);
		houseEditCard.add(btnNewButton_3);
		
		adMaleSpin = new JSpinner();
		adMaleSpin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		adMaleSpin.setBounds(52, 106, 41, 33);
		houseEditCard.add(adMaleSpin);
		
		
		AdFemaleSpin = new JSpinner();
		AdFemaleSpin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		AdFemaleSpin.setBounds(52, 151, 41, 33);
		houseEditCard.add(AdFemaleSpin);
		
		chOver8Spin = new JSpinner();
		chOver8Spin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		chOver8Spin.setBounds(52, 190, 41, 33);
		houseEditCard.add(chOver8Spin);
		
		chUnder8Spin = new JSpinner();
		chUnder8Spin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		chUnder8Spin.setBounds(52, 235, 41, 30);
		houseEditCard.add(chUnder8Spin);
		
		JLabel adMSpinLabel = new JLabel("Adult Males");
		adMSpinLabel.setBounds(111, 114, 90, 16);
		houseEditCard.add(adMSpinLabel);
		
		JLabel adFeSpinLabel = new JLabel("Adult Females");
		adFeSpinLabel.setBounds(111, 159, 90, 16);
		houseEditCard.add(adFeSpinLabel);
		
		JLabel chOver8SpinLabel = new JLabel("Children Over 8");
		chOver8SpinLabel.setBounds(111, 198, 111, 16);
		houseEditCard.add(chOver8SpinLabel);
		
		JLabel chUnder8SpinLabel = new JLabel("Children Under 8");
		chUnder8SpinLabel.setLabelFor(chUnder8Spin);
		chUnder8SpinLabel.setBounds(111, 242, 126, 16);
		houseEditCard.add(chUnder8SpinLabel);
		
		JLabel houseRequirements = new JLabel("Current Household Requirements");
		houseRequirements.setFont(new Font("Dialog", Font.BOLD, 15));
		houseRequirements.setBounds(311, 85, 260, 32);
		houseEditCard.add(houseRequirements);
		
		JLabel fibreReqLabel = new JLabel("Fibre: ");
		fibreReqLabel.setBounds(321, 129, 239, 16);
		houseEditCard.add(fibreReqLabel);
		
		JLabel fvReqLabel = new JLabel("Fruits & Vegtables:");
		fvReqLabel.setBounds(321, 159, 239, 16);
		houseEditCard.add(fvReqLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Protein: ");
		lblNewLabel_1.setBounds(321, 190, 57, 16);
		houseEditCard.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Other:");
		lblNewLabel_2.setBounds(321, 218, 57, 16);
		houseEditCard.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Calories:");
		lblNewLabel_3.setBounds(321, 242, 57, 16);
		houseEditCard.add(lblNewLabel_3);
		

	}
	
	private void resetHouseForm() {
		nameText.setText("");
		frmAddHouseholdsTo.setTitle("Add Households to Order");
		CardLayout c1 = (CardLayout) (frmAddHouseholdsTo.getContentPane().getLayout());
		c1.show(frmAddHouseholdsTo.getContentPane(), "name_694640061988500");
		adMaleSpin.setValue(0);
		AdFemaleSpin.setValue(0);
		chOver8Spin.setValue(0);
		chUnder8Spin.setValue(0);

	}
	
	private void loadToHouseForm(/*Household hs*/) {
		
	}
	
}
