package model.constant;

import model.reqmodel.loginReqModel;

public class constant {
    public static String API_URL = "https://auctions-app-2.herokuapp.com/api";
	public static String ACCESS_TOKEN;

    public static final String[] API_LOGIN = {
        "API_LOGIN_UNIT_TEST_000",
        "API_LOGIN_UNIT_TEST_001",
        "API_LOGIN_UNIT_TEST_002"
    };	

    public static class Request {
		
		// define input api login
		public static class RequestApiLogin {
			public static String apiPath = "/login"; 
			public static class UnitTest000 {
				public static loginReqModel requestBody 
				= new loginReqModel( "cc@gmail.com", "123456");
			}
			public static class UnitTest001 {
				public static loginReqModel requestBody 
				= new loginReqModel( "ddd@.123com", "123456");
			}
			public static class UnitTest002 {
				public static loginReqModel requestBody 
				= new loginReqModel( "cc@gmail.com", "12345678");
			}
		}
    }
}
