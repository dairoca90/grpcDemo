package com.rosalessw.grpc.user;

import com.rosalessw.grpc.User.APIResponse;
import com.rosalessw.grpc.User.Empty;
import com.rosalessw.grpc.User.LoginRequest;
import com.rosalessw.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
				//return success response
			
			response.setResponseCode(200)
					.setResponsemessage("SUCCESS");
		}
		else {
			//return failure response
			response.setResponseCode(400)
			.setResponsemessage("Invalid Password");
		}
		
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

	
	
	
}
