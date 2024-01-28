package com.projet_integrateur;


import static com.projet_integrateur.app.model.Models.E_MODELS.E_INTEREST;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_INTERESTS_MEMBER;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MANIF;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MEMBER;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MEMBERS_MANIF;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_SLOGAN;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.projet_integrateur.app.model.Manif;



public class Globals
{


    public static boolean LOGIN_REQUIRED = true;

    public static Boolean DialogOnSuccess_IsEnabled = false;
    public static Boolean DialogOnFailure_IsEnabled = false;

    
    public static  Boolean DEBUG_INFO = true;
    public static  Boolean TESTS_ENABLED = false;

    public static  Context          CURRENT_CONTEXT  = null;
    public static AppCompatActivity CURRENT_ACTIVTY  = null;
    public static Manif             CURRENT_MANIF   = null;

   

    public class Network
    {
        public static String TEST_URL = "http://192.168.68.103:5283/api/data/getAllManif";

        public enum E_SERVER_TYPE { E_SERVER_APACHE, E_SERVER_EXPRESS }
        public static E_SERVER_TYPE CURRENT_SERVER_TYPE = E_SERVER_TYPE.E_SERVER_APACHE;
        public E_SERVER_TYPE getServerType() { return CURRENT_SERVER_TYPE; }

        //?--------------------------   CONFIGURATION FOR EXPRESS SERVER     ------------------------
        public static String SERVER_EXPRESS_HTTP    =   "http://";
        public static String SERVER_EXPRESS_HOST    =   "192.168.68.103";
        public static String SERVER_EXPRESS_PORT    =   ":5283";
        public static String SERVER_EXPRESS_DATA_ROUTES  =   "/api/data/";
        public static String SERVER_EXPRESS_AUTH_ROUTES  =   "/api/auth/";
        public static String SERVER_EXPRESS_URL_SUFFIX  =   "";
        public static String SERVER_EXPRESS_URL_PREFIX =   SERVER_EXPRESS_HTTP +
                                                        SERVER_EXPRESS_HOST +
                                                        SERVER_EXPRESS_PORT;


        //?--------------------------   CONFIGURATION FOR APACHE SERVER     ------------------------
        public static String SERVER_APACHE_HTTP        =   "http://";
        public static String SERVER_APACHE_HOST        =   "192.168.68.104";
        public static String SERVER_APACHE_PORT        =   ":80";
        public static String SERVER_APACHE_DATA_ROUTES =   "/api/data/";
        public static String SERVER_APACHE_AUTH_ROUTES=   "/api/auth/";
        public static String SERVER_APACHE_URL_SUFFIX  =   ".php?";
        public static String SERVER_APACHE_URL_PREFIX  =    SERVER_APACHE_HTTP +
                                                            SERVER_APACHE_HOST +
                                                            SERVER_APACHE_PORT;

        //?--------------------------   CONFIGURATION APACHE OU EXPRESS     ------------------------
        public static String SERVER_DATA_ROUTES = "/api/data/";
        public static String SERVER_AUTH_ROUTES = "/api/auth/";
        public static String SERVER_URL_PREFIX = SERVER_APACHE_URL_PREFIX;
        public static String SERVER_URL_SUFFIX = SERVER_APACHE_URL_SUFFIX;

        public static String SERVER_URL_DATA = SERVER_URL_PREFIX + SERVER_DATA_ROUTES;
        public static String SERVER_URL_AUTH = SERVER_URL_PREFIX + SERVER_AUTH_ROUTES ;




      // public static String SERVER_URL_PREFIX = SERVER_EXPRESS_URL_PREFIX;
      //public static String SERVER_URL_SUFFIX = SERVER_EXPRESS_URL_SUFFIX;

        //?--------------------------   CONFIGURATION DES SERVICES CRUD     ------------------------
        public static String[] SERVER_GETALL_SERVICES =  { "getAllInterest", "getAllMember", "getAllSlogan", "getAllManif", "getAllMemberManif", "getAllInterestMember"};
        public static String[] SERVER_GET_SERVICES =     { "getInterest", "getMember", "getSlogan",  "getManif",  "getMemberManif", "getInterestMember"};
        public static String[] SERVER_CREATE_SERVICES =     { "createInterest", "register", "createSlogan",  "createManif",  "createMemberManif", "createInterestMember"};

