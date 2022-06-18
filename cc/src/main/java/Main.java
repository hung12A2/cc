import java.util.ArrayList;

import com.loginRestAssured;
import model.constant.constant;
import model.resUnitTest.resUnitTest;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] listApiLogin = constant.API_LOGIN;
        int sizeoflistApiLogin = listApiLogin.length;

        resUnitTest rut1 = loginRestAssured.UnitTest000();
        resUnitTest rut2 = loginRestAssured.UnitTest001();
        resUnitTest rut3 = loginRestAssured.UnitTest002();

        List<resUnitTest> listrut = new ArrayList<resUnitTest>();

        listrut.add(rut1);
        listrut.add(rut2);
        listrut.add(rut3);

        System.out.println("--- START --- ");
        
        for (int i = 0 ; i < sizeoflistApiLogin; i++ ){
            System.out.println(listrut.get(i).getName());
            System.out.println(listrut.get(i).getInput());
            System.out.println(listrut.get(i).getOutput());        
        }

        System.out.println("--- DONE --- ");

    }

}
