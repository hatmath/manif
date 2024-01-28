
package com.projet_integrateur.app.controller;


import android.util.Log;


import com.projet_integrateur.app.model.Interest;
import com.projet_integrateur.app.model.Manif;
import com.projet_integrateur.app.model.Member;

public class TestController 
{

    public  static final String  TAG = "[" + TestController.class.getSimpleName().toUpperCase() + "]";

    public enum  E_TEST {    E_CONSTRUCTOR, E_GETTER,  E_SETTER     }

    private static TestController m_Instance = null;
    public  static TestController getInstance()
    {
        if (m_Instance == null) {  m_Instance = new TestController();    }  
        return m_Instance;
    }

    public static void EXECUTE_TESTS()  {   TestController.getInstance().TEST_ALL(E_TEST.E_CONSTRUCTOR);        }

    //?-------------------------------------------------------------------------------------------------------------------------------------------
    //TESTS
    public Boolean TEST_ALL(E_TEST thisTest )  {  TEST_MODELS(thisTest);   return true;        }
    //?-------------------------------------------------------------------------------------------------------------------------------------------
    public static Boolean TEST_MODELS (E_TEST thisTest )
    {
        Log.d( TAG,"TESTING MODELS ..." );

        switch (thisTest)
        {
                //?????????????????????????????????????????????????????????????????????????????????????????????????????
                case E_CONSTRUCTOR:

                    if (Member.TEST(thisTest) == false) return false;
                    if (Interest.TEST(thisTest) == false) return false;
                    if (Manif.TEST(thisTest) == false)   Manif.TEST( thisTest );
                   //     slogan.TEST( thisTest );


                    break;
                //?????????????????????????????????????????????????????????????????????????????????????????????????????

                case         E_GETTER :             break;
                case         E_SETTER :             break;
                default :                           break;
                //?-------------------------------------------------------------------------------------------------------------------------------------------
            }

            return true;
        }
    }