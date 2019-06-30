package com.yzy.grpc;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author You
 * @create 2019-06-30 18:14
 */
public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        System.out.println("Server Start !");
        this.server = ServerBuilder.forPort(8899).addService((BindableService) new PersonServiceImpl()).build().start();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("close JVM");
            stop();
        }));

        System.out.println("run here");
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException {
        if (server != null) {
//            server.awaitTermination(3000,TimeUnit.MILLISECONDS);
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }
}
