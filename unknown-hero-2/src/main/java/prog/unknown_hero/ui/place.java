package prog.unknown_hero.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import prog.unknown_hero.utility.BaseMessage;
import prog.unknown_hero.utility.Sender;

public class place extends JFrame {
    	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int myOrder;

	ImageIcon card_back_img;
	ImageIcon[] hp_img = new ImageIcon[4];
	ImageIcon[] atk_img = new ImageIcon[14];
	ImageIcon[] def_img = new ImageIcon[4];
	ImageIcon[] cd_img = new ImageIcon[5];
	ImageIcon endButton_img;
	ImageIcon endButton_hov;
	ImageIcon spe_img;
	ImageIcon she_img;
	ImageIcon noweapon_img;
	
	ImageIcon dead_img;

	ImageIcon mag_img;
	ImageIcon sci_img;
	ImageIcon wor_img;
	ImageIcon grav_img;
	ImageIcon exg_img;
	ImageIcon copy_img;
	ImageIcon drug_img;
	ImageIcon recov_img;
	ImageIcon hback_img;
	ImageIcon spear_img;
	ImageIcon sheild_img;
	ImageIcon LLLW_img;
	ImageIcon LLWL_img;
	ImageIcon LLWW_img;
	ImageIcon LWLL_img;
	ImageIcon LWLW_img;
	ImageIcon LWWL_img;
	ImageIcon WLLL_img;
	ImageIcon WLLW_img;
	ImageIcon WLWL_img;
	ImageIcon WWLL_img;
	
	ImageIcon img2;
	ImageIcon img3;
	ImageIcon img4;
	ImageIcon img5;
	ImageIcon img6;
	ImageIcon img7;
	BufferedImage background;
	
	private boolean loadImages() {
		try {
			card_back_img = new ImageIcon("./img/BACK.jpg");
			for(int i=0; i<4; i++) {
				hp_img[i] = new ImageIcon("./img/HP-"+i+".jpg");
			}
			for(int i=0; i<14; i++) {
				atk_img[i] = new ImageIcon("./img/ATK-"+i+".jpg");
			}
			for(int i=0; i<4; i++) {
				def_img[i] = new ImageIcon("./img/DEF-"+i+".jpg");
			}
			for(int i=0; i<5; i++) {
				cd_img[i] = new ImageIcon("./img/CD-"+i+".jpg");
			}
			endButton_img = new ImageIcon("./img/END-BOTTON-NOT-CLICK.jpg");
			endButton_hov = new ImageIcon("./img/END-BOTTON-CLICK.jpg");
			spe_img = new ImageIcon("./img/WEAPON-長矛.jpg");
			she_img = new ImageIcon("./img/WEAPON-盾牌.jpg");
			noweapon_img = new ImageIcon("./img/WEAPON-無.jpg");

			dead_img = new ImageIcon("./img/DEAD.jpg");
			
			mag_img = new ImageIcon("./img/魔法師.jpg");
			sci_img = new ImageIcon("./img/科學家.jpg");
			wor_img = new ImageIcon("./img/工人.jpg");
			grav_img = new ImageIcon("./img/盜墓.jpg");
			exg_img = new ImageIcon("./img/交換.jpg");
			copy_img = new ImageIcon("./img/仿製.jpg");
			drug_img = new ImageIcon("./img/禁藥.jpg");
			recov_img = new ImageIcon("./img/回復.jpg");
			hback_img = new ImageIcon("./img/反擊.jpg");
			spear_img = new ImageIcon("./img/長矛.jpg");
			sheild_img = new ImageIcon("./img/盾牌.jpg");

			LLLW_img = new ImageIcon("./img/LLLW.jpg");
			LLWL_img = new ImageIcon("./img/LLLW.jpg");
			LLWW_img = new ImageIcon("./img/LLLW.jpg");
			LWLL_img = new ImageIcon("./img/LLLW.jpg");
			LWLW_img = new ImageIcon("./img/LLLW.jpg");
			LWWL_img = new ImageIcon("./img/LLLW.jpg");
			WLLL_img = new ImageIcon("./img/LLLW.jpg");
			WLLW_img = new ImageIcon("./img/LLLW.jpg");
			WLWL_img = new ImageIcon("./img/LLLW.jpg");
			WWLL_img = new ImageIcon("./img/LLLW.jpg");

			img2 = new ImageIcon("./img/ATK-13.jpg");
			img3 = new ImageIcon("./img/HP-3.jpg");
			img4 = new ImageIcon("./img/WEAPON-無.jpg");
			img5 = new ImageIcon("./img/DEF+0.jpg");
			img6 = new ImageIcon("./img/END-BOTTON-NOT-CLICK.jpg");

			img7 = new ImageIcon("./img/CD-3.jpg");
			
			background = ImageIO.read(new File("./img/BG-1.jpg"));

		} catch(IOException ex) {
			return false;
		}
		return true;
	}

