package RestClientUtility;

import java.util.HashMap;

public class RestDataSetup {
    private String baseUrl;
    private String path;
    private HashMap<String, String> params;
    private HashMap<String,Object> headers;
    private String requestType;
    private String method;
    private String body;

    public static RestDataSetup restDataSetup(String baseUrl, String path, HashMap<String,String> params, HashMap<String, Object> headers,String requestType,String method,String body)
    {
        RestDataSetup obj= new RestDataSetup();
        obj.setBaseUri(baseUrl);
        obj.setPath(path);
        obj.setQueryparams(params);
        obj.setHeaders(headers);
        obj.setRequestType(requestType);
        obj.setMethod(method);
        obj.setBody(body);
        return obj;
    }
    public String getBaseUri()
    {
        return this.baseUrl;
    }

    public String getPath(){
        return this.path;
    }

    private void setBody(String body)
    {
        this.body=body;
    }
    public String getBody()
    {
        return this.body;
    }

    public HashMap<String, Object> getHeaders()
    {
        return this.headers;
    }
    public HashMap<String,String> getParams(){
        return this.params;
    }

    public String contentType(){
        return requestType;
    }
    private void setMethod(String method) {
        this.method=method;
    }
    public String getMethod()
    {
        return this.method;
    }


    private void setRequestType(String requestType) {
        this.requestType=requestType;
    }

    private void setHeaders(HashMap<String, Object> headers) {
        this.headers=headers;
    }

    private void setQueryparams(HashMap<String, String> params) {
        this.params=params;
    }

    private void setBaseUri(String baseUrl)
    {
        this.baseUrl=baseUrl;
    }

    private void setPath(String path) {
        this.path=path;
    }

}
