package RestClientUtility;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static io.restassured.RestAssured.given;

public class RestClient {
    static Logger logger = LoggerFactory.getLogger(RestClient.class);
    Response response;
    public static RequestSpecification requestSpecification;


    public Response getResponse(RestDataSetup restDataSetup) {
        System.out.println("==========================");
        logger.info("hello");
        requestSpecification = given();
        requestSpecification = setBaseUri(restDataSetup);
        requestSpecification = setBasePath(restDataSetup);
        requestSpecification = setHeaders(restDataSetup);
        requestSpecification = setParams(restDataSetup);
        requestSpecification = setBody(restDataSetup);
        response = callRest(restDataSetup);
        System.out.println("==========================");
        System.out.println("Response Body:");
        System.out.println(response.getBody().prettyPrint());
        System.out.println("**********************************************************************************************");
        System.out.println();
        return response;
    }

    private Response callRest(RestDataSetup restDataSetup) {
        RestMethods method = RestMethods.valueOf(restDataSetup.getMethod());
        System.out.println("Method : "+method);
        switch (method) {
            case GET:
                response = requestSpecification.when().get();
                break;
            case PUT:
                response = requestSpecification.body(restDataSetup.getBody()).put();
                break;
            case POST:
                response = requestSpecification.body(restDataSetup).post();
                break;
        }
        return response;
    }

    private RequestSpecification setBasePath(RestDataSetup restDataSetup) {
        if(restDataSetup.getPath().isEmpty()){
            System.out.println("Path : null");
            return requestSpecification;
        } else {
            System.out.println("Path : "+restDataSetup.getPath());
            return requestSpecification.basePath(restDataSetup.getPath());

        }
    }

    private RequestSpecification setBaseUri(RestDataSetup restDataSetup) {
        if (restDataSetup.getBaseUri().isEmpty()) {
            System.out.println("BaseUri : null");
            return requestSpecification;
        } else {
            logger.info(restDataSetup.getBaseUri()+"Baseuri");
            System.out.println("BaseUri : "+restDataSetup.getBaseUri());
            return requestSpecification.baseUri(restDataSetup.getBaseUri());
        }
    }


    private RequestSpecification setHeaders(RestDataSetup restDataSetup) {
        if (restDataSetup.getHeaders().isEmpty()) {
            System.out.println("Headers : null");
            return requestSpecification;
        }else{
            System.out.println("Headers : "+ restDataSetup.getHeaders());
            return requestSpecification.headers(restDataSetup.getHeaders());
        }

    }

    private RequestSpecification setParams(RestDataSetup restDataSetup) {
        if (restDataSetup.getParams().isEmpty()) {
            System.out.println("QueryParams : null");
            return requestSpecification;
        }else{
            System.out.println("Query Params : "+restDataSetup.getParams());
            return requestSpecification.params(restDataSetup.getParams());
        }


    }

    private RequestSpecification setBody(RestDataSetup restDataSetup) {
        if (!restDataSetup.getBody().isEmpty()) {
            System.out.println("Body = "+restDataSetup.getBody());
            return requestSpecification.body(restDataSetup.getBody());
        } else{
            System.out.println("Body = null");
            return requestSpecification;
        }

    }

    public enum RestMethods {
        GET, POST, PATCH, PUT;
    }
}
