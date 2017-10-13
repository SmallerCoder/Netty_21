package club.wokao666.www.client;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.jboss.netty.util.CharsetUtil;

import club.wokao666.www.frame.main.MainFrame;
import club.wokao666.www.model.GenerateCard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class Client {
	
	
	private static int count = 0;
	private static int okCount = 1;
	public static int getOkCount() {
		return okCount;
	}
	public static void setOkCount(int okCount) {
		Client.okCount = okCount;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Client.count = count;
	}

	private static ChannelFuture connect;
	private static  Bootstrap bootstrap;
	
	public static ChannelFuture getConnect() {
		return connect;
	}

	public static Bootstrap getBootstrap() {
		return bootstrap;
	}

	public static void setBootstrap(Bootstrap bootstrap) {
		Client.bootstrap = bootstrap;
	}

	public static void setConnect(ChannelFuture connect) {
		Client.connect = connect;
	}

	public static Channel getMyChannel() {
		if(connect.channel()!=null){
		return connect.channel();
		}else{
			return null;
		}
	}

	public static void main(String[] args) {
		
		bootstrap = new Bootstrap();
		
		//worker
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try {
			bootstrap.group(worker);
			
			bootstrap.channel(NioSocketChannel.class);
			
			bootstrap.handler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel ch) throws Exception {
					ch.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
					ch.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
					ch.pipeline().addLast(new ClientHandler());
				}
			});
				new MainFrame().setVisible(true);
				connect = bootstrap.connect("172.18.34.110", 10101).sync();
				//总数-任意一张
				Client.getMyChannel().writeAndFlush(GenerateCard.getTwoCardNumber()+"-"+GenerateCard.getFirst()+"-"+GenerateCard.getThird()+"");
				connect.channel().closeFuture().sync();
		} catch (Exception e) {
			 e.printStackTrace();
		} finally{
			worker.shutdownGracefully();
		}
	}
}
