/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.getbrandao.fupload.bean;

import info.getbrandao.fupload.dao.DAO;
import info.getbrandao.fupload.model.Document;
import info.getbrandao.fupload.util.FilesUpload;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
/**
 *
 * @author gbrandao
 */
@ManagedBean(name="documentBean")
@ViewScoped
public class DocumentBean implements Serializable{
   
    private static final long serialVersionUID = 1L;
    Integer id;
    String name;
    String type;
    Document document=new Document();
    FilesUpload filesupload=new FilesUpload();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public FilesUpload getFilesupload() {
        return filesupload;
    }

    public void setFilesupload(FilesUpload filesupload) {
        this.filesupload = filesupload;
    }
    
    public void save() {
		System.out.println("Saving document " + this.document.getName());

		new DAO<Document>(Document.class).add(this.document);
	}
    
    public void uploadAction(FileUploadEvent event){
		this.filesupload.fileUpload(event);
		this.document.setName(event.getFile().getFileName());
    }
}
