package com.example.geo.museumguide.constante;

/**
 * Created by Geo on 1/7/2017.
 */

public class RESTConst {

    public static final String SERVER_PATH="http://192.168.43.16:8080/MuzeuServer";
    public static final String REST_SERVER_PATH=SERVER_PATH + "/rest";
    public static final String RESOURCE_SERVER_PATH=SERVER_PATH + "/resources/";

    public static final String USER_REST_PATH=REST_SERVER_PATH + "/user/";
    public static final String USER_LOGIN_REST_PATH=USER_REST_PATH + "login/";

    public static final String ARTEFACT_REST_PATH=REST_SERVER_PATH + "/artefact/";

    public static final String BYDEPARMTNENT_ARTEFACT_REST_PATH=ARTEFACT_REST_PATH + "/department/";

    public static final String DEPARTMENT_REST_PATH=REST_SERVER_PATH + "/department/";

    public static final String BEACON_DEPARTMENT_REST_PATH=DEPARTMENT_REST_PATH + "/beacon/";

    public static final String FOTO_DEPARTMENT_PATH=REST_SERVER_PATH + "/foto-department/";

    public static final String FOTO_DEPARTMENT_BY_DEPARTMENT_PATH=FOTO_DEPARTMENT_PATH + "/department/";

    public static final String FOTO_ARTEFACT_PATH=REST_SERVER_PATH + "/foto-artefact/";

    public static final String FOTO_ARTEFACT_BY_ARTEFACT_PATH=FOTO_ARTEFACT_PATH + "/artefact/";

    public static final String BEACON_REST_PATH=REST_SERVER_PATH + "/beacon/";

    public static final String FAVORITE_REST_PATH=REST_SERVER_PATH + "/favorite/";

    public static final String FAVORITE_ARTEFACT_REST_PATH=FAVORITE_REST_PATH + "artefact/";

    public static final String FAVORITE_FOTO_ARTEFACT_REST_PATH=FAVORITE_REST_PATH + "foto-artefact/";

    public static final String FAVORITE_DEPARTMENT_REST_PATH=FAVORITE_REST_PATH + "department/";

    public static final String FAVORITE_FOTO_DEPARTMENT_FOTO_REST_PATH=FAVORITE_REST_PATH + "foto-department/";

    public static String getByIdPath(String resourcePath, Number id){
        return resourcePath+id;
    }

    public static String getByIdPath(String resourcePath, String id){
        return resourcePath+id;
    }

    public static String getImagePath(String resourcePath){
        return RESOURCE_SERVER_PATH+resourcePath;
    }
}
