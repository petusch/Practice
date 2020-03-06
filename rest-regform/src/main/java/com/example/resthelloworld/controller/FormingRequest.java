package com.example.resthelloworld.controller;

import java.util.Map;

public class FormingRequest {

    public static String formingRequest(Map<String, String> requestParams, String operation, String table)
    {
        String request = "";
        boolean parametrsBefore = false;
        int id = Integer.parseInt(requestParams.getOrDefault("id","0"));
        String name = requestParams.get("name");
        String surname = requestParams.get("surname");
        String creationDate = requestParams.get("creationdate");
        String eMail = requestParams.get("email");
        String birthDate = requestParams.get("birthdate");
        if(operation.trim().equalsIgnoreCase("read"))
            request = "select * from "+ table.trim().toLowerCase() + " where ";
        else if (operation.trim().equalsIgnoreCase("delete"))
            request = "delete from "+ table.trim().toLowerCase() + " where ";

        if(id!=0) {
            request += "id=" + id;
            parametrsBefore = true;
        }
        if(name!=null){
            if (parametrsBefore)
                request=addingLogicalParameters(request,"and");
            request+="name = \'"+name+"\'";
            parametrsBefore = true;
        }
        if(surname!=null) {

            if (parametrsBefore)
                request=addingLogicalParameters(request,"and");
            request += "surname = \'" + surname + "\'";
            parametrsBefore=true;
        }
        if(creationDate!=null) {
            if (parametrsBefore)
                request = addingLogicalParameters(request, "and");
            request += "creationdate  = \'" + creationDate + "\'";
            parametrsBefore = true;
        }
        if(eMail!=null) {
            if (parametrsBefore)
                request = addingLogicalParameters(request, "and");
            request += "email  = \'" + eMail + "\'";
            parametrsBefore = true;
        }
        if(birthDate!=null) {
            if (parametrsBefore)
                request = addingLogicalParameters(request, "and");
            request += "birthdate  = \'" + birthDate + "\'";
        }
        System.out.println(request);
        return request;
    }

    private static String addingLogicalParameters(String request,String parameter)
    {
        request+=" "+parameter+" ";
        return request;
    }
}
