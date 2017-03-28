/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thoth.freemarker;

/**
 *
 * @author h1mjr01
 */
public class Product {

    private String url;
    private String name;

    // As per the JavaBeans spec., this defines the "url" bean property
    // It must be public!
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // As per the JavaBean spec., this defines the "name" bean property
    // It must be public!
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
