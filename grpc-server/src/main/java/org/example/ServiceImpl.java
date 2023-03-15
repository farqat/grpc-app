package org.example;

import io.grpc.stub.StreamObserver;

public class ServiceImpl extends ServiceGrpc.ServiceImplBase{

    @Override
    public void getData(ServiceOuterClass.Request request, StreamObserver<ServiceOuterClass.Response> responseObserver) {
        System.out.println(request);
        ServiceOuterClass.Response response = ServiceOuterClass.Response.newBuilder()
                .setId(request.getId())
                .setFirstname("Test")
                .setLastname("User")
                .setAge(25)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
