package com.projet_integrateur.app.model;

import static com.projet_integrateur.app.controller.TestController.E_TEST;

import android.util.Log;

import com.projet_integrateur.app.controller.TestController;


//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
public class Avatar
{
    //!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    
	
    private static final String  TAG = "[" + Avatar.class.getSimpleName().toUpperCase() + "]";


    private Integer           id       	= -1;
	private String 			name 		= "";

    //!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^    
    
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    //BUILDER
    public static Avatar Create( String thisName)
    {
        Avatar newAvatar = null;

        if (Models.getAvatar(thisName) == null ) //SI NEXISTE PAS
        {
            newAvatar = new Avatar( thisName);
            if (newAvatar == null) {Log.e(TAG, "Une erreur est survenue lors l\' initialisation !!");            }
            else
            {
                Models.getAvatars().add(newAvatar);
                newAvatar.setId(Models.getAvatars().indexOf(newAvatar) );
            }
        }  else Log.e(TAG, thisName + " EXISTE DEJA");

        return newAvatar;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
      
	//?-------------------------------------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    private Avatar( String thisName )	{   this.name = thisName;	}
	//?-------------------------------------------------------------------------------------------------------------------------------------------

    // ?-------------------------------------------------------------------------------------------------------------------------------------------
    // GETTERS
    public Integer getId()  				        { return id; }
	public String getName()  			        { return name; }
    //?-------------------------------------------------------------------------------------------
    //SETTERS
    public void setId(Integer thisId) 				{ id = thisId; }
	public void setName(String thisName) 		{ name = thisName; }


	public 	String toJSON()    
	{
		String  thisString = "\t{";
		thisString += "\t\"id\": \""  + id.toString()  + "\", " + "\"name\": \"" + name  + "\"";
        thisString += "\t}";
        return thisString;
	}
    
    //?-------------------------------------------------------------------------------------------
   
    public void logInfo()    	{     Log.i(TAG,  this.toJSON());	}
    //?-------------------------------------------------------------------------------------------


	//?-------------------------------------------------------------------------------------------------------------------------------------------
    //TESTS 
    public static Boolean TEST( E_TEST thisTest)
    {
        Boolean Result = false;		
		Avatar thisAvatar = null;
		
        switch(thisTest)
        {
            case E_CONSTRUCTOR :
            {
                thisAvatar = Avatar.Create( "Avatar test");
                if ( thisAvatar != null )
                {        Log.d( TestController.TAG,TAG +"\tTEST:CONSTRUCTOR -> PASS"  + "\t WHILE EXECUTING -> [ avatar.Create( \"Avatar test\"); ]");    Result = true;    }
                else  {  Log.d( TestController.TAG,TAG +"\tTEST:CONSTRUCTOR -> FAIL"  + "\t WHILE EXECUTING -> [ avatar.Create( \"Avatar test\"); ]");    Result = false;   }

            } break;
          
            case         E_GETTER :           break;
            case         E_SETTER :           break;
            default :                         break;

        }

        return Result;
    }
    //?-------------------------------------------------------------------------------------------------------------------------------------------





}
//?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

