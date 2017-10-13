package club.wokao666.www.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.awt.Image;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import club.wokao666.www.frame.main.MainFrame;
import club.wokao666.www.model.GenerateCard;

public class ClientHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg)
			throws Exception {

		System.out.println("客户端接收到：" + msg);

		if (msg.equals("2")) {
			MainFrame.getJLabelByNum(23).setText("准备就绪");
		}
		if (msg.equals("3")) {
			MainFrame.getJLabelByNum(23).setText("准备就绪");
			MainFrame.getJLabelByNum(24).setText("准备就绪");
		}
		if (msg.equals("4")) {
			MainFrame.getJLabelByNum(23).setText("准备就绪");
			MainFrame.getJLabelByNum(24).setText("准备就绪");
			MainFrame.getJLabelByNum(25).setText("准备就绪");
		}
		if (msg.equals("5")) {
			MainFrame.getJLabelByNum(23).setText("");
			MainFrame.getJLabelByNum(24).setText("");
			MainFrame.getJLabelByNum(25).setText("");
			MainFrame.getJLabelByNum(26).setText("");
			if (MainFrame.isStart()) {
				GenerateCard.drawTwoImage();
				MainFrame.getButton_1().setVisible(true);
			} else {
				GenerateCard.drawTwoImage();
				MainFrame.getLblNewLabel_23().setVisible(true);
				// MainFrame.getButton_1().setVisible(true);
			}
		}

		/**
		 * 名牌拆解
		 */

		if (msg.matches("\\d+-\\d+-\\d+-\\d+-\\d+-\\d+-\\d")) {

			Matcher m = Pattern.compile("\\d+-\\d+-").matcher(msg);
			String finalTest = msg.substring(msg.length() - 1, msg.length());

			int i = 2;
			while (m.find()) {
				i = i + 4;
				MainFrame.getJLabelByNum(i).setIcon(
						new ImageIcon(ImageIO.read(
								new File("./images/"
										+ m.group().substring(0,
												m.group().length() - 1)
										+ ".jpg")).getScaledInstance(90, 125,
								Image.SCALE_AREA_AVERAGING)));
				;
			}

			switch (finalTest) {
			case "1":
				ctx.channel().writeAndFlush("OK_1");
				break;
			case "2":
				ctx.channel().writeAndFlush("OK_2");
				break;
			case "3":
				ctx.channel().writeAndFlush("OK_3");
				break;
			case "4":
				ctx.channel().writeAndFlush("OK_4");
				break;
			default:
				break;
			}
		}
		if (msg.equals("OKL")) {
			MainFrame.getButton_1().setVisible(true);
		}

		if (msg.equals("OK")) {
			Client.setOkCount(Client.getOkCount()+1);
			Client.setCount(0);
		}

		if(msg.matches("\\d+-\\d")){
			switch (Client.getOkCount()) {
			case 1:
				Client.setCount(Client.getCount()+1);
				switch (Client.getCount()) {
				case 1:
					MainFrame.getJLabelByNum(7).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				case 2:
					MainFrame.getJLabelByNum(8).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				case 3:
					MainFrame.getJLabelByNum(9).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				}
				break;
			case 2 :
				Client.setCount(Client.getCount()+1);
				switch (Client.getCount()) {
				case 1:
					MainFrame.getJLabelByNum(11).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				case 2:
					MainFrame.getJLabelByNum(12).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				case 3:
					MainFrame.getJLabelByNum(13).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				}
				break;
			case 3 :
				Client.setCount(Client.getCount()+1);
				switch (Client.getCount()) {
				case 1:
					MainFrame.getJLabelByNum(15).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				case 2:
					MainFrame.getJLabelByNum(16).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				case 3:
					MainFrame.getJLabelByNum(17).setIcon(new ImageIcon(ImageIO.read(new File("./images/" + msg+".jpg")).getScaledInstance(90, 125, Image.SCALE_AREA_AVERAGING)));
					break;
				}
				break;
			}
		}
	}
}