	public place() {
		myOrder = 0;
		
		if(!loadImages()) {
			return;
		}
        
        setSize(805, 635);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new ImagePanel(background);
        setContentPane(panel);
		setResizable(false);
        panel.setLayout(new GridBagLayout());

        //=========================================================== enemy1
        JButton[] heroB = new JButton[4];
        JLabel[] hpB = new JLabel[4];
        JLabel[] atkB = new JLabel[4];
        JLabel[] defB = new JLabel[4];
        JLabel[] cardnum = new JLabel[4];
        JLabel[] weapon = new JLabel[4];
        JButton end_button = new JButton(img6);
        
        GridBagConstraints[] heroC = new GridBagConstraints[4];
        GridBagConstraints[] hpC = new GridBagConstraints[4];
        GridBagConstraints[] atkC = new GridBagConstraints[4];
        GridBagConstraints[] defC = new GridBagConstraints[4];
        GridBagConstraints[] cardnumC = new GridBagConstraints[4];
        GridBagConstraints[] weaponC = new GridBagConstraints[4];
        GridBagConstraints end_buttonC = new GridBagConstraints();
        
        for(int i=0; i<4; i++) {
        	heroB[i] = new JButton(card_back_img);
            hpB[i] = new JLabel(img3);
            atkB[i] = new JLabel(img2);
            defB[i] = new JLabel(img5);
            cardnum[i] = new JLabel(img7);
            weapon[i] = new JLabel(img4);
            heroB[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}
            	
            });
            
