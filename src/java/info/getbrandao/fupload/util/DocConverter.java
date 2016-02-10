/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.getbrandao.fupload.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author gbrandao
 */
@FacesConverter("docConverter")
public class DocConverter implements Converter{

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println(value);
        return value;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
