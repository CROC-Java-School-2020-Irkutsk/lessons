package ru.croc.java2020.lesson07.xml.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Root {

    private String attribute;
    private Child child;

    public Root(String attribute, Child child) {
        this.attribute = attribute;
        this.child = child;
    }

    public Root() {
    }

    @XmlAttribute
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Root{" +
                "attribute='" + attribute + '\'' +
                ", child=" + child +
                '}';
    }
}

class Child {
    private String text;

    public Child(String text) {
        this.text = text;
    }

    public Child() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Child{" +
                "text='" + text + '\'' +
                '}';
    }
}
