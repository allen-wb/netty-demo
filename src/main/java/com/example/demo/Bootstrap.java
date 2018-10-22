package com.example.demo;

import com.example.demo.exception.ExceptionHandler;
import com.example.demo.rest.JDApplyResource;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

/**
 * Created on 18/10/22
 *
 * @author wb
 */
public class Bootstrap {

    public static void main(String[] args) {

        NettyJaxrsServer nettyJaxrsServer = new NettyJaxrsServer();
        ResteasyDeployment deployment = new ResteasyDeployment();
        //接口路径
        deployment.getResources().add(new JDApplyResource());
        //异常处理
        deployment.getProviders().add(new ExceptionHandler());
        nettyJaxrsServer.setExecutorThreadCount(500);
        nettyJaxrsServer.setDeployment(deployment);
        //端口
        nettyJaxrsServer.setPort(Integer.valueOf("8888"));
        nettyJaxrsServer.setRootResourcePath("/");
        nettyJaxrsServer.start();

//        TaskExecutor taskExecutor = new TaskExecutor();
//        taskExecutor.execute();
    }

}
