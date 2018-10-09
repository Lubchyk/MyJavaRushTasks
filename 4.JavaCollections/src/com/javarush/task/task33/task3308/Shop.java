package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType
public class Shop {
    public int count;
    public Goods goods;
    public double profit;
    public String[] secretData;

    @XmlType
    public static class Goods {
        public List<String> names;
    }
}
