package com.yzy.grpc;

import com.yzy.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.stream.Stream;

/**
 * @author You
 * @create 2019-06-30 17:36
 */
public class PersonServiceImpl extends PersonServiceGrpc.PersonServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println(request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("余志友").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getPersonByAge(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        System.out.println(request.getAge());
        responseObserver.onNext(PersonResponse.newBuilder().setName("name1").setAge(1).setCity("city1").build());
        responseObserver.onNext(PersonResponse.newBuilder().setName("name2").setAge(2).setCity("city2").build());
        responseObserver.onNext(PersonResponse.newBuilder().setName("name3").setAge(3).setCity("city3").build());
        responseObserver.onNext(PersonResponse.newBuilder().setName("name4").setAge(4).setCity("city4").build());
        responseObserver.onNext(PersonResponse.newBuilder().setName("name5").setAge(5).setCity("city5").build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<PersonRequest> getPersonWapperByAges(StreamObserver<PersonResponseList> responseObserver) {
        return new StreamObserver<PersonRequest>() {
            @Override
            public void onNext(PersonRequest value) {
                System.out.println(value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                PersonResponse response1 = PersonResponse.newBuilder().setName("name 1").setAge(1).setCity("city 1").build();
                PersonResponse response2 = PersonResponse.newBuilder().setName("name 2").setAge(2).setCity("city 2").build();

                PersonResponseList responseList = PersonResponseList.newBuilder().addPersonResponse(response1).addPersonResponse(response2).build();

                responseObserver.onNext(responseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());

                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo("1").build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
