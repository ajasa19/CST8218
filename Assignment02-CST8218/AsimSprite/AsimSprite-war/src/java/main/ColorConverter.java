/* 
 * 8218: Assignment 1
 * File name: ColorConverter.java
*/
package main;

import java.awt.Color;
import java.util.regex.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * This class converts hex color objects to strings and back                                      
 * @author Nathan Denyer
 * @version 1
 * @since 1.8
 * @see None
 */
@FacesConverter("ColorConverter")
public class ColorConverter implements Converter {
    //Regex pattern to match a color hex code
    //First looks for a pound symbol at the start of a line
    //Then matches 6 characters that can be A-F (upper or lower), or 0-9
    //Finally it matches the end of the line
    private final Pattern HexPattern = Pattern.compile("^#([0-9A-Fa-f]{6})$");
    private Matcher MatchPattern;
    
    /**
     * Convert a hex color string to a color object
     * @param fc
     * @param uic
     * @param string
     * @return The converted color object
     */
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        MatchPattern = HexPattern.matcher(string);
        //Test for regex match
        if (!MatchPattern.matches())
        {
            //Display error if no match
            FacesMessage errorMessage = new FacesMessage
            (string + " is not a valid colour in the format: #RRGGBB");
            throw new ConverterException(errorMessage);
        }
        //Return the color object hex code
        return Color.decode(string);
    }
    
    /**
     * Convert a color object to a hex string
     * @param fc
     * @param uic
     * @param t
     * @return The converted color string
     */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        String colorString = null;
        
        try
        {
            //Cast the object to a color
            Color color = (Color)t;
            //Format as two digit hex
            String red = String.format("%02X", color.getRed());
            String green = String.format("%02X", color.getGreen());
            String blue = String.format("%02X", color.getBlue());
            //Format the string
            colorString = "#" + red + green + blue;     
        }
        catch (Exception e)
        {
            //Display error message if a step fails
            FacesMessage errorMessage = new FacesMessage
            (t.toString() + " is not a valid colour in the format: #RRGGBB");
            throw new ConverterException(errorMessage);
        }
        return colorString;
    }
}