        	if(i == myOrder) {	//me
        		heroC[i] = new GridBagConstraints();
        		heroC[i].gridx = 6;
        		heroC[i].gridy = 10;
        		heroC[i].gridwidth = 1;
        		heroC[i].gridheight = 4;
        		heroC[i].weightx = 0;
        		heroC[i].weighty = 0;
        		heroC[i].fill = GridBagConstraints.NONE;
        		heroC[i].anchor = GridBagConstraints.CENTER;
        		hpC[i] = new GridBagConstraints();
                hpC[i].gridx = 5;
                hpC[i].gridy = 10;
                hpC[i].gridwidth = 1;
                hpC[i].gridheight = 1;
                hpC[i].weightx = 0;
                hpC[i].weighty = 0;
                hpC[i].fill = GridBagConstraints.NONE;
                hpC[i].anchor = GridBagConstraints.EAST;
                atkC[i] = new GridBagConstraints();
                atkC[i].gridx = 5;
                atkC[i].gridy = 11;
                atkC[i].gridwidth = 1;
                atkC[i].gridheight = 1;
                atkC[i].weightx = 0;
                atkC[i].weighty = 0;
                atkC[i].fill = GridBagConstraints.NONE;
                atkC[i].anchor = GridBagConstraints.EAST;
                defC[i] = new GridBagConstraints();
                defC[i].gridx = 5;
                defC[i].gridy = 12;
                defC[i].gridwidth = 1;
                defC[i].gridheight = 1;
                defC[i].weightx = 0;
                defC[i].weighty = 0;
                defC[i].fill = GridBagConstraints.NONE;
                defC[i].anchor = GridBagConstraints.EAST;
                weaponC[i] = new GridBagConstraints();
                weaponC[i].gridx = 5;
                weaponC[i].gridy = 13;
                weaponC[i].gridwidth = 1;
                weaponC[i].gridheight = 1;
                weaponC[i].weightx = 0;
                weaponC[i].weighty = 0;
                weaponC[i].fill = GridBagConstraints.NONE;
                weaponC[i].anchor = GridBagConstraints.EAST;
                end_buttonC.gridx = 6;
                end_buttonC.gridy = 14;
                end_buttonC.gridwidth = 1;
                end_buttonC.gridheight = 1;
                end_buttonC.weightx = 0;
                end_buttonC.weighty = 0;
                end_buttonC.fill = GridBagConstraints.NONE;
                end_buttonC.anchor = GridBagConstraints.NORTH;
        	} else if(i == (myOrder+1)%4) {
        		heroC[i] = new GridBagConstraints();
        		heroC[i].gridx = 2;
        		heroC[i].gridy = 0;
        		heroC[i].gridwidth = 1;
        		heroC[i].gridheight = 4;
        		heroC[i].weightx = 0;
        		heroC[i].weighty = 0;
        		heroC[i].fill = GridBagConstraints.NONE;
        		heroC[i].anchor = GridBagConstraints.CENTER;
        		hpC[i] = new GridBagConstraints();
                hpC[i].gridx = 1;
                hpC[i].gridy = 0;
                hpC[i].gridwidth = 1;
                hpC[i].gridheight = 1;
                hpC[i].weightx = 0;
                hpC[i].weighty = 0;
                hpC[i].fill = GridBagConstraints.NONE;
                hpC[i].anchor = GridBagConstraints.EAST;
                atkC[i] = new GridBagConstraints();
                atkC[i].gridx = 1;
                atkC[i].gridy = 2;
                atkC[i].gridwidth = 1;
                atkC[i].gridheight = 1;
                atkC[i].weightx = 0;
                atkC[i].weighty = 0;
                atkC[i].fill = GridBagConstraints.NONE;
                atkC[i].anchor = GridBagConstraints.EAST;
                defC[i] = new GridBagConstraints();
                defC[i].gridx = 1;
                defC[i].gridy = 3;
                defC[i].gridwidth = 1;
                defC[i].gridheight = 1;
                defC[i].weightx = 0;
                defC[i].weighty = 0;
                defC[i].fill = GridBagConstraints.NONE;
                defC[i].anchor = GridBagConstraints.EAST;
                cardnumC[i] = new GridBagConstraints();
                cardnumC[i].gridx = 1;
                cardnumC[i].gridy = 1;
                cardnumC[i].gridwidth = 1;
                cardnumC[i].gridheight = 1;
                cardnumC[i].weightx = 0;
                cardnumC[i].weighty = 0;
                cardnumC[i].fill = GridBagConstraints.NONE;
                cardnumC[i].anchor = GridBagConstraints.EAST;
                weaponC[i] = new GridBagConstraints();
                weaponC[i].gridx = 2;
                weaponC[i].gridy = 4;
                weaponC[i].gridwidth = 1;
                weaponC[i].gridheight = 1;
                weaponC[i].weightx = 0;
                weaponC[i].weighty = 0;
                weaponC[i].fill = GridBagConstraints.NONE;
                weaponC[i].anchor = GridBagConstraints.CENTER;
        	} else if(i == (myOrder+2)%4) {
        		heroC[i] = new GridBagConstraints();
        		heroC[i].gridx = 4;
        		heroC[i].gridy = 0;
        		heroC[i].gridwidth = 1;
        		heroC[i].gridheight = 4;
        		heroC[i].weightx = 0;
        		heroC[i].weighty = 0;
        		heroC[i].fill = GridBagConstraints.NONE;
        		heroC[i].anchor = GridBagConstraints.CENTER;
        		hpC[i] = new GridBagConstraints();
                hpC[i].gridx = 3;
                hpC[i].gridy = 0;
                hpC[i].gridwidth = 1;
                hpC[i].gridheight = 1;
                hpC[i].weightx = 0;
                hpC[i].weighty = 0;
                hpC[i].fill = GridBagConstraints.NONE;
                hpC[i].anchor = GridBagConstraints.EAST;
                atkC[i] = new GridBagConstraints();
                atkC[i].gridx = 3;
                atkC[i].gridy = 2;
                atkC[i].gridwidth = 1;
                atkC[i].gridheight = 1;
                atkC[i].weightx = 0;
                atkC[i].weighty = 0;
                atkC[i].fill = GridBagConstraints.NONE;
                atkC[i].anchor = GridBagConstraints.EAST;
                defC[i] = new GridBagConstraints();
                defC[i].gridx = 3;
                defC[i].gridy = 3;
                defC[i].gridwidth = 1;
                defC[i].gridheight = 1;
                defC[i].weightx = 0;
                defC[i].weighty = 0;
                defC[i].fill = GridBagConstraints.NONE;
                defC[i].anchor = GridBagConstraints.EAST;
                cardnumC[i] = new GridBagConstraints();
                cardnumC[i].gridx = 3;
                cardnumC[i].gridy = 1;
                cardnumC[i].gridwidth = 1;
                cardnumC[i].gridheight = 1;
                cardnumC[i].weightx = 0;
                cardnumC[i].weighty = 0;
                cardnumC[i].fill = GridBagConstraints.NONE;
                cardnumC[i].anchor = GridBagConstraints.EAST;
                weaponC[i] = new GridBagConstraints();
                weaponC[i].gridx = 4;
                weaponC[i].gridy = 4;
                weaponC[i].gridwidth = 1;
                weaponC[i].gridheight = 1;
                weaponC[i].weightx = 0;
                weaponC[i].weighty = 0;
                weaponC[i].fill = GridBagConstraints.NONE;
                weaponC[i].anchor = GridBagConstraints.CENTER;
        	} else if(i == (myOrder+3)%4) {
        		heroC[i] = new GridBagConstraints();
        		heroC[i].gridx = 6;
        		heroC[i].gridy = 0;
        		heroC[i].gridwidth = 1;
        		heroC[i].gridheight = 4;
        		heroC[i].weightx = 0;
        		heroC[i].weighty = 0;
        		heroC[i].fill = GridBagConstraints.NONE;
        		heroC[i].anchor = GridBagConstraints.CENTER;
        		hpC[i] = new GridBagConstraints();
                hpC[i].gridx = 5;
                hpC[i].gridy = 0;
                hpC[i].gridwidth = 1;
                hpC[i].gridheight = 1;
                hpC[i].weightx = 0;
                hpC[i].weighty = 0;
                hpC[i].fill = GridBagConstraints.NONE;
                hpC[i].anchor = GridBagConstraints.EAST;
                atkC[i] = new GridBagConstraints();
                atkC[i].gridx = 5;
                atkC[i].gridy = 2;
                atkC[i].gridwidth = 1;
                atkC[i].gridheight = 1;
                atkC[i].weightx = 0;
                atkC[i].weighty = 0;
                atkC[i].fill = GridBagConstraints.NONE;
                atkC[i].anchor = GridBagConstraints.EAST;
                defC[i] = new GridBagConstraints();
                defC[i].gridx = 5;
                defC[i].gridy = 3;
                defC[i].gridwidth = 1;
                defC[i].gridheight = 1;
                defC[i].weightx = 0;
                defC[i].weighty = 0;
                defC[i].fill = GridBagConstraints.NONE;
                defC[i].anchor = GridBagConstraints.EAST;
                cardnumC[i] = new GridBagConstraints();
                cardnumC[i].gridx = 5;
                cardnumC[i].gridy = 1;
                cardnumC[i].gridwidth = 1;
                cardnumC[i].gridheight = 1;
                cardnumC[i].weightx = 0;
                cardnumC[i].weighty = 0;
                cardnumC[i].fill = GridBagConstraints.NONE;
                cardnumC[i].anchor = GridBagConstraints.EAST;
                weaponC[i] = new GridBagConstraints();
                weaponC[i].gridx = 6;
                weaponC[i].gridy = 4;
                weaponC[i].gridwidth = 1;
                weaponC[i].gridheight = 1;
                weaponC[i].weightx = 0;
                weaponC[i].weighty = 0;
                weaponC[i].fill = GridBagConstraints.NONE;
                weaponC[i].anchor = GridBagConstraints.CENTER;
        	}
            panel.add(heroB[i], heroC[i]);
            panel.add(hpB[i], hpC[i]);
            panel.add(atkB[i], atkC[i]);
            panel.add(defB[i], defC[i]);
            panel.add(cardnum[i], cardnumC[i]);
            panel.add(weapon[i], weaponC[i]);
            panel.add(end_button, end_buttonC);
        }

          JLabel ne = new JLabel();
          GridBagConstraints ce = new GridBagConstraints();
          ce.gridx = 0;
          ce.gridy = 5;
          ce.gridwidth = 1;
          ce.gridheight = 1;
          ce.weightx = 0;
          ce.weighty = 1;
          ce.fill = GridBagConstraints.NONE;
          ce.anchor = GridBagConstraints.SOUTH;
          panel.add(ne, ce);
          
          JButton[] hand = new JButton[4];
          GridBagConstraints[] handC = new GridBagConstraints[4];
          for(int i=0; i<4; i++){
        	  hand[i] = new JButton(card_back_img);
        	  handC[i] = new GridBagConstraints();
        	  handC[i].gridx = i;
        	  handC[i].gridy = 11;
        	  handC[i].gridwidth = 1;
        	  handC[i].gridheight = 3;
        	  handC[i].weightx = 0;
        	  handC[i].weighty = 0;
        	  handC[i].fill = GridBagConstraints.NONE;
        	  handC[i].anchor = GridBagConstraints.CENTER;
              panel.add(hand[i], handC[i]);
          }
   
          JLabel Ninfo = new JLabel("QAQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
          GridBagConstraints Cinfo = new GridBagConstraints();
          Cinfo.gridx = 2;
          Cinfo.gridy = 5;
          Cinfo.gridwidth = 4;
          Cinfo.gridheight = 1;
          Cinfo.weightx = 0;
          Cinfo.weighty = 0;
          Cinfo.fill = GridBagConstraints.NONE;
          Cinfo.anchor = GridBagConstraints.CENTER;
          panel.add(Ninfo, Cinfo);
          
          setVisible(true);
          
          Thread detector = new Thread(new Runnable() {

        	public void run() {
        		  if(Sender.hasMessage()) {
        			  BaseMessage message = Sender.get();
        			  String type = message.type();
        			  String[] contents = message.content();
        			  int i, j;
        			  if("INITED".equals(type)) {
        				  myOrder = Integer.parseInt(contents[0]);
        		  	  } else if("SETHAND".equals(type)) {
        				  for(i=0; i<contents.length; i++) {
        					  switch(Integer.parseInt(contents[i])) {
        					  case 0:
        						  hand[i].setIcon(mag_img);
        						  break;
        					  case 1:
        						  hand[i].setIcon(sci_img);
        						  break;
        					  case 2:
        						  hand[i].setIcon(wor_img);
        						  break;
        					  case 3:
        						  hand[i].setIcon(grav_img);
        						  break;
        					  case 4:
        						  hand[i].setIcon(exg_img);
        						  break;
        					  case 5:
        						  hand[i].setIcon(copy_img);
        						  break;
        					  case 6:
        						  hand[i].setIcon(drug_img);
        						  break;
        					  case 7:
        						  hand[i].setIcon(recov_img);
        						  break;
        					  case 8:
        						  hand[i].setIcon(hback_img);
        						  break;
        					  case 9:
        						  hand[i].setIcon(spear_img);
        						  break;
        					  case 10:
        						  hand[i].setIcon(sheild_img);
        						  break;
        					  }
        				  }
        				  for(j = i; j<4; j++) {
        					  hand[i].setIcon(card_back_img);
        				  }
        			  } else if("SETHERO".equals(type)) {
        				  int player = Integer.parseInt(contents[0]);
        				  int card = Integer.parseInt(contents[1]);
        				  if(player == 4) {
        					  System.out.println("The hero is still in the deck.");
        				  } else {
        					  switch(card) {
        					  case 0:
        						  heroB[player].setIcon(mag_img);
        						  break;
        					  case 1:
        						  heroB[player].setIcon(sci_img);
        						  break;
        					  case 2:
        						  heroB[player].setIcon(wor_img);
        						  break;
        					  }
        				  }
        			  } else if("SETHP".equals(type)) {
        				  int player = Integer.parseInt(contents[0]);
        				  int hp = Integer.parseInt(contents[1]);
    					  hpB[player].setIcon(hp_img[hp]);
        			  } else if("SETAP".equals(type)) {
        				  int player = Integer.parseInt(contents[0]);
        				  int atk = Integer.parseInt(contents[1]);
        				  atkB[player].setIcon(hp_img[atk]);
        			  } else if("SETDP".equals(type)) {
        				  int player = Integer.parseInt(contents[0]);
        				  int def = Integer.parseInt(contents[1]);
    					  defB[player].setIcon(hp_img[def]);
        			  } else if("DELWP".equals(type)) {
        				  int player = Integer.parseInt(contents[0]);
    					  weapon[player].setIcon(noweapon_img);
        			  } else if("SETINFO".equals(type)) {
        				  Ninfo.setText(contents[0]);
        			  } else if("SETHANDN".equals(type)) {
        				  int player = Integer.parseInt(contents[0]);
        				  int cn = Integer.parseInt(contents[1]);
        				  cardnum[player].setIcon(cd_img[cn]);
        			  }
        		  }
        		  try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
       	  
          });
          
          detector.start();
	}

}
