/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.getbrandao.fupload.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author gbrandao
 */
public class FilesUpload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String caminho;
	private byte[] files;
	private String arquivo;
	
	public String getArquivo() {
		return arquivo;
	}

	public FilesUpload(){
		
	}

	public String getRealPath() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) facesContext.getExternalContext().getContext();
		
		return context.getRealPath("/");
	}
	
	
	
	public void fileUpload(FileUploadEvent event) {
        try {
        	
        	UploadedFile uploadedFile = event.getFile();
        	String fileNameUploaded = uploadedFile.getFileName(); 
        	long fileSizeUploaded = uploadedFile.getSize(); 
        	String infoAboutFile = "File recieved:" +fileNameUploaded + " File size:" +fileSizeUploaded; 
        	FacesContext facesContext = FacesContext.getCurrentInstance(); 
        	facesContext.addMessage(null, new FacesMessage("Success", infoAboutFile));

            File file = new File(getRealPath() + "/documents/");
            file.mkdirs();
            
            this.files = event.getFile().getContents();
            this.caminho = getRealPath() + "/documents/" + uploadedFile.getFileName();    

        } catch (Exception ex) {
            System.out.println("File send error" + ex);
        }
        
        
    }
	
	public void save(){
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(this.caminho);
			fos.write(this.files);
			fos.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}