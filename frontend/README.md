
importer maif_core sql database: 

	manif_core.sql

Compte Adminstrateur par default:

	username : admin
	password : 12345678
	
	
	
Dans globals.java toute la configuration reseau comprenant le ip du server, ke type de serveur et routes utiliser, info de debuggage
	
	public static boolean LOGIN_REQUIRED = true;    
    public static  Boolean DEBUG_INFO = true;
    public static  Boolean TESTS_ENABLED = false;
	
	//?--------------------------   CONFIGURATION DU TYPE DE SERVEUR     ------------------------
	
		public static E_SERVER_TYPE CURRENT_SERVER_TYPE = E_SERVER_TYPE.E_SERVER_APACHE;
	
	//?--------------------------   CONFIGURATION FOR EXPRESS SERVER     ------------------------
	
		public static String SERVER_EXPRESS_HTTP    =   "http://";
        public static String SERVER_EXPRESS_HOST    =   "192.168.68.103";
        public static String SERVER_EXPRESS_PORT    =   ":5283";
        public static String SERVER_EXPRESS_DATA_ROUTES  =   "/api/data/";
        public static String SERVER_EXPRESS_AUTH_ROUTES  =   "/api/auth/";
		
	//?--------------------------   CONFIGURATION FOR APACHE SERVER     ------------------------
	
        public static String SERVER_APACHE_HTTP        =   "http://";
        public static String SERVER_APACHE_HOST        =   "192.168.68.104";
        public static String SERVER_APACHE_PORT        =   ":80";
        public static String SERVER_APACHE_DATA_ROUTES =   "/api/data/";
        public static String SERVER_APACHE_AUTH_ROUTES=   "/api/auth/";
        public static String SERVER_APACHE_URL_SUFFIX  =   ".php?";
		
		voir dossier scripts pour le script sql et php
		Il faut installer xampp pour le server apache puis importer manif_core.sql
		ensuite mettre le ip localhost ou autre associer au server apache
		les scripts php font ds le dossier xampp/htdocs/api/data