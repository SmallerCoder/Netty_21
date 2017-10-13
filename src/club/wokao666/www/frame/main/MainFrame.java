package club.wokao666.www.frame.main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import club.wokao666.www.client.Client;
import club.wokao666.www.model.GenerateCard;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JLabel lblNewLabel_2 ; 
	private static JLabel lblNewLabel_3 ; 
	private static JLabel lblNewLabel_4 ; 
	private static JLabel lblNewLabel_5 ; 
	private static JLabel lblNewLabel_6 ; 
	private static JLabel lblNewLabel_7 ; 
	private static JLabel lblNewLabel_8 ; 
	private static JLabel lblNewLabel_9 ; 
	private static JLabel lblNewLabel_10; 
	private static JLabel lblNewLabel_11 ; 
	private static JLabel lblNewLabel_12 ; 
	private static JLabel lblNewLabel_13 ; 
	private static JLabel lblNewLabel_14 ; 
	private static JLabel lblNewLabel_15 ; 
	private static JLabel lblNewLabel_16 ; 
	private static JLabel lblNewLabel_17 ; 
	private static JLabel lblNewLabel_18 ; 
	private static JLabel lblNewLabel_19 ; 
	private static JLabel lblNewLabel_20 ; 
	private static JLabel lblNewLabel_21 ; 
	private static JLabel lblNewLabel_22 ; 
	private static JLabel lblNewLabel_23 ; 
	private static JLabel lblNewLabel_24 ;
	private static JLabel lblNewLabel_25 ;
	private static JLabel lblNewLabel_26 ;
	private static JLabel lblNewLabel_27 ;
	
	
	private static JButton button_1;
	private static JButton button_2;
	private static JButton button_3;
	
	private static boolean isStart = false;
	
	
	public static boolean isStart() {
		return isStart;
	}

	public static void setStart(boolean isStart) {
		MainFrame.isStart = isStart;
	}
	public static JLabel getLblNewLabel_23() {
		return lblNewLabel_23;
	}
	//定义总点数
	private static int beginSum = 0;
	
	private static List<JLabel> JLabelList = new ArrayList<>();
	
	/**
	 * getter
	 * @return
	 */
	
	public static void setBeginSum(int beginSum) {
		MainFrame.beginSum = beginSum;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static int getBeginSum() {
		return beginSum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static List<JLabel> getJLabelList() {
		return JLabelList;
	}

	public static JButton getButton_1() {
		return button_1;
	}

	public static JButton getButton_2() {
		return button_2;
	}

	public static JButton getButton_3() {
		return button_3;
	}
	
	public static JLabel getJLabelByNum(int id){
		return getJLabelList().get(id-2);
	}
	
	
	
	/**
	 * add the label
	 */
	
	private static void add(){
		/**
		 * 将所有的JLabel放入列表中
		 */
		JLabelList.add(lblNewLabel_2);//0
		JLabelList.add(lblNewLabel_3);//1
		JLabelList.add(lblNewLabel_4);//2
		JLabelList.add(lblNewLabel_5);//3
		JLabelList.add(lblNewLabel_6);//4
		JLabelList.add(lblNewLabel_7);//5
		JLabelList.add(lblNewLabel_8);//6
		JLabelList.add(lblNewLabel_9);//7
		JLabelList.add(lblNewLabel_10);//8
		JLabelList.add(lblNewLabel_11);//9
		JLabelList.add(lblNewLabel_12);//10
		JLabelList.add(lblNewLabel_13);//11
		JLabelList.add(lblNewLabel_14);//12
		JLabelList.add(lblNewLabel_15);//13
		JLabelList.add(lblNewLabel_16);//14
		JLabelList.add(lblNewLabel_17);//15
		JLabelList.add(lblNewLabel_18);//16
		JLabelList.add(lblNewLabel_19);//17
		JLabelList.add(lblNewLabel_20);//18
		JLabelList.add(lblNewLabel_21);//19
		JLabelList.add(lblNewLabel_22);//20
		JLabelList.add(lblNewLabel_24);//21
		JLabelList.add(lblNewLabel_25);//22
		JLabelList.add(lblNewLabel_26);//23
		JLabelList.add(lblNewLabel_27);//24
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MainFrame()  {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 740);
		/*
		 * 中间位置
		 */
		Dimension screenSize = this.getToolkit().getScreenSize();
		int averageWidth = (int)((screenSize.getWidth()-970)/2);
		int averageHeight = (int)((screenSize.getHeight()-740)/2);
		setBounds(averageWidth, averageHeight, 970,740);
		
		JLabel backgroundImage = new JLabel();
		try {
			backgroundImage.setIcon(new ImageIcon(ImageIO.read(new File("./images/timg1.jpg")).getScaledInstance(950, 700, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		backgroundImage.setBounds(0, 0, 950, 700);
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		getContentPane().setLayout(null);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(70, 380, 40, 18);
		lblNewLabel_2.setText("$423");
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(870, 360, 40, 18);
		lblNewLabel_3.setText("$423");
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(70, 570, 40, 18);
		lblNewLabel_4.setText("$423");
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBounds(870, 580, 40, 18);
		lblNewLabel_5.setText("$423");
		getContentPane().add(lblNewLabel_5);

		/**
		 * 图片标签
		 */
		lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setBounds(210, 261, 90, 125);
		getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setBounds(190, 261, 90, 125);
		getContentPane().add(lblNewLabel_8);
		
		
		lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setBounds(170, 261, 90, 125);
		getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setBounds(150, 261, 90, 125);
		getContentPane().add(lblNewLabel_6);
		/**
		 * 第二组
		 */
		
		lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setBounds(710, 260, 90, 125);
		getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel();
		lblNewLabel_11.setBounds(690, 260, 90, 125);
		getContentPane().add(lblNewLabel_11);
		
		
		lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setBounds(670, 260, 90, 125);
		getContentPane().add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setBounds(650, 260, 90, 125);
		getContentPane().add(lblNewLabel_13);
		
		
		/**
		 * 第三组
		 */
		
		lblNewLabel_17 = new JLabel();
		lblNewLabel_17.setBounds(210, 558, 90, 125);
		getContentPane().add(lblNewLabel_17);
		
		lblNewLabel_16 = new JLabel();
		lblNewLabel_16.setBounds(190, 558, 90, 125);
		getContentPane().add(lblNewLabel_16);
		
		
		lblNewLabel_15 = new JLabel();
		lblNewLabel_15.setBounds(170, 558, 90, 125);
		getContentPane().add(lblNewLabel_15);
		
		
		lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setBounds(150, 558, 90, 125);
		getContentPane().add(lblNewLabel_14);
		
		
		/**
		 * 第四组
		 */
		
		lblNewLabel_18 = new JLabel();
		lblNewLabel_18.setBounds(730, 558, 90, 125);
		getContentPane().add(lblNewLabel_18);
		
		
		lblNewLabel_19 = new JLabel();
		lblNewLabel_19.setBounds(710, 558, 90, 125);
		getContentPane().add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel();
		lblNewLabel_20.setBounds(690, 558, 90, 125);
		getContentPane().add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel();
		lblNewLabel_21.setBounds(670, 558, 90, 125);
		getContentPane().add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel();
		lblNewLabel_22.setBounds(650, 558, 90, 125);
		getContentPane().add(lblNewLabel_22);
		
		/*
		 * 开始
		 */
		
		lblNewLabel_23 = new JLabel("开始游戏");
		lblNewLabel_23.setFont(new Font("你好", Font.PLAIN, 30));
		lblNewLabel_23.setBounds(410, 650, 128,37);
		lblNewLabel_23.setBorder(new TitledBorder(new EtchedBorder(),""));
		getContentPane().add(lblNewLabel_23);
		lblNewLabel_23.setVisible(false);
		
		/*
		 * 四个状态就绪标签
		 */
		lblNewLabel_24 = new JLabel();
		lblNewLabel_24.setFont(new Font("你好", Font.PLAIN, 15));
		lblNewLabel_24.setBounds(47, 270, 128,37);
		getContentPane().add(lblNewLabel_24);

		lblNewLabel_25 = new JLabel();
		lblNewLabel_25.setFont(new Font("你好", Font.PLAIN, 15));
		lblNewLabel_25.setBounds(845, 255, 128,37);
		getContentPane().add(lblNewLabel_25);
		
		lblNewLabel_26 = new JLabel();
		lblNewLabel_26.setFont(new Font("你好", Font.PLAIN, 15));
		lblNewLabel_26.setBounds(47, 660, 128,37);
		getContentPane().add(lblNewLabel_26);
		
		lblNewLabel_27 = new JLabel("准备就绪");
		lblNewLabel_27.setFont(new Font("你好", Font.PLAIN, 15));
		lblNewLabel_27.setBounds(845, 665, 128,37);
		getContentPane().add(lblNewLabel_27);
		
		/**
		 * 按钮组
		 */
	    button_1 = new JButton("摸牌");
		button_1.setBounds(333, 600, 75,30);
		button_1.setVisible(false);
		getContentPane().add(button_1);
		
		button_2 = new JButton("开牌");
		button_2.setBounds(437, 600, 75,30);
		button_2.setVisible(false);
		getContentPane().add(button_2);
		
		button_3 = new JButton("加注");
		button_3.setBounds(541, 600, 75,30);
		button_3.setVisible(false);
		getContentPane().add(button_3);
		
		add();
		//生成号码
		GenerateCard.generateImageNum();
		System.out.println("enen:"+GenerateCard.getFirst() + "-" + GenerateCard.getSecond()+"-"+GenerateCard.getThird());
		MainFrame.setBeginSum(GenerateCard.getTwoCardNumber());
		System.out.println("zongshu "+beginSum);
		
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(backgroundImage,new Integer(Integer.MIN_VALUE));
		this.setResizable(false);
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getX() + "," + e.getY());
				super.mouseClicked(e);
			}

		});
		
		
		/**
		 * 当点击了该按钮，会摸一张牌，如果点数大于21，则按钮消失，显示“开牌按钮”
		 */
		button_1.addMouseListener(new MouseAdapter() {
			
			//定义点击按钮次数，最多点3次
			int count = 0;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				count ++;
				if(count <= 3){
					beginSum += GenerateCard.getNumberById(19+count);
					lblNewLabel_27.setText("点数：" + beginSum);
					 if(beginSum>=21){
						 lblNewLabel_27.setText("点数：" + beginSum);
						 button_1.setVisible(false); 
					 }
					 if (beginSum>=16) {
						button_2.setVisible(true);
					}
				}else{
					button_1.setVisible(false);
				}
				super.mouseClicked(e);
			}
			
		});
		button_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				Client.getMyChannel().writeAndFlush("OVER"+beginSum);
				button_1.setVisible(false);
				button_2.setVisible(false);
			};
		});
		
		lblNewLabel_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				button_1.setVisible(true);
				isStart = true;
				if(beginSum>=16){
					button_2.setVisible(true);
				}
				Client.getMyChannel().writeAndFlush("OK");
				lblNewLabel_23.setVisible(false);
				super.mouseClicked(e);
			}
		});
	}
}
