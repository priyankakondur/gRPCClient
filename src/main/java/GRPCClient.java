import com.examples.grpc.User;
import com.examples.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
    public static void main(String[] args) {
        //to talk to server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8080).usePlaintext().build();

        //stubs generated from proto
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("Priya").setPassword("anaj").build();
        User.APIResponse response = userStub.login(loginRequest);
        //print response
        System.out.println(response.getResponseMessage());
    }
}

