package com.jennie.study.account.persist;

import org.dom4j.*;
import org.dom4j.bean.BeanAttribute;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.BaseElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2019/7/3
 * @Time: 21:50
 */
public class AccountPersistServiceImpl  implements AccountPersistService{

    private final static  String ELEMENT_ROOT="account_persist";
    private final static  String ELEMENT_ACCOUNTS ="accounts";
    private final static  String ELEMENT_ACCOUNT ="account";
    private final static  String ELEMENT_ACCOUNT_ID ="id";
    private final static  String ELEMENT_ACCOUNT_NAME ="name";
    private final static  String ELEMENT_ACCOUNT_EMAIL ="email";
    private final static  String ELEMENT_ACCOUNT_PASSWORD ="password";
    private final static  String ELEMENT_ACCOUNT_ACTIVATED ="activated";

    private String file;

    private SAXReader reader=new SAXReader();

    private Document readDocument() throws AccountPersistException{
        File dataFile=new File(file);
        if (!dataFile.exists()) {
            dataFile.getParentFile().mkdir();
            Document doc= DocumentFactory.getInstance().createDocument();
            Element rootEle=doc.addElement(ELEMENT_ROOT);
            rootEle.addElement(ELEMENT_ACCOUNTS);
            writeDocument(doc);
        }
        try {
            return reader.read(new File(file));
        }catch (DocumentException e){
            throw new AccountPersistException("Unable to read persist data xml ",e);
        }
    }

    private void writeDocument(Document doc) throws AccountPersistException{
        Writer out=null;
        try {
            out=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
            XMLWriter writer=new XMLWriter(out, OutputFormat.createPrettyPrint());
            writer.write(doc);
        }catch (IOException e){
            throw  new  AccountPersistException("Unable to write persist data xml",e);
        }finally {
            try {
                if (out!=null){
                    out.close();
                }
            }catch (IOException e){
                throw new AccountPersistException("Unable to close persist data xml write",e);
            }
        }
    }

    public Account crateAccount(Account account) throws AccountPersistException {
        Document doc=readDocument();
        Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
        if (accountsEle==null){
            doc.getRootElement().addElement(ELEMENT_ACCOUNTS);
        }
        for (Element accountEle : (List<Element>)accountsEle.elements()) {
            if (accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(account.getId())){
                return  updateAccount(account);
            }
        }
        Element accountEle=accountsEle.addElement(ELEMENT_ACCOUNT);
        accountEle.addElement(ELEMENT_ACCOUNT_ID).addText(account.getId());
        accountEle.addElement(ELEMENT_ACCOUNT_NAME).addText(account.getName());
        accountEle.addElement(ELEMENT_ACCOUNT_EMAIL).addText(account.getEmail());
        accountEle.addElement(ELEMENT_ACCOUNT_PASSWORD).addText(account.getPassword());
        accountEle.addElement(ELEMENT_ACCOUNT_ACTIVATED).addText(account.getActivated().toString());
        writeDocument(doc);
        return account;
    }

    public Account readAccount(String id) throws AccountPersistException {
        Document doc=readDocument();
        Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
        for (Element accountEle : (List<Element>)accountsEle.elements()) {
            if (accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
                return  buildAccount(accountEle);
            }
        }
        return null;
    }

    public Account updateAccount(Account account) throws AccountPersistException {
        Document doc=readDocument();
        Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
        for (Element accountEle : (List<Element>)accountsEle.elements()) {
            if (accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(account.getId())){
                accountEle.element(ELEMENT_ACCOUNT_NAME).setText(account.getName());
                accountEle.element(ELEMENT_ACCOUNT_EMAIL).setText(account.getEmail());
                accountEle.element(ELEMENT_ACCOUNT_PASSWORD).setText(account.getPassword());
                accountEle.element(ELEMENT_ACCOUNT_ACTIVATED).setText(account.getActivated().toString());
                writeDocument(doc);
//                return  buildAccount(accountEle);
            }
        }
        return account;
    }

    public void deleteAccount(String id) throws AccountPersistException {
        Document doc=readDocument();
        Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
        for (Element accountEle : (List<Element>)accountsEle.elements()) {
            if (accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
                accountsEle.remove(accountEle);
                writeDocument(doc);
            }
        }
    }

    private Account buildAccount(Element element){
        Account account=new Account();

        account.setId(element.elementText(ELEMENT_ACCOUNT_ID));
        account.setName(element.elementText(ELEMENT_ACCOUNT_NAME));
        account.setEmail(element.elementText(ELEMENT_ACCOUNT_EMAIL));
        account.setPassword(element.elementText(ELEMENT_ACCOUNT_PASSWORD));
        account.setActivated("true".equals(element.elementText(ELEMENT_ACCOUNT_ACTIVATED)));
        return account;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