        //?--------------------------   URLS  api/auth/   ---------------------------------
        public static String[] SERVER_AUTH_URLS = {
                SERVER_URL_AUTH + "login"          + SERVER_URL_SUFFIX,
                SERVER_URL_AUTH + "register"       + SERVER_URL_SUFFIX,
          };
        public static String  SERVER_URL_AUTH_LOGIN = SERVER_AUTH_URLS[0];
        public static String  SERVER_URL_AUTH_REGISTER= SERVER_AUTH_URLS[1];
        //?--------------------------   URLS  api/data/   ---------------------------------
        public static String[] SERVER_GETALL_URLS = {                                  //GETALL URLS
            SERVER_URL_DATA + SERVER_GETALL_SERVICES[E_INTEREST.ordinal()]            + SERVER_URL_SUFFIX,
            SERVER_URL_DATA + SERVER_GETALL_SERVICES[E_MEMBER.ordinal()]              + SERVER_URL_SUFFIX,
            SERVER_URL_DATA + SERVER_GETALL_SERVICES[E_SLOGAN.ordinal()]              + SERVER_URL_SUFFIX,
            SERVER_URL_DATA + SERVER_GETALL_SERVICES[E_MANIF.ordinal()]               + SERVER_URL_SUFFIX,
            SERVER_URL_DATA + SERVER_GETALL_SERVICES[E_MEMBERS_MANIF.ordinal()]       + SERVER_URL_SUFFIX,
            SERVER_URL_DATA + SERVER_GETALL_SERVICES[E_INTERESTS_MEMBER.ordinal()]    + SERVER_URL_SUFFIX
        };
        public static String[] SERVER_GET_URLS = {                                       //GET URLS
                SERVER_URL_DATA + SERVER_GET_SERVICES[E_INTEREST.ordinal()]           + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_GET_SERVICES[E_MEMBER.ordinal()]             + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_GET_SERVICES[E_SLOGAN.ordinal()]             + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_GET_SERVICES[E_MANIF.ordinal()]              + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_GET_SERVICES[E_MEMBERS_MANIF.ordinal()]      + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_GET_SERVICES[E_INTERESTS_MEMBER.ordinal()]   + SERVER_URL_SUFFIX
        };
        public static String[] SERVER_CREATE_URLS = {                                       //CREATE URLS

                SERVER_URL_DATA + SERVER_CREATE_SERVICES[E_INTEREST.ordinal()]           + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_CREATE_SERVICES[E_MEMBER.ordinal()]             + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_CREATE_SERVICES[E_SLOGAN.ordinal()]             + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_CREATE_SERVICES[E_MANIF.ordinal()]              + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_CREATE_SERVICES[E_MEMBERS_MANIF.ordinal()]      + SERVER_URL_SUFFIX,
                SERVER_URL_DATA + SERVER_CREATE_SERVICES[E_INTERESTS_MEMBER.ordinal()]   + SERVER_URL_SUFFIX

        };

        public static String[] SERVER_EXPRESS_CREATE_URLS = {                                       //CREATE URLS

                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_CREATE_SERVICES[E_INTEREST.ordinal()]           + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_AUTH_ROUTES + SERVER_CREATE_SERVICES[E_MEMBER.ordinal()]             + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_CREATE_SERVICES[E_SLOGAN.ordinal()]             + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_CREATE_SERVICES[E_MANIF.ordinal()]              + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_CREATE_SERVICES[E_MEMBERS_MANIF.ordinal()]      + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_CREATE_SERVICES[E_INTERESTS_MEMBER.ordinal()]   + SERVER_EXPRESS_URL_SUFFIX

        };
        //?--------------------------   URLS  api/data/   ---------------------------------
        public static String[] SERVER_EXPRESS_GETALL_URLS = {                                  //GETALL URLS
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GETALL_SERVICES[E_INTEREST.ordinal()]            + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GETALL_SERVICES[E_MEMBER.ordinal()]              + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GETALL_SERVICES[E_SLOGAN.ordinal()]              + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GETALL_SERVICES[E_MANIF.ordinal()]               + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GETALL_SERVICES[E_MEMBERS_MANIF.ordinal()]       + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GETALL_SERVICES[E_INTERESTS_MEMBER.ordinal()]    + SERVER_EXPRESS_URL_SUFFIX
        };
        public static String[] SERVER_EXPRESS_GET_URLS = {                                       //GET URLS
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GET_SERVICES[E_INTEREST.ordinal()]           + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GET_SERVICES[E_MEMBER.ordinal()]             + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GET_SERVICES[E_SLOGAN.ordinal()]             + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GET_SERVICES[E_MANIF.ordinal()]              + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GET_SERVICES[E_MEMBERS_MANIF.ordinal()]      + SERVER_EXPRESS_URL_SUFFIX,
                SERVER_EXPRESS_URL_PREFIX + SERVER_EXPRESS_DATA_ROUTES + SERVER_GET_SERVICES[E_INTERESTS_MEMBER.ordinal()]   + SERVER_EXPRESS_URL_SUFFIX
        };
}

}


