package com.example.work03;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

public class ProxyBizFilter implements HttpRequestFilter{

	@Override
	public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
		String url=fullRequest.getUri();
		  System.out.println(" filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx)接收到的请求,url: " + url);
		  if(url.startsWith("/hello")){
			  
		  } else {
	            throw new RuntimeException("不支持的uri:" + url);
	        }
		  HttpHeaders headers = fullRequest.headers();
	        if (headers == null) {
	            headers = new DefaultHttpHeaders();
	        }
	        headers.add("proxy-tag", this.getClass().getSimpleName());
	}

}
