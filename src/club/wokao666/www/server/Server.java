package club.wokao666.www.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.jboss.netty.util.CharsetUtil;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class Server {
	
	private static List<String>  fen = new ArrayList<>();
	
	public static List<String> getFen() {
		return fen;
	}
	public static void setFen(List<String> fen) {
		Server.fen = fen;
	}
	private static int count = 0;
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Server.count = count;
	}
	/**
	 * 创建管道会话队列
	 */
	private static Queue<Channel> channelQueue = new LinkedList<>();
	private static Queue<Channel> copyChannelQueue = new LinkedList<>();
	
	
	private static List<Channel> usedChannel = new ArrayList<>();
	
	public static List<Channel> getUsedChannel() {
		return usedChannel;
	}
	public static void setUsedChannel(List<Channel> usedChannel) {
		Server.usedChannel = usedChannel;
	}
	public static Queue<Channel> getCopyChannelQueue() {
		return copyChannelQueue;
	}
	public static void setCopyChannelQueue(Queue<Channel> copyChannelQueue) {
		Server.copyChannelQueue = copyChannelQueue;
	}
	/**
	 * 创建ip地址映射线性表
	 */
	private static List<String> ipList = new ArrayList<>();
	
	public static Queue<Channel> getChannelQueue() {
		return channelQueue;
	}
	public static List<String> getIpList() {
		return ipList;
	}

	/**
	 * channel count 的映射表
	 */
	private static Map<Channel,String> countMap = new HashMap<>();
	
	public static Map<Channel, String> getCountMap() {
		return countMap;
	}
	
	/**
	 * channel 和 名牌的映射表 
	 */
	
	private static Map<Channel,String> paiMap = new HashMap<>();
	
	public static Map<Channel, String> getPaiMap() {
		return paiMap;
	}
	
	public static void main(String[] args) {
		ServerBootstrap bootstrap = new ServerBootstrap();
		
		//boss和worker
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try {
			bootstrap.group(boss, worker);
			
			bootstrap.channel(NioServerSocketChannel.class);
			
			bootstrap.childHandler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel ch) throws Exception {
					ch.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
					ch.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
					ch.pipeline().addLast(new ServerHandler());
				}
			});
			
			//设置参数，TCP参数
			bootstrap.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannel的设置，链接缓冲池的大小
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);//socketchannel的设�?,维持链接的活跃，清除死链�?
			bootstrap.childOption(ChannelOption.TCP_NODELAY, true);//socketchannel的设�?,关闭延迟发�??
			
			//绑定端口
			ChannelFuture future = bootstrap.bind(10101);
			
			System.out.println("start");
			
			future.channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//释放资源
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}
