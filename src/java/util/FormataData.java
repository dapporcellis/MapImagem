/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marcelosiedler
 */
public class FormataData {
    private static SimpleDateFormat sf;
    
    public static Date formata(String data)
    {
        sf = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            return sf.parse(data);
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
    
    public static String formata(Date data)
    {
        sf = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            return sf.format(data);
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
    
    public static Date formata(String data, String formato)
    {
        sf = new SimpleDateFormat(formato);
        try
        {
            return sf.parse(data);
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
    
    public static String formata(Date data, String formato)
    {
        sf = new SimpleDateFormat(formato);
        try
        {
            return sf.format(data);
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
    
    
    
}
