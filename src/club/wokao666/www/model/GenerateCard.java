package club.wokao666.www.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import club.wokao666.www.client.Client;
import club.wokao666.www.frame.main.MainFrame;

public class GenerateCard {
	
	private static int first;
	private static int second;
	private static int third;
	
	private static int single;
	/*
	 * 点击开始游戏，随机生成两张图片
	 */
	
	public static int getFirst() {
		return first;
	}
	public static int getSecond() {
		return second;
	}
	public static int getThird() {
		return third;
	}
	/**
	 * 只生成头两张牌的号码，不画
	 * @return
	 */
	public static boolean generateImageNum(){
			first = (int)(Math.random()*13 + 1);
			second = (int)(Math.random()*13 + 1);
			third = (int)(Math.random()*4 + 1);
		return  true;
	}
	
	/**
	 * 画出头两张牌
	 * @throws IOException 
	 */
	
	public static void drawTwoImage() throws IOException{
		System.out.println("./images/" + first + "-" + third + ".jpg");
		System.out.println("./images/" + second + "-" + third + ".jpg");
		MainFrame.getJLabelByNum(18).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + first + "-" + third + ".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
		MainFrame.getJLabelByNum(19).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + second + "-" + third + ".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
	}
	
	/**
	 * 获得生成的两张牌的点数
	 * @param args
	 */
	public static int getTwoCardNumber(){
		if(first >= 10 ){
			first = 10;
		}
		if(second >= 10 ){
			second = 10;
		}
		return first + second ;
	}
	
	/*
	 * 根据摸牌的张数id获取点数
	 */
	
	public static int getNumberById(int id){
		int count = 0 ;
		int hello = 0 ;
		count = (int)(Math.random()*13 + 1);
		hello = (int)(Math.random()*4 + 1);
		try {
			MainFrame.getJLabelByNum(id).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + count + "-" + hello + ".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
			Client.getMyChannel().writeAndFlush(count+"-"+hello);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(count>=10){
			return 10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 300; i++) {
		System.out.println((int)(Math.random()*13 + 1) + "-" +(int) (Math.random()*4 + 1));
		
		}	}
	
	
}
