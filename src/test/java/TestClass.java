import RestApiConstants.EndPoints;
import RestApiConstants.Url;
import RestClientUtility.RestClient;
import RestClientUtility.RestDataSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestClass {
    public Response response;
    public RestDataSetup restDataSetup ;
    public RestClient restBaseSet=new RestClient();
    public static String url= Url.BASE_URI_STAGE;
    public static String path = EndPoints.BASE_URL;
    HashMap<String,String> params=new HashMap<>();
    HashMap<String,Object> headers=new HashMap<>();

    @Test
    public void test()
    {
        restDataSetup=RestDataSetup.restDataSetup(url,path,params,headers,"","GET","");
        response= restBaseSet.getResponse(restDataSetup);
        //Bhaskar



    }

    @Test
    public  void test1()
    {
        restDataSetup=RestDataSetup.restDataSetup(url,path,params,headers,"","GET","");
        response= restBaseSet.getResponse(restDataSetup);
        String res= response.getBody().asString();
        JsonPath obj = new JsonPath(res);
        res = obj.getString("obj1.obj2.name");

    }
    @Test
    public  void test2()
    {
        restDataSetup=RestDataSetup.restDataSetup(url,path,params,headers,"","GET","");
        response= restBaseSet.getResponse(restDataSetup);
        String res= response.getBody().asString();
        JsonPath obj = new JsonPath(res);
        res = obj.getString("obj1.obj2.name");

    }
    @Test
    public  void test3()
    {
        restDataSetup=RestDataSetup.restDataSetup(url,path,params,headers,"","GET","");
        response= restBaseSet.getResponse(restDataSetup);
        String res= response.getBody().asString();
        JsonPath obj = new JsonPath(res);
        res = obj.getString("obj1.o");

    }
}
