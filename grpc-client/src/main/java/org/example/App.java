package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090").usePlaintext().build();
        ServiceGrpc.ServiceBlockingStub stub = ServiceGrpc.newBlockingStub(channel);
        ServiceOuterClass.Request request = ServiceOuterClass.Request.newBuilder().setId(7).build();
        ServiceOuterClass.Response response = stub.getData(request);
        System.out.println(response);
        channel.shutdownNow();
    }
}
