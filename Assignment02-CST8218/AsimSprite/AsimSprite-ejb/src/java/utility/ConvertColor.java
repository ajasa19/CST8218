/* 
*Class:     ConvertColor
*Author:    Asim Jasarevic
*project:   Assignment 01
*Purpose:   Convert color object between hex and rgb string 
*/
package utility;

import java.awt.Color;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ajasa
 */
@FacesConverter("utility")
public class ConvertColor implements Converter {

    
    /**
    * getAsObject
    * convert rgb string passed by color object into hex color code return color object with new hex value
    */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {    
        
        //return a color object with R,G,B values but each segment converted to hex int
        return new Color (
            Integer.valueOf(value.substring(1,3), 16),
            Integer.valueOf(value.substring(3,5), 16),
            Integer.valueOf(value.substring(5,7), 16));
    }

    /**
    * getAsString
    * convert rgb string passed by color object into hex color code return value string
    */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Color color = (Color) value;  
        //make hex string by formating get requests of RGB to make #****** hex string
        String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        
        return hex;
    }

}
