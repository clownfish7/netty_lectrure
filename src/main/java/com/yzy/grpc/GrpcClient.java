package com.yzy.grpc;

import com.yzy.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

/**
 * @author You
 * @create 2019-06-30 20:02
 */
@SuppressWarnings("all")
public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();

        PersonServiceGrpc.PersonServiceBlockingStub blockingStub = PersonServiceGrpc.newBlockingStub(managedChannel);
        PersonServiceGrpc.PersonServiceStub stub = PersonServiceGrpc.newStub(managedChannel);
        MyResponse response = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("友友友").build());
        System.out.println(response.getRealname());

        System.out.println("--------------------------------------------");

        Iterator<PersonResponse> personByAge = blockingStub.getPersonByAge(PersonRequest.newBuilder().setAge(1).build());
        while (personByAge.hasNext()) {
            PersonResponse personResponse = personByAge.next();
            System.out.println(personResponse.getName());
            System.out.println(personResponse.getAge());
            System.out.println(personResponse.getCity());
        }

        System.out.println("--------------------------------------------");

        StreamObserver<PersonResponseList> personResponseListStreamObserver = new StreamObserver<PersonResponseList>() {
            @Override
            public void onNext(PersonResponseList value) {
                value.getPersonResponseList().forEach(personResponse -> {
                    System.out.println(personResponse.getName());
                    System.out.println(personResponse.getAge());
                    System.out.println(personResponse.getCity());
                    System.out.println("----------------");
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed!");
            }
        };

        StreamObserver<PersonRequest> personRequestStreamObserver = stub.getPersonWapperByAges(personResponseListStreamObserver);
        personRequestStreamObserver.onNext(PersonRequest.newBuilder().setAge(1).build());
        personRequestStreamObserver.onNext(PersonRequest.newBuilder().setAge(2).build());
        personRequestStreamObserver.onNext(PersonRequest.newBuilder().setAge(3).build());
        personRequestStreamObserver.onNext(PersonRequest.newBuilder().setAge(4).build());
        personRequestStreamObserver.onCompleted();

        Thread.sleep(50000);

        System.out.println("--------------------------------------------");

        StreamObserver<StreamResponse> streamResponseStreamObserver = new StreamObserver<StreamResponse>() {

            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted!");
            }
        };

        StreamObserver<StreamRequest> streamRequestStreamObserver = stub.biTalk(streamResponseStreamObserver);

        for (int i = 0; i < 10; i++) {
            streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(""+i+1).build());

            Thread.sleep(1000);
        }
    }
}
