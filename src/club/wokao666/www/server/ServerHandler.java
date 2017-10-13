package club.wokao666.www.server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
/**
 * 服务端消息处理
 * @author -琴兽-
 *
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {
	

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg)
			throws Exception {
		System.out.println("msg=" + msg);
		/**
		 * 将最开始的两张牌的和保存
		 */
		if (msg.matches("\\d+-\\d+-\\d")) {
			Matcher m = Pattern.compile("\\d+").matcher(msg);
			while (m.find()) {
				System.out.println(m.group(0));
				Server.getCountMap().put(ctx.channel(), m.group(0));
				break;
			}
			// 保存名牌
			Matcher m_1 = Pattern.compile("-\\d+-\\d").matcher(msg);
			while (m_1.find()) {
				System.out.println(m_1.group(0));
				Server.getPaiMap().put(ctx.channel(),
						m_1.group(0).substring(1, m_1.group().length()));
				break;
			}
		}
		for (Channel channel : Server.getChannelQueue()) {
			System.out.println("和为" + Server.getCountMap().get(channel));
			System.out.println("mingpai:" + Server.getPaiMap().get(channel));
		}

		if (msg.equals("OK")) {
			String mess = "";
			int count = 0;
			int index = 0;
			for (Channel chann : Server.getChannelQueue()) {
				if (chann != ctx.channel()) {
					mess = mess + Server.getPaiMap().get(chann) + "-";
				} else {
					index = ++count;
					continue;
				}
				count++;
			}
			System.out.println("mess = " + mess);
			System.out.println("mess + count = " + mess + index);

			for (Channel channel : Server.getChannelQueue()) {
				if (channel == ctx.channel()) {
					channel.writeAndFlush(mess + index);
					break;
				}
			}
		}

		switch (msg) {
		case "OK_1":
			Server.setCount(Server.getCount()+1);
			//开局
			if(Server.getCount()==4){
				//获取第一个回话
				Channel channel = Server.getCopyChannelQueue().poll();
				channel.writeAndFlush("OKL");
				Server.setCount(0);
			}
			break;
		case "OK_2":
			Server.setCount(Server.getCount()+1);
			if(Server.getCount()==4){
				//获取第一个回话
				Channel channel = Server.getCopyChannelQueue().poll();
				channel.writeAndFlush("OKL");
				Server.setCount(0);
			}
			break;
		case "OK_3":
			Server.setCount(Server.getCount()+1);
			if(Server.getCount()==4){
				//获取第一个回话
				Channel channel = Server.getCopyChannelQueue().poll();
				channel.writeAndFlush("OKL");
				Server.setCount(0);
			}
			break;
		case "OK_4":
			Server.setCount(Server.getCount()+1);
			if(Server.getCount()==4){
				//获取第一个回话
				Channel channel = Server.getCopyChannelQueue().poll();
				channel.writeAndFlush("OKL");
				Server.setCount(0);
			}
			break;
		default:
			break;
		}
		
		if(msg.matches("OVER\\d+")){
			System.out.println("pipei");
			Server.getFen().add(msg.substring(4,msg.length()));
			Runnable t = new  Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (Channel w : Server.getChannelQueue()) {
						if (!Server.getCopyChannelQueue().contains(w)) {
							if (!Server.getUsedChannel().contains(w)) {
								Server.getUsedChannel().add(w);
							}else{
								w.writeAndFlush("OK");
							}
						}else{
						w.writeAndFlush("OK");
						}
					}
				}
			};
			Thread h = new Thread(t);
			h.start();
			h.join(2000);
			Channel channel = Server.getCopyChannelQueue().poll();
			if(channel!=null)
			channel.writeAndFlush("OKL");
			Server.setCount(Server.getCount()+1);
			//TODO 比较分数的高低
//			if(Server.getCount()==4){
//				int one = Integre
//			}
		}
		
		for (String e : Server.getFen()) {
			System.out.println("fenshu:" + e);
		}
		
		if(msg.matches("\\d+-\\d")){
			for (Channel channel : Server.getChannelQueue()) {
				if(channel!=ctx.channel())
				channel.writeAndFlush(msg);
			}
		}
	}
	/**
	 * 新客户端接入
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
	/**
	 * 保存 ip地址 
	 */
	Matcher m =  Pattern.compile("\\d+.\\d+.\\d+.\\d+").matcher(ctx.channel().remoteAddress().toString());
	
	while (m.find()) {
		System.out.println(m.group());
		if (!Server.getIpList().contains(m.group())) {
			Server.getIpList().add(m.group());
		}
	}
		/**
		 * 如果有新的链接进来，我们就保存该链接对应的会话channel,并发送有多少个客户端进来了
		 */
		System.out.println("这次的 channel是：" + ctx.channel());
		if(!Server.getChannelQueue().contains(ctx.channel())){
			
			Server.getChannelQueue().offer(ctx.channel());
			Server.getCopyChannelQueue().offer(ctx.channel());
			System.out.println("size:"+Server.getChannelQueue().size());
			//会自动从头开始遍历
			for (Channel channel : Server.getChannelQueue()) {
				System.out.println("channel = "+channel);
				
				if(Server.getChannelQueue().size()==4){
					System.out.println("队列长度："+Server.getCopyChannelQueue().size());
					System.out.println("channel,channel = "+channel);
					for (Channel channel_1 : Server.getChannelQueue()) {
					channel_1.writeAndFlush(5+"");
					}
					break;
				}else{
					channel.writeAndFlush(Server.getChannelQueue().size()+"");
				}
			}
			
		}
	}
	/**
	 * 客户端断开
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelInactive");
		Server.getChannelQueue().remove(ctx.channel());
	}

	/**
	 * 异常
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
System.out.println("连接关闭了");
	}
	
	
}
