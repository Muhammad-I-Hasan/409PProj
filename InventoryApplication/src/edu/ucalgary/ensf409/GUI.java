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
import java.util.ArrayList;
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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GUI {

	private JFrame frmAddHouseholdsTo;
	private JTextField nameText;
	private JSpinner adMaleSpin;
	private JSpinner adFemaleSpin;
	private JSpinner chOver8Spin;
	private JSpinner chUnder8Spin;
	private JButton addHouseholdButton;
	private JButton btnEditHousehold;
	private JButton btnRemoveSelected;
	
	private JLabel fibreNeedsLabel;
	private JLabel fvNeedsLabel;
	private JLabel proNeedsLabel;
	private JLabel otherNeedsLabel;
	private JLabel calNeedsLabel;
    private ListSelectionModel listSelectionModel;
    private DefaultListModel listModel;
    
    private ClientList cl;
    private FoodInv inv;
    
    private Order order;
    private int editingInd = -1;


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
		frmAddHouseholdsTo.setTitle("Inventory Application");
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
				
				//Get most up-to-date Food Inventory and Client List from the database
				cl = new ClientList();
				inv = new FoodInv();
				
				cl.loadFromDB();
				inv.loadFromDB();
				
				//Create new order
				order = new Order(inv);
				
				frmAddHouseholdsTo.setTitle("Add Households to Order");
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
		
		listModel = new DefaultListModel();
		//listModel.addElement("Household 1");
		//listModel.addElement("66 Aspen Hills Way");
		//listModel.addElement("Household 2");
		//listModel.addElement("TEST?");
		
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

				int index = houseList.getSelectedIndex();
				Household editing = order.getHousehold(index);
				String houseName = (String) listModel.elementAt(index);
				nameText.setText(houseName);
				loadToHouseForm(order.getHousehold(index));
				
				editingInd = index; //so save button knows where to insert the new household
				// TO MAKE EASY WE ALWAYS DELETE OLD ONE AND ADD NEW
				
				
				
				
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
				frmAddHouseholdsTo.setTitle("Add Household");
				
				

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
			    order.removeHousehold(index);
			    
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
					Household hh = getValuesFromForm();
					if(editingInd != -1) {
						listModel.remove(editingInd);
						order.removeHousehold(editingInd);
						order.addHousehold(editingInd, hh);	
						listModel.add(editingInd, houseName);
						editingInd = -1;
					}else {
						order.addHousehold(hh);
						listModel.add(listModel.getSize(), houseName);
					}
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
				
				editingInd = -1; //in case we were editing
				resetHouseForm();
			}
		});
		btnNewButton_3.setBounds(357, 370, 101, 26);
		houseEditCard.add(btnNewButton_3);
		
		adMaleSpin = new JSpinner();
		adMaleSpin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showNeeds(getValuesFromForm());
			}
		});
		adMaleSpin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		adMaleSpin.setBounds(52, 106, 41, 33);
		houseEditCard.add(adMaleSpin);
		
		
		adFemaleSpin = new JSpinner();
		adFemaleSpin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showNeeds(getValuesFromForm());
			}
		});
		adFemaleSpin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		adFemaleSpin.setBounds(52, 151, 41, 33);
		houseEditCard.add(adFemaleSpin);
		
		chOver8Spin = new JSpinner();
		chOver8Spin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showNeeds(getValuesFromForm());
			}
		});
		chOver8Spin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		chOver8Spin.setBounds(52, 190, 41, 33);
		houseEditCard.add(chOver8Spin);
		
		chUnder8Spin = new JSpinner();
		chUnder8Spin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showNeeds(getValuesFromForm());
			}
		});
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
		fibreReqLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		fibreReqLabel.setBounds(321, 129, 117, 16);
		houseEditCard.add(fibreReqLabel);
		
		JLabel fvReqLabel = new JLabel("Fruits & Vegtables:");
		fvReqLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		fvReqLabel.setBounds(321, 159, 126, 16);
		houseEditCard.add(fvReqLabel);
		
		JLabel proReqLabel = new JLabel("Protein: ");
		proReqLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		proReqLabel.setBounds(321, 190, 57, 16);
		houseEditCard.add(proReqLabel);
		
		JLabel calReqLabel = new JLabel("Other:");
		calReqLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		calReqLabel.setBounds(321, 218, 57, 16);
		houseEditCard.add(calReqLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Calories:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(321, 242, 57, 16);
		houseEditCard.add(lblNewLabel_3);
		
		fibreNeedsLabel = new JLabel("##");
		fibreNeedsLabel.setBounds(470, 129, 57, 16);
		houseEditCard.add(fibreNeedsLabel);
		
		fvNeedsLabel = new JLabel("##");
		fvNeedsLabel.setBounds(470, 159, 57, 16);
		houseEditCard.add(fvNeedsLabel);
		
		proNeedsLabel = new JLabel("##");
		proNeedsLabel.setBounds(470, 190, 57, 16);
		houseEditCard.add(proNeedsLabel);
		
		otherNeedsLabel = new JLabel("##");
		otherNeedsLabel.setBounds(470, 218, 57, 16);
		houseEditCard.add(otherNeedsLabel);
		
		calNeedsLabel = new JLabel("##");
		calNeedsLabel.setBounds(470, 242, 57, 16);
		houseEditCard.add(calNeedsLabel);
		

	}
	
	private void resetHouseForm() {
		nameText.setText("");
		frmAddHouseholdsTo.setTitle("Add Households to Order");
		CardLayout c1 = (CardLayout) (frmAddHouseholdsTo.getContentPane().getLayout());
		c1.show(frmAddHouseholdsTo.getContentPane(), "name_694640061988500");
		adMaleSpin.setValue(0);
		adFemaleSpin.setValue(0);
		chOver8Spin.setValue(0);
		chUnder8Spin.setValue(0);

	}
	
	private void loadToHouseForm(Household hs) {
		ArrayList<Client> clients = hs.getClientList();
		
		int adMale = 0;
		int adFemale = 0;
		int chOver8 = 0;
		int chUnder8 = 0;
		
		for(Client c : clients) {
			if(c.getID() == 1) {
				adMale++;
			}
			else if(c.getID() == 2) {
				adFemale++;
			}
			else if(c.getID() == 3) {
				chOver8++;
			}
			else if(c.getID() == 4) {
				chUnder8++;
			}
		}
		
		adMaleSpin.setValue(adMale);
		adFemaleSpin.setValue(adFemale);
		chOver8Spin.setValue(chOver8);
		chUnder8Spin.setValue(chUnder8);

	}
	
	private void showNeeds(Household hs) {
		//used for spinner events
		//hs.updateNeeds();
		Nutrition needs = hs.getTotalNeeds();
		
		
		
		fibreNeedsLabel.setText(Integer.toString(needs.getGrain()));
		fvNeedsLabel.setText(Integer.toString(needs.getFruitsVeggies()));
		proNeedsLabel.setText(Integer.toString(needs.getProtein()));
		otherNeedsLabel.setText(Integer.toString(needs.getOther()));
		calNeedsLabel.setText(Integer.toString(needs.getCalories()));
		

	}
	
	private Household getValuesFromForm() {
		Household hh = new Household();
		
		for(int i = 0; i < (int)adMaleSpin.getValue(); i++) {
			hh.addClient(cl.getClient(1));
		}
		for(int i = 0; i < (int)adFemaleSpin.getValue(); i++) {
			hh.addClient(cl.getClient(2));
		}
		for(int i = 0; i < (int)chOver8Spin.getValue(); i++) {
			hh.addClient(cl.getClient(3));
		}
		for(int i = 0; i < (int)chUnder8Spin.getValue(); i++) {
			hh.addClient(cl.getClient(4));
		}
				
		return hh;
	}
	
}
